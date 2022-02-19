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
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.INT); 
  }
  public UnidadLexica unidadREAL() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.REAL); 
  }
  public UnidadLexica unidadBOOL() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.BOOL); 
  }
  public UnidadLexica unidadASIG() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.ASIG); 
  }
  public UnidadLexica unidadTRUE() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.TRUE); 
  }
  public UnidadLexica unidadFALSE() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.FALSE); 
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
  public UnidadLexica unidadNEG() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.NEG); 
  }
  public UnidadLexica unidadAND() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.AND); 
  }
  public UnidadLexica unidadOR() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.OR); 
  }
  public UnidadLexica unidadNOT() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.NOT); 
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
  public UnidadLexica unidadEQ() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.EQ); 
  }
  public UnidadLexica unidadNEQ() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.NEQ); 
  }
  public UnidadLexica unidadPAP() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PAP); 
  }
  public UnidadLexica unidadPCIERRE() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PCIERRE); 
  }
  
  public UnidadLexica unidadID() {
     return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(),ClaseLexica.ID,
                                         alex.lexema()); 
  }
  public UnidadLexica unidadNUM_INT() {
     return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(),ClaseLexica.NUM_INT,
                                         alex.lexema()); 
  }
  public UnidadLexica unidadNUM_REAL() {
     return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(),ClaseLexica.NUM_REAL,
                                         alex.lexema()); 
  }
 
  public UnidadLexica unidadEof() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.EOF); 
  }
  public void error() {
    System.err.println("***"+alex.fila()+" Caracter inexperado: "+alex.lexema());
	System.exit(1);
  }
}
