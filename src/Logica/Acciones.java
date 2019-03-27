/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Objetos.BorrarSitioWeb;
import Objetos.NuevaPagina;
import Objetos.NuevoSitioWeb;

/**
 *
 * @author jcsr
 */
public class Acciones {
    
    public void accionNuevoSitioWeb(NuevoSitioWeb nuevoSitioWeb){
        System.out.println("Accion nuevoSitioWeb, id:"+nuevoSitioWeb.getId());
    }
    
    
    public void accionBorrarSitioWeb(BorrarSitioWeb borrarSitioWeb){
        System.out.println("Accion borrarSitioWeb, id:"+borrarSitioWeb.getId());
    }
    
    
    public void accionNuevaPagina(NuevaPagina nuevaPagina){
        System.out.println("Accion nuevaPagina, id:"+nuevaPagina.getId());
    }
    
}
