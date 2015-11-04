/**
 * 
 */
package be.ugent.thesis.jlo.model.type;

import java.util.List;
import java.util.Set;

import org.aikodi.chameleon.core.element.Element;
import org.aikodi.chameleon.core.element.ElementImpl;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.type.TypeReference;
import org.aikodi.chameleon.oo.type.generics.InstantiatedTypeParameter;
import org.aikodi.chameleon.oo.type.generics.TypeParameter;
import org.aikodi.chameleon.util.association.Multi;
import org.aikodi.chameleon.util.association.Single;

import be.kuleuven.cs.distrinet.jnome.core.type.JavaTypeReference;

/**
 * @author Marko van Dooren
 *
 */
public class KeywordTypeReference extends ElementImpl implements JavaTypeReference {

  public KeywordTypeReference(TypeReference constructorReference) {
    setConstructorReference(constructorReference);
  }
  
  private final Multi<KeywordTypeArgument> _typeArguments = new Multi<>(this);
  
  public void add(KeywordTypeArgument argument) {
    add(_typeArguments, argument);
  }
  
  public List<KeywordTypeArgument> arguments() {
    return _typeArguments.getOtherEnds();
  }
  
  private Single<TypeReference> _typeConstructorReference = new Single<>(this);
  
  public void setConstructorReference(TypeReference typeReference) {
    set(_typeConstructorReference, typeReference);
  }
  
  public TypeReference typeConstructorReference() {
    return _typeConstructorReference.getOtherEnd();
  }
  
  @Override
  public Type getElement() throws LookupException {
    JLoType typeConstructor = (JLoType) typeConstructorReference().getElement();
    Type result = new JLoTypeRefinement(typeConstructor);
    arguments().forEach(a -> {
      TypeParameter parameter = new InstantiatedTypeParameter(a.name(), a.argument());
      TypeMemberDeclarator declarator = new TypeMemberDeclarator(parameter);
      result.add(declarator);
    });
    return result;
  }


  /**
   * @{inheritDoc}
   */
  @Override
  public String toString(Set<Element> visited) {
    StringBuilder builder = new StringBuilder();
    builder.append(typeConstructorReference().toString(visited));
    arguments().forEach(a -> builder.append(a.toString(visited)));
    return builder.toString();
  }

  /**
  /**
   * @{inheritDoc}
   */
  @Override
  public JavaTypeReference erasedReference() {
    return this;
  }

  /**
   * @{inheritDoc}
   */
  @Override
  public JavaTypeReference componentTypeReference() {
    return this;
  }

  /**
   * @{inheritDoc}
   */
  @Override
  protected Element cloneSelf() {
    return new KeywordTypeReference(null);
  }

}
