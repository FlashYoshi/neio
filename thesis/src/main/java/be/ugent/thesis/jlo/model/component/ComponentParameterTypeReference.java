package be.ugent.thesis.jlo.model.component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.aikodi.chameleon.core.declaration.Declaration;
import org.aikodi.chameleon.core.element.Element;
import org.aikodi.chameleon.core.element.ElementImpl;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.core.validation.Valid;
import org.aikodi.chameleon.core.validation.Verification;
import org.aikodi.chameleon.oo.language.ObjectOrientedLanguage;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.type.TypeInstantiation;
import org.aikodi.chameleon.util.association.Multi;
import org.aikodi.chameleon.util.association.Single;

import be.kuleuven.cs.distrinet.jnome.core.type.ArrayTypeReference;
import be.kuleuven.cs.distrinet.jnome.core.type.JavaTypeReference;

/**
 * @deprecated
 * @author Marko van Dooren
 */
public class ComponentParameterTypeReference extends ElementImpl implements JavaTypeReference,ComponentArgumentContainer {

	public ComponentParameterTypeReference(JavaTypeReference target) {
		setTarget(target);
	}
	
  public JavaTypeReference target() {
  	return _componentType.getOtherEnd();
  }
  
  private Single<JavaTypeReference> _componentType = new Single<JavaTypeReference>(this);

  public void setTarget(JavaTypeReference target) {
    set(_componentType, target);
  }
  
  public List<ActualComponentArgument> componentArguments() {
  	return _genericParameters.getOtherEnds();
  }
  
  public void addArgument(ActualComponentArgument arg) {
  	add(_genericParameters,arg);
  }
  
  public void addAllArguments(List<ActualComponentArgument> args) {
  	for(ActualComponentArgument argument : args) {
  		addArgument(argument);
  	}
  }
  
  public void removeArgument(ActualComponentArgument arg) {
  	remove(_genericParameters,arg);
  }
  
  public int indexOf(ActualComponentArgument arg) {
  	return _genericParameters.indexOf(arg);
  }
  
  private Multi<ActualComponentArgument> _genericParameters = new Multi<ActualComponentArgument>(this);

	public Type getElement() throws LookupException {
		Type componentType = target().getElement();
		List<ComponentParameter> parameters = new ArrayList<ComponentParameter>();
		List<ActualComponentArgument> componentArguments = componentArguments();
		List<ComponentParameter> formalParameters = target().getElement().parameters(ComponentParameter.class);
		if(componentArguments.size() != formalParameters.size()) {
			throw new LookupException("The number of actual component parameters: "+componentArguments.size()+ " does not match the number of formal component parameters: "+formalParameters.size());
		}
		Iterator<ActualComponentArgument> arguments =  componentArguments.iterator();
		Iterator<ComponentParameter> formals = formalParameters.iterator();
		while(arguments.hasNext()) {
			ActualComponentArgument arg = arguments.next();
			parameters.add(new InstantiatedComponentParameter(formals.next().name(), arg));
		}
		TypeInstantiation result = language(ObjectOrientedLanguage.class).createDerivedType(ComponentParameter.class, parameters, componentType);
		result.setUniParent(componentType.parent());
		return result;
	}

	public Declaration getDeclarator() throws LookupException {
		return target().getDeclarator();
	}

	public JavaTypeReference toArray(int dimension) {
  	JavaTypeReference result;
  	if(dimension > 0) {
  	  result = new ArrayTypeReference(clone(this), dimension);
  	} else {
  		result = this;
  	}
  	return result;
	}

	public JavaTypeReference erasedReference() {
		JavaTypeReference erasedReference = target().erasedReference();
		ComponentParameterTypeReference result = new ComponentParameterTypeReference(erasedReference);
		return result;
	}

	public JavaTypeReference componentTypeReference() {
		return target().componentTypeReference();
	}

	@Override
	protected ComponentParameterTypeReference cloneSelf() {
		return new ComponentParameterTypeReference(null);
	}

	@Override
	public Verification verifySelf() {
		return Valid.create();
	}

	public Type containerType(ActualComponentArgument argument) throws LookupException {
		return formalParameter(argument).containerType();
	}

	public FormalComponentParameter formalParameter(ActualComponentArgument argument) throws LookupException {
	  Type enclosing = componentTypeReference().getElement();
	  int index = indexOf(argument);
	  if(index >= 0) {
	  	return (FormalComponentParameter) enclosing.parameter(ComponentParameter.class, index);
	  } else {
	  	throw new LookupException("The given argument does not belong to this component parameter type reference.");
	  }
	}

	@Override
	public String toString(Set<Element> visited) {
		return "";
	}

}
