package be.ugent.neio.language;

import be.kuleuven.cs.distrinet.rejuse.property.PropertySet;
import org.aikodi.chameleon.core.element.Element;
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
        try {
            return this.createSet(this.language().property("accessibility.nested"));
        } catch (NullPointerException var2) {
            return this.createSet(this.language().property("accessibility.nested"));
        }
    }
}
