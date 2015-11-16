package be.ugent.neio.parsing;

import org.aikodi.chameleon.oo.type.TypeReference;

/**
 * @author Titouan Vervack
 */
public class Variable {
    private String name;
    private TypeReference type;

    public Variable(String name, TypeReference type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeReference getType() {
        return type;
    }

    public void setType(TypeReference type) {
        this.type = type;
    }
}
