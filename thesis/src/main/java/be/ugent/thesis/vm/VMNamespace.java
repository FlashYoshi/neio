package be.ugent.thesis.vm;

import org.aikodi.chameleon.core.namespace.RegularNamespace;

/**
 * @author Titouan Vervack
 */
public class VMNamespace extends RegularNamespace implements VMObject {
    public VMNamespace(String name) {
        super(name);
    }
}
