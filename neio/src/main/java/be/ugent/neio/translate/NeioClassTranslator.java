package be.ugent.neio.translate;

import be.kuleuven.cs.distrinet.jnome.core.expression.ArrayCreationExpression;
import be.kuleuven.cs.distrinet.jnome.core.expression.ArrayInitializer;
import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.ConstructorInvocation;
import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.SuperConstructorDelegation;
import be.kuleuven.cs.distrinet.jnome.core.language.Java7;
import be.ugent.neio.industry.NeioExpressionFactory;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.language.Neio;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.oo.expression.Expression;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.oo.expression.MethodInvocation;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.statement.Statement;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.type.TypeReference;
import org.aikodi.chameleon.plugin.build.BuildException;
import org.aikodi.chameleon.plugin.build.BuildProgressHelper;
import org.aikodi.chameleon.support.member.simplename.method.NormalMethod;
import org.aikodi.chameleon.support.translate.IncrementalTranslator;
import org.aikodi.chameleon.workspace.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static be.ugent.neio.util.Constants.*;

/**
 * @author Titouan Vervack
 */
public class NeioClassTranslator extends IncrementalTranslator<Neio, Java7> {
    private final Neio neio;

    /**
     * Create a new incremental translator that translates documents from the given
     * source view into the given target view.
     *
     * @param source The source view
     * @param target The target view to which translated documented must be added.
     */
    public NeioClassTranslator(View source, View target) {
        super(source, target);
        neio = (Neio) source.language();
    }

    private NeioFactory ooFactory() {
        return (NeioFactory) neio.plugin(ObjectOrientedFactory.class);
    }

    private NeioExpressionFactory eFactory() {
        return (NeioExpressionFactory) neio.plugin(ExpressionFactory.class);
    }

    @Override
    public Collection<Document> build(Document source, BuildProgressHelper buildProgressHelper) throws BuildException {
        List<Document> result = new ArrayList<>();
        try {
            reflectNewcalls(source);
        } catch (LookupException e) {
            System.err.println("Lookup exception when trying to add to uses: " + e.getMessage());
        }

        result.add(source);
        return result;
    }

    /**
     * Adds which classes are being used in this Document to the {@code ADD_USE} list
     *
     * @param source The Document we want to analyse, it has to extend {@code BASE_CLASS}
     */
    private void reflectNewcalls(Document source) throws LookupException {
        TypeReference baseref = ooFactory().createTypeReference(BASE_CLASS);
        List<Type> klasses = source.nearestDescendants(Type.class);
        if (!klasses.isEmpty()) {
            Type klass = klasses.get(0);
            baseref.setUniParent(klass);
            Type base = baseref.getElement();

            // Only add items if they're a subclass of the base class
            if (klass.subtypeOf(base) && !klass.isTrue(neio.INTERFACE)) {
                List<ConstructorInvocation> newCalls = klass.nearestDescendants(ConstructorInvocation.class);
                // Small optimization
                if (newCalls.isEmpty()) {
                    return;
                }

                // Add the constructors to the 'uses' and switch it out with a call to GET_INSTANCE
                for (ConstructorInvocation ci : newCalls) {
                    if (ci.getType().subtypeOf(base)) {
                        subNewCall(ci);
                    }
                }
            }
        }
    }

    /**
     * Substitutes a new call by a call to {@code GET_INSTANCE} that gets the correct mapping
     *
     * @param ci The invocation of the new call that should be substituted, it has to extend {@code BASE_CLASS}
     */
    private void subNewCall(ConstructorInvocation ci) throws LookupException {
        List<Expression> parameters = ci.getActualParameters();
        List<Expression> arguments = new ArrayList<>();

        ArrayCreationExpression paramTypes = new ArrayCreationExpression(ooFactory().createTypeReference("Class[]"));
        ArrayCreationExpression params = new ArrayCreationExpression(ooFactory().createTypeReference("Object[]"));
        ArrayInitializer initializer = new ArrayInitializer();
        ArrayInitializer paramsInitializer = new ArrayInitializer();

        for (Expression parameter : parameters) {
            initializer.addInitializer(ooFactory().createClassLiteral(parameter.getType().name()));
            paramsInitializer.addInitializer(parameter);
        }

        paramTypes.setInitializer(initializer);
        params.setInitializer(paramsInitializer);
        arguments.add(ooFactory().createClassLiteral(ci.getType().name()));
        arguments.add(paramTypes);
        arguments.add(params);

        MethodInvocation mi = eFactory().createMethodInvocation(GET_INSTANCE, null, arguments);
        ci.replaceWith(mi);
    }
}
