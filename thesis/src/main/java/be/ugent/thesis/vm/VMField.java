package be.ugent.thesis.vm;

import org.aikodi.chameleon.oo.type.TypeReference;
import org.aikodi.chameleon.oo.variable.RegularMemberVariable;

/**
 * @author Titouan Vervack
 */
public class VMField extends RegularMemberVariable {
    public VMField(String name, TypeReference type) {
        super(name, type);
    }
}
