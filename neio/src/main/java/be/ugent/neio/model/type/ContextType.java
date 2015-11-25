package be.ugent.neio.model.type;

import be.kuleuven.cs.distrinet.jnome.core.type.DirectJavaTypeReference;
import be.kuleuven.cs.distrinet.jnome.core.type.RegularJavaType;
import org.aikodi.chameleon.core.lookup.DeclarationSelector;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.core.lookup.SelectionResult;
import org.aikodi.chameleon.oo.member.Member;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.type.inheritance.InheritanceRelation;
import org.aikodi.chameleon.oo.type.inheritance.SubtypeRelation;

import java.util.List;

/**
 * @author Titouan Vervack
 */
public class ContextType extends RegularJavaType {
    public ContextType(Type returnType, Type contextType) {
        super(returnType.name() + contextType.name());

        addInheritanceRelation(new SubtypeRelation(new DirectJavaTypeReference(returnType)));
        addInheritanceRelation(new SubtypeRelation(new DirectJavaTypeReference(contextType)));
    }

    @Override
    protected <D extends Member> List<SelectionResult<D>> inheritedMembers(DeclarationSelector selector, List<SelectionResult<D>> result) throws LookupException {
        for (InheritanceRelation rel : inheritanceRelations()) {
            result = rel.accumulateInheritedMembers(selector, result);
            if (!result.isEmpty()) {
                return result;
            }
        }

        return result;
    }
}
