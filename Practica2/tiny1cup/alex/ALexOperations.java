package alex;

public class ALexOperations {
  private AnalizadorLexicoTiny alex;
  public ALexOperations(AnalizadorLexicoTiny alex) {
   this.alex = alex;   
  }
  public UnidadLexica unidadSEP_PROG() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.SEP_PROG); 
  }
  public UnidadLexica unidadPTO_COMA() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PTO_COMA); 
  } 
  public UnidadLexica unidadINT() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_INT); 
  }
  public UnidadLexica unidadREAL() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_REAL); 
  }
  public UnidadLexica unidadBOOL() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_BOOL); 
  }
  public UnidadLexica unidadASIG() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.ASIG); 
  }
  public UnidadLexica unidadTRUE() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_TRUE); 
  }
  public UnidadLexica unidadFALSE() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_FALSE); 
  }
  public UnidadLexica unidadMAS() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MAS); 
  }
  public UnidadLexica unidadMENOS() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
  }
  public UnidadLexica unidadPOR() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.POR); 
  }
  public UnidadLexica unidadDIV() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.DIV); 
  }
  public UnidadLexica unidadAND() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_AND); 
  }
  public UnidadLexica unidadOR() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_OR); 
  }
  public UnidadLexica unidadNOT() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_NOT); 
  }
  public UnidadLexica unidadBLT() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.BLT); 
  }
  public UnidadLexica unidadBGT() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.BGT); 
  }
  public UnidadLexica unidadBLE() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.BLE); 
  }
  public UnidadLexica unidadBGE() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.BGE); 
  }
  public UnidadLexica unidadBEQ() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.BEQ); 
  }
  public UnidadLexica unidadBNE() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.BNE); 
  }
  public UnidadLexica unidadPAP() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PAP); 
  }
  public UnidadLexica unidadPCIERRE() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PCIERRE); 
  }
public UnidadLexica unidadMOD() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MOD); 
  }
  public UnidadLexica unidadCCIERRE() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.CCIERRE); 
  } 
  public UnidadLexica unidadCAP() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.CAP); 
  }
  public UnidadLexica unidadLLCIERRE() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.LLCIERRE); 
  }
  public UnidadLexica unidadLLAP() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.LLAP); 
  }
  public UnidadLexica unidadFLECHA() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.FLECHA); 
  }
  public UnidadLexica unidadCOMA() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.COMA); 
  }
  public UnidadLexica unidadPUNTO() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PUNTO); 
  }
  public UnidadLexica unidadET() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.ET); 
  }
  public UnidadLexica unidadSTRING() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_STRING); 
  }
  public UnidadLexica unidadNULL() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_NULL); 
  }
  public UnidadLexica unidadPROC() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_PROC); 
  }
  public UnidadLexica unidadIF() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_IF); 
  }
  public UnidadLexica unidadTHEN() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_THEN); 
  }
  public UnidadLexica unidadELSE() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_ELSE); 
  }
  public UnidadLexica unidadENDIF() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_ENDIF); 
  }
  public UnidadLexica unidadWHILE() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_WHILE); 
  }
  public UnidadLexica unidadDO() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_DO); 
  }
  public UnidadLexica unidadENDWHILE() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_ENDWHILE); 
  }
  public UnidadLexica unidadCALL() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_CALL); 
  }
  public UnidadLexica unidadRECORD() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_RECORD); 
  }
  public UnidadLexica unidadARRAY() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_ARRAY); 
  }
  public UnidadLexica unidadOF() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_OF); 
  }
  public UnidadLexica unidadPOINTER() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_POINTER); 
  }
  public UnidadLexica unidadNEW() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_NEW); 
  }
  public UnidadLexica unidadDEL() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_DEL); 
  }
  public UnidadLexica unidadREAD() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_READ); 
  }
  public UnidadLexica unidadWRITE() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_WRITE); 
  }
  public UnidadLexica unidadNL() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_NL); 
  }
  public UnidadLexica unidadVAR() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_VAR); 
  }
  public UnidadLexica unidadTYPE() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.R_TYPE); 
  }
  public UnidadLexica unidadID() {
     return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(),ClaseLexica.ID,
                                         alex.lexema()); 
  }
  public UnidadLexica unidadLIT_INT() {
     return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(),ClaseLexica.LIT_INT,
                                         alex.lexema()); 
  }
  public UnidadLexica unidadLIT_REAL() {
     return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(),ClaseLexica.LIT_REAL,
                                         alex.lexema()); 
  }
 
  public UnidadLexica unidadEOF() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.EOF); 
  }
  public void error() {
    System.err.println("***"+alex.fila()+" Caracter inexperado: "+alex.lexema());
	System.exit(1);
  }
}