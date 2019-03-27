
package Objetos;

/**
 *
 * @author jcsr
 */
public class ComponenteVideo {
    
    private String origen;
    private int altura;
    private int ancho;

    public ComponenteVideo(String origen, int altura, int ancho) {
        this.origen = origen;
        this.altura = altura;
        this.ancho = ancho;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
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
