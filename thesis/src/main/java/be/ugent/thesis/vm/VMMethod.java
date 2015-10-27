package be.ugent.thesis.vm;

import org.aikodi.chameleon.core.element.Element;
import org.aikodi.chameleon.oo.method.Method;
import org.aikodi.chameleon.oo.method.MethodHeader;
import org.aikodi.chameleon.oo.method.RegularMethod;

/**
 * @author Titouan Vervack
 */
public class VMMethod extends RegularMethod {

    public VMMethod(MethodHeader header) {
        super(header);
    }

    @Override
    public boolean sameKind(Method method) {
        return false;
    }

    @Override
    protected Element cloneSelf() {
        return null;
    }
}
