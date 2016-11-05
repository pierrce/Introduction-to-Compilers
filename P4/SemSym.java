import java.util.*;

public class SemSym {
    private String type;
    private String varName;
    private List<String> params;

    public SemSym(String type) {
        this.type = type;
    }

    public SemSym(String t, List<String> p) {
        this.type = t;
        this.params = p;
    }

    public String getType() {
        return type;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String t) {
	this.varName = t;
    }

    public String toString() {
        return type;
    }
}
