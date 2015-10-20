package be.ugent.thesis.container;

import be.ugent.thesis.content.general.Content;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Titouan Vervack
 */
public class Document extends Root {
    protected List<Content> content = new ArrayList<>();

    public Document addContent(Content c) {
        content.add(c);
        return this;
    }
}
