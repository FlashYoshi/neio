package be.ugent.neio.jlo.model.component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.core.validation.Valid;
import org.aikodi.chameleon.core.validation.Verification;
import org.aikodi.chameleon.oo.type.DeclarationWithType;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.util.association.Multi;

public class MultiActualComponentArgument extends ActualComponentArgument implements ComponentArgumentContainer {

	public MultiActualComponentArgument() {
		
	}
	public MultiActualComponentArgument(List<SingleActualComponentArgument> arguments) {
		addAll(arguments);
	}
	
	@Override
	public ComponentRelationSet declaration() throws LookupException {
		List<DeclarationWithType> relations = new ArrayList<DeclarationWithType>();
		for(SingleActualComponentArgument argument : arguments()) {
			relations.add(argument.declaration());
		}
		return new ComponentRelationSet(relations, formalParameter());
	}

	@Override
	protected MultiActualComponentArgument cloneSelf() {
		return new MultiActualComponentArgument();
	}

	@Override
	public Verification verifySelf() {
		return Valid.create();
	}

	
	public void addAll(Collection<? extends SingleActualComponentArgument> elements) {
		for(SingleActualComponentArgument element:elements) {
			add(element);
		}
	}
	
	private Multi<SingleActualComponentArgument> _elements = new Multi<SingleActualComponentArgument>(this);

	public void add(SingleActualComponentArgument element) {
	  add(_elements,element);
	}
	
	public void remove(SingleActualComponentArgument element) {
	  remove(_elements,element);
	}
	
	public List<SingleActualComponentArgument> arguments() {
		return _elements.getOtherEnds();
	}
	public Type containerType(ActualComponentArgument argument) throws LookupException {
		return nearestAncestor(ComponentArgumentContainer.class).containerType(this);
	}
	public FormalComponentParameter formalParameter(ActualComponentArgument argument) throws LookupException {
		return nearestAncestor(ComponentArgumentContainer.class).formalParameter(this);
	}

}
