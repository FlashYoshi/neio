package be.ugent.thesis.container;

/**
 * @author Titouan Vervack
 */
public class Document extends Root {

    public Document() {
        level = 0;
    }

    @Override
    public String toLatex() {
        String s = "";
        s += "\\documentclass{article}\n" +
             "\\usepackage{a4wide}\n" +
             "\\setlength{\\parindent}{0em}\n" +
             "\\setlength{\\parskip}{1em}\n" +
             "\\begin{document}\n";

        s += contentToLatex(content);

        s += "\\end{document}";

        return s;
    }

    @Override
    public String identify() {
        return "Document";
    }
}
