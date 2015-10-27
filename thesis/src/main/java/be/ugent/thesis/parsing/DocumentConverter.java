package be.ugent.thesis.parsing;

import be.ugent.thesis.parsing.DocumentParser.DocumentContext;

import static be.ugent.thesis.util.Keywords.*;

/**
 * @author Titouan Vervack
 */
public class DocumentConverter extends DocumentBaseVisitor<Object> {

    public Object visitDocument(DocumentContext ctx) {
        visitHeader(ctx);
        return null;
    }

    private void visitHeader(DocumentContext ctx) {
        switch (ctx.HEADER().getText()) {
            case CLASS:
                break;
            case INTERFACE:
                break;
            case SCRIPT:
                break;
            default:
                break;
        }
    }
}
