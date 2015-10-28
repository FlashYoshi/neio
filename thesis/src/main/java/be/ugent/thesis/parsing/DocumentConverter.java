package be.ugent.thesis.parsing;

import be.ugent.thesis.parsing.ThesisParser.*;
import be.ugent.thesis.util.Keywords;
import be.ugent.thesis.vm.*;
import org.aikodi.chameleon.oo.method.SimpleNameMethodHeader;
import org.aikodi.chameleon.oo.type.BasicTypeReference;

import static be.ugent.thesis.util.Keywords.*;

/**
 * @author Titouan Vervack
 */
public class DocumentConverter extends ThesisParserBaseVisitor<Object> {

    public Object visitDocument(DocumentContext ctx) {
        visitHeader(ctx);
        return null;
    }

    private void visitHeader(DocumentContext ctx) {
        String header = ctx.HEADER().getText();
        System.out.println(header);
        header = header.substring(1, header.length() - 1);
        VMObject v = new VMContainer();
        v.add(new VMType(header));
        switch (header) {
            case CLASS:
                visitClass(ctx, v);
                break;
            case INTERFACE:
                break;
            case SCRIPT:
                break;
            default:
                break;
        }
    }

    private void visitClass(DocumentContext ctx, VMObject v) {
        ClassBodyContext body = ctx.body().classBody();
        visitExtensions(body, v);
        visitFields(body, v);
        visitMethods(body, v);
    }

    private void visitExtensions(ClassBodyContext body, VMObject v) {
        for (ExtensionContext extension : body.extension()) {
            // Do not need double check because if they are both null the method would not have been called
            if (extension.IMPLEMENTS() != null) {
                System.out.println(extension.IMPLEMENTS().getText() + " " + extension.chain().getText());
            } else {
                System.out.println(extension.EXTENDS().getText() + " " + extension.chain().getText());
            }
            v.add(new VMNamespace(extension.chain().getText()));
        }
    }

    private void visitFields(ClassBodyContext body, VMObject v) {
        for (FieldContext field : body.field()) {
            System.out.println(field.var().fieldName().getText() + " " + field.var().CAMEL_CASE().getText() + ";");
            v.add(new VMField(field.var().CAMEL_CASE().getText(), new BasicTypeReference(field.var().fieldName().getText())));
        }
        System.out.println();
    }

    private void visitMethods(ClassBodyContext body, VMObject v) {
        for (MethodContext method : body.method()) {
            visitMethod(method, v);
            System.out.println();
        }
    }

    public Object visitMethod(MethodContext method, VMObject v) {
        if (method.METHOD_OPTION() != null) {
            System.out.print(method.METHOD_OPTION().getText());
        }

        System.out.println(method.decl().getText() + " {");
        String type = visitMethodBlock(method.block(), v);
        v.add(new VMMethod(new SimpleNameMethodHeader(method.decl().methodName().getText(), new BasicTypeReference(type))));
        System.out.println("}");
        return null;
    }

    private String visitMethodBlock(BlockContext block, VMObject v) {
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
