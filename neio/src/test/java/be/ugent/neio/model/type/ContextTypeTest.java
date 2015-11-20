package be.ugent.neio.model.type;

import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.neio.builder.ClassBuilder;
import be.ugent.neio.industry.NeioExpressionFactory;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.industry.NeioLanguageFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.model.document.TextDocument;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.core.namespace.LazyRootNamespace;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.oo.expression.MethodInvocation;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.type.BasicTypeReference;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.support.member.simplename.method.RegularMethodInvocation;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author Titouan Vervack
 */
public class ContextTypeTest {

    private Neio neio;
    private JavaView view;
    private Document document;

    @Before
    public void initialize() {
        ClassBuilder builder = new ClassBuilder();
        List<Document> documents = builder.build("../base_library/project.xml");
        document = documents.get(0);
        view = document.view(JavaView.class);
        neio = new NeioLanguageFactory().create();
    }

    protected NeioFactory ooFactory() {
        return (NeioFactory) neio.plugin(ObjectOrientedFactory.class);
    }

    protected NeioExpressionFactory expressionFactory() {
        return (NeioExpressionFactory) neio.plugin(ExpressionFactory.class);
    }

    @Test
    public void testMembers() {
        try {
            Type doc = view.findType("Document");
            Type chapter1 = view.findType("Chapter");
            ContextType ctx = new ContextType(chapter1, doc);
            Type chapter2 = view.findType("Chapter");
            ContextType ctx2 = new ContextType(chapter2, ctx);
            MethodInvocation mi = new RegularMethodInvocation("#", new BasicTypeReference(ctx.name()));
            MethodInvocation mi2 = new RegularMethodInvocation("##", new BasicTypeReference(ctx2.name()));

            Neio target = new NeioLanguageFactory().create();
            JavaView targetView = new JavaView(new LazyRootNamespace(), target);
            TextDocument d = new TextDocument(targetView, document, new Block());
            d.namespaceDeclarations().get(0).add(ctx);
            d.namespaceDeclarations().get(0).add(ctx2);

            ctx.members(mi.selector());
        } catch (LookupException e) {
            e.printStackTrace();
        }
    }
}
