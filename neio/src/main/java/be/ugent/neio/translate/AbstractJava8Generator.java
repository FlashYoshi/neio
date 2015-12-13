package be.ugent.neio.translate;

import be.kuleuven.cs.distrinet.jnome.core.language.Java7;
import be.ugent.neio.language.Neio;
import org.aikodi.chameleon.core.element.Element;

public abstract class AbstractJava8Generator {

    protected Neio neio(Element element) {
        return element.language(Neio.class);
    }

    protected Java7 java(Element element) {
        return element.language(Java7.class);
    }
}
