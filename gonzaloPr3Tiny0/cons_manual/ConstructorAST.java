package cons_manual;

import java.io.IOException;
import java.io.Reader;
import alex.UnidadLexica;
import alex.AnalizadorLexicoTiny0;
import alex.ClaseLexica;
import errors.GestionErroresTiny0;
import semops.SemOps;
import asint.Tiny0ASint.Programa;
import asint.Tiny0ASint.Decs;
import asint.Tiny0ASint.Dec;
import asint.Tiny0ASint.Tipo;
import asint.Tiny0ASint.Instrs;
import asint.Tiny0ASint.Instr;
import asint.Tiny0ASint.Exp;

public class ConstructorAST {
    
    private UnidadLexica anticipo;
    private AnalizadorLexicoTiny0 alex;
    private GestionErroresTiny0 errores;
    private SemOps sem;
    
    public ConstructorAST(Reader input) throws IOException {
        
        errores = new GestionErroresTiny0();
        alex = new AnalizadorLexicoTiny0(input);
        alex.fijaGestionErrores(errores);
        sem = new SemOps();
        sigToken();
        
    }
    
    public Programa Inicio() {
        
        Programa prog = Programa();
        empareja(ClaseLexica.EOF);
        return prog;
        
    }
    
    private Programa Programa() {
        
        switch(anticipo.clase()) {
            
            case INT_RES: case BOOL_RES: case REAL_RES:
                Decs decs = Decs();
                empareja(ClaseLexica.END_DEC);
                Instrs instrs = Instrs();
                return sem.prog(decs, instrs);
                
            default:
                errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(),
                    ClaseLexica.INT_RES, ClaseLexica.BOOL_RES, ClaseLexica.REAL_RES);
                return null;
                
        }
        
    }
    
    private Decs Decs() {
        
        switch(anticipo.clase()) {
            
            case INT_RES: case BOOL_RES: case REAL_RES:
                Dec dec = Dec();
                return RDecs(sem.decs_una(dec));
                
            default:
                errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(),
                        ClaseLexica.INT_RES, ClaseLexica.BOOL_RES, ClaseLexica.REAL_RES);
                return null;
                
        }
        
    }
    
    private Decs RDecs(Decs decsH) {
        
        switch(anticipo.clase()) {
            
            case ENDL:
                empareja(ClaseLexica.ENDL);
                Dec dec = Dec();
                return RDecs(sem.decs_varias(decsH, dec));
                
            case END_DEC: return decsH;
            
            default:
                errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(),
                    ClaseLexica.ENDL, ClaseLexica.END_DEC);
                return null;
                
        }
        
    }
    
    private Dec Dec() {
        
        switch(anticipo.clase()) {
            
            case INT_RES: case BOOL_RES: case REAL_RES:
                Tipo tipo = Tipo();
                UnidadLexica tkId = anticipo;
                empareja(ClaseLexica.ID);
                return sem.dec(tipo, sem.str(tkId.lexema(), tkId.fila(), tkId.columna()));
                
            default:
                errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(),
                    ClaseLexica.INT_RES, ClaseLexica.BOOL_RES, ClaseLexica.REAL_RES);
                return null;
            
        }
        
    }
    
    private Tipo Tipo() {
        
        switch(anticipo.clase()) {
            
            case INT_RES:
                empareja(ClaseLexica.INT_RES);
                return sem.tipo_int();
                
            case BOOL_RES:
                empareja(ClaseLexica.BOOL_RES);
                return sem.tipo_bool();
                
            case REAL_RES:
                empareja(ClaseLexica.REAL_RES);
                return sem.tipo_real();
                
            default:
                errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(),
                    ClaseLexica.INT_RES, ClaseLexica.BOOL_RES, ClaseLexica.REAL_RES);
                return null;
            
        }
        
    }
    
    private Instrs Instrs() {
        
        switch(anticipo.clase()) {
            
            case ID:
                Instr instr = Instr();
                return RInstrs(sem.instrs_una(instr));
                
            default:
                errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(),
                    ClaseLexica.ID);
                return null;
            
        }
        
    }
    
    private Instrs RInstrs(Instrs instrsH) {
        
        switch(anticipo.clase()) {
            
            case ENDL:
                empareja(ClaseLexica.ENDL);
                Instr instr = Instr();
                return RInstrs(sem.instrs_varias(instrsH, instr));
                
            case EOF: return instrsH;
            
            default:
                errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(),
                    ClaseLexica.ENDL, ClaseLexica.EOF);
                return null;
            
        }
        
    }
    
    private Instr Instr() {
        
        switch(anticipo.clase()) {
            
            case ID:
                UnidadLexica tkId = anticipo;
                empareja(ClaseLexica.ID);
                empareja(ClaseLexica.IGUAL);
                Exp exp = E0();
                return sem.instr_asig(sem.str(tkId.lexema(), tkId.fila(), tkId.columna()), exp);
                
            default:
                errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(),
                    ClaseLexica.ID);
                return null;
            
        }
        
    }
    
    private Exp E0() {
        
        switch(anticipo.clase()) {
            
            case MAS: case MENOS: case POR: case DIV: case TRUE: case FALSE:
                case ID: case PAP: case NOT: case INT: case REAL:
                Exp exp = E1();
                return RE0(exp);
                
            default:
                errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(),
                    ClaseLexica.MAS, ClaseLexica.MENOS, ClaseLexica.POR, ClaseLexica.DIV,
                    ClaseLexica.TRUE, ClaseLexica.FALSE, ClaseLexica.ID, ClaseLexica.PAP,
                    ClaseLexica.NOT, ClaseLexica.INT, ClaseLexica.REAL);
                return null;
            
        }
        
    }
    
    private Exp RE0(Exp expH) {
        
        switch(anticipo.clase()) {
            
            case MAS:
                empareja(ClaseLexica.MAS);
                Exp exp0 = E0();
                return sem.suma(expH, exp0);
                
            case MENOS:
                empareja(ClaseLexica.MENOS);
                Exp exp1 = E1();
                return sem.resta(expH, exp1);
                
            case ENDL: case PCI: case EOF: return expH;
            
            default:
                errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(),
                    ClaseLexica.MAS, ClaseLexica.MENOS);
                return null;
            
        }
        
    }
    
    private Exp E1() {
        
        switch(anticipo.clase()) {
            
            case MAS: case MENOS: case POR: case DIV: case TRUE: case FALSE:
                case ID: case PAP: case NOT: case INT: case REAL:
                Exp exp = E2();
                return RE1(exp);
                
            default:
                errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(),
                    ClaseLexica.MAS, ClaseLexica.MENOS, ClaseLexica.POR, ClaseLexica.DIV,
                    ClaseLexica.TRUE, ClaseLexica.FALSE, ClaseLexica.ID, ClaseLexica.PAP,
                    ClaseLexica.NOT, ClaseLexica.INT, ClaseLexica.REAL);
                return null;
            
        }
        
    }
    
    private Exp RE1(Exp expH) {
        
        switch(anticipo.clase()) {
            
            case AND: case OR:
                String op = Op1AI();
                Exp exp = E2();
                return RE1(sem.exp(op, expH, exp));
                
            case MAS: case MENOS: case ENDL: case PCI: case EOF: return expH;
            
            default:
                errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(),
                    ClaseLexica.MAS, ClaseLexica.MENOS, ClaseLexica.AND, ClaseLexica.OR);
                return null;
            
        }
        
    }
    
    private Exp E2() {
        
        switch(anticipo.clase()) {
            
            case MAS: case MENOS: case POR: case DIV: case TRUE: case FALSE:
                case ID: case PAP: case NOT: case INT: case REAL:
                Exp exp = E3();
                return RE2(exp);
                
            default:
                errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(),
                    ClaseLexica.MAS, ClaseLexica.MENOS, ClaseLexica.POR, ClaseLexica.DIV,
                    ClaseLexica.TRUE, ClaseLexica.FALSE, ClaseLexica.ID, ClaseLexica.PAP,
                    ClaseLexica.NOT, ClaseLexica.INT, ClaseLexica.REAL);
                return null;
            
        }
        
    }
    
    private Exp RE2(Exp expH) {
        
        switch(anticipo.clase()) {
            
            case LT: case GT: case LET: case GET: case EQ: case NEQ:
                String op = Op2AI();
                Exp exp = E3();
                return RE2(sem.exp(op, expH, exp));
                
            case MAS: case MENOS: case AND: case OR: case ENDL: case PCI:
                case EOF: return expH;
                
            default:
                errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(),
                    ClaseLexica.MAS, ClaseLexica.MENOS, ClaseLexica.AND, ClaseLexica.OR,
                    ClaseLexica.LT, ClaseLexica.GT, ClaseLexica.LET, ClaseLexica.GET,
                    ClaseLexica.EQ, ClaseLexica.NEQ);
                return null;
            
        }
        
    }
    
    private Exp E3() {
        
        switch(anticipo.clase()) {
            
            case MAS: case MENOS: case POR: case DIV: case TRUE: case FALSE:
                case ID: case PAP: case NOT: case INT: case REAL:
                Exp exp = E4();
                return RE3(exp);
                
            default:
                errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(),
                    ClaseLexica.MAS, ClaseLexica.MENOS, ClaseLexica.POR, ClaseLexica.DIV,
                    ClaseLexica.TRUE, ClaseLexica.FALSE, ClaseLexica.ID, ClaseLexica.PAP,
                    ClaseLexica.NOT, ClaseLexica.INT, ClaseLexica.REAL);
                return null;
            
        }
        
    }
    
    private Exp RE3(Exp expH) {
        
        switch(anticipo.clase()) {
            
            case POR: case DIV:
                String op = OpNA();
                Exp exp = E4();
                return sem.exp(op, expH, exp);
                
            case MAS: case MENOS: case AND: case OR: case ENDL: case PCI:
                case EOF: case LT: case GT: case LET: case GET: case EQ:
                    case NEQ: return expH;
                
            default:
                errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(),
                    ClaseLexica.MAS, ClaseLexica.MENOS, ClaseLexica.AND, ClaseLexica.OR,
                    ClaseLexica.LT, ClaseLexica.GT, ClaseLexica.LET, ClaseLexica.GET,
                    ClaseLexica.EQ, ClaseLexica.NEQ, ClaseLexica.POR, ClaseLexica.DIV);
                return null;
            
        }
        
    }
    
    private Exp E4() {
        
        switch(anticipo.clase()) {
            
            case MENOS:
                empareja(ClaseLexica.MENOS);
                Exp exp5 = E5();
                return sem.menos(exp5);
                
            case NOT:
                empareja(ClaseLexica.NOT);
                Exp exp4 = E4();
                return sem.not(exp4);
                
            case MAS: case POR: case DIV: case TRUE: case FALSE: case ID:
                case PAP: case INT: case REAL:
                return E5();
                
            default:
                errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(),
                    ClaseLexica.MAS, ClaseLexica.MENOS, ClaseLexica.POR, ClaseLexica.DIV,
                    ClaseLexica.TRUE, ClaseLexica.FALSE, ClaseLexica.ID, ClaseLexica.PAP,
                    ClaseLexica.NOT, ClaseLexica.INT, ClaseLexica.REAL);
                return null;
            
        }
        
    }
    
    private Exp E5() {
        
        switch(anticipo.clase()) {
            
            case ID:
                UnidadLexica tkId = anticipo;
                empareja(ClaseLexica.ID);
                return sem.id(sem.str(tkId.lexema(), tkId.fila(), tkId.columna()));
                
            case TRUE:
                empareja(ClaseLexica.TRUE);
                return sem.cTrue();
                
            case FALSE:
                empareja(ClaseLexica.FALSE);
                return sem.cFalse();
                
            case INT:
                UnidadLexica tkInt = anticipo;
                empareja(ClaseLexica.INT);
                return sem.ent(sem.str(tkInt.lexema(), tkInt.fila(), tkInt.columna()));
                
            case REAL:
                UnidadLexica tkReal = anticipo;
                empareja(ClaseLexica.REAL);
                return sem.real(sem.str(tkReal.lexema(), tkReal.fila(), tkReal.columna()));
                
            case PAP:
                empareja(ClaseLexica.PAP);
                Exp exp = E0();
                empareja(ClaseLexica.PCI);
                return exp;
                
            default:
                errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(),
                    ClaseLexica.MAS, ClaseLexica.POR, ClaseLexica.DIV, ClaseLexica.TRUE,
                    ClaseLexica.FALSE, ClaseLexica.ID, ClaseLexica.PAP, ClaseLexica.INT,
                    ClaseLexica.REAL);
                return null;
            
        }
        
    }
    
    private String Op1AI() {
        
        switch(anticipo.clase()) {
            
            case AND:
                empareja(ClaseLexica.AND);
                return "and";
                
            case OR:
                empareja(ClaseLexica.OR);
                return "or";
                
            default:
                errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(),
                    ClaseLexica.AND, ClaseLexica.OR);
                return "?";
            
        }
        
    }
    
    private String Op2AI() {
        
        switch(anticipo.clase()) {
            
            case LT:
                empareja(ClaseLexica.LT);
                return "<";
                
            case GT:
                empareja(ClaseLexica.GT);
                return ">";
                
            case LET:
                empareja(ClaseLexica.LET);
                return "<=";
                
            case GET:
                empareja(ClaseLexica.GET);
                return ">=";
                
            case EQ:
                empareja(ClaseLexica.EQ);
                return "==";
                
            case NEQ:
                empareja(ClaseLexica.NEQ);
                return "!=";
                
            default:
                errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(),
                    ClaseLexica.LT, ClaseLexica.GT, ClaseLexica.LET, ClaseLexica.GET,
                    ClaseLexica.EQ, ClaseLexica.NEQ);
                return "?";
                
        }
        
    }
    
    private String OpNA() {
        
        switch(anticipo.clase()) {
            
            case POR:
                empareja(ClaseLexica.POR);
                return "*";
                
            case DIV:
                empareja(ClaseLexica.DIV);
                return "/";
                
            default:
                errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(),
                    ClaseLexica.POR, ClaseLexica.DIV);
                return "?";
            
        }
        
    }
    
    private void empareja(ClaseLexica claseEsperada) {
        
        if (anticipo.clase() == claseEsperada)
            sigToken();
        
        else
            errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), claseEsperada);
        
    }
    
    private void sigToken() {
        
        try {
            anticipo = alex.sigToken();
        }
        
        catch(IOException e) {
            errores.errorFatal(e);
        }
        
    }
    
}