package be.ugent.thesis.content.general;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Titouan Vervack
 */
public abstract class Content {

    protected int level;
    protected List<Content> content = new ArrayList<>();

    public boolean hasContent() {
        return !content.isEmpty();
    }

    public Content addContent(Content c) {
        content.add(c);
        return this;
    }

    public int getLevel() {
        return level;
    }

    public String toLatex() {
        return contentToLatex(content);
    }

    protected String contentToLatex(List<Content> content) {
        String latex = "";
        for (Content c : content) {
            latex += c.toLatex();
        }

        return latex;
    }

    public String toTree() {
        return toTree(0);
    }

    public String toTree(int depth) {
        String s = identify() + "\n";
        depth++;
        int prev = depth - 1;
        for (Content c : content) {
            if (c instanceof Text) {
                continue;
            }
            for (int i = 0; i < depth * 3; i++) {
                if (i < prev * 3) {
                    s += " ";
                } else if (i == prev * 3) {
                    s += "|";
                } else {
                    s += "-";
                }
            }
            s += c.toTree(depth);
        }

        return s;
    }

    abstract public String identify();
}
