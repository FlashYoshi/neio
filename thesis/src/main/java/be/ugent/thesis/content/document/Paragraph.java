package be.ugent.thesis.content.document;

import be.ugent.thesis.content.general.Content;
import be.ugent.thesis.content.general.Text;

/**
 * @author Titouan Vervack
 */
public class Paragraph extends Content {

    public Paragraph(String text) {
        content.add(new Text(text.trim()));
        level = Integer.MAX_VALUE;
    }

    @Override
    public String toLatex() {
        String s = contentToLatex(content);
        s += "\n\n";

        return s;
    }

    @Override
    public String identify() {
        return "Paragraph";
    }
}
