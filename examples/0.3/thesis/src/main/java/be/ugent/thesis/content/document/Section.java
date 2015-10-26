package be.ugent.thesis.content.document;

import be.ugent.thesis.content.general.Content;

/**
 * @author Titouan Vervack
 */
public class Section extends Content {

    private String title;

    public Section(String title, int level) {
        this.title = title.trim();
        this.level = level;

        if (level > 3) {
            throw new IllegalArgumentException("Section nesting is too deep for LaTeX");
        }
    }

    @Override
    public String toLatex() {
        String s = "\\";
        for (int i = 0; i < level - 1; i++) {
            s += "sub";
        }

        s += "section*{" + title + "}\n";
        s += contentToLatex(content);

        return s;
    }

    @Override
    public String identify() {
        return "Section";
    }
}
