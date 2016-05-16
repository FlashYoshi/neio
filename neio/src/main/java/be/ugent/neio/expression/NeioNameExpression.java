package be.ugent.neio.expression;

import be.kuleuven.cs.distrinet.jnome.core.expression.JavaNameExpression;
import be.ugent.neio.model.type.ContextType;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.oo.expression.NameExpression;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.variable.RegularVariable;

/**
 * @author Titouan Vervack
 */
public class NeioNameExpression extends JavaNameExpression {

    public NeioNameExpression(String identifier) {
        super(identifier);
    }

    @Override
    public NameExpression cloneSelf() {
        return new NeioNameExpression(name());
    }

    @Override
    protected ContextType actualType() throws LookupException {
        Type returnType = super.actualType();
        RegularVariable var = (RegularVariable) getElement();
        Type contextType;
        if (var.getInitialization() != null) {
            contextType = var.getInitialization().getType();
        } else {
            contextType = var.getType();
        }
        ContextType ctx = new ContextType(returnType, contextType);
        ctx.setUniParent(parent());

        return ctx;
    }
}
