package asint;

public class TinyASint {

	public static abstract class Exp {
		public Exp() {
		}

		public abstract int prioridad();

		public abstract void procesa(Procesamiento procesamiento);
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
			return (o == this) || ((o instanceof StringLocalizado) && (((StringLocalizado) o).s.equals(s)));
		}

		public int hashCode() {
			return s.hashCode();
		}
	}

	private static abstract class ExpBin extends Exp {
		private Exp arg0;
		private Exp arg1;

		public Exp arg0() {
			return arg0;
		}

		public Exp arg1() {
			return arg1;
		}

		public ExpBin(Exp arg0, Exp arg1) {
			super();
			this.arg0 = arg0;
			this.arg1 = arg1;
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

	private static abstract class ExpLogica extends ExpBin {
		public ExpLogica(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public final int prioridad() {
			return 1;
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

	private static abstract class ExpComparativa extends ExpBin {
		public ExpComparativa(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public final int prioridad() {
			return 2;
		}
	}

	public static class Beq extends ExpComparativa {
		public Beq(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Bne extends ExpComparativa {
		public Bne(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Bge extends ExpComparativa {
		public Bge(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Ble extends ExpComparativa {
		public Ble(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Blt extends ExpComparativa {
		public Blt(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Bgt extends ExpComparativa {
		public Bgt(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
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

	public static class Mod extends ExpMultiplicativa {
		public Mod(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	private static abstract class ExpUnaria extends Exp {
		private Exp arg0;

		public Exp arg0() {
			return arg0;
		}

		public ExpUnaria(Exp arg0) {
			super();
			this.arg0 = arg0;
		}

		public final int prioridad() {
			return 4;
		}
	}

	public static class Menos_unario extends ExpUnaria {
		public Menos_unario(Exp arg0) {
			super(arg0);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Not extends ExpUnaria {
		public Not(Exp arg0) {
			super(arg0);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Index extends Exp {
		private Exp exp1;
		private Exp exp2;

		public Index(Exp exp1, Exp exp2) {
			super();
			this.exp1 = exp1;
			this.exp2 = exp2;
		}

		public Exp exp1() {
			return exp1;
		}

		public Exp exp2() {
			return exp2;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		public int prioridad() {
			// TODO Auto-generated method stub
			return 5;
		}
	}

	public static class Punto extends Exp {
		private Exp exp;
		private StringLocalizado id;

		public Punto(Exp exp, StringLocalizado id) {
			super();
			this.exp = exp;
			this.id = id;
		}

		public Exp exp() {
			return exp;
		}

		public StringLocalizado id() {
			return id;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		public int prioridad() {
			// TODO Auto-generated method stub
			return 5;
		}
	}

	public static class Flecha extends Exp {
		private Exp exp;
		private StringLocalizado id;

		public Flecha(Exp exp, StringLocalizado id) {
			super();
			this.exp = exp;
			this.id = id;
		}

		public Exp exp() {
			return exp;
		}

		public StringLocalizado id() {
			return id;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		public int prioridad() {
			// TODO Auto-generated method stub
			return 5;
		}
	}

	public static class Indireccion extends Exp {
		private Exp exp;

		public Indireccion(Exp exp) {
			super();
			this.exp = exp;
		}

		public Exp exp() {
			return exp;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		public int prioridad() {
			return 6;
		}
	}

	public static abstract class Num extends Exp {
		private StringLocalizado num;

		public Num(StringLocalizado num) {
			super();
			this.num = num;
		}

		public final int prioridad() {
			return 7;
		}

		public StringLocalizado num() {
			return num;
		}
	}

	public static class Num_int extends Num {
		public Num_int(StringLocalizado num) {
			super(num);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Num_Real extends Num {
		public Num_Real(StringLocalizado num) {
			super(num);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
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
			return 7;
		}
	}

	public static class R_true extends Exp {
		public R_true() {
			super();
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		public final int prioridad() {
			return 7;
		}
	}

	public static class R_false extends Exp {
		public R_false() {
			super();
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		public final int prioridad() {
			return 7;
		}
	}

	public static class R_null extends Exp {
		public R_null() {
			super();
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		public final int prioridad() {
			return 7;
		}
	}

	public static class R_str extends Exp {
		private StringLocalizado id;

		public R_str(StringLocalizado id) {
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
			return 7;
		}
	}

	public static abstract class LDecs {
		public LDecs() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class LDecs_una extends LDecs {
		private Dec dec;

		public LDecs_una(Dec dec) {
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

	public static class LDecs_muchas extends LDecs {
		private Dec dec;
		private LDecs ldecs;

		public LDecs_muchas(LDecs ldecs, Dec dec) {
			super();
			this.dec = dec;
			this.ldecs = ldecs;
		}

		public Dec dec() {
			return dec;
		}

		public LDecs ldecs() {
			return ldecs;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class LInst {
		public LInst() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class Lista_inst_una extends LInst {
		private Inst inst;

		public Lista_inst_una(Inst inst) {
			super();
			this.inst = inst;
		}

		public Inst inst() {
			return inst;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Lista_inst_muchas extends LInst {
		private Inst inst;
		private LInst linst;

		public Lista_inst_muchas(LInst linst, Inst inst) {
			super();
			this.inst = inst;
			this.linst = linst;
		}

		public Inst inst() {
			return inst;
		}

		public LInst linst() {
			return linst;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class Prog {

		public Prog() {

		}

		public abstract void procesa(Procesamiento p);

	}

	public static class Prog_con_dec extends Prog {
		private LInst linst;
		private LDecs ldecs;

		public Prog_con_dec(LDecs ldecs, LInst linst) {
			super();
			this.linst = linst;
			this.ldecs = ldecs;

		}

		public LInst linst() {
			return linst;
		}

		public LDecs ldecs() {
			return ldecs;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Prog_sin_dec extends Prog {
		private LInst linst;

		public Prog_sin_dec(LInst linst) {
			super();
			this.linst = linst;
		}

		public LInst linst() {
			return linst;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class Tipo {
		public Tipo() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class Tipo_int extends Tipo {
		public Tipo_int() {
			super();
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Tipo_real extends Tipo {
		public Tipo_real() {
			super();
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Tipo_bool extends Tipo {
		public Tipo_bool() {
			super();
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Tipo_String extends Tipo {
		public Tipo_String() {
			super();
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Tipo_Id extends Tipo {
		private StringLocalizado id;

		public Tipo_Id(StringLocalizado id) {
			super();
			this.id = id;
		}

		public StringLocalizado id() {
			return id;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Tipo_Pointer extends Tipo {
		private Tipo t;

		public Tipo_Pointer(Tipo t) {
			super();
			this.t = t;
		}

		public Tipo tipo() {
			return t;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Tipo_Array extends Tipo {
		private StringLocalizado id;
		private Tipo t;

		public Tipo_Array(StringLocalizado id, Tipo t) {
			super();
			this.id = id;
			this.t = t;
		}

		public Tipo tipo() {
			return t;
		}

		public StringLocalizado id() {
			return id;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Tipo_Record extends Tipo {
		private LCampo lcampos;

		public Tipo_Record(LCampo lcampos) {
			super();
			this.lcampos = lcampos;
		}

		public LCampo lcampos() {
			return lcampos;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class LCampo {
		public LCampo() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class Campo_una extends LCampo {
		private Campo campo;

		public Campo_una(Campo campo) {
			super();
			this.campo = campo;
		}

		public Campo campo() {
			return campo;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

	}

	public static class Campo_muchas extends LCampo {
		private Campo campo;
		private LCampo campos;

		public Campo_muchas(LCampo campos, Campo campo) {
			super();
			this.campos = campos;
			this.campo = campo;
		}

		public Campo campo() {
			return campo;
		}

		public LCampo campos() {
			return campos;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

	}

	public static class Campo {
		private Tipo tipo;
		private StringLocalizado id;

		public Campo(Tipo tipo, StringLocalizado id) {
			this.id = id;
			this.tipo = tipo;
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

	public static abstract class Inst {
		public Inst() {
		}

		public abstract void procesa(Procesamiento p);

	}

	public static class Inst_asig extends Inst {
		private Exp exp1;
		private Exp exp2;

		public Inst_asig(Exp exp1, Exp exp2) {
			super();
			this.exp1 = exp1;
			this.exp2 = exp2;
		}

		public Exp exp1() {
			return exp1;
		}

		public Exp exp2() {
			return exp2;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Inst_if_then extends Inst {
		private Exp exp;
		private LInst_aux aux_linst_una;

		public Inst_if_then(Exp exp, LInst_aux aux_linst_una) {
			super();
			this.exp = exp;
			this.aux_linst_una = aux_linst_una;
		}

		public Exp exp() {
			return exp;
		}

		public LInst_aux aux_linst_una() {
			return aux_linst_una;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		
	}

	public static class Inst_if_then_else extends Inst {
		private Exp exp;
		private LInst_aux linst_aux1;
		private LInst_aux linst_aux2;

		public Inst_if_then_else(Exp exp, LInst_aux linst_aux1, LInst_aux linst_aux2) {
			super();
			this.exp = exp;
			this.linst_aux1 = linst_aux1;
			this.linst_aux2 = linst_aux2;
		}

		public Exp exp() {
			return exp;
		}

		public LInst_aux linst_aux1() {
			return linst_aux1;
		}

		public LInst_aux linst_aux2() {
			return linst_aux2;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Inst_while extends Inst {
		private Exp exp;
		private LInst_aux aux_linst_una;

		public Inst_while(Exp exp, LInst_aux aux_linst_una) {
			super();
			this.exp = exp;
			this.aux_linst_una = aux_linst_una;
		}

		public Exp exp() {
			return exp;
		}

		public LInst_aux aux_linst_una() {
			return aux_linst_una;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Inst_read extends Inst {
		private Exp exp;

		public Inst_read(Exp exp) {
			super();
			this.exp = exp;
		}

		public Exp exp() {
			return exp;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Inst_write extends Inst {
		private Exp exp;

		public Inst_write(Exp exp) {
			super();
			this.exp = exp;
		}

		public Exp exp() {
			return exp;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Inst_nl extends Inst {
		public Inst_nl() {
			super();
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Inst_new extends Inst {
		private Exp exp;

		public Inst_new(Exp exp) {
			super();
			this.exp = exp;
		}

		public Exp exp() {
			return exp;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Inst_delete extends Inst {
		private Exp exp;

		public Inst_delete(Exp exp) {
			super();
			this.exp = exp;
		}

		public Exp exp() {
			return exp;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Inst_call_con_params extends Inst {
		private StringLocalizado id;
		private LParreg real_params;

		public Inst_call_con_params(StringLocalizado id, LParreg real_params) {
			super();
			this.id = id;
			this.real_params = real_params;
		}

		public StringLocalizado id() {
			return id;
		}

		public LParreg real_params() {
			return real_params;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Inst_call_sin_params extends Inst {
		private StringLocalizado id;

		public Inst_call_sin_params(StringLocalizado id) {
			super();
			this.id = id;
		}

		public StringLocalizado id() {
			return id;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Inst_compuesta extends Inst {
		private Bloque bloque;

		public Inst_compuesta(Bloque bloque) {
			super();
			this.bloque = bloque;
		}

		public Bloque bloque() {
			return bloque;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class LInst_aux {
		public LInst_aux() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class Aux_linst_vacia extends LInst_aux {
		public Aux_linst_vacia() {
			super();
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Aux_linst_una extends LInst_aux {
		private LInst linst;

		public Aux_linst_una(LInst linst) {
			super();
			this.linst = linst;
		}

		public LInst linst() {
			return linst;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class LParreg {
		public LParreg() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class Par_reg_una extends LParreg {
		private Exp exp;
		
		public Par_reg_una(Exp exp) {
			super();
			this.exp = exp;
		}

		public Exp exp() {
			return exp;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		


	}

	public static class Par_reg_muchas extends LParreg {
		private Exp exp;
		private LParreg params;

		public Par_reg_muchas(Exp exp, LParreg params) {
			super();
			this.params = params;
			this.exp = exp;
		}

		public Exp exp() {
			return exp;
		}

		public LParreg params() {
			return params;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class Dec {
		private StringLocalizado id;

		public Dec(StringLocalizado id) {
			this.id = id;
		}

		public StringLocalizado id() {
			return id;
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class Dec_Var extends Dec {
		private Tipo tipo;

		public Dec_Var(Tipo tipo, StringLocalizado id) {
			super(id);
			this.tipo = tipo;
		}

		public Tipo tipo() {
			return tipo;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

	}

	public static class Dec_Type extends Dec {
		private Tipo tipo;

		public Dec_Type(Tipo tipo, StringLocalizado id) {
			super(id);
			this.tipo = tipo;
		}

		public Tipo tipo() {
			return tipo;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

	}

	public static class Dec_proc extends Dec {
		private Bloque bloque;
		private LPF lparams;
		
		public Dec_proc(StringLocalizado id, LPF lparams, Bloque b) {
			super(id);
			this.bloque = b;
			this.lparams = lparams;
		}
		
		public LPF lparams() {
			return lparams;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		public Bloque bloque() {
			return bloque;
		}

	}


	public static abstract class LPF {
		public LPF() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class Param_una extends LPF {
		private PF param;

		public Param_una(PF param) {
			super();
			this.param = param;
		}

		public PF param() {
			return param;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Param_muchas extends LPF {
		private PF param;
		private LPF lparams;

		public Param_muchas(LPF lparams, PF param) {
			super();
			this.lparams = lparams;
			this.param = param;
		}

		public PF param() {
			return param;
		}

		public LPF lparams() {
			return lparams;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class PF {
		private StringLocalizado id;
		private Tipo tipo;

		public PF(Tipo tipo, StringLocalizado id) {
			this.id = id;
			this.tipo = tipo;
		}

		public StringLocalizado id() {
			return id;
		}

		public Tipo tipo() {
			return tipo;
		}

		public abstract void procesa(Procesamiento p);

	}

	public static class Param_con_et extends PF {
		public Param_con_et(Tipo tipo, StringLocalizado id) {
			super(tipo, id);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Param_sin_et extends PF {
		public Param_sin_et(Tipo tipo, StringLocalizado id) {
			super(tipo, id);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Bloque {
		private Prog prog;
		
		public Bloque(Prog prog) {
			this.prog = prog;
		}

		public Prog prog() {
			return prog;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	
	// Constructoras
	public Prog prog_con_dec(LDecs ldecs, LInst linst) {
		return new Prog_con_dec(ldecs, linst);
	}

	public Prog prog_sin_dec(LInst linst) {
		return new Prog_sin_dec(linst);
	}

	public LDecs lista_dec_una(Dec dec) {
		return new LDecs_una(dec);
	}

	public LDecs lista_dec_muchas(LDecs ldecs, Dec dec) {
		return new LDecs_muchas(ldecs, dec);
	}

	public Dec dec_var(Tipo tipo, StringLocalizado id) {
		return new Dec_Var(tipo, id);
	}

	public Dec dec_type(Tipo tipo, StringLocalizado id) {
		return new Dec_Type(tipo, id);
	}

	public Dec dec_proc(StringLocalizado id, LPF lparams, Bloque bloque) {
		return new Dec_proc(id, lparams, bloque);
	}

	public LPF param_una(PF param) {
		return new Param_una(param);
	}

	public LPF param_muchas(LPF lparams, PF param) {
		return new Param_muchas(lparams, param);
	}

	public PF param_con_et(Tipo tipo, StringLocalizado id) {
		return new Param_con_et(tipo, id);
	}

	public PF param_sin_et(Tipo tipo, StringLocalizado id) {
		return new Param_sin_et(tipo, id);
	}

	public Tipo tipo_Entero() {
		return new Tipo_int();
	}

	public Tipo tipo_Real() {
		return new Tipo_real();
	}

	public Tipo tipo_Bool() {
		return new Tipo_bool();
	}

	public Tipo tipo_String() {
		return new Tipo_String();
	}

	public Tipo tipo_Id(StringLocalizado id) {
		return new Tipo_Id(id);
	}

	public Tipo tipo_Pointer(Tipo t) {
		return new Tipo_Pointer(t);
	}

	public Tipo tipo_Array(StringLocalizado id, Tipo t) {
		return new Tipo_Array(id, t);
	}

	public Tipo tipo_Record(LCampo lcampos) {
		return new Tipo_Record(lcampos);
	}

	public LCampo campo_una(Campo campo) {
		return new Campo_una(campo);
	}

	public LCampo campo_muchas(LCampo campos, Campo campo) {
		return new Campo_muchas(campos, campo);
	}

	public Campo campo(Tipo t, StringLocalizado id) {
		return new Campo(t, id);
	}

	public LInst lista_inst_una(Inst inst) {
		return new Lista_inst_una(inst);
	}

	public LInst lista_inst_muchas(LInst linst, Inst inst) {
		return new Lista_inst_muchas(linst, inst);
	}

	public Inst inst_asig(Exp e1, Exp e2) {
		return new Inst_asig(e1, e2);
	}

	public Inst inst_if_then(Exp exp, LInst_aux linst) {
		return new Inst_if_then(exp, linst);
	}

	public Inst inst_if_then_else(Exp exp, LInst_aux linst, LInst_aux linst1) {
		return new Inst_if_then_else(exp, linst, linst1);
	}

	public LInst_aux aux_linst_vacia() {
		return new Aux_linst_vacia();
	}

	public LInst_aux aux_linst_una(LInst linst) {
		return new Aux_linst_una(linst);

	}

	public Inst inst_while(Exp exp, LInst_aux linst) {
		return new Inst_while(exp, linst);
	}

	public Inst inst_read(Exp exp) {
		return new Inst_read(exp);
	}

	public Inst inst_write(Exp exp) {
		return new Inst_write(exp);
	}

	public Inst inst_nl() {
		return new Inst_nl();
	}

	public Inst inst_new(Exp exp) {
		return new Inst_new(exp);
	}

	public Inst inst_delete(Exp exp) {
		return new Inst_delete(exp);
	}

	public Inst inst_call_sin_params(StringLocalizado id) {
		return new Inst_call_sin_params(id);
	}

	public Inst inst_call_con_params(StringLocalizado id, LParreg params) {
		return new Inst_call_con_params(id, params);
	}

	public LParreg par_reg_una(Exp exp) {
		return new Par_reg_una(exp);
	}

	public LParreg par_reg_muchas(Exp exp, LParreg params) {
		return new Par_reg_muchas(exp, params);
	}

	public Inst inst_compuesta(Bloque b) {
		return new Inst_compuesta(b);
	}

	public Bloque bloque(Prog prog) {
		return new Bloque(prog);
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

	public Exp beq(Exp arg0, Exp arg1) {
		return new Beq(arg0, arg1);
	}

	public Exp bne(Exp arg0, Exp arg1) {
		return new Bne(arg0, arg1);
	}

	public Exp ble(Exp arg0, Exp arg1) {
		return new Ble(arg0, arg1);
	}

	public Exp bge(Exp arg0, Exp arg1) {
		return new Bge(arg0, arg1);
	}

	public Exp bgt(Exp arg0, Exp arg1) {
		return new Bgt(arg0, arg1);
	}

	public Exp blt(Exp arg0, Exp arg1) {
		return new Blt(arg0, arg1);
	}

	public Exp c_and(Exp arg0, Exp arg1) {
		return new And(arg0, arg1);
	}

	public Exp mod(Exp arg0, Exp arg1) {
		return new Mod(arg0, arg1);
	}

	public Exp c_or(Exp arg0, Exp arg1) {
		return new Or(arg0, arg1);
	}

	public Exp c_not(Exp exp) {
		return new Not(exp);
	}

	public Exp menos_unario(Exp exp) {
		return new Menos_unario(exp);
	}

	public Exp num_int(StringLocalizado num) {
		return new Num_int(num);
	}

	public Exp num_real(StringLocalizado num) {
		return new Num_Real(num);
	}

	public Exp identificador(StringLocalizado id) {
		return new Id(id);
	}

	public Exp c_false() {
		return new R_false();
	}

	public Exp c_true() {
		return new R_true();
	}

	public Exp c_null() {
		return new R_null();
	}

	public Exp c_str(StringLocalizado id) {
		return new R_str(id);
	}

	public Exp index(Exp arg0, Exp arg1) {
		return new Index(arg0, arg1);
	}

	public Exp indireccion(Exp arg0) {
		return new Indireccion(arg0);
	}

	public Exp punto(Exp arg0, StringLocalizado id) {
		return new Punto(arg0, id);
	}

	public Exp flecha(Exp arg0, StringLocalizado id) {
		return new Flecha(arg0, id);
	}

	public StringLocalizado str(String s, int fila, int col) {
		return new StringLocalizado(s, fila, col);
	}

}
