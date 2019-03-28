
package Objetos;

/**
 *
 * @author jcsr
 */
public class ComponenteTitulo {
    
    private String texto;
    private String alineacion;
    
    private boolean tieneAlineacion;

    public ComponenteTitulo(String texto, String alineacion) {
        this.texto = texto;
        this.alineacion = alineacion;
        if(alineacion==null){
            tieneAlineacion=false;
        }else{
            tieneAlineacion=true;
        }
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(String alineacion) {
        this.alineacion = alineacion;
    }

    public boolean isTieneAlineacion() {
        return tieneAlineacion;
    }

    public void setTieneAlineacion(boolean tieneAlineacion) {
        this.tieneAlineacion = tieneAlineacion;
    }
    
    
    
    
    
}
