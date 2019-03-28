
package Objetos;

import java.util.ArrayList;

/**
 *
 * @author jcsr
 */
public class ComponenteMenu {
    
    private String padre;
    private ArrayList<String> etiquetas;
    
    private boolean tienePadre;
    private boolean tieneEtiquetas;

    public ComponenteMenu(String padre, ArrayList<String> etiquetas) {
        this.padre = padre;
        this.etiquetas = etiquetas;
        if(padre==null){
            tienePadre=false;
        }else{
            tienePadre=true;
        }
        if(etiquetas.isEmpty()){
            tieneEtiquetas=false;
        }else{
            tieneEtiquetas=true;
        }
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
    
    
    
    
}
