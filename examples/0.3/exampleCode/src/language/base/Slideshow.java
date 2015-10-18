package language.base;
import language.content.Content;
import language.items.Slide;

/**
 * @author Titouan Vervack
 */
public class Slideshow extends Base {

    public Slideshow addSlide(Slide slide) {
        items.add(slide);
        return this;
    }

    public Slideshow addSlide(String text) {
        Slide slide = new Slide(text);
        items.add(slide);
        return this;
    }

    public Slideshow addSlide(Content content) {
        content.position = Content.Position.CENTER;
        Slide slide = new Slide(content);
        items.add(slide);
        return this;
    }
}
