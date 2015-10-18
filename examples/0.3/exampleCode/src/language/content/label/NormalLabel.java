package language.content.label;

import language.content.Content;

import java.awt.*;

/**
 * @author Titouan Vervack
 */
public class NormalLabel extends Content implements Label {
    private String label;
    private Content labelContent;

    public NormalLabel(String label, Content labelContent) {
        this.label = label;
        this.labelContent = labelContent;
    }

    public Content drawFrom(Label other, Color color) {
        // draw from other
        return this;
    }

    public Content drawTo(Label other, Color color) {
        // draw to other
        return this;
    }
}
