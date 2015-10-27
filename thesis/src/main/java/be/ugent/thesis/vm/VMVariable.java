package be.ugent.thesis.vm;

import org.aikodi.chameleon.core.element.Element;
import org.aikodi.chameleon.oo.expression.Expression;
import org.aikodi.chameleon.oo.type.TypeReference;
import org.aikodi.chameleon.oo.variable.RegularVariable;

/**
 * @author Titouan Vervack
 */
public class VMVariable extends RegularVariable implements VMObject {
    public VMVariable(String name, TypeReference typeRef, Expression init) {
        super(name, typeRef, init);
    }

    @Override
    protected Element cloneSelf() {
        return null;
    }
}
