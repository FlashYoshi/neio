package be.ugent.neio.jlo.input;

import be.kuleuven.cs.distrinet.jnome.input.Java7Factory;
import be.ugent.neio.jlo.model.type.RegularJLoType;
import org.aikodi.chameleon.oo.type.RegularType;

public class JLoFactory extends Java7Factory {

    public JLoFactory() {

    }

    @Override
    public RegularType createRegularType(String name) {
        return new RegularJLoType(name);
    }

}
