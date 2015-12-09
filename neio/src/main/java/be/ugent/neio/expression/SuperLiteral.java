package be.ugent.neio.expression;

import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.type.TypeReference;
import org.aikodi.chameleon.support.expression.LiteralWithTypeReference;

/**
 * TODO: This should not be a literal
 * @author Titouan Vervack
 */
public class SuperLiteral extends LiteralWithTypeReference {

    public SuperLiteral() {
        super("super");
    }

    public SuperLiteral(TypeReference ref) {
        super("super", ref);
    }

    @Override
    protected Type actualType() throws LookupException {
        TypeReference tref = getTypeReference();
        if (tref == null) {
            return nearestAncestor(Type.class);
        } else {
            return tref.getElement();
        }
    }

    @Override
    protected SuperLiteral cloneSelf() {
        return new SuperLiteral();
    }
}
