
package Objetos;

/**
 *
 * @author jcsr
 */
public class ComponenteImagen {
    
    private String origen;
    private String alineacion;
    private int altura;
    private int ancho;

    public ComponenteImagen(String origen, String alineacion, int altura, int ancho) {
        this.origen = origen;
        this.alineacion = alineacion;
        this.altura = altura;
        this.ancho = ancho;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(String alineacion) {
        this.alineacion = alineacion;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    
    
    
    
    
}
