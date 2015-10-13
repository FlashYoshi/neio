package language.content.label;

import language.content.Content;
import language.content.TextContent;

import java.awt.*;

/**
 * @author Titouan Vervack
 */
public class TextLabel extends TextContent implements language.content.label.Label {
    private String label;
    private TextContent labelContent;

    public TextLabel(String label, TextContent labelContent) {
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
