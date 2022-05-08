package procesamientos;

import asint.ProcesamientoPorDefecto;


import asint.TinyASint.*;


public class Impresion extends ProcesamientoPorDefecto {
	public Impresion() {
	}

	public void procesa(Prog_con_dec prog) {
		prog.ldecs().procesa(this);
		System.out.println();
		System.out.println("&&");
		prog.linst().procesa(this);
		System.out.println();
	}

	public void procesa(Prog_sin_dec prog) {
		prog.linst().procesa(this);
		System.out.println();
	}

	public void procesa(LDecs_una lDecs_una) {
		lDecs_una.dec().procesa(this);
	}

	public void procesa(LDecs_muchas lDecs_muchas) {
		lDecs_muchas.ldecs().procesa(this);
		System.out.println(";");
		lDecs_muchas.dec().procesa(this);

	}

	public void procesa(Dec_Var dec) {
		System.out.print(" var ");
		dec.tipo().procesa(this);
		System.out.print(" ");
		System.out.print(dec.id());

	}

	public void procesa(Dec_Type dec) {
		System.out.print(" type ");
		dec.tipo().procesa(this);
		System.out.print(" ");
		System.out.print(dec.id());

	}

	public void procesa(Dec_proc_con_params dec) {
		System.out.print(" proc ");
		System.out.print(dec.id());
		System.out.print("(");
		dec.lparams().procesa(this);
		System.out.print(")");
		dec.bloque().procesa(this);

	}
	public void procesa(Dec_proc_sin_params dec) {
		System.out.print(" proc ");
		System.out.print(dec.id());
		System.out.print("(");
		System.out.print(")");
		dec.bloque().procesa(this);

	}


	public void procesa(Param_una param_una) {
		param_una.param().procesa(this);
	}

	public void procesa(Param_muchas param_muchas) {
		param_muchas.lparams().procesa(this);
		System.out.print(",");
		param_muchas.lparams().procesa(this);
	}

	public void procesa(Param_con_et param) {
		param.tipo().procesa(this);
		System.out.print(" & ");
		System.out.print(param.id());
	}

	public void procesa(Param_sin_et param) {
		param.tipo().procesa(this);
		System.out.print(param.id());
	}

	public void procesa(Tipo_int tipo_int) {
		System.out.print("int ");
	}

	public void procesa(Tipo_real tipo_real) {
		System.out.print("real ");
	}

	public void procesa(Tipo_bool tipo_bool) {
		System.out.print("bool ");
	}

	public void procesa(Tipo_String tipo_s) {
		System.out.print(" string ");
	}

	public void procesa(Tipo_Id tipo_id) {
		System.out.print(tipo_id.id());
	}

	public void procesa(Tipo_Pointer tipo_Pointer) {
		System.out.print("pointer ");
		tipo_Pointer.tipo().procesa(this);

	}

	public void procesa(Tipo_Array tipo_Array) {
		System.out.print("array ");
		System.out.print("[");
		System.out.print(tipo_Array.id());
		System.out.print("] of");
		tipo_Array.tipo().procesa(this);

	}

	public void procesa(Tipo_Record tipo_Record) {
		System.out.println("record {");
		tipo_Record.lcampos().procesa(this);
		System.out.println();
		System.out.print("} ");

	}

	public void procesa(Campo_muchas campo_muchas) {
		campo_muchas.campos().procesa(this);
		System.out.println(";");
		campo_muchas.campo().procesa(this);
	}

	public void procesa(Campo_una campo_una) {
		campo_una.campo().procesa(this);
	}

	public void procesa(Campo campo) {
		campo.tipo().procesa(this);
		System.out.print(" " +campo.id());
	}

	public void procesa(Lista_inst_una lista_inst_una) {
		lista_inst_una.inst().procesa(this);
	}

	public void procesa(Lista_inst_muchas lista_inst_muchas) {
		lista_inst_muchas.linst().procesa(this);
		System.out.println(";");
		lista_inst_muchas.inst().procesa(this);
	}

	public void procesa(Inst_asig inst) {
		inst.exp1().procesa(this);
		System.out.print(" = ");
		inst.exp2().procesa(this);
	}

	public void procesa(Inst_if_then inst) {
		System.out.print(" if ");
		inst.exp().procesa(this);
		System.out.print(" then ");
		System.out.println();
		inst.aux_linst_una().procesa(this);
		System.out.println();
		System.out.print(" endif ");
	}

	public void procesa(Inst_if_then_else inst) {
		System.out.print(" if ");
		inst.exp().procesa(this);
		System.out.print(" then ");
		System.out.println();
		inst.linst_aux1().procesa(this);
		System.out.println();
		System.out.print(" else ");
		System.out.println();
		inst.linst_aux2().procesa(this);
		System.out.println();
		System.out.print(" endif ");
	}

	public void procesa(Aux_linst_vacia aux_linst_vacia) {
		System.out.print(" ");
	}

	public void procesa(Aux_linst_una aux_linst_una) {
		aux_linst_una.linst().procesa(this);
	}

	public void procesa(Inst_while inst) {
		System.out.print(" while ");
		inst.exp().procesa(this);
		System.out.println(" do ");
		inst.aux_linst_una().procesa(this);
		System.out.println();
		System.out.print(" endwhile ");
	}

