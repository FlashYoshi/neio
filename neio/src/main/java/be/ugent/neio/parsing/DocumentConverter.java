package be.ugent.neio.parsing;

import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.neio.industry.NeioExpressionFactory;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.parsing.DocumentParser.ContentContext;
import be.ugent.neio.parsing.DocumentParser.DocumentContext;
import be.ugent.neio.parsing.DocumentParser.SentenceContext;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.factory.Factory;
import org.aikodi.chameleon.core.namespace.Namespace;
import org.aikodi.chameleon.core.namespace.NamespaceReference;
import org.aikodi.chameleon.core.namespace.RegularNamespace;
import org.aikodi.chameleon.core.namespacedeclaration.NamespaceDeclaration;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.oo.method.Method;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.statement.Statement;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.variable.FormalParameter;
import org.aikodi.chameleon.support.modifier.Public;
import org.aikodi.chameleon.support.modifier.Static;
import org.antlr.v4.runtime.tree.TerminalNode;


/**
 * @author Titouan Vervack
 */
public class DocumentConverter extends DocumentParserBaseVisitor<Object> {

    private final Document document;
    private final Neio neio;
    private final Block block;
    private final String name;

    public DocumentConverter(Document document, JavaView view, String name) {
        this.document = document;
        this.neio = view.language(Neio.class);
        this.block = ooFactory().createBlock();
        this.name = name;
    }

    protected Factory factory() {
        return neio.plugin(Factory.class);
    }

    protected NeioFactory ooFactory() {
        return (NeioFactory) neio.plugin(ObjectOrientedFactory.class);
    }

    protected NeioExpressionFactory expressionFactory() {
        return (NeioExpressionFactory) neio.plugin(ExpressionFactory.class);
    }

    public Document visitDocument(DocumentContext ctx) {
        block.addStatement(visitHeader(ctx));
        visitBody(ctx);

        fillDocument();

        return document;
    }

    private void fillDocument() {
        //NamespaceDeclaration ns = document.namespaceDeclarations().get(0);
        NamespaceDeclaration ns = factory().createNamespaceDeclaration(new NamespaceReference("be.ugent"));
        Type type = ooFactory().createRegularType(name);
        type.addModifier(new Public());
        Method method = ooFactory().createMethod("main", "void");
        method.header().addFormalParameter(new FormalParameter("args", ooFactory().createTypeReference("String[]")));
        method.addModifier(new Public());
        method.addModifier(new Static());

        method.setImplementation(ooFactory().createImplementation(block));
        type.add(method);
        ns.add(type);
        document.add(ns);
    }

    private Statement visitHeader(DocumentContext ctx) {
        String header = ctx.HEADER().getText();
        // Strip the brackets
        String documentType = header.substring(1, header.length() - 1);
        String name = documentType.toLowerCase();
        Statement v = ooFactory().createNewDeclaration(documentType, name, expressionFactory().createNewExpression(documentType));

        System.out.println(ctx.HEADER().getText());
        return v;
    }

    private void visitBody(DocumentContext ctx) {
        ctx.body().content().forEach(this::visitContent);
    }

    @Override
    public Object visitContent(ContentContext ctx) {
        visitPrefixCall(ctx);
        visitPostFixCall(ctx);
        visitText(ctx);
        if (ctx.mnl() != null) {
            System.out.print(ctx.mnl().getText());
        }
        return null;
    }

    private void visitPrefixCall(ContentContext ctx) {
        if (ctx.prefixCall() != null) {
            for (TerminalNode h : ctx.prefixCall().HASH()) {
                System.out.print(h.toString());
            }
            System.out.print(" ");
            for (TerminalNode w : ctx.prefixCall().sentence().WORD()) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }

    private void visitPostFixCall(ContentContext ctx) {
        if (ctx.postfixCall() != null) {
            System.out.println(ctx.postfixCall().getText());
        }
    }

    private void visitText(ContentContext ctx) {
        if (ctx.text() != null) {
            for (SentenceContext s : ctx.text().sentence()) {
                for (TerminalNode w : s.WORD()) {
                    System.out.print(w + " ");
                }
                System.out.println();
            }
        }
    }
}
