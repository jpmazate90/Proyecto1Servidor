
package Objetos;

public class Componente {
    private String id;
    private String pagina;
    private String clase;

    public Componente(String id, String pagina, String clase) {
        this.id = id;
        this.pagina = pagina;
        this.clase = clase;
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
