package alex;

import java.io.FileInputStream;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AnalizadorLexicoTiny {

   private Reader input;
   private StringBuffer lex;
   private int sigCar;
   private int filaInicio;
   private int columnaInicio;
   private int filaActual;
   private int columnaActual;
   private static String NL = System.getProperty("line.separator");
   
   private static enum Estado {
    INICIO, REC_ID, REC_0, REC_ENT, REC_IDEC1, REC_DEC, REC_IDEC2,
    REC_IEXP1, REC_EXP, REC_IEXP0, REC_IEXP2, REC_MAS, REC_MENOS,
	REC_ISEP1, REC_SEP, REC_PTO_COMA, REC_BEQ, REC_ASIG, REC_BLE,
	REC_BLT, REC_BGT, REC_BGE, REC_IBNE, REC_BNE, REC_PAP, REC_PCIERRE,
	REC_POR, REC_DIV, REC_EOF, REC_COM
	}

   private Estado estado;

   public AnalizadorLexicoTiny(Reader input) throws IOException {
    this.input = input;
    lex = new StringBuffer();
    sigCar = input.read();
    filaActual=1;
    columnaActual=1;
   }
   
   public UnidadLexica sigToken() throws IOException {
     estado = Estado.INICIO;
     filaInicio = filaActual;
     columnaInicio = columnaActual;
     lex.delete(0,lex.length());
     while(true) {
         switch(estado) {
           case INICIO: 
              if(hayLetra())  transita(Estado.REC_ID);
              else if (hayMas()) transita(Estado.REC_MAS);
              else if (hayMenos()) transita(Estado.REC_MENOS);
              else if (hayCero()) transita(Estado.REC_0);
              else if (hayDigitoPos()) transita(Estado.REC_ENT);
			  else if (hayEt()) transita(Estado.REC_ISEP1);
			  else if (hayPuntoComa()) transita(Estado.REC_PTO_COMA);
			  else if (hayIgual()) transita(Estado.REC_ASIG);
			  else if (hayBLT()) transita(Estado.REC_BLT);
			  else if (hayBGT()) transita(Estado.REC_BGT);
			  else if (hayExclamacion()) transita(Estado.REC_IBNE);
			  else if (hayPAp()) transita(Estado.REC_PAP);
			  else if (hayPCierre()) transita(Estado.REC_PCIERRE);
			  else if (hayPor()) transita(Estado.REC_POR);
			  else if (hayDiv()) transita(Estado.REC_DIV);
			  else if (hayEOF()) transita(Estado.REC_EOF);
			  else if (hayNL()) transita(Estado.INICIO);
			  else if (haySep()) transita(Estado.INICIO);
			  else if (hayAlmohadilla()) transita(Estado.REC_COM);
              else error();
              break;
           case REC_ID: 
              if (hayLetra() || hayDigito() || haySubrayado()) transita(Estado.REC_ID);
              else return unidadID();               
              break;
           case REC_ENT:
               if (hayDigito()) transita(Estado.REC_ENT);
               else if (hayPunto()) transita(Estado.REC_IDEC1);
			   else if (hayE()) transita(Estado.REC_IEXP1);
               else return unidadLIT_INT();
               break;
           case REC_0:
               if (hayPunto()) transita(Estado.REC_IDEC1);
               else return unidadLIT_INT();
               break;
           case REC_IDEC1:
               if (hayDigito()) transita(Estado.REC_DEC);
               else error();
               break;
           case REC_DEC: 
               if (hayDigitoPos()) transita(Estado.REC_DEC);
               else if(hayCero()) transita(Estado.REC_IDEC2);
			   else if(hayE()) transita(Estado.REC_IEXP1);
               else return unidadLIT_REAL();
               break;
		   case REC_IDEC2: 
               if (hayDigitoPos()) transita(Estado.REC_DEC);
               else if(hayCero()) transita(Estado.REC_IDEC2);
               else error();
               break;
		   case REC_IEXP1: 
               if (hayMas()) transita(Estado.REC_IEXP2);
               else if(hayMenos()) transita(Estado.REC_IEXP2);
               else if(hayDigitoPos())transita(Estado.REC_EXP);
               else error();
               break;
		   case REC_EXP: 
               if (hayDigito()) transita(Estado.REC_EXP);
               else return unidadLIT_REAL();
               break;
		   case REC_IEXP0: 
               return unidadLIT_REAL();
               
		   case REC_IEXP2: 
               if (hayDigitoPos()) transita(Estado.REC_EXP);
               else if(hayCero()) transita(Estado.REC_IEXP0);
               else error();
               break;
		   case REC_MAS: 
               if (hayDigitoPos()) transita(Estado.REC_ENT);
               else if(hayCero()) transita(Estado.REC_0);
               else return unidadMAS();
               break;
		   case REC_MENOS: 
               if (hayDigitoPos()) transita(Estado.REC_ENT);
               else if(hayCero()) transita(Estado.REC_0);
               else return unidadMENOS();
               break;
		   case REC_ISEP1: 
               if (hayEt()) transita(Estado.REC_SEP);
               else error();
               break;
		   case REC_SEP: 
               return unidadSEP_PROG();
		   case REC_PTO_COMA: 
               return unidadPTO_COMA();
		   case REC_ASIG:
			   if(hayIgual()) transita(Estado.REC_BEQ);
               else return unidadASIG();  
			   break;
		   case REC_BEQ: 
               return unidadBEQ();
		   case REC_BLT:
			   if(hayIgual()) transita(Estado.REC_BLE);
               else return unidadBLT();  
			   break;
		   case REC_BLE: 
               return unidadBLE();   
		   case REC_BGT:
			   if(hayIgual()) transita(Estado.REC_BGE);
               else return unidadBGT(); 
			   break;
		   case REC_BGE: 
               return unidadBGE();
		   case REC_IBNE:
			   if(hayIgual()) transita(Estado.REC_BNE);
               else error();  
			   break;
		   case REC_BNE: 
               return unidadBNE();   
		   case REC_PAP: 
               return unidadPAP();
		   case REC_PCIERRE: 
               return unidadPCIERRE();
		   case REC_POR: 
               return unidadPOR();
		   case REC_DIV: 
               return unidadDIV();
	       case REC_EOF: 
               return unidadEOF();
           case REC_COM: 
               if (hayNL()) transitaIgnorando(Estado.INICIO);
               else if (hayEOF()) transita(Estado.REC_EOF);
               else transitaIgnorando(Estado.REC_COM);
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
     if (sigCar == NL.charAt(0)) saltaFinDeLinea();
     if (sigCar == '\n') {
        filaActual++;
        columnaActual=0;
     }
     else {
       columnaActual++;  
     }
   }
   private void saltaFinDeLinea() throws IOException {
      for (int i=1; i < NL.length(); i++) {
          sigCar = input.read();
          if (sigCar != NL.charAt(i)) error();
      }
      sigCar = '\n';
   }
   
   private boolean hayLetra() {return sigCar >= 'a' && sigCar <= 'z' ||
                                      sigCar >= 'A' && sigCar <= 'z';}
   private boolean hayDigitoPos() {return sigCar >= '1' && sigCar <= '9';}
   private boolean hayCero() {return sigCar == '0';}
   private boolean hayDigito() {return hayDigitoPos() || hayCero();}
   private boolean hayPor() {return sigCar == '*';}
   private boolean hayDiv() {return sigCar == '/';}
   private boolean hayPAp() {return sigCar == '(';}
   private boolean hayPCierre() {return sigCar == ')';}
   private boolean hayIgual() {return sigCar == '=';}
   private boolean hayPunto() {return sigCar == '.';}
   private boolean hayAlmohadilla() {return sigCar == '#';}
   private boolean haySep() {return sigCar == ' ' || sigCar == '\t' || sigCar=='\n';}
   private boolean hayNL() {return sigCar == '\r' || sigCar == '\b' || sigCar == '\n';}
   private boolean hayEOF() {return sigCar == -1;}
   private boolean hayE() {return sigCar == 'e' || sigCar == 'E';}
   private boolean haySubrayado() {return sigCar == '_';}
   private boolean hayMas() {return sigCar == '+';}
   private boolean hayMenos() {return sigCar == '-';}
   private boolean hayEt() {return sigCar == '&';}
   private boolean hayPuntoComa() {return sigCar == ';';}
   private boolean hayBLT() {return sigCar == '<';}
   private boolean hayBGT() {return sigCar == '>';}
   private boolean hayExclamacion() {return sigCar == '!';}

   
   
   
   private UnidadLexica unidadID() {
     switch(lex.toString()) {
	    case "int":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.R_INT);
		case "real":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.R_REAL);
		case "bool":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.R_BOOL);
		case "true":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.R_TRUE);
		case "false":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.R_FALSE);
		case "and":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.R_AND);
		case "or":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.R_OR);
		case "not":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.R_NOT);			
         default:    
            return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,ClaseLexica.ID,lex.toString());     
      }
   }  
   private UnidadLexica unidadLIT_INT() {
     return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,ClaseLexica.LIT_INT,lex.toString());     
   }    
   private UnidadLexica unidadLIT_REAL() {
     return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,ClaseLexica.LIT_REAL,lex.toString());     
   }
   private UnidadLexica unidadSEP_PROG() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.SEP_PROG);     
   }
   private UnidadLexica unidadPTO_COMA() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PTO_COMA);     
   }
   private UnidadLexica unidadASIG() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.ASIG);     
   }
   private UnidadLexica unidadMAS() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MAS);     
   }
   private UnidadLexica unidadMENOS() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MENOS);     
   }
   private UnidadLexica unidadPOR() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.POR);     
   }
   private UnidadLexica unidadDIV() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.DIV);     
   }
   private UnidadLexica unidadBLT() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.BLT);     
   }
   private UnidadLexica unidadBGT() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.BGT);     
   }
   private UnidadLexica unidadBLE() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.BLE);     
   }
   private UnidadLexica unidadBGE() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.BGE);     
   }
   private UnidadLexica unidadBEQ() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.BEQ);     
   }
   private UnidadLexica unidadBNE() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.BNE);     
   }
   private UnidadLexica unidadPAP() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PAP);     
   }
   private UnidadLexica unidadPCIERRE() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PCIERRE);     
   }
   private UnidadLexica unidadEOF() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.EOF);     
   }   

   
   private void error() {
     System.err.println("("+filaActual+','+columnaActual+"):Caracter inexperado");  
     System.exit(1);
   }

   public static void main(String arg[]) throws IOException {
     Reader input = new InputStreamReader(new FileInputStream("input.txt"));
     AnalizadorLexicoTiny al = new AnalizadorLexicoTiny(input);
     UnidadLexica unidad;
     do {
       unidad = al.sigToken();
       System.out.println(unidad);
     }
     while (unidad.clase() != ClaseLexica.EOF);
    } 
}