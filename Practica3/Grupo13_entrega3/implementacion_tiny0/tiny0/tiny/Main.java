package tiny;


import asint.TinyASint.Prog;
import procesamientos.Impresion;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;


public class Main {
   public static void main(String[] args) throws Exception {
         Prog prog = null;
  	   	System.out.println("Ejecutando constructor ast descendente manual \n");
         prog = ejecuta_descendente_manual(args[0]);
         prog.procesa(new Impresion());
         System.out.println();
         System.out.println("?xito");
           
   }
   
   
   private static Prog ejecuta_descendente_manual(String in) throws Exception {
     Reader input = new InputStreamReader(new FileInputStream(in));
     c_ast_descendente_manual.ConstructorAST constructorast = new c_ast_descendente_manual.ConstructorAST(input);
     return constructorast.Init();
   }
}   
   