	public void procesa(Inst_read inst) {
		System.out.print(" read ");
		inst.exp().procesa(this);
	}

	public void procesa(Inst_write inst) {
		System.out.print(" write ");
		inst.exp().procesa(this);
	}

	public void procesa(Inst_nl inst) {
		System.out.print(" nl ");
	}

	public void procesa(Inst_new inst) {
		System.out.print(" new ");
		inst.exp().procesa(this);
	}

	public void procesa(Inst_delete inst) {
		System.out.print(" delete ");
		inst.exp().procesa(this);
	}

	public void procesa(Inst_call_con_params inst) {
		System.out.print(" call " + inst.id() + "(");
		inst.real_params().procesa(this);
		System.out.print(")");
	}

	public void procesa(Inst_call_sin_params inst) {
		System.out.print(" call " + inst.id() + "()");
	}

	public void procesa(Par_reg_una par_reg_una) {
		par_reg_una.exp().procesa(this);
	}

	public void procesa(Par_reg_muchas par_reg_muchas) {
		par_reg_muchas.params().procesa(this);
		System.out.print(" , ");
		par_reg_muchas.exp().procesa(this);
	}

	public void procesa(Inst_compuesta inst) {
		inst.bloque().procesa(this);
	}

	public void procesa(Bloque bloque) {
		System.out.println(" { ");
		bloque.prog().procesa(this);
		System.out.print(" } ");

	}


	private void imprime_arg(Exp arg, int p) {
		if (arg.prioridad() < p) {
			System.out.print("(");
			arg.procesa(this);
			System.out.print(")");
		} else {
			arg.procesa(this);
		}
	}

	public void procesa(Suma exp) {
		imprime_arg(exp.arg0(), 1);
		System.out.print(" + ");
		imprime_arg(exp.arg1(), 0);

	}

	public void procesa(Resta exp) {
		imprime_arg(exp.arg0(), 1);
		System.out.print(" - ");
		imprime_arg(exp.arg1(), 1);

	}

	public void procesa(Mul exp) {
		imprime_arg(exp.arg0(), 4);
		System.out.print(" * ");
		imprime_arg(exp.arg1(), 4);

	}

	public void procesa(Div exp) {
		imprime_arg(exp.arg0(), 4);
		System.out.print(" / ");
		imprime_arg(exp.arg1(), 4);

	}

	public void procesa(Mod exp) {
		imprime_arg(exp.arg0(), 4);
		System.out.print(" % ");
		imprime_arg(exp.arg1(), 4);

	}

	public void procesa(Id exp) {
		System.out.print(exp.id());
	}

	public void procesa(Num exp) {
		System.out.print(exp.num());
	}

	public void procesa(Menos_unario menos_unario) {
		System.out.print("-");
		imprime_arg(menos_unario.arg0(), 5);
	}

	public void procesa(Not not) {
		System.out.print(" not ");
		imprime_arg(not.arg0(), 4);
	}

	public void procesa(Beq beq) {
		imprime_arg(beq.arg0(), 2);
		System.out.print(" == ");
		imprime_arg(beq.arg1(), 3);

	}

	public void procesa(Bne bne) {
		imprime_arg(bne.arg0(), 2);
		System.out.print(" != ");
		imprime_arg(bne.arg1(), 3);

	}

	public void procesa(Bge bge) {
		imprime_arg(bge.arg0(), 2);
		System.out.print(" >= ");
		imprime_arg(bge.arg1(), 3);

	}

	public void procesa(Ble ble) {
		imprime_arg(ble.arg0(), 2);
		System.out.print(" <= ");
		imprime_arg(ble.arg1(), 3);

	}

	public void procesa(Blt blt) {
		imprime_arg(blt.arg0(), 2);
		System.out.print(" < ");
		imprime_arg(blt.arg1(), 3);

	}

	public void procesa(Bgt bgt) {
		imprime_arg(bgt.arg0(), 2);
		System.out.print(" > ");
		imprime_arg(bgt.arg1(), 3);

	}

	public void procesa(And and) {
		imprime_arg(and.arg0(), 1);
		System.out.print(" and ");
		imprime_arg(and.arg1(), 2);

	}

	public void procesa(Or or) {
		imprime_arg(or.arg0(), 1);
		System.out.print(" or ");
		imprime_arg(or.arg1(), 2);
	}

	public void procesa(R_true r_true) {
		System.out.print(" true ");

	}

	public void procesa(R_false r_false) {
		System.out.print(" false ");
	}

	public void procesa(Punto punto) {
		punto.exp().procesa(this);
		System.out.print(".");
		System.out.print(punto.id());
	}

	public void procesa(Flecha flecha) {
		flecha.exp().procesa(this);
		System.out.print("->");
		System.out.print(flecha.id());
	}

	public void procesa(Indireccion ind) {
		System.out.print("*");
		ind.exp().procesa(this);

	}

	public void procesa(R_null n) {
		System.out.print("null");
	}

	public void procesa(R_str s) {
		System.out.print(s.id());
	}

	public void procesa(Index ind) {
		ind.exp1().procesa(this);
		System.out.print("[");
		ind.exp2().procesa(this);
		System.out.print("]");
	}

}
