
package Objetos;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jcsr
 */
public class NuevoSitioWeb {
    
    private String id;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String usuarioModificacion;

    public NuevoSitioWeb(String id, String usuarioCreacion, Date fechaCreacion, Date fechaModificacion, String usuarioModificacion) {
        this.id = id;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuarioModificacion = usuarioModificacion;
    }

    public String getId() {
        
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    
    
    
    
    
}
