package main;


import asint.TinyASint.Prog;
import procesamientos.Impresion;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import alex.AnalizadorLexicoTiny;


public class Main {
   public static void main(String[] args) throws Exception {
	   Prog prog = null;
       if (args[0].equals("-asc")) {
    	   System.out.println("Ejecutando constructor AST ascendente \n");
           prog = ejecuta_ascendente(args[1]);
       }
       else if (args[0].equals("-desc")) {
           prog = ejecuta_descendente(args[1]);
    	   System.out.println("Ejecutando constructor AST descendente \n");
       }
       else 
          System.out.println("Args tienen que ser -asc o -desc y el nombre del fichero");
       
       prog.procesa(new Impresion());
       System.out.println("\n Éxito");

           
   }
   
   
   private static Prog ejecuta_ascendente(String in) throws Exception {       
	     Reader input = new InputStreamReader(new FileInputStream(in));
	     AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
	     c_ast_ascendente.ConstructorAST constructorast =  new c_ast_ascendente.ConstructorAST(alex);
	     return (Prog)constructorast.parse().value;
	  }
	   private static Prog ejecuta_descendente(String in) throws Exception {
	     Reader input = new InputStreamReader(new FileInputStream(in));
	     c_ast_descendente.ConstructorAST constructorast = new c_ast_descendente.ConstructorAST(input);
	     return constructorast.Init();
	   }
}   
   
