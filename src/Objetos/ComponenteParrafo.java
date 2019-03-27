
package Objetos;

/**
 *
 * @author jcsr
 */
public class ComponenteParrafo {
    
    private String texto;
    private String alineacion;
    private String color;

    public ComponenteParrafo(String texto, String alineacion, String color) {
        this.texto = texto;
        this.alineacion = alineacion;
        this.color = color;
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
    
    
    
}
