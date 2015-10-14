package language.content;

import language.util.Color;
import language.util.Font;

/**
 * @author Titouan Vervack
 */
public class TextContent extends Content {

    public Color color = null;
    public Font font = null;

    public TextContent color(String color) {
        this.color = new Color(color);

        return this;
    }

    public TextContent font(Font font) {
        this.font = font;

        return this;
    }
}
