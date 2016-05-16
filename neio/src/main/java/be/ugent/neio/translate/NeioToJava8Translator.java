package be.ugent.neio.translate;

import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.ConstructorInvocation;
import be.kuleuven.cs.distrinet.jnome.core.language.Java7;
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
import org.aikodi.chameleon.oo.statement.Statement;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.variable.FormalParameter;
import org.aikodi.chameleon.plugin.build.BuildException;
import org.aikodi.chameleon.plugin.build.BuildProgressHelper;
import org.aikodi.chameleon.support.modifier.Public;
import org.aikodi.chameleon.support.modifier.Static;
import org.aikodi.chameleon.support.statement.StatementExpression;
import org.aikodi.chameleon.support.translate.IncrementalTranslator;
import org.aikodi.chameleon.workspace.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NeioToJava8Translator extends IncrementalTranslator<Neio, Java7> {

    private boolean debug;

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
        result.add(document);

        return result;
    }

    protected TextDocument createJavaDocument(TextDocument sourceDocument) throws LookupException {
        return new Java8Generator().createJavaDocument(sourceDocument);
    }

    private void prepareDocument(TextDocument document) {
        Neio neio = (Neio) document.language();
        NeioFactory ooFactory = (NeioFactory) neio.plugin(ObjectOrientedFactory.class);
        NeioExpressionFactory eFactory = (NeioExpressionFactory) neio.plugin(ExpressionFactory.class);
        Type type = ooFactory.createRegularType(document.getName());
        type.addModifier(new Public());
        Method main = ooFactory.createMethod("main", "void");
        main.header().addFormalParameter(new FormalParameter("args", ooFactory.createTypeReference("String[]")));
        main.addModifier(new Public());
        main.addModifier(new Static());
        Block block = document.getBlock();
        Block newBlock = ooFactory.createBlock();
        List<ConstructorInvocation> descendants = ((StatementExpression) block.statement(0)).getExpression().descendants(ConstructorInvocation.class);
        ConstructorInvocation ci = descendants.get(descendants.size() - 1);
        List<Expression> arguments = new ArrayList<>();
        arguments.add((Expression) ci.clone());
        newBlock.addStatement(ooFactory.createStatement(eFactory.createMethodInvocation(Constants.CREATE_DOCUMENT, null, arguments)));
        main.setImplementation(ooFactory.createImplementation(newBlock));
        type.add(main);

        Method method  = ooFactory.createMethod(Constants.CREATE_DOCUMENT, "void");
        method.header().addFormalParameter(new FormalParameter(Constants.CD_PARAM, ci.getTypeReference()));
        method.addModifier(new Public());
        method.addModifier(new Static());
        ci.replaceWith(eFactory.createNameExpression(false, Constants.CD_PARAM));
        method.setImplementation(ooFactory.createImplementation(block));
        type.add(method);

        NamespaceDeclaration ns = ooFactory.createNamespaceDeclaration(
                ooFactory.createNamespaceReference(document.loader().namespace().fullyQualifiedName()));
        ns.add(type);

        for (Namespace namespace : document.view().namespace().getSubNamespace("neio").descendantNamespaces()) {
            ns.addImport(ooFactory.createDemandImport(namespace.fullyQualifiedName()));
        }

        ns.addImport(ooFactory.createDemandImport("java.util"));
        document.add(ns);
    }
}
