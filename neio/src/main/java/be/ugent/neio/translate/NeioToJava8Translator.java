package be.ugent.neio.translate;

import be.kuleuven.cs.distrinet.jnome.core.language.Java7;
import be.ugent.neio.language.Neio;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.exception.ModelException;
import org.aikodi.chameleon.plugin.build.BuildException;
import org.aikodi.chameleon.plugin.build.BuildProgressHelper;
import org.aikodi.chameleon.support.member.simplename.variable.MemberVariableDeclarator;
import org.aikodi.chameleon.support.modifier.Private;
import org.aikodi.chameleon.support.translate.IncrementalTranslator;
import org.aikodi.chameleon.workspace.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NeioToJava8Translator extends IncrementalTranslator<Neio, Java7> {

    public NeioToJava8Translator(View source, View target) {
        super(source, target);
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
        Document interfaceDocument = createInterface(sourceDocument);
        result.add(interfaceDocument);
        Document implementationDocument = createImplementation(sourceDocument);
        if (implementationDocument != null) {
            result.add(implementationDocument);
        }
        return result;
    }

    protected Document createImplementation(Document sourceDocument) {
        Document result = sourceDocument.cloneTo(target());
        return new Java8ClassGenerator().createImplementation(result);
    }

    protected void makeFieldsPrivate(Document target) {
        target.apply(MemberVariableDeclarator.class, d -> d.addModifier(new Private()));
    }

    protected Document createInterface(Document sourceDocument) throws LookupException {
        Document result = sourceDocument.cloneTo(target());
        return new Java8InterfaceGenerator().createInterface(result);
    }
}
