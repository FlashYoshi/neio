package be.ugent.neio.parsing;

import org.aikodi.chameleon.oo.type.TypeReference;

/**
 * @author Titouan Vervack
 */
public class Variable {
    private final String methodName;
    private TypeReference type;
    private int level;
    private int nestingLevel;

    public Variable(TypeReference type, int level, String methodName) {
        this(type, level, methodName, -1);
    }

    public Variable(TypeReference type, int level, String methodName, int nestingLevel) {
        this.type = type;
        this.level = level;
        this.methodName = methodName;
        this.nestingLevel = nestingLevel;
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

    public String getMethodName() {
        return methodName;
    }

    public int getNestingLevel() {
        return nestingLevel;
    }
}
