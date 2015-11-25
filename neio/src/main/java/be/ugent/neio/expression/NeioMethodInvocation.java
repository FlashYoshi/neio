package be.ugent.neio.expression;

import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.JavaMethodInvocation;
import be.ugent.neio.model.type.ContextType;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.core.reference.CrossReferenceTarget;
import org.aikodi.chameleon.oo.type.Type;

/**
 * @author Titouan Vervack
 */
public class NeioMethodInvocation extends JavaMethodInvocation {

    public NeioMethodInvocation(String name, CrossReferenceTarget target) {
        super(name, target);
    }

    @Override
    protected Type actualType() throws LookupException {
        Type returnType = super.actualType();
        Type contextType = (Type) getTarget().targetContext().declarationContainer();

        return new ContextType(returnType, contextType);
    }
}
