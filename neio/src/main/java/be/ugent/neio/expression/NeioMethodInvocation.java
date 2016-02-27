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

    // TODO: Check errors that are produced due to different actualType()
    // Used to make certain a NeioMethodInvocation does not turn into a JavaMethodInvocation
    @Override
    protected NeioMethodInvocation cloneSelf() {
        return new NeioMethodInvocation(name(), null);
    }

    @Override
    protected Type actualType() throws LookupException {
        Type returnType = super.actualType();
        Type contextType = (Type) getTarget().targetContext().declarationContainer();

        ContextType ctx = new ContextType(returnType, contextType);
        ctx.setUniParent(getTarget());

        return ctx;
    }
}
