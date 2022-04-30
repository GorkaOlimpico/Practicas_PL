package tiny0;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import cons_manual.ConstructorAST;
import asint.Tiny0ASint.Programa;
import procesamientos.Impresion;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        Reader input = new InputStreamReader(new FileInputStream(args[0]));
		ConstructorAST constructorast = new ConstructorAST(input);
		Programa prog = constructorast.Inicio();
        prog.procesa(new Impresion());
        
    }
    
}