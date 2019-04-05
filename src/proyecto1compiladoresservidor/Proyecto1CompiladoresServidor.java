package proyecto1compiladoresservidor;

import Analizadores.AnalizadorLexico1;
import Analizadores.AnalizadorLexico2;
import Analizadores.parser;
import Analizadores.parser2;
import Logica.Acciones;
import Logica.Mensajes;
import Objetos.Mandar;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StringReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.*;
import java.util.Scanner;

/**
 *
 * @author jcsr
 */
public class Proyecto1CompiladoresServidor implements Runnable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {//sirve para cargar la base de datos
            File archivoUsuarios = new File("baseDatos.txt");
            FileReader fileReader = new FileReader(archivoUsuarios);
            AnalizadorLexico2 lex2 = new AnalizadorLexico2(fileReader);
            parser2 parser2 = new parser2(lex2);
            parser2.parse();// carga los datos
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Surgio un error al intentar cargar la base de datos");
        }
        
        Mensajes mensaje = new Mensajes();
        try {// es donde esta esperando que el cliente mande un mensaje
            System.out.println("ESPERANDO MENSAJES DEL CLIENTE");
            ServerSocket servidor = new ServerSocket(9090);
            Socket cliente;

            while (true) {
                try {// al momento de recibir el mensaje
                    cliente = servidor.accept();
                    //encapsula la informacion en un objeto 
                    ObjectInputStream flujo = new ObjectInputStream(cliente.getInputStream());
                    Mandar mensajeRecibido;
                    mensajeRecibido = (Mandar) flujo.readObject();
                    System.out.println("Mensaje: " + mensajeRecibido.getTexto());// lo muestra en pantalla el mensaje
                    System.out.println("Usuario que envio: " + mensajeRecibido.getUsuario());
                    StringReader reader = new StringReader(mensajeRecibido.getTexto());
                    AnalizadorLexico1 lex = new AnalizadorLexico1(reader);// y manda a generar la accion con el otro parser
                    parser parser = new parser(lex, mensajeRecibido.getUsuario());
                    parser.parse();
                    cliente.close();
                } catch (Exception e) {
                    mensaje.mandarError("SURGIO UN ERROR AL LEER EL MENSAJE DEL CLIENTE");
                    e.printStackTrace();
                }

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }catch (Exception ex) {
            System.out.println("Surgio un error al leer el mensaje del cliente");
            ex.printStackTrace();
        }

    }

    public void run() {
        try {// HIlo para el ciclo
            System.out.println("Entre");
            ServerSocket servidor = new ServerSocket(9090);
            Socket cliente;

            while (true) {
                cliente = servidor.accept();
                ObjectInputStream flujo = new ObjectInputStream(cliente.getInputStream());
                Mandar mensajeRecibido;
                mensajeRecibido = (Mandar) flujo.readObject();
                System.out.println("Mensaje: " + mensajeRecibido.getTexto());
                System.out.println("Usuario que envio: " + mensajeRecibido.getUsuario());
                cliente.close();

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Surgio un error al leer el mensaje del cliente");
        }
    }

}


/*

<ACCION NOMBRE="NUEVO_SITIO_WEB">
<PARAMETROS>
<PARAMETRO NOMBRE = "ID">[_MIID]</PARAMETRO>
</PARAMETROS>
</ACCION>

*/
