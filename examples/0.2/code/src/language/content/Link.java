package language.content;

/**
 * @author Titouan Vervack
 */
public class Link extends TextContent {

    private String name;
    private String url;

    public Link(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
