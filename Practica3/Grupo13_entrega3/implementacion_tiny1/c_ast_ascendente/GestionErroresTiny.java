package c_ast_ascendente;


public class GestionErroresTiny {
   public void errorLexico(int fila, String lexema) {
     System.out.println("ERROR lexico fila "+fila+": Caracter inesperado: "+lexema); 
     System.exit(1);
   }  
   public void errorSintactico(UnidadLexica unidadLexica) {
     System.out.print("ERROR sintactico fila "+unidadLexica.lexema().fila()+", columna "+unidadLexica.lexema().col()+": Elemento inesperado "+unidadLexica.value);
     System.exit(1);
   }
}
