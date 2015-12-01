package be.ugent.neio.model.modifier;

import be.kuleuven.cs.distrinet.rejuse.property.PropertySet;
import be.ugent.neio.language.Neio;
import org.aikodi.chameleon.core.element.Element;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.core.modifier.ModifierImpl;
import org.aikodi.chameleon.core.property.ChameleonProperty;

/**
 * @author Titouan Vervack
 */
public class Nested extends ModifierImpl {
    @Override
    protected Element cloneSelf() {
        return new Nested();
    }

    @Override
    public PropertySet<Element, ChameleonProperty> impliedProperties() {
        return this.createSet(this.language(Neio.class).NESTED);
    }

    // TODO: is this allowed?
    @Override
    public boolean uniSameAs(Element other) throws LookupException {
        return getClass().isInstance(other);
    }
}
