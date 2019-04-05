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
// sirve para mandar un mensaje de exito a la aplicacion cliente
    public void mandarMensaje(String texto) {
        try {
            String mensajeEnviar = "<MENSAJE>["+texto+"]</MENSAJE>";
            Socket cliente = new Socket("localhost", 8080);
            DataOutputStream flujo = new DataOutputStream(cliente.getOutputStream());
            flujo.writeUTF(mensajeEnviar);
            cliente.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
// sirve para mandar un mensaje de error a la aplicacion cliente
    public void mandarError(String mensaje) {
        try {
            String mensajeEnviar = "<ERROR>["+mensaje+"]</ERROR>";
            Socket cliente = new Socket("localhost", 8080);
            DataOutputStream flujo = new DataOutputStream(cliente.getOutputStream());
            flujo.writeUTF(mensajeEnviar);
            cliente.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
