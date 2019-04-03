
package Objetos;

import java.util.ArrayList;

public class Componente {
    private String id;
    private String pagina;
    private String clase;
    
    private String texto;
    private String alineacion;
    private String color;
    private String origen;
    private String altura;
    private String ancho;
    private String padre;
    private ArrayList<String> etiquetas;

    public Componente(String id, String pagina, String clase, String texto, String alineacion, String color, String origen, String altura, String ancho, String padre, ArrayList<String> etiquetas) {
        this.id = id;
        this.pagina = pagina;
        this.clase = clase;
        this.texto = texto;
        this.alineacion = alineacion;
        this.color = color;
        this.origen = origen;
        this.altura = altura;
        this.ancho = ancho;
        this.padre = padre;
        this.etiquetas = etiquetas;
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

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getAncho() {
        return ancho;
    }

    public void setAncho(String ancho) {
        this.ancho = ancho;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public ArrayList<String> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

   

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }
    
    
    
}
