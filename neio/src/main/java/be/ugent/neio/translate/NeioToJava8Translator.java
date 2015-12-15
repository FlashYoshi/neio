package be.ugent.neio.translate;

import be.kuleuven.cs.distrinet.jnome.core.language.Java7;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.model.document.TextDocument;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.core.namespace.Namespace;
import org.aikodi.chameleon.core.namespacedeclaration.NamespaceDeclaration;
import org.aikodi.chameleon.exception.ModelException;
import org.aikodi.chameleon.oo.method.Method;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.variable.FormalParameter;
import org.aikodi.chameleon.plugin.build.BuildException;
import org.aikodi.chameleon.plugin.build.BuildProgressHelper;
import org.aikodi.chameleon.support.modifier.Public;
import org.aikodi.chameleon.support.modifier.Static;
import org.aikodi.chameleon.support.translate.IncrementalTranslator;
import org.aikodi.chameleon.workspace.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NeioToJava8Translator extends IncrementalTranslator<Neio, Java7> {

    private boolean debug;

    public NeioToJava8Translator(View source, View target) {
        super(source, target);
        debug = false;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    @Override
    public Collection<Document> build(Document source, BuildProgressHelper buildProgressHelper) throws BuildException {
        List<Document> result;
        try {
            result = translate(source);
        } catch (ModelException e) {
            throw new BuildException(e);
        }
        return result;
    }

    public List<Document> translate(Document sourceDocument) throws ModelException {
        List<Document> result = new ArrayList<>();
        TextDocument document = (TextDocument) sourceDocument;
        prepareDocument(document);
        if (!debug) {
            document = createJavaDocument(document);
        }
        finishDocument(document);
        result.add(document);

        return result;
    }

    protected TextDocument createJavaDocument(TextDocument sourceDocument) throws LookupException {
        return new Java8Generator().createJavaDocument(sourceDocument);
    }

    private void prepareDocument(TextDocument document) {
        Neio neio = (Neio) document.language();
        NeioFactory ooFactory = (NeioFactory) neio.plugin(ObjectOrientedFactory.class);
        Type type = ooFactory.createRegularType(document.getName());
        type.addModifier(new Public());
        Method method = ooFactory.createMethod("main", "void");
        method.header().addFormalParameter(new FormalParameter("args", ooFactory.createTypeReference("String[]")));
        method.addModifier(new Public());
        method.addModifier(new Static());
        Block block = document.getBlock();
        method.setImplementation(ooFactory.createImplementation(block));
        type.add(method);

        NamespaceDeclaration ns = ooFactory.createNamespaceDeclaration(
                ooFactory.createNamespaceReference(document.loader().namespace().fullyQualifiedName()));
        ns.add(type);

        for (Namespace namespace : document.view().namespace().getSubNamespace("neio").descendantNamespaces()) {
            ns.addImport(ooFactory.createDemandImport(namespace.fullyQualifiedName()));
        }
        document.add(ns);
    }

    private void finishDocument(TextDocument document) {
        // There is only the main method
        Method main = document.nearestDescendants(Method.class).get(0);
        NeioFactory ooFactory = (NeioFactory) document.language().plugin(ObjectOrientedFactory.class);
        main.setImplementation(ooFactory.createImplementation(document.getBlock()));
    }
}
