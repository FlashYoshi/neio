package language.content.layout;
import language.content.Content;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Titouan Vervack
 */
public class VerticalBox extends Content {
    private List<Content> content = new ArrayList<>();

    public VerticalBox(Content[] content) {
        for (Content c : content) {
            this.content.add(c);
        }
    }
}
