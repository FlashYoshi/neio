package be.ugent.neio.translate;

import be.kuleuven.cs.distrinet.jnome.core.language.Java7;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.model.document.TextDocument;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.exception.ModelException;
import org.aikodi.chameleon.oo.method.Method;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
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

    private final String name;

    public NeioToJava8Translator(View source, View target, String name) {
        super(source, target);
        this.name = name;
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
        TextDocument interfaceDocument = createJavaDocument(document);
        finishDocument(interfaceDocument);
        result.add(interfaceDocument);

        return result;
    }

    protected TextDocument createJavaDocument(TextDocument sourceDocument) throws LookupException {
        return new Java8Generator().createJavaDocument(sourceDocument);
    }

    private void finishDocument(TextDocument document) {
        Neio neio = (Neio) document.language();
        NeioFactory ooFactory = (NeioFactory) neio.plugin(ObjectOrientedFactory.class);
        Type type = ooFactory.createRegularType(name);
        type.addModifier(new Public());
        Method method = ooFactory.createMethod("main", "void");
        method.header().addFormalParameter(new FormalParameter("args", ooFactory.createTypeReference("String[]")));
        method.addModifier(new Public());
        method.addModifier(new Static());

        method.setImplementation(ooFactory.createImplementation(document.getBlock()));
        type.add(method);
        document.namespaceDeclarations().get(0).add(type);
    }
}
