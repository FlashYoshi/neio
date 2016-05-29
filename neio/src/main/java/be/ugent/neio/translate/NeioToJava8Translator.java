package be.ugent.neio.translate;

import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.ConstructorInvocation;
import be.kuleuven.cs.distrinet.jnome.core.language.Java7;
import be.kuleuven.cs.distrinet.jnome.core.method.JavaMethod;
import be.ugent.neio.industry.NeioExpressionFactory;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.model.document.TextDocument;
import be.ugent.neio.util.Constants;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.core.namespace.Namespace;
import org.aikodi.chameleon.core.namespacedeclaration.NamespaceDeclaration;
import org.aikodi.chameleon.exception.ModelException;
import org.aikodi.chameleon.oo.expression.Expression;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.oo.expression.MethodInvocation;
import org.aikodi.chameleon.oo.method.Method;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.variable.FormalParameter;
import org.aikodi.chameleon.oo.variable.VariableDeclaration;
import org.aikodi.chameleon.plugin.build.BuildException;
import org.aikodi.chameleon.plugin.build.BuildProgressHelper;
import org.aikodi.chameleon.support.modifier.Public;
import org.aikodi.chameleon.support.modifier.Static;
import org.aikodi.chameleon.support.statement.StatementExpression;
import org.aikodi.chameleon.support.translate.IncrementalTranslator;
import org.aikodi.chameleon.support.variable.LocalVariableDeclarator;
import org.aikodi.chameleon.workspace.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static be.ugent.neio.util.Constants.*;

public class NeioToJava8Translator extends IncrementalTranslator<Neio, Java7> {

    private boolean debug;
    private JavaMethod main;
    private ConstructorInvocation startArgument;

