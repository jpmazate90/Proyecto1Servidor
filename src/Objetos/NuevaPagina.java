
package Objetos;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jcsr
 */
public class NuevaPagina {
    
    private String id;
    private String link;
    private String titulo;
    private String sitio;
    private String padre;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String usuarioModificacion;
    private ArrayList<String> etiquetas;

    public NuevaPagina(String id,String link ,String titulo,String sitio, String padre, String usuarioCreacion, Date fechaCreacion, Date fechaModificacion, String usuarioModificacion, ArrayList<String> etiquetas) {
        this.id = id;
        this.link=link;
        this.titulo = titulo;
        this.sitio = sitio;
        this.padre = padre;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuarioModificacion = usuarioModificacion;
        this.etiquetas = etiquetas;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public ArrayList<String> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<String> etiquetas) {
        this.etiquetas = etiquetas;
    }
    
    
    
}
