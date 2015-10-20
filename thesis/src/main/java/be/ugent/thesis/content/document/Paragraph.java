package be.ugent.thesis.content.document;

import be.ugent.thesis.content.general.Content;

/**
 * @author Titouan Vervack
 */
public class Paragraph extends Content {
    private String text;

    public Paragraph(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
