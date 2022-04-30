package procesamientos;

import asint.Tiny0ASint.Suma;
import asint.Tiny0ASint.Resta;
import asint.Tiny0ASint.Mul;
import asint.Tiny0ASint.Div;
import asint.Tiny0ASint.And;
import asint.Tiny0ASint.Or;
import asint.Tiny0ASint.Lt;
import asint.Tiny0ASint.Gt;
import asint.Tiny0ASint.Let;
import asint.Tiny0ASint.Get;
import asint.Tiny0ASint.Eq;
import asint.Tiny0ASint.Neq;
import asint.Tiny0ASint.Menos;
import asint.Tiny0ASint.Not;
import asint.Tiny0ASint.Id;
import asint.Tiny0ASint.Int;
import asint.Tiny0ASint.Real;
import asint.Tiny0ASint.True;
import asint.Tiny0ASint.False;
import asint.Tiny0ASint.Tipo_int;
import asint.Tiny0ASint.Tipo_bool;
import asint.Tiny0ASint.Tipo_real;
import asint.Tiny0ASint.Dec;
import asint.Tiny0ASint.Decs_varias;
import asint.Tiny0ASint.Decs_una;
import asint.Tiny0ASint.Instr_asig;
import asint.Tiny0ASint.Instrs_varias;
import asint.Tiny0ASint.Instrs_una;
import asint.Tiny0ASint.Programa;
import asint.Tiny0ASint.Exp;
import asint.ProcesamientoPorDefecto;

public class Impresion extends ProcesamientoPorDefecto {
   
    public Impresion() {}
    
    public void procesa(Programa prog) {
        
        prog.decs().procesa(this);
        System.out.println();
        System.out.println("&&");
        prog.instrs().procesa(this);
        
    }
    
    public void procesa(Decs_una decs) {
        decs.dec().procesa(this);
    }
    
    public void procesa(Decs_varias decs) {
        
        decs.decs().procesa(this);
        System.out.println(";");
        decs.dec().procesa(this);
        
    }
    
    public void procesa(Dec dec) {
        
        dec.tipo().procesa(this);
        System.out.print(" " + dec.id());
        
    }
    
    public void procesa(Tipo_int tipo_int) {
        System.out.print(tipo_int.rInt());
    }
    
    public void procesa(Tipo_bool tipo_bool) {
        System.out.print(tipo_bool.rBool());
    }
    
    public void procesa(Tipo_real tipo_real) {
        System.out.print(tipo_real.rReal());
    }
    
    public void procesa(Instrs_una instrs) {
        instrs.instr().procesa(this);
    }
    
    public void procesa(Instrs_varias instrs) {
        
        instrs.instrs().procesa(this);
        System.out.println(";");
        instrs.instr().procesa(this);
        
    }
    
    public void procesa(Instr_asig instr_asig) {
        
        System.out.print(instr_asig.id() + " = ");
        instr_asig.exp().procesa(this);
        
    }
    
    public void procesa(Suma exp) {
        
        imprime_arg(exp.arg0(),1);
        System.out.print(" + ");
        imprime_arg(exp.arg1(),0);
        
    }
    
    public void procesa(Resta exp) {
        
        imprime_arg(exp.arg0(),1);
        System.out.print(" - ");
        imprime_arg(exp.arg1(),1);
        
    }
    
    public void procesa(Mul exp) {
        
        imprime_arg(exp.arg0(),4);
        System.out.print(" * ");
        imprime_arg(exp.arg1(),4);
        
    }
    
    public void procesa(Div exp) {
        
        imprime_arg(exp.arg0(),4);
        System.out.print(" / ");
        imprime_arg(exp.arg1(),4);
        
    }
    
    public void procesa(And exp) {
        
        imprime_arg(exp.arg0(),1);
        System.out.print(" and ");
        imprime_arg(exp.arg1(),2);
        
    }
    
    public void procesa(Or exp) {
        
        imprime_arg(exp.arg0(),1);
        System.out.print(" or ");
        imprime_arg(exp.arg1(),2);
        
    }
    
    public void procesa(Lt exp) {
        
        imprime_arg(exp.arg0(),2);
        System.out.print(" < ");
        imprime_arg(exp.arg1(),3);
        
    }
    
    public void procesa(Gt exp) {
        
        imprime_arg(exp.arg0(),2);
        System.out.print(" > ");
        imprime_arg(exp.arg1(),3);
        
    }
    
    public void procesa(Let exp) {
        
        imprime_arg(exp.arg0(),2);
        System.out.print(" <= ");
        imprime_arg(exp.arg1(),3);
        
    }
    
    public void procesa(Get exp) {
        
        imprime_arg(exp.arg0(),2);
        System.out.print(" >= ");
        imprime_arg(exp.arg1(), 3);
        
    }
    
    public void procesa(Eq exp) {
        
        imprime_arg(exp.arg0(),2);
        System.out.print(" == ");
        imprime_arg(exp.arg1(),3);
        
    }
    
    public void procesa(Neq exp) {
        
        imprime_arg(exp.arg0(),2);
        System.out.print(" != ");
        imprime_arg(exp.arg1(),3);
        
    }
    
    public void procesa(Menos exp) {
        
        System.out.print("-");
        imprime_arg(exp.arg(),5);
        
    }
    
    public void procesa(Not exp) {
        
        System.out.print("not ");
        imprime_arg(exp.arg(),4);
        
    }
    
    private void imprime_arg(Exp arg, int p) {
        
        if (arg.prioridad() < p) {
            
            System.out.print("(");
            arg.procesa(this);
            System.out.print(")");
            
        }
        
        else
            arg.procesa(this);
        
    }
    
    public void procesa(Id exp) {
        System.out.print(exp.id());
    }
    
    public void procesa(Int exp) {
        System.out.print(exp.ent());
    }
    
    public void procesa(Real exp) {
        System.out.print(exp.real());
    }
    
    public void procesa(True exp) {
        System.out.print(exp.rTrue());
    }
    
    public void procesa(False exp) {
        System.out.print(exp.rFalse());
    }
   
}   

            