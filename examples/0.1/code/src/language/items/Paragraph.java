package language.items;
import language.content.Content;
import language.content.Link;
import language.content.Text;

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
}
