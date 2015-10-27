package be.ugent.thesis.parsing;

import be.ugent.thesis.parsing.ThesisParser.DocumentContext;
import be.ugent.thesis.parsing.ThesisParser.ClassBodyContext;
import be.ugent.thesis.parsing.ThesisParser.ExtensionContext;
import be.ugent.thesis.parsing.ThesisParser.FieldContext;
import be.ugent.thesis.parsing.ThesisParser.MethodContext;

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
        switch (ctx.HEADER().getText()) {
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
            System.out.println(extension.IMPLEMENTS().getText());
            System.out.println(extension.EXTENDS().getText());
        }
    }

    private void visitFields(ClassBodyContext body) {
        for (FieldContext field : body.field()) {
            System.out.println(field.getText());
        }
    }

    private void visitMethods(ClassBodyContext body) {
        for (MethodContext method : body.method()) {
            System.out.println(method.getText());
        }
    }
}
