package language.content;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Titouan Vervack
 */
public class Text extends TextContent {

    private boolean bold = false;
    private int size = 12;
    private List<TextContent> content = new ArrayList<>();

    public Text(String text) {
        content.add(new StringWrapper(text));
    }

    public Text(TextContent content) {
        this.content.add(content);
    }

    public Text addText(String text) {
        this.content.add(new Text(text));
        return this;
    }

    public Text setBold() {
        bold = true;
        return this;
    }

    public Text setSmall(){
        size = 8;
        return this;
    }

    public Text setBig(){
        size = 18;
        return this;
    }
}
