
package Objetos;

/**
 *
 * @author jcsr
 */
public class BorrarComponente {
    
    private String id;
    private String pagina;

    public BorrarComponente(String id, String pagina) {
        this.id = id;
        this.pagina = pagina;
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
    
    
    
}
