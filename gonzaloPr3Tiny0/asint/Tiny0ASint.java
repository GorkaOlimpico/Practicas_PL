package asint;

public class Tiny0ASint {
    
    public static abstract class Exp {
        
        public Exp() {}
        
        public abstract int prioridad();
        
        public abstract void procesa(Procesamiento p);
        
    }
    
    public static class StringLocalizado {
        
        private String s;
        private int fila;
        private int col;
        
        public StringLocalizado(String s, int fila, int col) {
            
            this.s = s;
            this.fila = fila;
            this.col = col;
            
        }
        
        public int fila() {
            return fila;
        }
        
        public int col() {
            return col;
        }
        
        public String toString() {
            return s;
        }
        
        public boolean equals(Object o) {
            
            return (o == this) ||
                    ((o instanceof StringLocalizado) &&
                            (((StringLocalizado)o).s.equals(s)));
            
        }
        
        public int hashCode() {
            return s.hashCode();
        }
        
    }
    
    public static class Int extends Exp {
        
        private StringLocalizado ent;
        
        public Int(StringLocalizado ent) {
            
            super();
            this.ent = ent;
            
        }
        
        public StringLocalizado ent() {
            return ent;
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
        public final int prioridad() {
            return 5;
        }
        
    }
    
    public static class Real extends Exp {
        
        private StringLocalizado real;
        
        public Real(StringLocalizado real) {
            super();
            this.real = real;
        }
        
        public StringLocalizado real() {
            return real;
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
        public final int prioridad() {
            return 5;
        }
        
    }
    
    public static class Id extends Exp {
        
        private StringLocalizado id;
        
        public Id(StringLocalizado id) {
            
            super();
            this.id = id;
            
        }
        
        public StringLocalizado id() {
            return id;
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
        public final int prioridad() {
            return 5;
        }
        
    }
    
    public static class True extends Exp {
        
        public True() {
            super();
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
        public String rTrue() {
            return "true";
        }
        
        public final int prioridad() {
            return 5;
        }
        
    }
    
    public static class False extends Exp {
        
        public False() {
            super();
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    
        public String rFalse() {
            return "false";
        }
        
        public final int prioridad() {
            return 5;
        }
        
    }
    
    private static abstract class ExpBin extends Exp {
        
        private Exp arg0;
        private Exp arg1;
    
        public ExpBin(Exp arg0, Exp arg1) {
        
            super();
            this.arg0 = arg0;
            this.arg1 = arg1;
        
        }
        
        public Exp arg0() {
            return arg0;
        }
        
        public Exp arg1() {
            return arg1;
        }
        
    }
    
    private static abstract class ExpUn extends Exp {
        
        private Exp arg;
        
        public ExpUn(Exp arg) {
            
            super();
            this.arg = arg;
            
        }
    
        public Exp arg() {
            return arg;
        }
        
        public final int prioridad() {
            return 4;
        }
        
    }
    
    private static abstract class ExpAditiva extends ExpBin {
        
        public ExpAditiva(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        
        public final int prioridad() {
            return 0;
        }
        
    }
    
    private static abstract class ExpMultiplicativa extends ExpBin {
        
        public ExpMultiplicativa(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        
        public final int prioridad() {
            return 3;
        }
        
    }
    
    private static abstract class ExpLogica extends ExpBin {
        
        public ExpLogica(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        
        public final int prioridad() {
            return 1;
        }
        
    }
    
    private static abstract class ExpRelacional extends ExpBin {
        
        public ExpRelacional(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        
        public final int prioridad() {
            return 2;
        }
        
    }
    
    public static class Suma extends ExpAditiva {
        
        public Suma(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
    }
    
    public static class Resta extends ExpAditiva {
        
        public Resta(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
    }
    
    public static class Mul extends ExpMultiplicativa {
        
        public Mul(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
    }
    
    public static class Div extends ExpMultiplicativa {
        
        public Div(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
    }
    
    public static class And extends ExpLogica {
        
        public And(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
    }
    
    public static class Or extends ExpLogica {
        
        public Or(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
    }
    
    public static class Lt extends ExpRelacional {
        
        public Lt(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
    }
    
    public static class Gt extends ExpRelacional {
        
        public Gt(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
    }
    
    public static class Let extends ExpRelacional {
        
        public Let(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
    }
    
    public static class Get extends ExpRelacional {
        
        public Get(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
    }
    
    public static class Eq extends ExpRelacional {
        
        public Eq(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
    }
    
    public static class Neq extends ExpRelacional {
        
        public Neq(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
    }
    
    public static class Menos extends ExpUn {
        
        public Menos(Exp arg) {
            super(arg);
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
    }
    
    public static class Not extends ExpUn {
        
        public Not(Exp arg) {
            super(arg);
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
    }
    
    public static class Programa {
        
        private Decs decs;
        private Instrs instrs;
        
        public Programa(Decs decs, Instrs instrs) {
            
            super();
            this.decs = decs;
            this.instrs = instrs;
            
        }
        
        public Decs decs() {
            return decs;
        }
        
        public Instrs instrs() {
            return instrs;
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
    }
    
    public static abstract class Tipo {
        
        public Tipo() {}
        
        public abstract void procesa(Procesamiento p);
        
    }
    
    public static class Tipo_int extends Tipo {
        
        public Tipo_int() {
            super();
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    
        public String rInt() {
            return "int";
        }
        
    }
    
    public static class Tipo_bool extends Tipo {
        
