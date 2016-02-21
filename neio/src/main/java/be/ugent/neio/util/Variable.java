package be.ugent.neio.util;

import org.aikodi.chameleon.oo.type.Type;

/**
 * @author Titouan Vervack
 */
public class Variable {

    private Type type;
    private String varName;

    public Variable(Type type, String varName) {
        this.type = type;
        this.varName = varName;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type typeName) {
        this.type = type;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }
}
