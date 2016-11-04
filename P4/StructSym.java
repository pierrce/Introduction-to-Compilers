public class StructSym {

    private String returnType;
    private List<String> paramTypes;

    public StructSym(String rt, List<String> pt) {
        this.returnType = rt;
        this.paramTypes = pt;
    }

    public String getReturnType() {
        return this.returnType;
    }

    public String getParamTypes() {
        string ret = "";
        for (int i = 0; i < paramTypes.size(); i++) {
            ret += (this.paramTypes.get(i) + " ");
        }
        return ret;
    }

    public String toString() {
        return "not implemented";
    }
}
