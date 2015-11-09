package be.ugent.neio.parsing;

import be.ugent.neio.parsing.DocumentParser.ContentContext;
import be.ugent.neio.parsing.DocumentParser.DocumentContext;
import be.ugent.neio.parsing.DocumentParser.SentenceContext;
import org.antlr.v4.runtime.tree.TerminalNode;


/**
 * @author Titouan Vervack
 */
public class DocumentConverter extends DocumentParserBaseVisitor<Object> {

    public Object visitDocument(DocumentContext ctx) {
        visitHeader(ctx);
        visitBody(ctx);
        return null;
    }

    private void visitHeader(DocumentContext ctx) {
        System.out.println(ctx.HEADER().getText());
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
