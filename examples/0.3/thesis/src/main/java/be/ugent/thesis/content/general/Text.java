package be.ugent.thesis.content.general;

/**
 * @author Titouan Vervack
 */
public class Text extends Content {
    private String text;

    public Text(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public String toLatex() {
        return text;
    }

    @Override
    public String identify() {
        return "Text";
    }
}
