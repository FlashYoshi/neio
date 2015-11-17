package be.ugent.neio.parsing;

import org.aikodi.chameleon.oo.type.TypeReference;

/**
 * @author Titouan Vervack
 */
public class Variable {
    private String name;
    private TypeReference type;
    private int level;

    public Variable(String name, TypeReference type) {
        this(name, type, -1);
    }

    public Variable(String name, TypeReference type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;
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

    public int getLevel() {
        return level;
    }

    public boolean isNested() {
        return level > 0;
    }
}
