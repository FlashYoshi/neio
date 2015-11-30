package be.ugent.neio.model.type;

import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.neio.builder.ClassBuilder;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.oo.type.Type;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Titouan Vervack
 */
public class ContextTypeTest {

    private JavaView view;

    @Before
    public void initialize() {
        ClassBuilder builder = new ClassBuilder();
        view = (JavaView) builder.build("../base_library/project.xml");
    }

    @Test
    public void testConstruction() {
        try {
            String doc = "neio.stdlib.Document";
            String par = "neio.stdlib.Paragraph";
            String cha = "neio.stdlib.Chapter";

            Type document = view.findType(doc);
            Type paragraph = view.findType(par);
            Type chapter = view.findType(cha);


            ContextType ctx = new ContextType(chapter, document);
            assert (ctx.getDirectSuperTypes() != null && ctx.getDirectSuperTypes().size() == 2);
            assert (ctx.getDirectSuperTypes().get(0).getFullyQualifiedName().equals(cha));
            assert (ctx.getDirectSuperTypes().get(1).getFullyQualifiedName().equals(doc));

            ContextType ctx2 = new ContextType(paragraph, ctx);
            assert (ctx2.getDirectSuperTypes() != null && ctx2.getDirectSuperTypes().size() == 2);
            assert (ctx2.getDirectSuperTypes().get(0).getFullyQualifiedName().equals(par));
            assert (ctx2.getDirectSuperTypes().get(1).getDirectSuperTypes().get(0).getFullyQualifiedName().equals(cha));
            assert (ctx2.getDirectSuperTypes().get(1).getDirectSuperTypes().get(1).getFullyQualifiedName().equals(doc));
        } catch (LookupException e) {
            e.printStackTrace();
        }
    }
}
