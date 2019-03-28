
package Objetos;

/**
 *
 * @author jcsr
 */
public class ComponenteParrafo {
    
    private String texto;
    private String alineacion;
    private String color;
    
    private boolean tieneAlineacion;
    private boolean tieneColor;

    public ComponenteParrafo(String texto, String alineacion, String color) {
        this.texto = texto;
        this.alineacion = alineacion;
        this.color = color;
        if(color==null){
            tieneColor=false;
        }else{
            tieneColor=true;
        }
        
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isTieneAlineacion() {
        return tieneAlineacion;
    }

    public void setTieneAlineacion(boolean tieneAlineacion) {
        this.tieneAlineacion = tieneAlineacion;
    }

    public boolean isTieneColor() {
        return tieneColor;
    }

    public void setTieneColor(boolean tieneColor) {
        this.tieneColor = tieneColor;
    }
    
    
    
}
