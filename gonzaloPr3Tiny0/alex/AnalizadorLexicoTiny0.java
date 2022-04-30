package alex;

import errors.GestionErroresTiny0;
import java.io.FileInputStream;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AnalizadorLexicoTiny0 {
    
    private Reader input;
    private StringBuffer lex;
    private int sigCar;
    private int filaInicio;
    private int columnaInicio;
    private int filaActual;
    private int columnaActual;
    private static String NL = System.getProperty("line.separator");
    private GestionErroresTiny0 errores;
    
    private static enum Estado {
        
        INICIO, REC_LT, REC_GT, REC_LET, REC_GET, REC_EQ, AUX_NEQ, REC_NEQ, REC_POR,
        REC_DIV, REC_PAP, REC_PCI, REC_IGUAL, AUX_MAS, AUX_MENOS, REC_MAS, REC_MENOS,
        REC_0, REC_INT, AUX_DEC1, AUX_DEC2, REC_DEC, AUX_EXP, EXP_MAS, EXP_MENOS,
        REC_EXP, REC_EXP0, REC_ID, AUX_AMB, REC_AMB, REC_PYC, REC_EOF
        
    }
    
    private Estado estado;
    
    public AnalizadorLexicoTiny0(Reader input) throws IOException {
        
        this.input = input;
        lex = new StringBuffer();
        sigCar = input.read();
        filaActual = 1;
        columnaActual = 1;
        
    }
    
    public UnidadLexica sigToken() throws IOException {
        
        estado = Estado.INICIO;
        filaInicio = filaActual;
        columnaInicio = columnaActual;
        lex.delete(0, lex.length());
        
        while(true) {
            
            switch(estado) {
                
                case INICIO:
                    if (haySep()) transitaIgnorando(Estado.INICIO);
                    else if (hayEOF()) transita(Estado.REC_EOF);
                    else if (hayPyc()) transita(Estado.REC_PYC);
                    else if (hayAmb()) transita(Estado.AUX_AMB);
                    else if (hayLetra()) transita(Estado.REC_ID);
                    else if (hayDigitoPos()) transita(Estado.REC_INT);
                    else if (hayCero()) transita(Estado.REC_0);
                    else if (hayMas()) transita(Estado.AUX_MAS);
                    else if (hayMenos()) transita(Estado.AUX_MENOS);
                    else if (hayIgual()) transita(Estado.REC_IGUAL);
                    else if (hayPAp()) transita(Estado.REC_PAP);
                    else if (hayPCi()) transita(Estado.REC_PCI);
                    else if (hayDiv()) transita(Estado.REC_DIV);
                    else if (hayPor()) transita(Estado.REC_POR);
                    else if (hayExc()) transita(Estado.AUX_NEQ);
                    else if (hayGt()) transita(Estado.REC_GT);
                    else if (hayLt()) transita(Estado.REC_LT);
                    else error();
                    break;
                    
                case REC_EOF: return unidadEOF();
                
                case REC_PYC: return unidadPyc();
                
                case AUX_AMB:
                    if (hayAmb()) transita(Estado.REC_AMB);
                    else error();
                    break;
                    
                case REC_AMB: return unidadAmb();
                
                case REC_ID:
                    if (hayLetra() || hayDigito() || hayBarraBaja()) transita(Estado.REC_ID);
                    else return unidadId();
                    break;
                    
                case REC_INT:
                    if (hayDigito()) transita(Estado.REC_INT);
                    else if (hayPunto()) transita(Estado.AUX_DEC1);
                    else if (hayE()) transita(Estado.AUX_EXP);
                    else return unidadInt();
                    break;
                    
                case REC_0:
                    if (hayPunto()) transita(Estado.AUX_DEC1);
                    else if (hayE()) transita(Estado.AUX_EXP);
                    else return unidadInt();
                    break;
                    
                case AUX_MAS:
                    if (hayEsp()) transita(Estado.REC_MAS);
                    else if (hayCero()) transita(Estado.REC_0);
                    else if (hayDigitoPos()) transita(Estado.REC_INT);
                    else error();
                    break;
                    
                case AUX_MENOS:
                    if (hayEsp()) transita(Estado.REC_MENOS);
                    else if (hayCero()) transita(Estado.REC_0);
                    else if (hayDigitoPos()) transita(Estado.REC_INT);
                    else error();
                    break;
                    
                case REC_MAS: return unidadMas();
                
                case REC_MENOS: return unidadMenos();
                
                case REC_IGUAL:
                    if (hayIgual()) transita(Estado.REC_EQ);
                    else return unidadIgual();
                    break;
                    
                case REC_EQ: return unidadEq();
                
                case REC_PAP: return unidadPAp();
                
                case REC_PCI: return unidadPCi();
                
                case REC_POR: return unidadPor();
                
                case REC_DIV: return unidadDiv();
                
                case AUX_NEQ:
                    if (hayIgual()) transita(Estado.REC_NEQ);
                    else error();
                    break;
                    
                case REC_NEQ: return unidadNeq();
                
                case REC_GT:
                    if (hayIgual()) transita(Estado.REC_GET);
                    else return unidadGt();
                    break;
                    
                case REC_LT:
                    if (hayIgual()) transita(Estado.REC_LET);
                    else return unidadLt();
                    break;
                    
                case REC_GET: return unidadGet();
                
                case REC_LET: return unidadLet();
                
                case AUX_DEC1:
                    if (hayDigito()) transita(Estado.REC_DEC);
                    else error();
                    break;
                    
                case REC_DEC:
                    if (hayDigitoPos()) transita(Estado.REC_DEC);
                    else if (hayCero()) transita(Estado.AUX_DEC2);
                    else if (hayE()) transita(Estado.AUX_EXP);
                    else return unidadReal();
                    break;
                    
                case AUX_DEC2:
                    if (hayDigitoPos()) transita(Estado.REC_DEC);
                    else if (hayCero()) transita(Estado.AUX_DEC2);
                    else error();
                    break;
                    
                case AUX_EXP:
                    if (hayDigitoPos()) transita(Estado.REC_EXP);
                    else if (hayCero()) transita(Estado.REC_EXP0);
                    else if (hayMas()) transita(Estado.EXP_MAS);
                    else if (hayMenos()) transita(Estado.EXP_MENOS);
                    else error();
                    break;
                    
                case EXP_MAS:
                    if (hayDigitoPos()) transita(Estado.REC_EXP);
                    else if (hayCero()) transita(Estado.REC_EXP0);
                    else error();
                    break;
                    
                case EXP_MENOS:
                    if (hayDigitoPos()) transita(Estado.REC_EXP);
                    else if (hayCero()) transita(Estado.REC_EXP0);
                    else error();
                    break;
                    
                case REC_EXP0: return unidadReal();
                
                case REC_EXP:
                    if (hayDigito()) transita(Estado.REC_EXP);
                    else return unidadReal();
                    break;
                    
            }
            
        }
        
    }
    
    private void transita(Estado sig) throws IOException {
        
        lex.append((char)sigCar);
        sigCar();
        estado = sig;
        
    }
    
    private void transitaIgnorando(Estado sig) throws IOException {
        
        sigCar();
        filaInicio = filaActual;
        columnaInicio = columnaActual;
        estado = sig;
        
    }
    
    private void sigCar() throws IOException {
        
        sigCar = input.read();
        
        if (sigCar == NL.charAt(0))
            saltaFinDeLinea();
        
        if (sigCar == '\n') {
            
            ++filaActual;
            columnaActual = 0;
            
        }
        
        else
            ++columnaActual;
        
    }
    
    private void saltaFinDeLinea() throws IOException {
        
        for (int i = 1; i < NL.length(); ++i) {
            
            sigCar = input.read();
            
            if (sigCar != NL.charAt(i))
                error();
            
        }
        
        sigCar = '\n';
        
    }
    
    private boolean hayLetra() {return sigCar >= 'a' && sigCar <= 'z' || sigCar >= 'A' && sigCar <= 'z';}
    
    private boolean hayDigitoPos() {return sigCar >= '1' && sigCar <= '9';}
    
    private boolean hayCero() {return sigCar == '0';}
    
    private boolean hayDigito() {return sigCar >= '0' && sigCar <= '9';}
    
    private boolean hayMas() {return sigCar == '+';}
    
    private boolean hayMenos() {return sigCar == '-';}
    
    private boolean hayPor() {return sigCar == '*';}
    
    private boolean hayDiv() {return sigCar == '/';}
    
    private boolean hayPAp() {return sigCar == '(';}
    
    private boolean hayPCi() {return sigCar == ')';}
    
    private boolean hayIgual() {return sigCar == '=';}
    
    private boolean hayPunto() {return sigCar == '.';}
    
    private boolean haySep() {return sigCar == ' ' || sigCar == '\t' || sigCar=='\n' || sigCar == '\r' || sigCar=='\b';}
    
    private boolean hayNL() {return sigCar == '\n' || sigCar == '\r' || sigCar == '\b';}
    
    private boolean hayEOF() {return sigCar == -1;}
    
    private boolean hayPyc() {return sigCar == ';';}
    
    private boolean hayAmb() {return sigCar == '&';}
    
    private boolean hayExc() {return sigCar == '!';}
    
    private boolean hayGt() {return sigCar == '>';}
    
    private boolean hayLt() {return sigCar == '<';}
    
    private boolean hayBarraBaja() {return sigCar == '_';}
    
    private boolean hayE() {return sigCar == 'e' || sigCar == 'E';}
    
    private boolean hayEsp() {return sigCar == ' ';}
    
    private UnidadLexica unidadId() {
        
        switch(lex.toString()) {
            
            case "bool":
                return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.BOOL_RES);
                
            case "int":
                return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.INT_RES);
                
            case "real":
                return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.REAL_RES);
                
            case "true":
                return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.TRUE);
                
            case "false":
                return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.FALSE);
                
            case "and":
                return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.AND);
                
            case "or":
                return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.OR);
                
            case "not":
                return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.NOT);
                
            default:
                return new UnidadLexicaMultivaluada(filaInicio, columnaInicio, ClaseLexica.ID, lex.toString());
                
        }
        
    }
    
    private UnidadLexica unidadInt() {
        return new UnidadLexicaMultivaluada(filaInicio, columnaInicio, ClaseLexica.INT, lex.toString());
    }
    
    private UnidadLexica unidadReal() {
        return new UnidadLexicaMultivaluada(filaInicio, columnaInicio, ClaseLexica.REAL, lex.toString());
    }
    
    private UnidadLexica unidadMas() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.MAS);
    }
    
    private UnidadLexica unidadMenos() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.MENOS);
    }
    
    private UnidadLexica unidadPor() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.POR);
    }
    
    private UnidadLexica unidadDiv() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.DIV);
    }
    
    private UnidadLexica unidadPAp() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.PAP);
    }
    
    private UnidadLexica unidadPCi() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.PCI);
    }
    
    private UnidadLexica unidadIgual() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.IGUAL);
    }
    
    private UnidadLexica unidadEOF() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.EOF);
    }
    
    private UnidadLexica unidadPyc() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.ENDL);
    }
    
    private UnidadLexica unidadAmb() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.END_DEC);
    }
    
    private UnidadLexica unidadEq() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.EQ);
    }
    
    private UnidadLexica unidadNeq() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.NEQ);
    }
    
    private UnidadLexica unidadGt() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.GT);
    }
    
    private UnidadLexica unidadLt() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.LT);
    }
    
    private UnidadLexica unidadGet() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.GET);
    }
    
    private UnidadLexica unidadLet() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.LET);
    }
    
    private void error() {
        
        System.err.println("(" + filaActual + ", " + columnaActual + "): Caracter inesperado");
        System.exit(1);
        
    }
    
    public void fijaGestionErrores(GestionErroresTiny0 errores) {
        this.errores = errores;
    }
    
    public static void main(String[] args) throws IOException {
        
        Reader input = new InputStreamReader(new FileInputStream(args[0]));
        AnalizadorLexicoTiny0 al = new AnalizadorLexicoTiny0(input);
        UnidadLexica unidad;
        
        do {
            
            unidad = al.sigToken();
            System.out.println(unidad);
            
        }
        
        while (unidad.clase() != ClaseLexica.EOF);
        
    }
    
}