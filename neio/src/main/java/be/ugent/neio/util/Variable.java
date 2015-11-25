package be.ugent.neio.util;

/**
 * @author Titouan Vervack
 */
public class Variable {

    private String typeName;
    private String varName;

    public Variable(String typeName, String varName) {
        this.typeName = typeName;
        this.varName = varName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }
}
