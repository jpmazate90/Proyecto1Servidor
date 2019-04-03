
package Logica;

import Objetos.Mandar;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author jcsr
 */
public class Mensajes {
    
    public void mandarMensaje(String texto){
        try{
                Socket cliente = new Socket("localhost", 8080);
                DataOutputStream flujo  = new DataOutputStream(cliente.getOutputStream());
                flujo.writeUTF(texto);
                cliente.close();
                
                }catch(Exception e){
                    e.printStackTrace();
                }
    }
    
}
