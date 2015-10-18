import language.base.Document;
import language.items.Paragraph;
import language.base.Slideshow;
import language.content.lists.Itemize;
import language.content.Text;
import language.content.Image;
import language.items.Slide;
import language.content.Content;
import language.content.label.TextLabel;
import language.content.label.NormalLabel;
import language.content.layout.HorizontalBox;
import language.content.lists.Enumerate;

import java.awt.*;

/**
 * @author Titouan Vervack
 */
public class Main {

    public static void main(String[] args) {
        documentExample();
        slidesExample();
    }

    public static void documentExample() {
        Document doc = new Document();
        String con1 = "Aan het einde van het vorige academiejaar liet onze belangrijkste server, genaamd King";
        String con2 = "King is onze server in het datacenter te S10.\nHet is een Dell PowerEdge 2850, die machines worden zelfs niet meer verscheept ";
        String con3 = "Ansible is een system automation applicatie die groepen van servers kan installeren door het uitvoeren van commando’s over ssh";
        String con4 = "Procrat en ik, FlashYoshi, spendeerden vele (code)nights aan het begrijpen van de software op de oude server";
        String con5 = "Ansible werd niet alleen maar gebruikt om King te configureren maar ook Abyss, onze NAS die in kelder naast Tweek gesitueerd is, werd door Ansible geconfigureerd.";
        Paragraph par1 = new Paragraph("Deze vakantie liep het allemaal tot een einde, Ansible werkt afgewerkt en de server werd succesvol gemigreerd.");
        String con6 = "Deze vakantie liep het allemaal tot een einde, Ansible werkt afgewerkt en de server werd succesvol gemigreerd.";
        Paragraph par2 = new Paragraph(new Text("ANSIBLE IS AF").setBold());
        Paragraph par3 = new Paragraph();

        par3.addText(new Text("P.S.: Onze Ansible-configuratie is openbaar beschikbaar op ")
                     .setSmall())
            .addLink("GitHub", "https://zeus.ugent.be/git/ansible-config")
            .addText(".");

        doc.addParagraph("Dag iedereen,")
           .addParagraph(con1)
           .addParagraph(con2)
           .addParagraph(con3)
           .addParagraph(con4)
           .addParagraph(new Paragraph(con5)
             .setLiteral())
           .addParagraph(par1)
           .addParagraph(con6)
           .addParagraph(par2)
           .addParagraph(par3);
    }

    public static void slidesExample() {
        Slideshow slides = new Slideshow();
        TextLabel label1 = new TextLabel("label1", new Text("This"));
        slides.addSlide("Zeus WPI")
              .addSlide(new Itemize()
                .addStep("Activiteiten")
                .indent()
                  .addStep("Projecten")
                  .indent()
                    .addStep("Sfeer"))
              .addSlide(new Image("image1"))
              .addSlide(new Slide()
                .addImage("image2")
                .addImage("image3"))
              .addSlide(new Slide()
                .addImage(new Image("image4")
                  .addCaption("This is the caption of the fourth image")))
              .addSlide(new Slide()
                .addTitle("This is the title for this slide")
                .horizontalBox(new Content[]{
                        new Text("This text will be on the left while " +
                                 "the image will be to the right of " +
                                 "it. The text and image will be " +
                                 "split so that they both use 50%"),
                        new Image("image6")
                          .addCaption("This is also a caption")}
                ))
              .addSlide(new Slide()
                .verticalBox(new Content[]{
                        new Text(label1)
                          .addText(" is the first label of this slideshow"),
                        new NormalLabel("label2", new HorizontalBox(new Content[]{
                          new Itemize()
                            .addStep("These items")
                            .addStep("are placed")
                            .addStep("in the bottom")
                            .addStep("left"),
                          new Enumerate()
                            .addStep("Whilst these")
                            .addStep("are placed")
                            .addStep("in the bottom")
                            .addStep("right")
                        }))
                          .drawFrom(label1, Color.MAGENTA)
                }));

    }
}
