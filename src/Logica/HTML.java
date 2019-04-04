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

    private final String DIRECCION_APACHE = "/var/www/html";

    private static String INICIO_HTML = "<html>";
    private static String FIN_HTML = "</html>";
    private static String INICIO_BODY = "<body>";
    private static String FIN_BODY = "</body>";
    private static String INICIO_P = "<p>";
    private static String FIN_P = "</p>";

    private static String INICIO_COMPONENTE = "<COMPONENTE>";
    private static String FIN_COMPONENTE = "</COMPONENTE>";
    private static String INICIO_ID = "<ID>";
    private static String FIN_ID = "</ID>";
    private static String INICIO_PAGINA = "<PAGINA>";
    private static String FIN_PAGINA = "</PAGINA>";
    private static String INICIO_CLASE = "<CLASE>";
    private static String FIN_CLASE = "</CLASE>";
    private static String INICIO_PAGINA_WEB = "<PAGINA_WEB>";
    private static String FIN_PAGINA_WEB = "</PAGINA_WEB>";
    private static String INICIO_LINK = "<LINK>";
    private static String FIN_LINK = "</LINK>";
    private static String INICIO_SITIO_WEB = "<SITIO_WEB>";
    private static String FIN_SITIO_WEB = "</SITIO_WEB>";
    private static String INICIO_PADRE = "<PADRE>";
    private static String FIN_PADRE = "</PADRE>";
    private static String INICIO_USUARIO_CREACION = "<USUARIO_CREACION>";
    private static String FIN_USUARIO_CREACION = "</USUARIO_CREACION>";
    private static String INICIO_USUARIO_MODIFICACION = "<USUARIO_MODIFICACION>";
    private static String FIN_USUARIO_MODIFICACION = "</USUARIO_MODIFICACION>";
    private static String INICIO_FECHA_CREACION = "<FECHA_CREACION>";
    private static String FIN_FECHA_CREACION = "</FECHA_CREACION>";
    private static String INICIO_FECHA_MODIFICACION = "<FECHA_MODIFICACION>";
    private static String FIN_FECHA_MODIFICACION = "</FECHA_MODIFICACION>";
    private static String INICIO_ETIQUETAS = "<ETIQUETAS>";
    private static String FIN_ETIQUETAS = "</ETIQUETAS>";
    private static String INICIO_ETIQUETA = "<ETIQUETA>";
    private static String FIN_ETIQUETA = "</ETIQUETA>";
    private static String INICIO_SITIO = "<SITIO>";
    private static String FIN_SITIO = "</SITIO>";

    private static String INICIO_TITULO_PAGINA = "<TITULO_PAGINA>";
    private static String FIN_TITULO_PAGINA = "</TITULO_PAGINA>";
    private static String INICIO_TEXTO = "<TEXTO>";
    private static String FIN_TEXTO = "</TEXTO>";
    private static String INICIO_ALINEACION = "<ALINEACION>";
    private static String FIN_ALINEACION = "</ALINEACION>";
    private static String INICIO_COLOR = "<COLOR>";
    private static String FIN_COLOR = "</COLOR>";
    private static String INICIO_ORIGEN = "<ORIGEN>";
    private static String FIN_ORIGEN = "</ORIGEN>";
    private static String INICIO_ALTURA = "<ALTURA>";
    private static String FIN_ALTURA = "</ALTURA>";
    private static String INICIO_ANCHO = "<ANCHO>";
    private static String FIN_ANCHO = "</ANCHO>";

    private static String INICIO_DIV = "<div";
    private static String FIN_DIV = "</div>";
    private static String INICIO_IMG = "<img ";

    private static String CORCHETE_CERRADO = ">";
    private static String SRC = "src=";
    private static String WIDTH = "width=";
    private static String HEIGHT = "height=";
    private static String ALIGN = "align=";
    private static String RIGHT = "right";
    private static String LEFT = "left";
    private static String CENTER = "center";
    private static String JUSTIFY = "justify";

    private static String INICIO_P_SIN = "<p ";
    private static String STYLE = "style=\"color:";

    private static String INICIO_H1 = "<h1 ";
    private static String FIN_H1 = "</h1>";

    private static String INICIO_VIDEO = "<video ";
    private static String CONTROLS = "controls";
    private static String FIN_VIDEO = "</video>";

    private static String INICIO_A = "<a ";
    private static String FIN_A = "</a>";

    private static String HREF = "href=";
    private static String BR = "<br>";
    private static String INICIO_TITLE = "<title>";
    private static String FIN_TITLE = "</title>";
    
    public Mensajes msg = new Mensajes();

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

    public void crearPaginaWeb(NuevaPagina nuevaPagina, String pathPagina) {
        try {
            File archivoPagina = new File(pathPagina);
            archivoPagina.createNewFile();
            FileWriter writer;
            writer = new FileWriter(archivoPagina);
            BufferedWriter escritor = new BufferedWriter(writer);
            if (nuevaPagina.getTitulo() != null) {
                escritor.write(INICIO_HTML);
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

    public void crearComponente(AgregarComponente agregar, String pagina) {
        try {
            File archivo = new File(pagina);
            FileWriter writer;
            writer = new FileWriter(archivo, true);
            BufferedWriter escritor = new BufferedWriter(writer);

            if (agregar.isEsImagen()) {

                ComponenteImagen imagen = agregar.getCompImagen();
                escritor.write(INICIO_HTML);
                escritor.write(INICIO_BODY);

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

            } else if (agregar.isEsMenu()) {
                Acciones acciones = new Acciones();
                ComponenteMenu menu = agregar.getCompMenu();
                ArrayList<Pagina> paginasHijas;
                ArrayList<Pagina> paginasEtiquetas;
                ArrayList<Pagina> paginasResultantes;
                escritor.write(INICIO_HTML);
                escritor.write(INICIO_BODY);
                escritor.write(BR);

                if (menu.getPadre() != null && menu.getEtiquetas() != null && menu.getEtiquetas().size() > 0) {
                    paginasHijas = acciones.paginasHijas(menu.getPadre());
                    paginasEtiquetas = acciones.paginasEtiqueta(menu.getEtiquetas());
                    paginasResultantes = acciones.paginasFiltradasPorAmbos(paginasEtiquetas, menu.getPadre());
                    for (int i = 0; i < paginasResultantes.size(); i++) {
                        String id = paginasResultantes.get(i).getId();
                        if (paginasResultantes.get(i).getId().startsWith("_index")) {
                            id = "index";
                        }
                        String path = DIRECCION_APACHE + "/" + paginasResultantes.get(i).getSitio() + "/" + id + ".html";
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
                        String path = DIRECCION_APACHE + "/" + paginasEtiquetas.get(i).getSitio() + "/" + id + ".html";
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
                        String path = DIRECCION_APACHE + "/" + paginasHijas.get(i).getSitio() + "/" + id + ".html";
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
    
    public void borrarPagina(String path){
        try{
        File archivo = new File(path);
        archivo.delete();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void borrarSitio(File directorio) {
        File[] ficheros = directorio.listFiles();
        for (int x = 0; x < ficheros.length; x++) {
            if (ficheros[x].isDirectory()) {
                borrarSitio(ficheros[x]);
            }
            ficheros[x].delete();
        }
        
    }

    public void guardarBaseDatos(ArrayList<Sitio> sitios, ArrayList<Pagina> paginas, ArrayList<Componente> componentes) {
        try {

            File baseDatos = new File("baseDatos.txt");
            FileWriter writer;
            writer = new FileWriter(baseDatos, false);
            BufferedWriter escritor = new BufferedWriter(writer);

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
