


package proyecto1compiladoresservidor;

import Analizadores.AnalizadorLexico1;
import Analizadores.parser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java_cup.runtime.*;

/**
 *
 * @author jcsr
 */
public class Proyecto1CompiladoresServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File archivo2 = new File("archivo2.txt");
        try {
          
            
           FileReader reader2 = new FileReader(archivo2);
           AnalizadorLexico1 lex1 = new AnalizadorLexico1(reader2);
           parser parser1 = new parser(lex1);
           parser1.parse();
            
        } catch (FileNotFoundException ex) {
           ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
