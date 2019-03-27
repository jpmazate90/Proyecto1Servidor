/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apoyo;

/**
 *
 * @author jcsr
 */
public class Parametro {
    
    private String nombre;
    private String lexema;

    public Parametro(String nombre, String lexema) {
        this.nombre = nombre;
        this.lexema = lexema;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }
    
    
    
}
