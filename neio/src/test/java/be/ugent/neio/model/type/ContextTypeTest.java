package be.ugent.neio.model.type;

import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.neio.builder.ClassBuilder;
import be.ugent.neio.expression.NeioMethodInvocation;
import be.ugent.neio.industry.NeioExpressionFactory;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.industry.NeioLanguageFactory;
import be.ugent.neio.language.Neio;
import org.aikodi.chameleon.core.factory.Factory;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.core.namespace.Namespace;
import org.aikodi.chameleon.core.namespacedeclaration.NamespaceDeclaration;
import org.aikodi.chameleon.oo.expression.Expression;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.oo.method.Method;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.support.modifier.Public;
import org.aikodi.chameleon.workspace.InputException;
import org.aikodi.chameleon.workspace.ProjectException;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Titouan Vervack
 */
public class ContextTypeTest {

    private final String doc;
    private final String par;
    private final String cha;
    private final Neio neio;
    private JavaView view;

    public ContextTypeTest() {
        doc = "neio.stdlib.Document";
        par = "neio.stdlib.Paragraph";
        cha = "neio.stdlib.Chapter";
        neio = new NeioLanguageFactory().create();
    }

    private NeioFactory ooFactory() {
        return (NeioFactory) neio.plugin(Factory.class);
    }

    private NeioExpressionFactory eFactory() {
        return (NeioExpressionFactory) neio.plugin(ExpressionFactory.class);
    }

    @Before
    public void initialize() {
        ClassBuilder builder = new ClassBuilder();
        view = (JavaView) builder.build("../base_library/project.xml");
    }

    @Test
    public void testConstruction() {
        try {
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

    @Test
    public void testMethodFind() throws LookupException, ProjectException, InputException {
        Method method = createTestMethod();
        Expression ci = eFactory().createConstructor(doc, null);
        NeioMethodInvocation mi0 = new NeioMethodInvocation("#", ci);
        mi0.addArgument(ooFactory().createStringLiteral("test1"));
        addToMethod(method, mi0);
        Method m0 = mi0.getElement();
        assert (m0.name().equals("#"));
        assert (!m0.isTrue(m0.language(Neio.class).NESTED));
        Type t0 = m0.nearestAncestor(Type.class);
        assert (t0.getFullyQualifiedName().equals(doc));

        NeioMethodInvocation mi1 = new NeioMethodInvocation("#", mi0);
        mi1.addArgument(ooFactory().createStringLiteral("test2"));
        mi1.addArgument(ooFactory().createIntegerLiteral("2"));
        addToMethod(method, mi1);
        Method m1 = mi1.getElement();
        assert (m1.name().equals("#"));
        assert (m1.isTrue(m1.language(Neio.class).NESTED));
        Type t1 = m1.nearestAncestor(Type.class);
        assert (t1.getFullyQualifiedName().equals(cha));

        NeioMethodInvocation mi2 = new NeioMethodInvocation("newline", mi1);
        mi2.addArgument(ooFactory().createStringLiteral("This is a newline"));
        addToMethod(method, mi2);
        Method m2 = mi2.getElement();
        assert (m2.name().equals("newline"));
        assert (!m2.isTrue(m2.language(Neio.class).NESTED));
        Type t2 = m2.nearestAncestor(Type.class);
        assert (t2.getFullyQualifiedName().equals(cha));

        NeioMethodInvocation mi3 = new NeioMethodInvocation("#", mi2);
        mi3.addArgument(ooFactory().createStringLiteral("test3"));
        addToMethod(method, mi3);
        Method m3 = mi3.getElement();
        assert (m3.name().equals("#"));
        assert (!m3.isTrue(m3.language(Neio.class).NESTED));
        Type t3 = m3.nearestAncestor(Type.class);
        assert (t3.getFullyQualifiedName().equals(doc));
    }

    @Test(expected = LookupException.class)
    public void testNoMethodFound() throws ProjectException, InputException, LookupException {
        Method method = createTestMethod();
        Expression ci = eFactory().createConstructor(doc, null);
        NeioMethodInvocation mi0 = new NeioMethodInvocation("###", ci);
        mi0.addArgument(ooFactory().createStringLiteral("test1"));
        mi0.addArgument(ooFactory().createIntegerLiteral("3"));
        addToMethod(method, mi0);

        mi0.getElement();
    }

    private void addToMethod(Method method, Expression expression) {
        Block block = method.implementation().getBody();
        Block newBlock = new Block();
        block.statements().forEach(newBlock::addStatement);

        newBlock.addStatement(ooFactory().createStatement(expression));
        method.setImplementation(ooFactory().createImplementation(newBlock));
    }

    private Method createTestMethod() throws InputException, ProjectException {
        Type type = ooFactory().createRegularType("Test");
        type.addModifier(new Public());
        Method method = ooFactory().createMethod("main", "void");
        method.setImplementation(ooFactory().createImplementation(new Block()));
        type.add(method);

        NamespaceDeclaration ns = ooFactory().createNamespaceDeclaration(
                ooFactory().createNamespaceReference("test"));
        ns.add(type);
        type.setUniParent(view.namespace());
        for (Namespace namespace : view.namespace().getSubNamespace("neio").descendantNamespaces()) {
            ns.addImport(ooFactory().createDemandImport(namespace.fullyQualifiedName()));
        }

        return method;
    }
}
