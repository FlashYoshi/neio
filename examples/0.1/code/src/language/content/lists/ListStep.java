package language.content.lists;

import language.content.Content;
import language.content.Text;

/**
 * @author Titouan Vervack
 */
public class ListStep extends Content {

    private Text stepContent;

    public ListStep(String stepContent) {
        this.stepContent = new Text(stepContent);
    }
}
