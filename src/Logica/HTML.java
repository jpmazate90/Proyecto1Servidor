package Logica;

import Analizadores.sym2;
import Objetos.AgregarComponente;
import Objetos.Componente;
import Objetos.ComponenteImagen;
import Objetos.ComponenteMenu;
import Objetos.ComponenteParrafo;
import Objetos.ComponenteTitulo;
import Objetos.ComponenteVideo;
import Objetos.NuevaPagina;
import Objetos.NuevoSitioWeb;
import Objetos.Pagina;
import Objetos.Sitio;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jcsr
 */
public class HTML {
    // atributos privados de la clase
    private final String DIRECCION_APACHE = "/var/www/html";
    private final String DIRECCION_LOCALHOST = "../";

    private static final String INICIO_HTML = "<html>";
    private static final String FIN_HTML = "</html>";
    private static final String INICIO_BODY = "<body>";
    private static final String FIN_BODY = "</body>";
    private static final String INICIO_P = "<p>";
    private static final String FIN_P = "</p>";

    private static final String INICIO_COMPONENTE = "<COMPONENTE>";
    private static final String FIN_COMPONENTE = "</COMPONENTE>";
    private static final String INICIO_ID = "<ID>";
    private static final String FIN_ID = "</ID>";
    private static final String INICIO_PAGINA = "<PAGINA>";
    private static final String FIN_PAGINA = "</PAGINA>";
    private static final String INICIO_CLASE = "<CLASE>";
    private static final String FIN_CLASE = "</CLASE>";
    private static final String INICIO_PAGINA_WEB = "<PAGINA_WEB>";
    private static final String FIN_PAGINA_WEB = "</PAGINA_WEB>";
    private static final String INICIO_LINK = "<LINK>";
    private static final String FIN_LINK = "</LINK>";
    private static final String INICIO_SITIO_WEB = "<SITIO_WEB>";
    private static final String FIN_SITIO_WEB = "</SITIO_WEB>";
    private static final String INICIO_PADRE = "<PADRE>";
    private static final String FIN_PADRE = "</PADRE>";
    private static final String INICIO_USUARIO_CREACION = "<USUARIO_CREACION>";
    private static final String FIN_USUARIO_CREACION = "</USUARIO_CREACION>";
    private static final String INICIO_USUARIO_MODIFICACION = "<USUARIO_MODIFICACION>";
    private static final String FIN_USUARIO_MODIFICACION = "</USUARIO_MODIFICACION>";
    private static final String INICIO_FECHA_CREACION = "<FECHA_CREACION>";
    private static final String FIN_FECHA_CREACION = "</FECHA_CREACION>";
    private static final String INICIO_FECHA_MODIFICACION = "<FECHA_MODIFICACION>";
    private static final String FIN_FECHA_MODIFICACION = "</FECHA_MODIFICACION>";
    private static final String INICIO_ETIQUETAS = "<ETIQUETAS>";
    private static final String FIN_ETIQUETAS = "</ETIQUETAS>";
    private static final String INICIO_ETIQUETA = "<ETIQUETA>";
    private static final String FIN_ETIQUETA = "</ETIQUETA>";
    private static final String INICIO_SITIO = "<SITIO>";
    private static final String FIN_SITIO = "</SITIO>";

    private static final String INICIO_TITULO_PAGINA = "<TITULO_PAGINA>";
    private static final String FIN_TITULO_PAGINA = "</TITULO_PAGINA>";
    private static final String INICIO_TEXTO = "<TEXTO>";
    private static final String FIN_TEXTO = "</TEXTO>";
    private static final String INICIO_ALINEACION = "<ALINEACION>";
    private static final String FIN_ALINEACION = "</ALINEACION>";
    private static final String INICIO_COLOR = "<COLOR>";
    private static final String FIN_COLOR = "</COLOR>";
    private static final String INICIO_ORIGEN = "<ORIGEN>";
    private static final String FIN_ORIGEN = "</ORIGEN>";
    private static final String INICIO_ALTURA = "<ALTURA>";
    private static final  String FIN_ALTURA = "</ALTURA>";
    private static final String INICIO_ANCHO = "<ANCHO>";
    private static final String FIN_ANCHO = "</ANCHO>";

