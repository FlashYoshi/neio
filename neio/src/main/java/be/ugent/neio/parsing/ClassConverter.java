package be.ugent.neio.parsing;

import be.kuleuven.cs.distrinet.jnome.core.type.RegularJavaType;
import be.ugent.neio.util.Keywords;
import be.ugent.neio.parsing.NeioClassParser.*;
import org.aikodi.chameleon.oo.method.SimpleNameMethodHeader;
import org.aikodi.chameleon.oo.type.BasicTypeReference;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.type.TypeReference;
import org.aikodi.chameleon.oo.type.inheritance.SubtypeRelation;
import org.aikodi.chameleon.oo.variable.RegularMemberVariable;
import org.aikodi.chameleon.support.member.simplename.method.NormalMethod;

import static be.ugent.neio.util.Keywords.*;

/**
 * @author Titouan Vervack
 */
public class ClassConverter extends NeioClassParserBaseVisitor<Object> {

    public Object visitDocument(DocumentContext ctx, String klassName) {
        visitHeader(ctx, klassName);
        return null;
    }

    private void visitHeader(DocumentContext ctx, String klassName) {
        String header = ctx.HEADER().getText();
        System.out.println(header);
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
        type.add(new NormalMethod(new SimpleNameMethodHeader(method.decl().methodName().getText(), new BasicTypeReference(returnType))));
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
