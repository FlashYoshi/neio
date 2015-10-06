package language.base;

import language.items.Paragraph;

/**
 * @author Titouan Vervack
 */
public class Document extends Base {

    public Document addParagraph(Paragraph par) {
        items.add(par);
        return this;
    }

    public Document addParagraph(String content) {
        Paragraph par = new Paragraph(content);
        items.add(par);
        return this;
    }
}
