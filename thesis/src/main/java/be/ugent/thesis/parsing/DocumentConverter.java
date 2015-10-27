package be.ugent.thesis.parsing;

import be.ugent.thesis.parsing.ThesisParser.*;

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
        switch (header) {
            case CLASS:
                visitClass(ctx);
                break;
            case INTERFACE:
                break;
            case SCRIPT:
                break;
            default:
                break;
        }
    }

    private void visitClass(DocumentContext ctx) {
        ClassBodyContext body = ctx.body().classBody();
        visitExtensions(body);
        visitFields(body);
        visitMethods(body);
    }

    private void visitExtensions(ClassBodyContext body) {
        for (ExtensionContext extension : body.extension()) {
            // Do not need double check because if they are both null the method would not have been called
            if (extension.IMPLEMENTS() != null) {
                System.out.println(extension.IMPLEMENTS().getText() + " " + extension.PACKAGE().getText());
            } else {
                System.out.println(extension.EXTENDS().getText() + " " + extension.PACKAGE().getText());
            }
        }
    }

    private void visitFields(ClassBodyContext body) {
        for (FieldContext field : body.field()) {
            System.out.println(field.var().fieldName().getText() + " " + field.var().CAMEL_CASE().getText() + ";");
        }
        System.out.println();
    }

    private void visitMethods(ClassBodyContext body) {
        for (MethodContext method : body.method()) {
            visitMethod(method);
            System.out.println();
        }
    }

    @Override
    public Object visitMethod(MethodContext method) {
        if (method.METHOD_OPTION() != null) {
            System.out.print(method.METHOD_OPTION().getText());
        }

        System.out.println(method.call().getText() + " {");
        visitMethodBlock(method.block());
        System.out.println("}");
        return null;
    }

    private void visitMethodBlock(BlockContext block) {
        for (StatementContext statementContext : block.statement()) {
            System.out.println(statementContext.getText());
        }

        if (block.returnCall() != null) {
            System.out.println(block.returnCall());
        }
    }
}
