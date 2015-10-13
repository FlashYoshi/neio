package language.content.label;

import language.content.Content;

import java.awt.*;

/**
 * @author Titouan Vervack
 */
public interface Label {

    Content drawFrom(Label other, Color color);

    Content drawTo(Label other, Color color);
}
