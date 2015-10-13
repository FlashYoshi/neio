package language.content;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Titouan Vervack
 */
public class Content {

    protected List<Content> content = new ArrayList<>();
    public Position position;

    public enum Position {
        CENTER
    }

    public Content setCenter() {
        position = Position.CENTER;
        return this;
    }
}
