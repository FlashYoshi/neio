package be.ugent.thesis.jlo.model.expression;


import org.aikodi.chameleon.oo.type.Type;
import be.ugent.thesis.jlo.model.component.Subobject;

/**
 * @author Marko van Dooren
 */
public class OuterTarget extends AbstractTarget {

  public OuterTarget() {
	}
  

  public Type getTargetDeclaration() {
    return nearestAncestor(Subobject.class).nearestAncestor(Type.class);
  }

  protected OuterTarget cloneSelf() {
	  return new OuterTarget();
	}

}
