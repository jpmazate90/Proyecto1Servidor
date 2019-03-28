
package Objetos;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jcsr
 */
public class ModificarPagina {
    
    private String id;
    private String titulo;
    private String usuarioModificacion;
    private Date datefechaModificacion;
    private ArrayList<String> etiquetas;
    private boolean tieneTitulo;

    public ModificarPagina(String id, String titulo, String usuarioModificacion, Date datefechaModificacion, ArrayList<String> etiquetas) {
        this.id = id;
        this.titulo = titulo;
        this.usuarioModificacion = usuarioModificacion;
        this.datefechaModificacion = datefechaModificacion;
        this.etiquetas = etiquetas;
        
        if(titulo==null){
            tieneTitulo=false;
        }else{
            tieneTitulo=true;
        }
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
