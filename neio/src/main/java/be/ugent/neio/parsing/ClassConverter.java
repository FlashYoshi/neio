package be.ugent.neio.parsing;

import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.parsing.ClassParser.*;
import be.ugent.neio.util.Keywords;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.factory.Factory;
import org.aikodi.chameleon.core.namespacedeclaration.NamespaceDeclaration;
import org.aikodi.chameleon.oo.method.Method;
import org.aikodi.chameleon.oo.method.SimpleNameMethodHeader;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.type.BasicTypeReference;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.type.TypeReference;
import org.aikodi.chameleon.oo.type.inheritance.InheritanceRelation;
import org.aikodi.chameleon.oo.type.inheritance.SubtypeRelation;
import org.aikodi.chameleon.oo.variable.MemberVariable;
import org.aikodi.chameleon.oo.variable.RegularMemberVariable;
import org.aikodi.chameleon.support.member.simplename.method.NormalMethod;

import static be.ugent.neio.util.Keywords.CLASS;
import static be.ugent.neio.util.Keywords.INTERFACE;

/**
 * @author Titouan Vervack
 */
public class ClassConverter extends ClassParserBaseVisitor<Object> {

    private final Document document;
    private final JavaView view;
    private final Neio neio;

    public ClassConverter(Document document, JavaView view) {
        this.document = document;
        this.view = view;
        this.neio = view.language(Neio.class);
    }

    protected Factory factory() {
        return neio.plugin(Factory.class);
    }

    protected NeioFactory ooFactory() {
        return (NeioFactory) neio.plugin(ObjectOrientedFactory.class);
    }

    public Object visitDocument(DocumentContext ctx) {
        visitHeader(ctx);
        return null;
    }

    private void visitHeader(DocumentContext ctx) {
        String header = ctx.HEADER().getText();
        String klassName = ctx.CLASS_NAME().getText();
        System.out.println(header + " " + klassName);
        switch (header) {
            case CLASS:
                visitClass(ctx, klassName);
                break;
            case INTERFACE:
                break;
            default:
                break;
        }
    }

    private void visitClass(DocumentContext ctx, String klassName) {
        ClassBodyContext body = ctx.body().classBody();
        NamespaceDeclaration ns = factory().createRootNamespaceDeclaration();
        Type klass = ooFactory().createRegularType(klassName);
        visitExtensions(body, klass);
        visitFields(body, klass);
        visitMethods(body, klass);
        ns.add(klass);
        document.add(ns);
    }

    private void visitExtensions(ClassBodyContext body, Type type) {
        for (ExtensionContext extension : body.extension()) {
            System.out.println(extension.chain().getText());
            type.addInheritanceRelation(visitExtension(extension));
        }
    }

    @Override
    public InheritanceRelation visitExtension(ExtensionContext ctx) {
        // Ignore the namespace for now, it does not really matter at this point
        String ignoredNS = ctx.chain().getChild(ctx.chain().getChildCount() - 1).getText();
        TypeReference ref = ooFactory().createTypeReference(ignoredNS);

        return ooFactory().createSubtypeRelation(ref);
    }

    private void visitFields(ClassBodyContext body, Type type) {
        for (FieldContext field : body.field()) {
            System.out.println(field.var().fieldName().getText() + " " + field.var().CAMEL_CASE().getText() + ";");
            type.add(visitField(field));
        }
    }

    @Override
    public MemberVariable visitField(FieldContext ctx) {
        String name = ctx.var().CAMEL_CASE().getText();
        TypeReference type = ooFactory().createTypeReference(ctx.var().fieldName().getText());

        return ooFactory().createMemberVariable(name, type);
    }

    private void visitMethods(ClassBodyContext body, Type type) {
        for (MethodContext method : body.method()) {
            visitMethod(method, type);
            System.out.println();
        }
    }

    public Object visitMethod(MethodContext method, Type type) {
        if (method.METHOD_OPTION() != null) {
            System.out.print(method.METHOD_OPTION().getText());
        }

        System.out.println(method.decl().getText() + " {");
        String returnType = visitMethodBlock(method.block());
        Method m = new NormalMethod(new SimpleNameMethodHeader(method.decl().methodName().getText(), new BasicTypeReference(returnType)));
        type.add(m);
        System.out.println("}");
        return null;
    }

    private String visitMethodBlock(BlockContext block) {
        for (StatementContext statementContext : block.statement()) {
            System.out.println(statementContext.getText());
        }

        if (block.returnCall() != null) {
            System.out.println(block.returnCall().getText());
            // Still have to dereference this type
            return block.returnCall().CAMEL_CASE().getText();
        }

        return Keywords.VOID;
    }
}
