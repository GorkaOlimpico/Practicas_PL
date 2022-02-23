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
    INICIO, REC_1, REC_2, REC_3, REC_4, REC_5, REC_6,
    REC_7, REC_8, REC_9
	//Faltan los estados de los caracteres
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
              if(hayLetra())  transita(Estado.REC_1);
              else if (hayDigitoPos()) transita(Estado.REC_3);
              else if (hayCero()) transita(Estado.REC_2);
			  //Faltan los caracteres
              else error();
              break;
           case REC_1: 
              if (hayLetra() || hayDigito() || haySubrayado()) transita(Estado.REC_1);
              else return unidadID();               
              break;
           case REC_3:
               if (hayDigito()) transita(Estado.REC_3);
               else if (hayPunto()) transita(Estado.REC_4);
			   else if (hayE()) transita(Estado.REC_7);
               else return unidadLIT_INT();
               break;
           case REC_2:
               if (hayPunto()) transita(Estado.REC_4);
               else return unidadLIT_INT();
               break;
           case REC_4:
               if (hayDigito()) transita(Estado.REC_5);
               else error();
               break;
           case REC_5: 
               if (hayDigitoPos()) transita(Estado.REC_5);
               else if(hayCero()) transita(Estado.REC_6);
			   else if(hayE()) transita(Estado.REC_7);
               else return unidadLIT_REAL();
               break;
		   case REC_6: 
               if (hayDigitoPos()) transita(Estado.REC_5);
               else if(hayCero()) transita(Estado.REC_6);
               else error();
               break;
		   case REC_7: 
               if (hayDigitoPos()) transita(Estado.REC_8);
               else if(hayCero()) transita(Estado.REC_9);
               else error();
               break;
		   case REC_8: 
               if (hayDigito()) transita(Estado.REC_8);
               else return unidadLIT_REAL();
               break;
		   case REC_9: 
               return unidadLIT_REAL();
               break;
			   //faltan los caracteres--------------
           case REC_POR: return unidadPor();
           case REC_DIV: return unidadDiv();              
           case REC_PAP: return unidadPAp();
           case REC_PCIERR: return unidadPCierre();
           case REC_IGUAL: return unidadIgual();
           case REC_COMA: return unidadComa();
           case REC_COM: 
               if (hayNL()) transitaIgnorando(Estado.INICIO);
               else if (hayEOF()) transita(Estado.REC_EOF);
               else transitaIgnorando(Estado.REC_COM);
               break;
			//-------------------------------------
           case REC_EOF: return unidadEof();
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
   private boolean haySuma() {return sigCar == '+';}
   private boolean hayResta() {return sigCar == '-';}
   private boolean hayMul() {return sigCar == '*';}
   private boolean hayDiv() {return sigCar == '/';}
   private boolean hayPAp() {return sigCar == '(';}
   private boolean hayPCierre() {return sigCar == ')';}
   private boolean hayIgual() {return sigCar == '=';}
   private boolean hayComa() {return sigCar == ',';}
   private boolean hayPunto() {return sigCar == '.';}
   private boolean hayAlmohadilla() {return sigCar == '#';}
   private boolean haySep() {return sigCar == ' ' || sigCar == '\t' || sigCar=='\n';}
   private boolean hayNL() {return sigCar == '\r' || sigCar == '\b' || sigCar == '\n';}
   private boolean hayEOF() {return sigCar == -1;}
   private boolean hayE() {return sigCar == 'e' || sigCar == 'E';}
   private boolean haySubrayado() {return sigCar == '_';}
   
   private UnidadLexica unidadId() {
     switch(lex.toString()) {
	    case "int":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.INT);
		case "real":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.REAL);
		case "bool":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.BOOL);
		case "true":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.TRUE);
		case "false":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.FALSE);
		case "and":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.AND);
		case "or":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.OR);
		case "not":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.NOT);			
         default:    
            return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,ClaseLexica.IDEN,lex.toString());     
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
   private UnidadLexica unidadNEG() { //?????????????? cómo lodiferencio del menos binario????????
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.NEG);     
   }
   private UnidadLexica unidadBLT() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.BLT);     
   }
   private UnidadLexica unidadBLE() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.BLE);     
   }
   private UnidadLexica unidadBGE() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.BGE);     
   }
   private UnidadLexica unidadEQ() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.EQ);     
   }
   private UnidadLexica unidadNEQ() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.NEQ);     
   }
   private UnidadLexica unidadPAP() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PAP);     
   }
   private UnidadLexica unidadPCIERRE() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PCIERRE);     
   }
   private UnidadLexica unidadEof() {
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