        public Tipo_bool() {
            super();
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    
        public String rBool() {
            return "bool";
        }
        
    }
    
    public static class Tipo_real extends Tipo {
        
        public Tipo_real() {
            super();
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    
        public String rReal() {
            return "real";
        }
        
    }
    
    public static class Dec {
        
        private Tipo tipo;
        private StringLocalizado id;
        
        public Dec(Tipo tipo, StringLocalizado id) {
            
            this.tipo = tipo;
            this.id = id;
            
        }
        
        public Tipo tipo() {
            return tipo;
        }
        
        public StringLocalizado id() {
            return id;
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
    }
    
    public static abstract class Decs {
        
        public Decs() {}
        
        public abstract void procesa(Procesamiento p);
        
    }
    
    public static class Decs_una extends Decs {
        
        private Dec dec;
        
        public Decs_una(Dec dec) {
            
            super();
            this.dec = dec;
            
        }
        
        public Dec dec() {
            return dec;
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
    }
    
    public static class Decs_varias extends Decs {
        
        private Dec dec;
        private Decs decs;
        
        public Decs_varias(Decs decs, Dec dec) {
            
            super();
            this.dec = dec;
            this.decs = decs;
            
        }
        
        public Dec dec() {
            return dec;
        }
        
        public Decs decs() {
            return decs;
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
    }
    
    public static abstract class Instr {
    
        public Instr() {}
    
        public abstract void procesa(Procesamiento p);
        
    }
    
    public static class Instr_asig extends Instr {
        
        private StringLocalizado id;
        private Exp exp;
        
        public Instr_asig(StringLocalizado id, Exp exp) {
            
            super();
            this.id = id;
            this.exp = exp;
            
        }
        
        public StringLocalizado id() {
            return id;
        }
        
        public Exp exp() {
            return exp;
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
    }
    
    public static abstract class Instrs {
        
        public Instrs() {}
        
        public abstract void procesa(Procesamiento p);
        
    }
    
    public static class Instrs_una extends Instrs {
        
        private Instr instr;
        
        public Instrs_una(Instr instr) {
            
            super();
            this.instr = instr;
            
        }
        
        public Instr instr() {
            return instr;
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
    }
    
    public static class Instrs_varias extends Instrs {
        
        private Instr instr;
        private Instrs instrs;
        
        public Instrs_varias(Instrs instrs, Instr instr) {
            
            super();
            this.instr = instr;
            this.instrs = instrs;
            
        }
        
        public Instr instr() {
            return instr;
        }
        
        public Instrs instrs() {
            return instrs;
        }
        
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
    }

    // Constructoras
    public Programa prog(Decs decs, Instrs instrs) {
        return new Programa(decs, instrs);
    }
    public Decs decs_una(Dec dec) {
        return new Decs_una(dec);
    }
    public Decs decs_varias(Decs decs, Dec dec) {
        return new Decs_varias(decs, dec);
    }
    public Dec dec(Tipo tipo, StringLocalizado id) {
        return new Dec(tipo, id);
    }
    public Tipo tipo_int() {
        return new Tipo_int();
    }
    public Tipo tipo_bool() {
        return new Tipo_bool();
    }
    public Tipo tipo_real() {
        return new Tipo_real();
    }
    public Instrs instrs_una(Instr instr) {
        return new Instrs_una(instr);
    }
    public Instrs instrs_varias(Instrs instrs, Instr instr) {
        return new Instrs_varias(instrs, instr);
    }
    public Instr instr_asig(StringLocalizado id, Exp exp) {
        return new Instr_asig(id, exp);
    }
    public Exp suma(Exp arg0, Exp arg1) {
        return new Suma(arg0, arg1);
    }
    public Exp resta(Exp arg0, Exp arg1) {
        return new Resta(arg0, arg1);
    }
    public Exp mul(Exp arg0, Exp arg1) {
        return new Mul(arg0, arg1);
    }
    public Exp div(Exp arg0, Exp arg1) {
        return new Div(arg0, arg1);
    }
    public Exp and(Exp arg0, Exp arg1) {
        return new And(arg0, arg1);
    }
    public Exp or(Exp arg0, Exp arg1) {
        return new Or(arg0, arg1);
    }
    public Exp lt(Exp arg0, Exp arg1) {
        return new Lt(arg0, arg1);
    }
    public Exp gt(Exp arg0, Exp arg1) {
        return new Gt(arg0, arg1);
    }
    public Exp let(Exp arg0, Exp arg1) {
        return new Let(arg0, arg1);
    }
    public Exp get(Exp arg0, Exp arg1) {
        return new Get(arg0, arg1);
    }
    public Exp eq(Exp arg0, Exp arg1) {
        return new Eq(arg0, arg1);
    }
    public Exp neq(Exp arg0, Exp arg1) {
        return new Neq(arg0, arg1);
    }
    public Exp menos(Exp arg) {
        return new Menos(arg);
    }
    public Exp not(Exp arg) {
        return new Not(arg);
    }
    public Exp id(StringLocalizado id) {
        return new Id(id);
    }
    public Exp ent(StringLocalizado ent) {
        return new Int(ent);
    }
    public Exp real(StringLocalizado real) {
        return new Real(real);
    }
    public Exp cTrue() {
        return new True();
    }
    public Exp cFalse() {
        return new False();
    }
    public StringLocalizado str(String s, int fila, int col) {
        return new StringLocalizado(s, fila, col);
    }
    
}
