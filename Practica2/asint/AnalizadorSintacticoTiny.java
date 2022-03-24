/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package asint;

import alex.UnidadLexica;
import alex.AnalizadorLexicoTiny;
import alex.ClaseLexica;
import errors.GestionErroresTiny;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnalizadorSintacticoTiny {
   private UnidadLexica anticipo;
   private AnalizadorLexicoTiny alex;
   private GestionErroresTiny errores;
   
   public AnalizadorSintacticoTiny(Reader input) throws IOException {
      errores = new GestionErroresTiny();
      alex = new AnalizadorLexicoTiny(input);
      alex.fijaGestionErrores(errores);
      sigToken();
   }
   public void Sp() {
      PROG();
      empareja(ClaseLexica.EOF);
   }
   private void PROG() {
     switch(anticipo.clase()) {
         case R_REAL: case R_INT: case R_BOOL:
        	 LDEC();
             empareja(ClaseLexica.SEP_PROG);
             LINST();
        	 break;
         default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                          ClaseLexica.R_REAL, ClaseLexica.R_INT, ClaseLexica.R_BOOL);                                            
   }
   }
   private void LDEC() {
      switch(anticipo.clase()) {
      	case R_REAL: case R_INT: case R_BOOL:
              DEC();
              RLDEC();
              break;
          case EOF: break;
          default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
        		  						   ClaseLexica.R_REAL, ClaseLexica.R_INT, ClaseLexica.R_BOOL);                                         
      } 
   }
   private void DEC() {
      switch(anticipo.clase()) {
      	case R_REAL: case R_INT: case R_BOOL:    
           TIPO();
           empareja(ClaseLexica.ID);
           break;
       default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
    		   							 ClaseLexica.R_REAL, ClaseLexica.R_INT, ClaseLexica.R_BOOL);                                         
   }
   }    
   private void RLDEC() {
      switch(anticipo.clase()) {
       case PTO_COMA:    
           empareja(ClaseLexica.PTO_COMA);
           DEC();
           RLDEC();
           break;
       case SEP_PROG: break;    
       default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                         ClaseLexica.PTO_COMA, ClaseLexica.SEP_PROG);                                       
      }          
   }   
   private void TIPO() {
     switch(anticipo.clase()) {       
       case R_REAL:   
    	   empareja(ClaseLexica.R_REAL);
    	   break;
       case R_INT:   
    	   empareja(ClaseLexica.R_INT);
    	   break;
       case R_BOOL:   
    	   empareja(ClaseLexica.R_BOOL);
    	   break;
       default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
    		   							ClaseLexica.R_REAL, ClaseLexica.R_INT, ClaseLexica.R_BOOL);                                         
     }
   }
   private void LINST() {
     switch(anticipo.clase()) {
         case ID:
             INST();
             RLINST();
             break;
         default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                           ClaseLexica.ID);                                    
     }  
   }
   private void RLINST() {
      switch(anticipo.clase()) {
          case PTO_COMA: 
             empareja(ClaseLexica.PTO_COMA);
             INST();
             RLINST();
             break;
          case EOF: break;
          default:    
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                      ClaseLexica.PTO_COMA,ClaseLexica.EOF);                                              
      } 
   }
   private void INST() {
     switch(anticipo.clase()) {
         case ID:
             empareja(ClaseLexica.ID);
             empareja(ClaseLexica.ASIG);
             E0();
             break;
         default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                           ClaseLexica.ID);                                    
     }  
   }
   private void E0() {
      switch(anticipo.clase()) {
          case LIT_INT: case R_FALSE: case ID: case MENOS: case R_NOT: case PAP: case LIT_REAL: case R_TRUE:
             E1();
             RE0();
             break;
          default:    
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                      ClaseLexica.LIT_INT,ClaseLexica.R_FALSE,
                                      ClaseLexica.ID,ClaseLexica.MENOS,
                                      ClaseLexica.R_NOT,ClaseLexica.PAP,
                                      ClaseLexica.LIT_REAL,ClaseLexica.R_TRUE);                                              
      } 
   }
   private void RE0() {
      switch(anticipo.clase()) {
          case MAS: 
        	  empareja(ClaseLexica.MAS);
        	  E0();
        	  break;

          case MENOS: 
               empareja(ClaseLexica.MENOS); 
               E1(); 
               break;
          case PCIERRE: case PTO_COMA: case EOF: break;
          default:     
              errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                      ClaseLexica.MAS,ClaseLexica.MENOS);
   }   
   }
   private void E1() {
		switch(anticipo.clase()) {
		case LIT_INT: case R_FALSE: case ID: case MENOS: case R_NOT: case PAP: case LIT_REAL: case R_TRUE:
			E2();
			RE1();
			break;
		default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
				ClaseLexica.ID,ClaseLexica.LIT_INT,
				ClaseLexica.LIT_REAL, ClaseLexica.PAP,ClaseLexica.R_NOT,ClaseLexica.MENOS,ClaseLexica.R_FALSE,ClaseLexica.R_TRUE);                                                                      
		}  
	}
   private void RE1() {
		switch(anticipo.clase()) {
		case R_AND: case R_OR: 
			OPBAI1();
			E2();
			RE1();
			break;
		case MAS: case MENOS: case PCIERRE: case PTO_COMA: case EOF:break;
		default:    
			errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
					ClaseLexica.R_AND,ClaseLexica.R_OR,
					ClaseLexica.MAS, ClaseLexica.MENOS);                                              
		} 
	}
   
	private void E2() {
		switch(anticipo.clase()) {
		case LIT_INT: case R_FALSE : case ID: case MENOS: case R_NOT: case PAP: case LIT_REAL: case R_TRUE:
			E3();
			RE2();
			break;
		default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
				ClaseLexica.ID,ClaseLexica.LIT_INT,
				ClaseLexica.LIT_REAL, ClaseLexica.PAP,ClaseLexica.R_NOT,ClaseLexica.MENOS,ClaseLexica.R_FALSE,ClaseLexica.R_TRUE); 
		}   
	}
	
	private void RE2() {
		switch(anticipo.clase()) {
		case BEQ:  case BNE:    case BLT:    case BLE: case BGE:    case BGT:
			OPBAI2();
			E3();
			RE2();
			break;
		case R_AND: case R_OR:    case MAS:    case MENOS:    case PCIERRE:    case PTO_COMA:    case EOF:
			break;
		default:    
			errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
					ClaseLexica.BEQ,ClaseLexica.BNE,ClaseLexica.BLT,ClaseLexica.BLE,ClaseLexica.BGE,ClaseLexica.BGT,ClaseLexica.R_AND,
					ClaseLexica.R_OR,ClaseLexica.MAS,ClaseLexica.MENOS);
		}  
	}
	private void E3() {
		switch(anticipo.clase()) {
		case LIT_INT: case R_FALSE : case ID: case MENOS: case R_NOT: case PAP: case LIT_REAL: case R_TRUE:
			E4();
			RE3();
			break;
		default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
				ClaseLexica.ID,ClaseLexica.LIT_INT,
				ClaseLexica.LIT_REAL, ClaseLexica.PAP,ClaseLexica.R_NOT,ClaseLexica.MENOS,ClaseLexica.R_FALSE,ClaseLexica.R_TRUE); 
		}  
	}
	
	private void RE3() {
		switch(anticipo.clase()) {
		case DIV: case POR:
			OPBNA();
			E4();
			break;
		case R_AND: case BEQ : case BGE: case BGT: case BLE: case BNE: case BLT: case MAS:
		case MENOS: case R_OR : case PCIERRE: case PTO_COMA: case EOF:
			break;
		default:    
			errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
					ClaseLexica.DIV,ClaseLexica.POR,ClaseLexica.R_AND,ClaseLexica.BEQ,ClaseLexica.BGE,ClaseLexica.BGT,ClaseLexica.BLE,
					ClaseLexica.BNE,ClaseLexica.BLT,ClaseLexica.MAS,ClaseLexica.MENOS,ClaseLexica.R_OR);
		}  
	}
	private void E4() {
		switch(anticipo.clase()) {
		case MENOS:
			empareja(ClaseLexica.MENOS);
			E5();
			break;
		case R_NOT:
			empareja(ClaseLexica.R_NOT);
			E4();
			break;
		case LIT_INT: case R_FALSE : case ID: case PAP: case LIT_REAL: case R_TRUE:
			E5();
			break;
		default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
				ClaseLexica.ID,ClaseLexica.LIT_INT,
				ClaseLexica.LIT_REAL, ClaseLexica.PAP,ClaseLexica.R_NOT,ClaseLexica.MENOS,ClaseLexica.R_FALSE,ClaseLexica.R_TRUE); 
		}  
	}
	
	private void E5() {
		switch(anticipo.clase()) {
		case LIT_INT:  empareja(ClaseLexica.LIT_INT);break;
		case LIT_REAL:   empareja(ClaseLexica.LIT_REAL);break;
		case ID:  empareja(ClaseLexica.ID);break;
		case R_FALSE:  empareja(ClaseLexica.R_FALSE);break;
		case R_TRUE:   empareja(ClaseLexica.R_TRUE);break;
		case PAP:  
			empareja(ClaseLexica.PAP);
			E0();
			empareja(ClaseLexica.PCIERRE);
			break;
		default:    
			errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
					ClaseLexica.LIT_INT,ClaseLexica.LIT_REAL,ClaseLexica.ID,ClaseLexica.PAP,ClaseLexica.R_FALSE,ClaseLexica.R_TRUE);
		}  
	}
	
	private void OPBNA() {
		switch(anticipo.clase()) {
		case POR:  empareja(ClaseLexica.POR);break;
		case DIV:   empareja(ClaseLexica.DIV);break;
		default:    
			errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
					ClaseLexica.POR,ClaseLexica.DIV);
		}  
	}
	
	private void OPBAI2() {
		switch(anticipo.clase()) {
		case BNE:  empareja(ClaseLexica.BNE);break;
		case BEQ:   empareja(ClaseLexica.BEQ);break;
		case BLE:  empareja(ClaseLexica.BLE);break;
		case BGE:   empareja(ClaseLexica.BGE);break;
		case BLT:  empareja(ClaseLexica.BLT);break;
		case BGT:   empareja(ClaseLexica.BGT);break;
		default:    
			errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
					ClaseLexica.BEQ,ClaseLexica.BNE,ClaseLexica.BLT,ClaseLexica.BLE,ClaseLexica.BGE,ClaseLexica.BGT);
		}  
	}
	
	private void OPBAI1() {
		switch(anticipo.clase()) {
		case R_AND:  empareja(ClaseLexica.R_AND);break;
		case R_OR:   empareja(ClaseLexica.R_OR);break;
		default:    
			errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
					ClaseLexica.R_AND,ClaseLexica.R_OR);
		}  
	}
	
	private void empareja(ClaseLexica claseEsperada) {
		if (anticipo.clase() == claseEsperada)
			sigToken();
		else errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),claseEsperada);
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
