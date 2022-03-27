package alex;

public class ALexOperations {
  private AnalizadorLexicoTiny alex;
  public ALexOperations(AnalizadorLexicoTiny alex) {
   this.alex = alex;   
  }
  public UnidadLexica unidadSEP_PROG() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.SEP_PROG,"SEP_PROG"); 
  }
  public UnidadLexica unidadPTO_COMA() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.PTO_COMA,"PTO_COMA"); 
  } 
  public UnidadLexica unidadINT() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_INT,"R_INT"); 
  }
  public UnidadLexica unidadREAL() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_REAL,"R_REAL"); 
  }
  public UnidadLexica unidadBOOL() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_BOOL,"R_BOOL"); 
  }
  public UnidadLexica unidadASIG() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.ASIG,"ASIG"); 
  }
  public UnidadLexica unidadTRUE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_TRUE,"R_TRUE"); 
  }
  public UnidadLexica unidadFALSE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_FALSE,"R_FALSE"); 
  }
  public UnidadLexica unidadMAS() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.MAS,"MAS"); 
  }
  public UnidadLexica unidadMENOS() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.MENOS,"MENOS"); 
  }
  public UnidadLexica unidadPOR() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.POR,"POR"); 
  }
  public UnidadLexica unidadDIV() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.DIV,"DIV"); 
  }
  public UnidadLexica unidadAND() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_AND,"R_AND"); 
  }
  public UnidadLexica unidadOR() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_OR,"R_OR"); 
  }
  public UnidadLexica unidadNOT() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_NOT,"R_NOT"); 
  }
  public UnidadLexica unidadBLT() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.BLT,"BLT"); 
  }
  public UnidadLexica unidadBGT() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.BGT,"BGT"); 
  }
  public UnidadLexica unidadBLE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.BLE,"BLE"); 
  }
  public UnidadLexica unidadBGE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.BGE,"BGE"); 
  }
  public UnidadLexica unidadBEQ() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.BEQ,"BEQ"); 
  }
  public UnidadLexica unidadBNE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.BNE,"BNE"); 
  }
  public UnidadLexica unidadPAP() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.PAP,"PAP"); 
  }
  public UnidadLexica unidadPCIERRE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.PCIERRE,"PCIERRE"); 
  }
  public UnidadLexica unidadMOD() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.MOD,"MOD"); 
  }
  public UnidadLexica unidadCCIERRE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.CCIERRE,"CCIERRE"); 
  } 
  public UnidadLexica unidadCAP() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.CAP,"CAP"); 
  }
  public UnidadLexica unidadLLCIERRE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.LLCIERRE,"LLCIERRE"); 
  }
  public UnidadLexica unidadLLAP() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.LLAP,"LLAP"); 
  }
  public UnidadLexica unidadFLECHA() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.FLECHA,"FLECHA"); 
  }
  public UnidadLexica unidadCOMA() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.COMA,"COMA"); 
  }
  public UnidadLexica unidadPUNTO() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.PUNTO,"PUNTO"); 
  }
  public UnidadLexica unidadET() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.ET,"ET"); 
  }
  public UnidadLexica unidadSTRING() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_STRING,"R_STRING"); 
  }
  public UnidadLexica unidadNULL() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_NULL,"R_NULL"); 
  }
  public UnidadLexica unidadPROC() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_PROC,"R_PROC"); 
  }
  public UnidadLexica unidadIF() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_IF,"R_IF"); 
  }
  public UnidadLexica unidadTHEN() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_THEN,"R_THEN"); 
  }
  public UnidadLexica unidadELSE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_ELSE,"R_ELSE"); 
  }
  public UnidadLexica unidadENDIF() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_ENDIF,"R_ENDIF"); 
  }
  public UnidadLexica unidadWHILE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_WHILE,"R_WHILE"); 
  }
  public UnidadLexica unidadDO() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_DO,"R_DO"); 
  }
  public UnidadLexica unidadENDWHILE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_ENDWHILE,"R_ENDWHILE"); 
  }
  public UnidadLexica unidadCALL() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_CALL,"R_CALL"); 
  }
  public UnidadLexica unidadRECORD() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_RECORD,"R_RECORD"); 
  }
  public UnidadLexica unidadARRAY() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_ARRAY,"R_ARRAY"); 
  }
  public UnidadLexica unidadOF() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_OF,"R_OF"); 
  }
  public UnidadLexica unidadPOINTER() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_POINTER,"R_POINTER"); 
  }
  public UnidadLexica unidadNEW() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_NEW,"R_NEW"); 
  }
  public UnidadLexica unidadDEL() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_DEL,"R_DEL"); 
  }
  public UnidadLexica unidadREAD() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_READ,"R_READ"); 
  }
  public UnidadLexica unidadWRITE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_WRITE,"R_WRITE"); 
  }
  public UnidadLexica unidadNL() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_NL,"R_NL"); 
  }
  public UnidadLexica unidadVAR() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_VAR,"R_VAR"); 
  }
  public UnidadLexica unidadTYPE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.R_TYPE,"R_TYPE"); 
  }
  public UnidadLexica unidadEOF() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.EOF,"EOF"); 
  }
  
  // Multivaluadas
  public UnidadLexica unidadID() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.ID,
                                         alex.lexema()); 
  }
  public UnidadLexica unidadLIT_INT() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.LIT_INT,
                                         alex.lexema()); 
  }
  public UnidadLexica unidadLIT_REAL() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.LIT_REAL,
                                         alex.lexema()); 
  }
  public UnidadLexica unidadLIT_CAD() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.LIT_CAD,
                                         alex.lexema()); 
  }
 
  
  public void error() {
     System.err.println("("+alex.fila()+','+alex.columna()+"):Caracter inexperado :"+ alex.lexema());  
     System.exit(1);
  }
}