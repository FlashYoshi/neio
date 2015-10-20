package be.ugent.thesis.content.document;

import be.ugent.thesis.content.general.Content;

/**
 * @author Titouan Vervack
 */
public class Section extends Content {
    private String text;

    public Section(String text) {
        this.text = text.trim();
        System.out.println(this.text);
    }

    public Section addParagraph(Paragraph p) {
        content.add(p);
        return this;
    }
}
