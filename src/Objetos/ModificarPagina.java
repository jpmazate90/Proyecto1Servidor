
package Objetos;

import java.util.ArrayList;

/**
 *
 * @author jcsr
 */
public class ModificarPagina {
    
    private String id;
    private String titulo;
    private ArrayList<String> etiquetas;

    public ModificarPagina(String id, String titulo, ArrayList<String> etiquetas) {
        this.id = id;
        this.titulo = titulo;
        this.etiquetas = etiquetas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<String> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<String> etiquetas) {
        this.etiquetas = etiquetas;
    }
    
    
    
    
}