    private static final String INICIO_DIV = "<div";
    private static final String FIN_DIV = "</div>";
    private static final String INICIO_IMG = "<img ";

    private static final String CORCHETE_CERRADO = ">";
    private static final String SRC = "src=";
    private static final String WIDTH = "width=";
    private static final String HEIGHT = "height=";
    private static final String ALIGN = "align=";
    private static final String RIGHT = "right";
    private static final String LEFT = "left";
    private static final String CENTER = "center";
    private static final String JUSTIFY = "justify";

    private static final String INICIO_P_SIN = "<p ";
    private static final String STYLE = "style=\"color:";

    private static final String INICIO_H1 = "<h1 ";
    private static final String FIN_H1 = "</h1>";

    private static final String INICIO_VIDEO = "<video ";
    private static final String CONTROLS = "controls";
    private static final String FIN_VIDEO = "</video>";

    private static final String INICIO_A = "<a ";
    private static final String FIN_A = "</a>";

    private static final String HREF = "href=";
    private static final String BR = "<br>";
    private static final String INICIO_TITLE = "<title>";
    private static final String FIN_TITLE = "</title>";
    
    public Mensajes msg = new Mensajes();
// metodo que genera el index de un sitio web 
    public void crearIndexSitio(NuevoSitioWeb nuevoSitioWeb, String pathSitio, String pathIndex) {

        try {
            File archivoSitio = new File(pathSitio);
            archivoSitio.mkdir();
            File archivoIndex = new File(pathIndex);
            FileWriter writer;
            writer = new FileWriter(archivoIndex);
            BufferedWriter escritor = new BufferedWriter(writer);

            escritor.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
// crea una pagina web 
    public void crearPaginaWeb(NuevaPagina nuevaPagina, String pathPagina) {
        try {// crea el nuevo archivo 
            File archivoPagina = new File(pathPagina);
            archivoPagina.createNewFile();
            FileWriter writer;
            writer = new FileWriter(archivoPagina);
            BufferedWriter escritor = new BufferedWriter(writer);
            if (nuevaPagina.getTitulo() != null) {
                escritor.write(INICIO_HTML);// y si tiene titulo le genera el titulo de una vez
                escritor.write(INICIO_TITLE);
                escritor.write(nuevaPagina.getTitulo());
                escritor.write(FIN_TITLE);
                escritor.write(FIN_HTML);
            }
            escritor.flush();
            escritor.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // crea un titulo en base al path y el titulo
    public void crearTitulo(String path,String titulo){
        try {
            File archivoPagina = new File(path);
            archivoPagina.createNewFile();
            FileWriter writer;
            writer = new FileWriter(archivoPagina);
            BufferedWriter escritor = new BufferedWriter(writer);
            
                escritor.write(INICIO_HTML);
                escritor.write(INICIO_TITLE);
                escritor.write(titulo);
                escritor.write(FIN_TITLE);
                escritor.write(FIN_HTML);
            
            escritor.flush();
            escritor.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
// crea el componente en el archivo en base a la info
    public void crearComponente(AgregarComponente agregar, String pagina) {
        try {
            File archivo = new File(pagina);
            FileWriter writer;
            writer = new FileWriter(archivo, true);
            BufferedWriter escritor = new BufferedWriter(writer);
            // si es una imagen genera la info de imagen 
            if (agregar.isEsImagen()) {

                ComponenteImagen imagen = agregar.getCompImagen();
                escritor.write(INICIO_HTML);
                escritor.write(INICIO_BODY);
// si tiene alineacion 
                if (imagen.getAlineacion() != null) {
                    escritor.write(INICIO_DIV);
                    escritor.write(" " + ALIGN);
                    if (imagen.getAlineacion().equals("DERECHA")) {
                        escritor.write(" \"" + RIGHT + "\" ");
                    } else if (imagen.getAlineacion().equals("IZQUIERDA")) {
                        escritor.write(" \"" + LEFT + "\" ");
                    } else if (imagen.getAlineacion().equals("CENTRAR")) {
                        escritor.write(" \"" + CENTER + "\" ");
                    } else {
                        escritor.write(" \"" + JUSTIFY + "\" ");
                    }
                    escritor.write(CORCHETE_CERRADO + "\n");
                }

                escritor.write(INICIO_IMG);
                escritor.write(SRC);
                escritor.write("\"" + imagen.getOrigen() + "\" ");
                escritor.write(WIDTH + "\"" + imagen.getAncho() + "\" ");
                escritor.write(HEIGHT + "\"" + imagen.getAltura() + "\" ");
                escritor.write(CORCHETE_CERRADO);
                if (imagen.getAlineacion() != null) {
                    escritor.write(FIN_DIV);
                }

                escritor.write(FIN_BODY);
                escritor.write(FIN_HTML);
                escritor.flush();
                escritor.close();
                System.out.println("Se creo el componente imagen ");
// si es un menu genera el objeto de menu
            } else if (agregar.isEsMenu()) {
                Acciones acciones = new Acciones();
                ComponenteMenu menu = agregar.getCompMenu();
                ArrayList<Pagina> paginasHijas;
                ArrayList<Pagina> paginasEtiquetas;
                ArrayList<Pagina> paginasResultantes;
                escritor.write(INICIO_HTML);
                escritor.write(INICIO_BODY);
                escritor.write(BR);
// si tiene filtros los hace aqui
                if (menu.getPadre() != null && menu.getEtiquetas() != null && menu.getEtiquetas().size() > 0) {
                    paginasHijas = acciones.paginasHijas(menu.getPadre());
                    paginasEtiquetas = acciones.paginasEtiqueta(menu.getEtiquetas());
                    paginasResultantes = acciones.paginasFiltradasPorAmbos(paginasEtiquetas, menu.getPadre());
                    for (int i = 0; i < paginasResultantes.size(); i++) {
                        String id = paginasResultantes.get(i).getId();
                        if (paginasResultantes.get(i).getId().startsWith("_index")) {
                            id = "index";
                        }
                        String path = DIRECCION_LOCALHOST  + paginasResultantes.get(i).getSitio() + "/" + id + ".html";
                        escritor.write(INICIO_A);
                        escritor.write(" " + HREF);
                        escritor.write("\"" + path + "\"");
                        escritor.write(CORCHETE_CERRADO);
                        escritor.write(path);
                        escritor.write(FIN_A);
                        escritor.write(BR);

                    }

                } else if (menu.getEtiquetas() != null && menu.getEtiquetas().size() > 0) {
                    paginasEtiquetas = acciones.paginasEtiqueta(menu.getEtiquetas());
                    for (int i = 0; i < paginasEtiquetas.size(); i++) {
                        String id = paginasEtiquetas.get(i).getId();
                        if (paginasEtiquetas.get(i).getId().startsWith("_index")) {
                            id = "index";
                        }
                        String path = DIRECCION_LOCALHOST+ paginasEtiquetas.get(i).getSitio() + "/" + id + ".html";
                        escritor.write(INICIO_A);
                        escritor.write(" " + HREF);
                        escritor.write("\"" + path + "\"");
                        escritor.write(CORCHETE_CERRADO);
                        escritor.write(path);
                        escritor.write(FIN_A);
                        escritor.write(BR);

                    }
                } else if (menu.getPadre() != null) {
                    paginasHijas = acciones.paginasHijas(menu.getPadre());
                    for (int i = 0; i < paginasHijas.size(); i++) {
                        String id = paginasHijas.get(i).getId();
                        if (paginasHijas.get(i).getId().startsWith("_index")) {
                            id = "index";
                        }
                        String path = DIRECCION_LOCALHOST + paginasHijas.get(i).getSitio() + "/" + id + ".html";
                        escritor.write(INICIO_A);
                        escritor.write(" " + HREF);
                        escritor.write("\"" + path + "\"");
                        escritor.write(CORCHETE_CERRADO);
                        escritor.write(path);
                        escritor.write(FIN_A);
                        escritor.write(BR);

                    }
                }

                escritor.write(FIN_BODY);
                escritor.write(FIN_HTML);
                escritor.flush();
                escritor.close();
                System.out.println("Se creo el componente menu ");
// si es un parrafo genera la info de parrafo
            } else if (agregar.isEsParrafo()) {
                ComponenteParrafo parrafo = agregar.getCompParrafo();
                escritor.write(INICIO_HTML);
                escritor.write(INICIO_BODY);

                if (parrafo.getAlineacion() != null && parrafo.getColor() != null) {
                    escritor.write(INICIO_P_SIN);
                    escritor.write(" " + ALIGN);
                    if (parrafo.getAlineacion().equals("DERECHA")) {
                        escritor.write(" \"" + RIGHT + "\" ");
                    } else if (parrafo.getAlineacion().equals("IZQUIERDA")) {
                        escritor.write(" \"" + LEFT + "\" ");
                    } else if (parrafo.getAlineacion().equals("CENTRAR")) {
                        escritor.write(" \"" + CENTER + "\" ");
                    } else {
                        escritor.write(" \"" + JUSTIFY + "\" ");
                    }
                    escritor.write(STYLE + parrafo.getColor() + "\";");
                    escritor.write(CORCHETE_CERRADO);
                    escritor.write(parrafo.getTexto());
                    escritor.write(FIN_P);
                } else if (parrafo.getAlineacion() != null) {
                    escritor.write(INICIO_P_SIN);
                    escritor.write(" " + ALIGN);
                    if (parrafo.getAlineacion().equals("DERECHA")) {
                        escritor.write(" \"" + RIGHT + "\" ");
                    } else if (parrafo.getAlineacion().equals("IZQUIERDA")) {
                        escritor.write(" \"" + LEFT + "\" ");
                    } else if (parrafo.getAlineacion().equals("CENTRAR")) {
                        escritor.write(" \"" + CENTER + "\" ");
                    } else {
                        escritor.write(" \"" + JUSTIFY + "\" ");
                    }
                    escritor.write(CORCHETE_CERRADO);
                    escritor.write(parrafo.getTexto());
                    escritor.write(FIN_P);
                } else if (parrafo.getColor() != null) {
                    escritor.write(INICIO_P_SIN);
                    escritor.write(" " + STYLE + parrafo.getColor() + "\";");
                    escritor.write(CORCHETE_CERRADO);
                    escritor.write(parrafo.getTexto());
                    escritor.write(FIN_P);
                } else {
                    escritor.write(INICIO_P);
                    escritor.write(parrafo.getTexto());
                    escritor.write(FIN_P);
                }
                escritor.write(FIN_BODY);
                escritor.write(FIN_HTML);
                escritor.flush();
                escritor.close();
                System.out.println("Se creo el componente PARRAFO ");
// si es un titulo genera la info de titulo
            } else if (agregar.isEsTitulo()) {
                ComponenteTitulo titulo = agregar.getCompTitulo();
                escritor.write(INICIO_HTML);
                escritor.write(INICIO_BODY);

                if (titulo.getAlineacion() != null) {
                    escritor.write(INICIO_H1);
                    escritor.write(" " + ALIGN);
                    if (titulo.getAlineacion().equals("DERECHA")) {
                        escritor.write(" \"" + RIGHT + "\" ");
                    } else if (titulo.getAlineacion().equals("IZQUIERDA")) {
                        escritor.write(" \"" + LEFT + "\" ");
                    } else if (titulo.getAlineacion().equals("CENTRAR")) {
                        escritor.write(" \"" + CENTER + "\" ");
                    } else {
                        escritor.write(" \"" + JUSTIFY + "\" ");
                    }
                    escritor.write(CORCHETE_CERRADO + "\n");
                    escritor.write(titulo.getTexto());
                    escritor.write(FIN_H1);
                } else {
                    escritor.write(INICIO_H1 + CORCHETE_CERRADO);
                    escritor.write(titulo.getTexto());
                    escritor.write(FIN_H1);
                }

                escritor.write(FIN_BODY);
                escritor.write(FIN_HTML);
                escritor.flush();
                escritor.close();
                System.out.println("Se creo el componente titulo");
// genera la info de video 
            } else if (agregar.isEsVideo()) {

                ComponenteVideo video = agregar.getCompVideo();
                escritor.write(INICIO_HTML);
                escritor.write(INICIO_BODY);

                escritor.write(INICIO_VIDEO);
                escritor.write(SRC);
                escritor.write("\"" + video.getOrigen() + "\" ");
                escritor.write(WIDTH + "\"" + video.getAncho() + "\" ");
                escritor.write(HEIGHT + "\"" + video.getAltura() + "\" ");
                escritor.write(" " + CONTROLS);
                escritor.write(CORCHETE_CERRADO);
                escritor.write(FIN_VIDEO);

                escritor.write(FIN_BODY);
                escritor.write(FIN_HTML);
                escritor.flush();
                escritor.close();
                System.out.println("Se creo el componente VIDEO");

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    // sirve para borrar una pagina
    public void borrarPagina(String path){
        try{
        File archivo = new File(path);
        archivo.delete();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
// borra un folder que tiene hijos de forma recursiva 
    public void borrarSitio(File directorio) {
        File[] ficheros = directorio.listFiles();
        for (int x = 0; x < ficheros.length; x++) {
            if (ficheros[x].isDirectory()) {
                borrarSitio(ficheros[x]);
            }
            ficheros[x].delete();
        }
        
    }
// guarda en la base de datos toda la informacion
    public void guardarBaseDatos(ArrayList<Sitio> sitios, ArrayList<Pagina> paginas, ArrayList<Componente> componentes) {
        try {
// abre el archivo y empieza a sobreescribir
            File baseDatos = new File("baseDatos.txt");
            FileWriter writer;
            writer = new FileWriter(baseDatos, false);
            BufferedWriter escritor = new BufferedWriter(writer);
// primero los sitios
            for (int i = 0; i < sitios.size(); i++) {
                escritor.write(INICIO_SITIO + "\n");

                escritor.write(INICIO_ID);
                escritor.write(sitios.get(i).getId());
                escritor.write(FIN_ID + "\n");

                escritor.write(INICIO_USUARIO_CREACION);
                escritor.write(sitios.get(i).getUsuarioCreacion());
                escritor.write(FIN_USUARIO_CREACION + "\n");

                escritor.write(INICIO_FECHA_CREACION);
                escritor.write(sitios.get(i).getFechaCreacion());
                escritor.write(FIN_FECHA_CREACION + "\n");

                escritor.write(INICIO_FECHA_MODIFICACION);
                escritor.write(sitios.get(i).getFechaModificacion());
                escritor.write(FIN_FECHA_MODIFICACION + "\n");

                escritor.write(INICIO_USUARIO_MODIFICACION);
                escritor.write(sitios.get(i).getUsuarioModificacion());
                escritor.write(FIN_USUARIO_MODIFICACION + "\n");

                escritor.write(FIN_SITIO + "\n" + "\n");

            }
// luego las paginas
            for (int i = 0; i < paginas.size(); i++) {
                escritor.write(INICIO_PAGINA + "\n");

                escritor.write(INICIO_ID);
                escritor.write(paginas.get(i).getId());
                escritor.write(FIN_ID + "\n");

                escritor.write(INICIO_LINK);
                escritor.write(paginas.get(i).getLink());
                escritor.write(FIN_LINK + "\n");

                escritor.write(INICIO_SITIO_WEB);
                escritor.write(paginas.get(i).getSitio());
                escritor.write(FIN_SITIO_WEB + "\n");

                if (paginas.get(i).getPadre() == null) {
                    escritor.write(INICIO_PADRE);
                    escritor.write("null");
                    escritor.write(FIN_PADRE + "\n");
                } else {
                    escritor.write(INICIO_PADRE);
                    escritor.write(paginas.get(i).getPadre());
                    escritor.write(FIN_PADRE + "\n");
                }

                escritor.write(INICIO_USUARIO_CREACION);
                escritor.write(paginas.get(i).getUsuarioCreacion());
                escritor.write(FIN_USUARIO_CREACION + "\n");

                escritor.write(INICIO_FECHA_CREACION);
                escritor.write(paginas.get(i).getFechaCreacion());
                escritor.write(FIN_FECHA_CREACION + "\n");

                escritor.write(INICIO_FECHA_MODIFICACION);
                escritor.write(paginas.get(i).getFechaModificacion());
                escritor.write(FIN_FECHA_MODIFICACION + "\n");

                escritor.write(INICIO_USUARIO_MODIFICACION);
                escritor.write(paginas.get(i).getUsuarioModificacion());
                escritor.write(FIN_USUARIO_MODIFICACION + "\n");

                escritor.write(INICIO_ETIQUETAS + "\n");

                for (int j = 0; j < paginas.get(i).getEtiquetas().size(); j++) {
                    escritor.write(INICIO_ETIQUETA);
                    escritor.write(paginas.get(i).getEtiquetas().get(j));
                    escritor.write(FIN_ETIQUETA + "\n");
                }

                escritor.write(FIN_ETIQUETAS + "\n");

                escritor.write(INICIO_TITULO_PAGINA);
                if (paginas.get(i).getTitulo() == null) {
                    escritor.write("null");
                } else {
                    escritor.write(paginas.get(i).getTitulo());
                }
                escritor.write(FIN_TITULO_PAGINA + "\n");

                escritor.write(FIN_PAGINA + "\n" + "\n");

            }
// y por ultimo los componentes
            for (int i = 0; i < componentes.size(); i++) {
                escritor.write(INICIO_COMPONENTE + "\n");

                escritor.write(INICIO_ID);
                escritor.write(componentes.get(i).getId());
                escritor.write(FIN_ID + "\n");

                escritor.write(INICIO_PAGINA_WEB);
                escritor.write(componentes.get(i).getPagina());
                escritor.write(FIN_PAGINA_WEB + "\n");

                escritor.write(INICIO_CLASE);
                escritor.write(componentes.get(i).getClase());
                escritor.write(FIN_CLASE + "\n");

                escritor.write(INICIO_TEXTO);
                if (componentes.get(i).getTexto() == null) {
                    escritor.write("null");
                } else {
                    escritor.write(componentes.get(i).getTexto());
                }
                escritor.write(FIN_TEXTO + "\n");

                escritor.write(INICIO_ALINEACION);
                if (componentes.get(i).getAlineacion() == null) {
                    escritor.write("null");
                } else {
                    escritor.write(componentes.get(i).getAlineacion());
                }
                escritor.write(FIN_ALINEACION + "\n");

                escritor.write(INICIO_COLOR);
                if (componentes.get(i).getColor() == null) {
                    escritor.write("null");
                } else {
                    escritor.write(componentes.get(i).getColor());
                }
                escritor.write(FIN_COLOR + "\n");

                escritor.write(INICIO_ORIGEN);
                if (componentes.get(i).getOrigen() == null) {
                    escritor.write("null");
                } else {
                    escritor.write(componentes.get(i).getOrigen());
                }
                escritor.write(FIN_ORIGEN + "\n");

                escritor.write(INICIO_ALTURA);
                if (componentes.get(i).getAltura() == null) {
                    escritor.write("null");
                } else {
                    escritor.write(componentes.get(i).getAltura());
                }
                escritor.write(FIN_ALTURA + "\n");

                escritor.write(INICIO_ANCHO);
                if (componentes.get(i).getAncho() == null) {
                    escritor.write("null");
                } else {
                    escritor.write(componentes.get(i).getAncho());
                }
                escritor.write(FIN_ANCHO + "\n");

                escritor.write(INICIO_PADRE);
                if (componentes.get(i).getPadre() == null) {
                    escritor.write("null");
                } else {
                    escritor.write(componentes.get(i).getPadre());
                }
                escritor.write(FIN_PADRE + "\n");

                escritor.write(INICIO_ETIQUETAS);
                if (componentes.get(i).getEtiquetas() == null || componentes.get(i).getEtiquetas().isEmpty()) {
                    escritor.write("null");
                } else {
                    escritor.write(componentes.get(i).getEtiquetas().get(0));
                    for (int j = 1; j < componentes.get(i).getEtiquetas().size(); j++) {
                        escritor.write("|" + componentes.get(i).getEtiquetas().get(j));
                    }
                }
                escritor.write(FIN_ETIQUETAS + "\n");

                escritor.write(FIN_COMPONENTE + "\n" + "\n");

            }

            escritor.flush();
            escritor.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
