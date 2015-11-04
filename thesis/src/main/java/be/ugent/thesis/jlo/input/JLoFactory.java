package be.ugent.thesis.jlo.input;

import org.aikodi.chameleon.oo.type.RegularType;
import be.ugent.thesis.jlo.model.type.RegularJLoType;

import be.kuleuven.cs.distrinet.jnome.input.Java7Factory;

public class JLoFactory extends Java7Factory {

	public JLoFactory() {
		
	}
	@Override
	public RegularType createRegularType(String name) {
		return new RegularJLoType(name);
	}
	
}
