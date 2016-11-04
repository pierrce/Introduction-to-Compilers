import java.util.*;

public class SemSym {
    private String type;
    private String typeName;
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

    public String getKind() {
        return typeName;
    }

    public String toString() {
        return type;
    }
}
