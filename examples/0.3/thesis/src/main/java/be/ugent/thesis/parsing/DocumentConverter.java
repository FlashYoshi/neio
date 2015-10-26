package be.ugent.thesis.parsing;

import be.ugent.thesis.container.Document;
import be.ugent.thesis.content.document.Paragraph;
import be.ugent.thesis.content.document.Section;
import be.ugent.thesis.content.general.Content;
import be.ugent.thesis.parsing.DocumentParser.BodyContext;
import be.ugent.thesis.parsing.DocumentParser.DocumentContext;
import be.ugent.thesis.parsing.DocumentParser.ParagraphContext;
import be.ugent.thesis.parsing.DocumentParser.SectionContext;

import java.util.Stack;

/**
 * @author Titouan Vervack
 */
public class DocumentConverter extends DocumentBaseVisitor<Object> {

    private Stack<Content> structure = new Stack<>();

    public Section visitSection(SectionContext ctx) {
        if (ctx != null) {
            return new Section(ctx.WORDS().toString(), ctx.HASH().size());
        } else {
            System.err.println("SectionContext is null: ");
            return null;
        }
    }

    public Paragraph visitParagraph(ParagraphContext ctx) {
        if (ctx != null) {
            /*String s = "";
            for (TerminalNode n : ctx.WORDS()) {
                s += n.toString();
            }*/

            return new Paragraph(ctx.WORDS().toString());
        } else {
            System.err.println("SectionContext is null: ");
            return null;
        }
    }

    public Document visitDocument(DocumentContext ctx) {
        if (ctx != null) {
            Document document = new Document();
            structure.push(document);
            for (BodyContext b : ctx.body()) {
                Content c = visitBody(b);

                while (structure.peek().getLevel() >= c.getLevel()) {
                    structure.pop();
                }

                structure.peek().addContent(c);
                structure.push(c);
            }

            return document;
        }

        return null;
    }

    public Content visitBody(BodyContext ctx) {
        SectionContext s = ctx.section();
        ParagraphContext p = ctx.paragraph();

        if (s != null) {
            return visitSection(s);
        } else if (p != null) {
            return visitParagraph(p);
        } else {
            System.err.println("Unknown body type found: " + ctx.getText());
            return null;
        }
    }
}
