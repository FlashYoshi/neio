package language.items;
import language.content.Content;
import language.content.Link;
import language.content.Text;
import language.util.Color;
import language.util.Font;

/**
 * @author Titouan Vervack
 */
public class Paragraph extends Item {

    private boolean literal = false;

    public Paragraph() {

    }

    public Paragraph(String content) {
        addText(content);
    }

    public Paragraph(Content content) {
        this.content.add(content);
    }

    public Paragraph addLink(String name, String url) {
        content.add(new Link(name, url));
        return this;
    }

    public Paragraph addText(String text) {
        content.add(new Text(text));
        return this;
    }

    public Paragraph addText(Text text) {
        content.add(text);
        return this;
    }

    public Paragraph setLiteral() {
        literal = true;
        return this;
    }

    public Paragraph color(Color color) {
        if (!content.isEmpty()) {
            for (Content c : content) {
                // c.property("color", color);
                // voorzie mapping van attribute -> functienaam
                //c.color(color);
            }
        }

        return this;
    }

    public Paragraph font(Font font) {
        if (!content.isEmpty()) {
            for (Content c : content) {
                //
                //c.font(font);
            }
        }

        return this;
    }
}
