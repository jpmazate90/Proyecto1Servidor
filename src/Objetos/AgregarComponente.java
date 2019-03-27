
package Objetos;

/**
 *
 * @author jcsr
 */
public class AgregarComponente {
    private String id;
    private String pagina;
    private String clase;
    
    private ComponenteTitulo compTitulo;
    private ComponenteParrafo compParrafo;
    private ComponenteImagen compImagen;
    private ComponenteVideo compVideo;
    private ComponenteMenu compMenu;
    
    private boolean esTitulo;
    private boolean esParrafo;
    private boolean esImagen;
    private boolean esVideo;
    private boolean esMenu;

    public AgregarComponente(String id, String pagina, String clase, ComponenteTitulo compTitulo, ComponenteParrafo compParrafo, ComponenteImagen compImagen, ComponenteVideo compVideo, ComponenteMenu compMenu, boolean esTitulo, boolean esParrafo, boolean esImagen, boolean esVideo, boolean esMenu) {
        this.id = id;
        this.pagina = pagina;
        this.clase = clase;
        this.compTitulo = compTitulo;
        this.compParrafo = compParrafo;
        this.compImagen = compImagen;
        this.compVideo = compVideo;
        this.compMenu = compMenu;
        this.esTitulo = esTitulo;
        this.esParrafo = esParrafo;
        this.esImagen = esImagen;
        this.esVideo = esVideo;
        this.esMenu = esMenu;
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

    public ComponenteTitulo getCompTitulo() {
        return compTitulo;
    }

    public void setCompTitulo(ComponenteTitulo compTitulo) {
        this.compTitulo = compTitulo;
    }

    public ComponenteParrafo getCompParrafo() {
        return compParrafo;
    }

    public void setCompParrafo(ComponenteParrafo compParrafo) {
        this.compParrafo = compParrafo;
    }

    public ComponenteImagen getCompImagen() {
        return compImagen;
    }

    public void setCompImagen(ComponenteImagen compImagen) {
        this.compImagen = compImagen;
    }

    public ComponenteVideo getCompVideo() {
        return compVideo;
    }

    public void setCompVideo(ComponenteVideo compVideo) {
        this.compVideo = compVideo;
    }

    public ComponenteMenu getCompMenu() {
        return compMenu;
    }

    public void setCompMenu(ComponenteMenu compMenu) {
        this.compMenu = compMenu;
    }

    public boolean isEsTitulo() {
        return esTitulo;
    }

    public void setEsTitulo(boolean esTitulo) {
        this.esTitulo = esTitulo;
    }

    public boolean isEsParrafo() {
        return esParrafo;
    }

    public void setEsParrafo(boolean esParrafo) {
        this.esParrafo = esParrafo;
    }

    public boolean isEsImagen() {
        return esImagen;
    }

    public void setEsImagen(boolean esImagen) {
        this.esImagen = esImagen;
    }

    public boolean isEsVideo() {
        return esVideo;
    }

    public void setEsVideo(boolean esVideo) {
        this.esVideo = esVideo;
    }

    public boolean isEsMenu() {
        return esMenu;
    }

    public void setEsMenu(boolean esMenu) {
        this.esMenu = esMenu;
    }
    
    
    
}
