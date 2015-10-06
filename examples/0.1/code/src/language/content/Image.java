package language.content;

/**
 * @author Titouan Vervack
 */
public class Image extends Content {

    private String path;
    private Text caption;

    public Image(String path){
        this.path = path;
    }

    public Image addCaption(String text) {
        caption = new Text(text);
        return this;
    }
}
