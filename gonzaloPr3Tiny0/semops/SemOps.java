package semops;

import asint.Tiny0ASint;

public class SemOps extends Tiny0ASint {
    
    public Exp exp(String op, Exp arg0, Exp arg1) {
        
        switch(op) {
            
            case "and": return and(arg0, arg1);
            case "or": return or(arg0, arg1);
            case "<": return lt(arg0, arg1);
            case ">": return gt(arg0, arg1);
            case "<=": return let(arg0, arg1);
            case ">=": return get(arg0, arg1);
            case "==": return eq(arg0, arg1);
            case "!=": return neq(arg0, arg1);
            case "*": return mul(arg0, arg1);
            case "/": return div(arg0, arg1);
            
        }
        
        throw new UnsupportedOperationException("exp " + op);
        
    }
    
}
