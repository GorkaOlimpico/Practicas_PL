package alex;

import asintAsc.ClaseLexica;

public class ALexOperations {
  private AnalizadorLexicoTiny alex;
  public ALexOperations(AnalizadorLexicoTiny alex) {
   this.alex = alex;   
  }
  public UnidadLexica unidadSEP_PROG() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.sep_prog,"&&"); 
  }
  public UnidadLexica unidadPTO_COMA() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.pto_coma,";"); 
  } 
  public UnidadLexica unidadINT() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_int,"int"); 
  }
  public UnidadLexica unidadREAL() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_real,"real"); 
  }
  public UnidadLexica unidadBOOL() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_bool,"bool"); 
  }
  public UnidadLexica unidadASIG() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.asig,"="); 
  }
  public UnidadLexica unidadTRUE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_true,"true"); 
  }
  public UnidadLexica unidadFALSE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_false,"false"); 
  }
  public UnidadLexica unidadMAS() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.mas,"+"); 
  }
  public UnidadLexica unidadMENOS() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.menos,"-"); 
  }
  public UnidadLexica unidadPOR() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.por,"*"); 
  }
  public UnidadLexica unidadDIV() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.div,"/"); 
  }
  public UnidadLexica unidadAND() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_and,"and"); 
  }
  public UnidadLexica unidadOR() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_or,"or"); 
  }
  public UnidadLexica unidadNOT() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_not,"not"); 
  }
  public UnidadLexica unidadBLT() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.blt,"blt"); 
  }
  public UnidadLexica unidadBGT() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.bgt,"ngt"); 
  }
  public UnidadLexica unidadBLE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.ble,"ble"); 
  }
  public UnidadLexica unidadBGE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.bge,"bge"); 
  }
  public UnidadLexica unidadBEQ() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.beq,"beq"); 
  }
  public UnidadLexica unidadBNE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.bne,"bne"); 
  }
  public UnidadLexica unidadPAP() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.pap,"pap"); 
  }
  public UnidadLexica unidadPCIERRE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.pcierre,"pcierre"); 
  }
  public UnidadLexica unidadMOD() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.mod,"mod"); 
  }
  public UnidadLexica unidadCCIERRE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.ccierre,"ccierre"); 
  } 
  public UnidadLexica unidadCAP() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.cap,"cap"); 
  }
  public UnidadLexica unidadLLCIERRE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.llcierre,"llcierre"); 
  }
  public UnidadLexica unidadLLAP() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.llap,"llap"); 
  }
  public UnidadLexica unidadFLECHA() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.flecha,"flecha"); 
  }
  public UnidadLexica unidadCOMA() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.coma,","); 
  }
  public UnidadLexica unidadPUNTO() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.punto,"."); 
  }
  public UnidadLexica unidadET() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.et,"&"); 
  }
  public UnidadLexica unidadSTRING() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_string,"string"); 
  }
  public UnidadLexica unidadNULL() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_null,"null"); 
  }
  public UnidadLexica unidadPROC() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_proc,"proc"); 
  }
  public UnidadLexica unidadIF() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_if,"if"); 
  }
  public UnidadLexica unidadTHEN() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_then,"then"); 
  }
  public UnidadLexica unidadELSE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_else,"else"); 
  }
  public UnidadLexica unidadENDIF() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_endif,"endif"); 
  }
  public UnidadLexica unidadWHILE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_while,"while"); 
  }
  public UnidadLexica unidadDO() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_do,"do"); 
  }
  public UnidadLexica unidadENDWHILE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_endwhile,"endwhile"); 
  }
  public UnidadLexica unidadCALL() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_call,"call"); 
  }
  public UnidadLexica unidadRECORD() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_record,"record"); 
  }
  public UnidadLexica unidadARRAY() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_array,"array"); 
  }
  public UnidadLexica unidadOF() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_of,"of"); 
  }
  public UnidadLexica unidadPOINTER() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_pointer,"pointer"); 
  }
  public UnidadLexica unidadNEW() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_new,"new"); 
  }
  public UnidadLexica unidadDEL() {
	return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_del,"del"); 
  }
  public UnidadLexica unidadREAD() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_read,"read"); 
  }
  public UnidadLexica unidadWRITE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_write,"write"); 
  }
  public UnidadLexica unidadNL() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_nl,"nl"); 
  }
  public UnidadLexica unidadVAR() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_var,"var"); 
  }
  public UnidadLexica unidadTYPE() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.r_type,"type"); 
  }
  public UnidadLexica unidadEOF() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.EOF,"<EOF>"); 
  }
  
  // Multivaluadas
  public UnidadLexica unidadID() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.id,
                                         alex.lexema()); 
  }
  public UnidadLexica unidadLIT_INT() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.lit_int,
                                         alex.lexema()); 
  }
  public UnidadLexica unidadLIT_REAL() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.lit_real,
                                         alex.lexema()); 
  }
  public UnidadLexica unidadLIT_CAD() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.lit_cad,
                                         alex.lexema()); 
  }
 
  
  public void error() {
     System.err.println("("+alex.fila()+','+alex.columna()+"):Caracter inexperado :"+ alex.lexema());  
     System.exit(1);
  }
}