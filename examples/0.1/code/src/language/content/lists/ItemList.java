package language.content.lists;

import language.content.Content;

/**
 * @author Titouan Vervack
 */
public abstract class ItemList extends Content {

    public ItemList addStep(String stepContent) {
        ListStep step = new ListStep(stepContent);
        content.add(step);
        return this;
    }

    abstract void render();
}
