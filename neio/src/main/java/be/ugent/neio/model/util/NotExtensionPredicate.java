package be.ugent.neio.model.util;

import org.aikodi.chameleon.util.Util;
import org.aikodi.chameleon.workspace.ExtensionPredicate;

/**
 * @author Titouan Vervack
 */
public class NotExtensionPredicate extends ExtensionPredicate {

    public NotExtensionPredicate(String ... extensions) {
        super(extensions);
    }

    @Override
    public boolean eval(String fileName) {
        boolean result = super.eval(fileName);

        if (Util.getAllButLastPart(fileName) == null) {
            return false;
        }

        return !result;
    }

    @Override
    public String toString() {
        return "Not" + super.toString();
    }
}
