package be.ugent.neio.parsing;

import be.kuleuven.cs.distrinet.jnome.core.type.RegularJavaType;
import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.neio.language.Neio;
import be.ugent.neio.parsing.ClassParser.*;
import be.ugent.neio.util.Keywords;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.oo.expression.MethodInvocation;
import org.aikodi.chameleon.oo.method.Method;
import org.aikodi.chameleon.oo.method.SimpleNameMethodHeader;
import org.aikodi.chameleon.oo.type.BasicTypeReference;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.type.TypeReference;
import org.aikodi.chameleon.oo.type.inheritance.SubtypeRelation;
import org.aikodi.chameleon.oo.variable.RegularMemberVariable;
import org.aikodi.chameleon.support.member.simplename.method.NormalMethod;
import org.aikodi.chameleon.support.member.simplename.method.RegularMethodInvocation;
import org.antlr.v4.runtime.TokenStream;

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
        Type klass = new RegularJavaType(klassName);
        visitExtensions(body, klass);
        visitFields(body, klass);
        visitMethods(body, klass);
    }

    private void visitExtensions(ClassBodyContext body, Type type) {
        for (ExtensionContext extension : body.extension()) {
            // Do not need double check because if they are both null the method would not have been called
            if (extension.IMPLEMENTS() != null) {
                System.out.println(extension.IMPLEMENTS().getText() + " " + extension.chain().getText());
            } else {
                System.out.println(extension.EXTENDS().getText() + " " + extension.chain().getText());
            }
            type.addInheritanceRelation(new SubtypeRelation((TypeReference) visit(extension)));
        }
    }

    private void visitFields(ClassBodyContext body, Type type) {
        for (FieldContext field : body.field()) {
            System.out.println(field.var().fieldName().getText() + " " + field.var().CAMEL_CASE().getText() + ";");
            type.add(new RegularMemberVariable(field.var().CAMEL_CASE().getText(), (TypeReference) visit(field.var().fieldName())));
        }
        System.out.println();
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
