package language.content.lists;

import language.content.Content;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Titouan Vervack
 */
public abstract class ItemList extends Content {

    private int indent = 0;

    private List<List<Content>> content = new ArrayList<>();

    public ItemList addStep(String stepContent) {
        ListStep step = new ListStep(stepContent);
        List<Content> list;
        if ((list = content.get(indent)) == null) {
            list = new ArrayList<>();
            content.add(list);
        }
        list.add(step);
        return this;
    }

    public ItemList indent() {
        indent++;
        return this;
    }

    public ItemList unindent() {
        indent--;
        return this;
    }

    abstract void render();
}