    public NeioToJava8Translator(View source, View target) {
        super(source, target);
        debug = false;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    @Override
    public Collection<Document> build(Document source, BuildProgressHelper buildProgressHelper) throws BuildException {
        List<Document> result;
        try {
            result = translate(source);
        } catch (ModelException e) {
            throw new BuildException(e);
        }
        return result;
    }

    public List<Document> translate(Document sourceDocument) throws ModelException {
        List<Document> result = new ArrayList<>();
        TextDocument document = (TextDocument) sourceDocument;
        prepareDocument(document);
        if (!debug) {
            document = createJavaDocument(document);
        }
        finishDocument(document);
        result.add(document);

        return result;
    }

    private void finishDocument(TextDocument document) {
        Neio neio = (Neio) document.language();
        NeioFactory oFactory = (NeioFactory) neio.plugin(ObjectOrientedFactory.class);
        NeioExpressionFactory eFactory = (NeioExpressionFactory) neio.plugin(ExpressionFactory.class);

        List<Expression> arguments = new ArrayList<>();
        arguments.add(eFactory.createNameExpression(false, Constants.CD_PARAM));
        main.body().addStatement(oFactory.createStatement(eFactory.createMethodInvocation(false, Constants.FINISH_DOCUMENT, null, arguments)));
    }

    private Method createFinishDocument(TextDocument document) {
        Neio neio = (Neio) document.language();
        NeioFactory oFactory = (NeioFactory) neio.plugin(ObjectOrientedFactory.class);
        NeioExpressionFactory eFactory = (NeioExpressionFactory) neio.plugin(ExpressionFactory.class);

        List<Expression> arguments = new ArrayList<>();
        arguments.add(eFactory.createNameExpression(Constants.CD_PARAM));
        Expression ci = eFactory.createConstructorInvocation(DEFAULT_WRITER, null, arguments);

        List<Expression> miArguments = new ArrayList<>();
        miArguments.add(oFactory.createStringLiteral(document.getName()));
        MethodInvocation mi = eFactory.createNeioMethodInvocation(WRITE_METHOD, ci, miArguments);
        LocalVariableDeclarator varDecl = new LocalVariableDeclarator(oFactory.createTypeReference("java.lang.String"));
        String varName = "$var0";
        VariableDeclaration var = new VariableDeclaration(varName, mi);
        varDecl.add(var);

        Method finishDocument = oFactory.createMethod(Constants.FINISH_DOCUMENT, "void");
        finishDocument.header().addFormalParameter(new FormalParameter(Constants.CD_PARAM, startArgument.getTypeReference()));
        finishDocument.addModifier(new Public());
        finishDocument.addModifier(new Static());
        Block block = oFactory.createBlock();
        block.addStatement(varDecl);
        finishDocument.setImplementation(oFactory.createImplementation(block));
        callBuilder(document, varName, block);

        return finishDocument;
    }

    /**
     * Builds the TeX/JS/... string into a real document such as a PDF
     *
     * @param neioDocument The document to build
     * @param writerReturn The variable name of the TeX/JS/... string
     */
    private void callBuilder(TextDocument neioDocument, String writerReturn, Block block) {
        Neio neio = (Neio) neioDocument.language();
        NeioFactory oFactory = (NeioFactory) neio.plugin(ObjectOrientedFactory.class);
        NeioExpressionFactory eFactory = (NeioExpressionFactory) neio.plugin(ExpressionFactory.class);
        List<Expression> arguments = new ArrayList<>();
        Expression ci = eFactory.createConstructorInvocation(DEFAULT_BUILDER, null, arguments);

        List<Expression> miArguments = new ArrayList<>();
        miArguments.add(eFactory.createNameExpression(writerReturn));
        MethodInvocation mi = eFactory.createNeioMethodInvocation(BUILD_METHOD, ci, miArguments);

        block.addStatement(oFactory.createStatement(mi));
    }

    protected TextDocument createJavaDocument(TextDocument sourceDocument) throws LookupException {
        return new Java8Generator().createJavaDocument(sourceDocument);
    }

    private void prepareDocument(TextDocument document) {
        Neio neio = (Neio) document.language();
        NeioFactory oFactory = (NeioFactory) neio.plugin(ObjectOrientedFactory.class);
        NeioExpressionFactory eFactory = (NeioExpressionFactory) neio.plugin(ExpressionFactory.class);

        // Create the main function
        Type type = oFactory.createRegularType(document.getName());
        type.addModifier(new Public());
        main = oFactory.createMethod("main", "void");
        main.header().addFormalParameter(new FormalParameter("args", oFactory.createTypeReference("String[]")));
        main.addModifier(new Public());
        main.addModifier(new Static());
        Block block = document.getBlock();
        Block newBlock = oFactory.createBlock();

        // Get the Constructor at the root of the document
        MethodInvocation mi = (MethodInvocation) block.statement(0).children().get(0);
        while (mi.getTarget() != null && (mi.getTarget() instanceof MethodInvocation)) {
            mi = (MethodInvocation) mi.getTarget();
        }
        startArgument = (ConstructorInvocation) mi;

        // Create a variable from it
        LocalVariableDeclarator varDecl = new LocalVariableDeclarator(((ConstructorInvocation) startArgument.clone()).getTypeReference());
        VariableDeclaration var = new VariableDeclaration(Constants.CD_PARAM, (Expression) startArgument.clone());
        varDecl.add(var);
        newBlock.addStatement(varDecl);

        // Fill the body of main
        List<Expression> arguments = new ArrayList<>();
        arguments.add(eFactory.createNameExpression(false, Constants.CD_PARAM));
        newBlock.addStatement(oFactory.createStatement(eFactory.createMethodInvocation(Constants.CREATE_DOCUMENT, null, arguments)));
        main.setImplementation(oFactory.createImplementation(newBlock));
        type.add(main);

        // Create a method to execute the document
        Method createDocument = oFactory.createMethod(Constants.CREATE_DOCUMENT, "void");
        createDocument.header().addFormalParameter(new FormalParameter(Constants.CD_PARAM, ((ConstructorInvocation) startArgument.clone()).getTypeReference()));
        createDocument.addModifier(new Public());
        createDocument.addModifier(new Static());
        startArgument.replaceWith(eFactory.createNameExpression(false, Constants.CD_PARAM));
        createDocument.setImplementation(oFactory.createImplementation(block));
        type.add(createDocument);

        // Add a method to print the document
        type.add(createFinishDocument(document));

        // Include everything
        NamespaceDeclaration ns = oFactory.createNamespaceDeclaration(
                oFactory.createNamespaceReference(document.loader().namespace().fullyQualifiedName()));
        ns.add(type);

        for (Namespace namespace : document.view().namespace().getSubNamespace("neio").descendantNamespaces()) {
            ns.addImport(oFactory.createDemandImport(namespace.fullyQualifiedName()));
        }

        ns.addImport(oFactory.createDemandImport("java.util"));
        document.add(ns);
    }
}
