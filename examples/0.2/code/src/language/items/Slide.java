package language.items;
import language.content.Content;
import language.content.Text;
import language.content.Image;
import language.content.layout.HorizontalBox;
import language.content.layout.VerticalBox;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Titouan Vervack
 */
public class Slide extends Item {

    private List<Content> content = new ArrayList<>();
    private Text title;

    public Slide() {

    }

    public Slide(String content) {
        this.content.add(new Text(content).setBig());
    }

    public Slide(Content content) {
        this.content.add(content);
    }

    public Slide addImage(String path) {
        Image image = new Image(path);
        content.add(image);
        return this;
    }

    public Slide addImage(Image image) {
        content.add(image);
        return this;
    }

    public Slide addTitle(String title) {
        this.title = new Text(title);
        return this;
    }

    public Slide horizontalBox(Content[] content) {
        HorizontalBox hbox = new HorizontalBox(content);
        this.content.add(hbox);
        return this;
    }

    public Slide verticalBox(Content[] content) {
        VerticalBox vbox = new VerticalBox(content);
        this.content.add(vbox);
        return this;
    }
}
