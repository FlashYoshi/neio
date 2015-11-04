package be.ugent.neio.jlo.model.type;

import java.util.List;

import org.aikodi.chameleon.oo.type.ParameterSubstitution;
import org.aikodi.chameleon.oo.type.Type;

import be.kuleuven.cs.distrinet.jnome.core.type.CapturedType;

public class JLoCapturedType extends CapturedType implements JLoType {

	public JLoCapturedType(List<ParameterSubstitution<?>> parameters, Type baseType) {
		super(parameters,baseType);
	}

	public JLoCapturedType(ParameterSubstitution substitution, Type baseType) {
		super(substitution, baseType);
	}
	
	@Override
	public JLoCapturedType clone() {
		return new JLoCapturedType(clonedParameters(),baseType());
	}

}
