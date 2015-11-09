package be.ugent.neio.parsing;

import be.ugent.neio.parsing.NeioDocumentParser.*;


/**
 * @author Titouan Vervack
 */
public class DocumentConverter extends NeioDocumentParserBaseVisitor<Object> {

    public Object visitDocument(DocumentContext ctx) {
        visitHeader(ctx);
        visitBody(ctx);
        return null;
    }

    private void visitHeader(DocumentContext ctx) {
        System.out.println(ctx.HEADER().getText());
    }

    private void visitBody(DocumentContext ctx) {
        for (ContentContext c : ctx.body().content()) {
            visitContent(c);
        }
    }

    @Override
    public Object visitContent(ContentContext ctx) {
        visitPrefixCall(ctx);
        visitPostFixCall(ctx);
        visitText(ctx);
        if (ctx.mnl() != null){
            System.out.println(ctx.mnl().getText());
        }
        return null;
    }

    private void visitPrefixCall(ContentContext ctx) {
        if (ctx.prefixCall() != null) {
            System.out.println(ctx.prefixCall().getText());
        }
    }

    private void visitPostFixCall(ContentContext ctx) {
        if (ctx.postfixCall() != null) {
            System.out.println(ctx.postfixCall().getText());
        }
    }

    private void visitText(ContentContext ctx) {
        if (ctx.text() != null) {
            System.out.println(ctx.text().getText());
        }
    }
}
