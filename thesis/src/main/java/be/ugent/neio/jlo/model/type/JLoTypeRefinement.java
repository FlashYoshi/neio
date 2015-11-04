package be.ugent.neio.jlo.model.type;

public class JLoTypeRefinement extends RegularJLoType {

	public JLoTypeRefinement(JLoType type) {
		super(type.name());
		addInheritanceRelation(new JLoSubtypeRelation(type));
		setUniParent(type.parent());
	}

}
