package asint;

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

public interface Procesamiento {
    
    void procesa(Suma exp);
    void procesa(Resta exp);
    void procesa(Mul exp);
    void procesa(Div exp);
    void procesa(And exp);
    void procesa(Or exp);
    void procesa(Lt exp);
    void procesa(Gt exp);
    void procesa(Let exp);
    void procesa(Get exp);
    void procesa(Eq exp);
    void procesa(Neq exp);
    void procesa(Menos exp);
    void procesa(Not exp);
    void procesa(Id exp);
    void procesa(Int exp);
    void procesa(Real exp);
    void procesa(True exp);
    void procesa(False exp);
    void procesa(Tipo_int tipo_int);
    void procesa(Tipo_bool tipo_bool);
    void procesa(Tipo_real tipo_real);
    void procesa(Dec dec);
    void procesa(Decs_varias decs);
    void procesa(Decs_una decs);
    void procesa(Instr_asig instr_asig);
    void procesa(Instrs_varias instrs);
    void procesa(Instrs_una instrs);
    void procesa(Programa prog);
    
}