/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Objetos.AgregarComponente;
import Objetos.BorrarComponente;
import Objetos.BorrarPagina;
import Objetos.BorrarSitioWeb;
import Objetos.Componente;
import Objetos.ComponenteImagen;
import Objetos.ComponenteMenu;
import Objetos.ComponenteParrafo;
import Objetos.ComponenteTitulo;
import Objetos.ComponenteVideo;
import Objetos.Mandar;
import Objetos.ModificarComponente;
import Objetos.ModificarPagina;
import Objetos.NuevaPagina;
import Objetos.NuevoSitioWeb;
import Objetos.Pagina;
import Objetos.Sitio;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import sun.font.CreatedFontTracker;

/**
 *
 * @author jcsr
 */
public class Acciones {
    // atributos de la clase privados
    private static ArrayList<Sitio> sitios = new ArrayList<>();
    private static ArrayList<Pagina> paginas = new ArrayList<>();
    private static ArrayList<Componente> componentes = new ArrayList<>();
    private final String direccionApache = "/var/www/html";
    private final String DIRECCION_LOCALHOST = "../";
    private HTML html;
    private SimpleDateFormat formato;
    private Mensajes msg = new Mensajes();
    //constructor de la clase
    public Acciones() {
        html = new HTML();
        formato = new SimpleDateFormat("yyyy-MM-dd");

    }
// accion de nuevo sitio web
    public void accionNuevoSitioWeb(NuevoSitioWeb nuevoSitioWeb, String usuario) {
        System.out.println("Accion nuevoSitioWeb, id:" + nuevoSitioWeb.getId());
        ArrayList<String> etiquetas = new ArrayList<>();
        boolean existeId = existeIdSitio(nuevoSitioWeb.getId());
        if (existeId == false) {// verifica si existe el id
            String direccionSitio = direccionApache + "/" + nuevoSitioWeb.getId();
            String indexSitio = direccionSitio + "/index.html";
            html.crearIndexSitio(nuevoSitioWeb, direccionSitio, indexSitio);// crea el index del sitio
            String id = "_index" + nuevoSitioWeb.getId();// genera el path del index
            Pagina pagina = new Pagina(id, id, nuevoSitioWeb.getId(), null, usuario, formato.format(nuevoSitioWeb.getFechaCreacion()), formato.format(nuevoSitioWeb.getFechaModificacion()), usuario, etiquetas, null);
            Sitio sitio = new Sitio(nuevoSitioWeb.getId(), nuevoSitioWeb.getUsuarioCreacion(), formato.format(nuevoSitioWeb.getFechaCreacion()), formato.format(nuevoSitioWeb.getFechaModificacion()), nuevoSitioWeb.getUsuarioModificacion());
            sitios.add(sitio);// y genera la pagina del index y guarda los datos en la base de datos del servidor
            paginas.add(pagina);
            guardarBaseDatos();
            msg.mandarMensaje("SE CREO CORRECTAMENTE EL NUEVO SITIO WEB CON ID:" + nuevoSitioWeb.getId());
        } else {
            //mandar a la aplicacion cliente en XML
            msg.mandarError("ERROR SEMANTICO: NUEVO SITIO WEB,YA EXISTE EL ID PARA EL SITIO:" + nuevoSitioWeb.getId());

        }
    }
// guarda en la base de datos
    public void guardarBaseDatos() {
        html.guardarBaseDatos(sitios, paginas, componentes);

    }
    // verifica si existe el id de un sitio
    public boolean existeIdSitio(String id) {
        for (int i = 0; i < sitios.size(); i++) {
            if (sitios.get(i).getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
// verifica si existe el id de una pagina
    public boolean existeIdPagina(String id) {
        for (int i = 0; i < paginas.size(); i++) {
            if (paginas.get(i).getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
// retorna una pagina por medio del id
    public Pagina paginaPorId(String id) {
        for (int i = 0; i < paginas.size(); i++) {
            if (paginas.get(i).getId().equals(id)) {
                return paginas.get(i);
            }
        }
        return null;
    }
// verifica si existe un componente por medio del id 
    public boolean existeIdComponente(String id) {
        for (int i = 0; i < componentes.size(); i++) {
            if (componentes.get(i).getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
// accion de borrar sitio web
    public void accionBorrarSitioWeb(BorrarSitioWeb borrarSitioWeb) {
        System.out.println("Accion borrarSitioWeb, id:" + borrarSitioWeb.getId());
        ArrayList<Sitio> sits = Acciones.sitios;
        ArrayList<Pagina> pags = Acciones.paginas;
        String idSitio = borrarSitioWeb.getId();
        BorrarPagina borrarPagina;
// verifica si existe el sitio
        boolean existeSitio = existeIdSitio(idSitio);
        if (existeSitio == true) {
            for (int i = 0; i < sits.size(); i++) {// si existe busca el sitio en la base de datos y lo remueve
                if (sits.get(i).getId().equals(borrarSitioWeb.getId())) {
                    idSitio = sits.get(i).getId();
                    sits.remove(i);
                    i--;
                    break;
                }
            }
// luego tiene que buscar las paginas que pertenecian a ese sitio
            for (int i = 0; i < pags.size(); i++) {
                if (pags.get(i).getSitio().equals(idSitio)) {
                    borrarPagina = new BorrarPagina(pags.get(i).getId());
                    accionBorrarPagina(borrarPagina, true);
                    i--;
                }

            }// crea el path del sitio 
            String pathSitio = direccionApache + "/" + idSitio;
            File directorio = new File(pathSitio);
            if (directorio.isDirectory()) {
                html.borrarSitio(directorio);
                directorio.delete();
            } else {// si no es un directorio lo muestra en pantalla
                System.out.println("no es un directorio");
            }// manda que se borro el sitio
            msg.mandarMensaje("SE BORRO CORRECTAMENTE EL SITIO WEB CON ID:" + borrarSitioWeb.getId());

        } else {// si hay un error lo muestra
            msg.mandarError("ERROR SEMANTICO: BORRAR SITIO WEB, NO EXISTE EL ID PARA EL SITIO:" + borrarSitioWeb.getId());
        }

    }

    public void accionNuevaPagina(NuevaPagina nuevaPagina) {
        System.out.println("Accion nuevaPagina, id:" + nuevaPagina.getId());
        boolean existePagina = existeIdPagina(nuevaPagina.getId());
        boolean padre = true;// verifica si no existe id de la pagina
        if (existePagina == false) {
            boolean existeSitio = existeIdSitio(nuevaPagina.getSitio());
            if (existeSitio == true) {// luego si existe el sitio
                if (nuevaPagina.getPadre() != null) {
                    padre = existeIdPagina(nuevaPagina.getPadre());
                    if (padre == true) {// si tiene padre obtiene su objeto y compara que esten en el mismo sitio
                        Pagina pagPadre = paginaPorId(nuevaPagina.getPadre());
                        if (!pagPadre.getSitio().equals(nuevaPagina.getSitio())) {
                            padre = false;
                            msg.mandarError("ERROR SEMANTICO: NUEVA PAGINA, NO ESTAN EN EL MISMO SITIO WEB LA PAGINA:" + nuevaPagina.getId() + ", SU SITIO ES:" + nuevaPagina.getSitio() + ", Y EL PADRE: " + nuevaPagina.getPadre() + ", SU SITIO ES:" + pagPadre.getSitio() + ". POR LO CUAL NO SE PUEDE CREAR LA PAGINA");
                        }
                    }
                }
                if (padre == true) {
                    Pagina paginaNueva;// si todo funciona crea el path 
                    String pathPagina = direccionApache + "/" + nuevaPagina.getSitio() + "/" + nuevaPagina.getId() + ".html";
                    html.crearPaginaWeb(nuevaPagina, pathPagina);
                    paginaNueva = new Pagina(nuevaPagina.getId(), nuevaPagina.getLink(), nuevaPagina.getSitio(), nuevaPagina.getPadre(), nuevaPagina.getUsuarioCreacion(), formato.format(nuevaPagina.getFechaCreacion()), formato.format(nuevaPagina.getFechaModificacion()), nuevaPagina.getUsuarioModificacion(), nuevaPagina.getEtiquetas(), nuevaPagina.getTitulo());
                    paginas.add(paginaNueva);
                    guardarBaseDatos();// dice que si funciono la nueva pagina
                    msg.mandarMensaje("SE CREO CORRECTAMENTE LA NUEVA PAGINA CON ID:" + nuevaPagina.getId());
                } else {// sino muestra el error
                    msg.mandarError("ERROR SEMANTICO: NUEVA PAGINA, NO EXISTE UNA PAGINA CON ID:" + nuevaPagina.getPadre() + " PARA SER PADRE DENTRO DEL MISMO SITIO");
                }

            } else {// sino muestra el error
                msg.mandarError("ERROR SEMANTICO: NUEVA PAGINA, NO EXISTE NINGUN SITIO CON EL ID:" + nuevaPagina.getSitio());
            }
        } else {// sino muestra el error
            msg.mandarError("ERROR SEMANTICO: NUEVA PAGINA,YA EXISTE LA PAGINA CON ID:" + nuevaPagina.getId());
        }

    }
// accion de borrar pagina
    public void accionBorrarPagina(BorrarPagina borrarPagina, boolean borrarIndex) {

        System.out.println("Accion borrarPagina, id:" + borrarPagina.getId());
        ArrayList<Pagina> pags = Acciones.paginas;
        ArrayList<Componente> comps = Acciones.componentes;
        String id = borrarPagina.getId();
        boolean existePag = existeIdPagina(borrarPagina.getId());
        if (existePag == true) {// mira si existe la pagina
            Pagina pagina = paginaPorId(borrarPagina.getId());
            if (borrarPagina.getId().startsWith("_index") && borrarPagina.getId().endsWith(pagina.getSitio()) && borrarIndex == false) {
                msg.mandarError("ERROR SEMANTICO: BORRAR PAGINA ,NO SE PUEDE BORRAR EL INDEX DEL SITIO:" + pagina.getSitio());
            } else {// busca la pagina en todas las paginas y la remueve
                for (int i = 0; i < pags.size(); i++) {
                    if (pags.get(i).getId().equals(borrarPagina.getId())) {
                        pags.remove(i);
                        i--;
                        break;
                    }
                }// busca los componentes de esa pagina y los borra
                for (int i = 0; i < comps.size(); i++) {
                    if (comps.get(i).getPagina().equals(id)) {
                        comps.remove(i);
                        i--;
                    }

                }

                for (int i = 0; i < pags.size(); i++) {// luego busca si hay carpetas hijas y hace recursiva la funcion
                    if (pags.get(i).getPadre() != null && pags.get(i).getPadre().equals(id)) {
                        BorrarPagina paginaHija = new BorrarPagina(pags.get(i).getId());
                        accionBorrarPagina(paginaHija, borrarIndex);
                        i=0;
                    }

                }// por ultimo crea el path del archivo que se va a eliminar
                String path = direccionApache + "/" + pagina.getSitio() + "/" + id + ".html";
                html.borrarPagina(path);
                guardarBaseDatos();// guarda en la base de datos y dice que funciono el borrar la pagina
                msg.mandarMensaje("SE BORRO CORRECTAMENTE LA PAGINA CON ID:" + borrarPagina.getId());
            }
        } else {//muestra el error
            msg.mandarError("ERROR SEMANTICO: BORRAR PAGINA , NO EXISTE PAGINA CON ID:" + borrarPagina.getId() + " PARA BORRAR");
        }
    }
    
    
// accion de modificar pagina 
    public void accionModificarPagina(ModificarPagina modificarPagina) {
        System.out.println("Accion modificarPagina, id:" + modificarPagina.getId());

        String idPag = modificarPagina.getId();
        boolean existePag = existeIdPagina(idPag);
        if (existePag == true) {// verifica que esta la pagina
            Pagina pagina = paginaPorId(idPag);
            pagina.setFechaModificacion(formato.format(modificarPagina.getDatefechaModificacion()));
            pagina.setUsuarioModificacion(modificarPagina.getUsuarioModificacion());
            if (modificarPagina.getTitulo() != null) {// si tiene titulo la modificacion lo agrega al index
                String id = pagina.getId();
                if (pagina.getId().startsWith("_index")) {
                    id = "index";
                }// genera el link
                String link = direccionApache + "/" + pagina.getSitio() + "/" + id + ".html";
                limpiarPagina(link);// y crea el titulo
                html.crearTitulo(link, modificarPagina.getTitulo());
                ingresarComponentes(idPag, link);

            }// si tiene etiquetas las cambia a la pagina que se utilizo
            if (modificarPagina.getEtiquetas() != null && modificarPagina.getEtiquetas().size() > 0) {
                pagina.setEtiquetas(modificarPagina.getEtiquetas());

            }
            guardarBaseDatos();// guarda en la base de datos
            msg.mandarMensaje("SE MODIFICO CORRECTAMENTE LA PAGINA CON ID:" + modificarPagina.getId());

        } else {//muestra el error
            msg.mandarError("ERROR SEMANTICO: MODIFICAR PAGINA, NO EXISTE LA PAGINA A MODIFICAR CON ID:" + idPag);
        }
    }
// acccion de agregar componente
    public void accionAgregarComponente(AgregarComponente agregarComponente) {
        try {
            System.out.println("Accion agregarComponente, id:" + agregarComponente.getId());
            boolean existeComponente = existeIdComponente(agregarComponente.getId());
            if (existeComponente == false) {// verifica que exista el componente
                boolean existePagina = existeIdPagina(agregarComponente.getPagina());
                if (existePagina == true) {// verifica que exista la pagina
                    Pagina paginaId = paginaPorId(agregarComponente.getPagina());
                    if (paginaId != null) {
                        String id = paginaId.getId();// y por ultimo mira si es el index o no
                        if (paginaId.getId().startsWith("_index")) {
                            id = "index";
                        }
                        String link = direccionApache + "/" + paginaId.getSitio() + "/" + id + ".html";
                        html.crearComponente(agregarComponente, link);// manda a crear el componente
                        Componente componente = objetoComponente(agregarComponente);
                        if (componente != null) {
                            componentes.add(componente);// y por ultimo obtiene el componente y lo agrega a la base de datos
                            guardarBaseDatos();
                            msg.mandarMensaje("SE CREO CORRECTAMENTE EL COMPONENTE CON ID:" + agregarComponente.getId());
                        } else {
                            System.out.println("El objeto es null");
                        }
                    }
                } else {//muestra el error
                    msg.mandarError("ERROR SEMANTICO: AGREGAR COMPONENTE,NO EXISTE LA PAGINA CON ID:" + agregarComponente.getPagina());
                }

            } else {//muestra el error
                msg.mandarError("ERROR SEMANTICO: AGREGAR COMPONENTE,YA EXISTE UN COMPONENTE CON EL ID:" + agregarComponente.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
// borra un componente
    public void accionBorrarComponente(BorrarComponente borrarComponente) {
        try {
            ComponenteImagen img = null;
            ComponenteMenu menu = null;
            ComponenteParrafo parrafo = null;
            ComponenteTitulo titulo = null;
            ComponenteVideo video = null;
            System.out.println("Accion borrarComponente, id:" + borrarComponente.getId());
            ArrayList<Componente> componentes = Acciones.getComponentes();
            String idPagina = null;
            boolean existeIdComponente = existeIdComponente(borrarComponente.getId());
            if (existeIdComponente == true) {// verifica que exista el componente
                boolean existePagina = existeIdPagina(borrarComponente.getPagina());
                if (existePagina == true) {// y verifica si existe la pagina
                    for (int i = 0; i < componentes.size(); i++) {
                        if (componentes.get(i).getId().equals(borrarComponente.getId())) {
                            idPagina = componentes.get(i).getPagina();
                            componentes.remove(i);
                            break;// si es asi entonces lo busca y lo remueve de la base de datos
                        }
                    }
                    if (idPagina != null) {// genera la pagina a partir del id
                        Pagina pagina = paginaPorId(idPagina);
                        String id = pagina.getId();// este codigo es para verificar si es el index o n
                        if (pagina.getId().startsWith("_index")) {
                            id = "index";
                        }// genera el link
                        String direccion = direccionApache + "/" + pagina.getSitio() + "/" + id + ".html";
                        limpiarPagina(direccion);// deja vacia la pagina para volver a cargarla
                        // si la pagina tenia titulo entonces crea el titulo de la pagina
                        if (pagina.getTitulo() != null && !pagina.getTitulo().equals("null")) {
                            html.crearTitulo(direccion, pagina.getTitulo());
                        }
                        // y por ultimo regresa los componentes que estaban en la base de datos
                        for (int i = 0; i < componentes.size(); i++) {
                            if (componentes.get(i).getPagina().equals(idPagina)) {
                                String clase = componentes.get(i).getClase();
                                if (clase.equals("TITULO")) {// aqui dependiendo de que tipo de componente sea crea un objeto u otro
                                    String alineacion = null;
                                    if (componentes.get(i).getAlineacion() != null && !componentes.get(i).getAlineacion().equals("null")) {
                                        alineacion = componentes.get(i).getAlineacion();
                                    }
                                    titulo = new ComponenteTitulo(componentes.get(i).getTexto(), alineacion);

                                } else if (clase.equals("PARRAFO")) {// si es parrafo genera un objeto ComponenteParrafo
                                    String alineacion = null, color = null;
                                    if (componentes.get(i).getAlineacion() != null && !componentes.get(i).getAlineacion().equals("null")) {
                                        alineacion = componentes.get(i).getAlineacion();
                                    }
                                    if (componentes.get(i).getColor() != null && !componentes.get(i).getColor().equals("null")) {
                                        color = componentes.get(i).getColor();
                                    }
                                    parrafo = new ComponenteParrafo(componentes.get(i).getTexto(), alineacion, color);

                                } else if (clase.equals("VIDEO")) {// si es un video genera un objeto ComponenteVideo
                                    video = new ComponenteVideo(componentes.get(i).getOrigen(), Integer.parseInt(componentes.get(i).getAltura()), Integer.parseInt(componentes.get(i).getAncho()));

                                } else if (clase.equals("IMAGEN")) {// si es una imagen genera un objeto ComponenteImagen
                                    String alineacion = null;
                                    if (componentes.get(i).getAlineacion() != null && !componentes.get(i).getAlineacion().equals("null")) {
                                        alineacion = componentes.get(i).getAlineacion();
                                    }
                                    img = new ComponenteImagen(componentes.get(i).getOrigen(), alineacion, Integer.parseInt(componentes.get(i).getAltura()), Integer.parseInt(componentes.get(i).getAncho()));

                                } else if (clase.equals("MENU")) {// si es un menu genera un objeto ComponenteMenu
                                    ArrayList<String> etiquetas = componentes.get(i).getEtiquetas();
                                    String padre = null;
                                    if (etiquetas.size() == 1) {
                                        if (etiquetas.get(0).equals("null")) {
                                            etiquetas = new ArrayList<>();
                                        }
                                    }
                                    if (componentes.get(i).getPadre() != null && !componentes.get(i).getPadre().equals("null")) {
                                        padre = componentes.get(i).getPadre();
                                    }
                                    menu = new ComponenteMenu(padre, etiquetas);
                                }// luego de tener el componente genera un objeto AgregarComponente con lo cual se llamara a crear componente que es la funcion encargada de crear el html
                                AgregarComponente cmp = new AgregarComponente(componentes.get(i).getId(), componentes.get(i).getPagina(), componentes.get(i).getClase(), titulo, parrafo, img, video, menu);
                                // manda a crear el html
                                html.crearComponente(cmp, direccion);
                                menu = null;
                                titulo = null;
                                parrafo = null;
                                img = null;
                                video = null;

                            }

                        }// y al final guarda en la base de datos
                        guardarBaseDatos();
                        msg.mandarMensaje("SE BORRO CORRECTAMENTE EL COMPONENTE CON ID:" + borrarComponente.getId());
                    }

                } else {//muestra el error
                    msg.mandarError("ERROR SEMANTICO: BORRAR COMPONENTE,NO EXISTE LA PAGINA CON ID:" + borrarComponente.getPagina());
                }
            } else {//muestra el error
                msg.mandarError("ERROR SEMANTICO: BORRAR COMPONENTE,NO EXISTE EL COMPONENTE CON EL ID:" + borrarComponente.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
// accion de modificar componente
    public void accionModificarComponente(ModificarComponente modificarComponente, String usuario) {
        try {
            System.out.println("Accion modificarComponente, id:" + modificarComponente.getId());
            ComponenteImagen img = null;
            ComponenteMenu menu = null;
            ComponenteParrafo parrafo = null;
            ComponenteTitulo titulo = null;
            ComponenteVideo video = null;
            ArrayList<Componente> cmps = Acciones.componentes;
            ArrayList<Pagina> pags = Acciones.paginas;
            boolean existeComponente = existeIdComponente(modificarComponente.getId());
            if (existeComponente == true) {// verifica que exista el componente
                boolean existePagina = existeIdPagina(modificarComponente.getPagina());
                if (existePagina == true) {// verifica que exista la pagina
                    Pagina paginaId = paginaPorId(modificarComponente.getPagina());
// obtiene la pagaina por el id
                    if (paginaId != null) {
                        String id = paginaId.getId();
                        if (paginaId.getId().startsWith("_index")) {
                            id = "index";
                        }// genera el path a utilizar en base si es index o no 
                        String direccion = direccionApache + "/" + paginaId.getSitio() + "/" + id + ".html";
                        limpiarPagina(direccion);
                        Componente componenteNuevo = objetoModificarComponente(modificarComponente);
                        for (int i = 0; i < cmps.size(); i++) {
                            if (cmps.get(i).getId().equals(modificarComponente.getId())) {
                                cmps.add(i, componenteNuevo);
                                cmps.remove(i + 1);
                                break;
                            }
                        }
                        String idPagina = paginaId.getId();
// y si la pagina tiene titulo se lo agrega al inicio
                        if (paginaId.getTitulo() != null && !paginaId.getTitulo().equals("null")) {
                            html.crearTitulo(direccion, paginaId.getTitulo());
                        }
                        for (int i = 0; i < pags.size(); i++) {
                            if (pags.get(i).getId().equals(paginaId.getId())) {
                                Date fechaActual = new Date();
                                pags.get(i).setFechaModificacion(formato.format(fechaActual));
                                pags.get(i).setUsuarioModificacion(usuario);
                                break;
                            }// modifica la fecha de modificacion y el usuario modificacion
                        }

                        for (int i = 0; i < componentes.size(); i++) {// y recorre los componentes 
                            if (componentes.get(i).getPagina().equals(idPagina)) {
                                String clase = componentes.get(i).getClase();
                                if (clase.equals("TITULO")) {// genera un objeto titulo
                                    String alineacion = null;
                                    if (componentes.get(i).getAlineacion() != null && !componentes.get(i).getAlineacion().equals("null")) {
                                        alineacion = componentes.get(i).getAlineacion();
                                    }
                                    titulo = new ComponenteTitulo(componentes.get(i).getTexto(), alineacion);

                                } else if (clase.equals("PARRAFO")) {// genera un componente parrafo
                                    String alineacion = null, color = null;
                                    if (componentes.get(i).getAlineacion() != null && !componentes.get(i).getAlineacion().equals("null")) {
                                        alineacion = componentes.get(i).getAlineacion();
                                    }
                                    if (componentes.get(i).getColor() != null && !componentes.get(i).getColor().equals("null")) {
                                        color = componentes.get(i).getColor();
                                    }
                                    parrafo = new ComponenteParrafo(componentes.get(i).getTexto(), alineacion, color);

                                } else if (clase.equals("VIDEO")) {//genera un objeto video
                                    video = new ComponenteVideo(componentes.get(i).getOrigen(), Integer.parseInt(componentes.get(i).getAltura()), Integer.parseInt(componentes.get(i).getAncho()));

                                } else if (clase.equals("IMAGEN")) {// genera un objeto imagen
                                    String alineacion = null;
                                    if (componentes.get(i).getAlineacion() != null && !componentes.get(i).getAlineacion().equals("null")) {
                                        alineacion = componentes.get(i).getAlineacion();
                                    }
                                    img = new ComponenteImagen(componentes.get(i).getOrigen(), alineacion, Integer.parseInt(componentes.get(i).getAltura()), Integer.parseInt(componentes.get(i).getAncho()));

                                } else if (clase.equals("MENU")) {// genera un componente menu
                                    ArrayList<String> etiquetas = componentes.get(i).getEtiquetas();
                                    String padre = null;
                                    if (etiquetas.size() == 1) {
                                        if (etiquetas.get(0).equals("null")) {
                                            etiquetas = new ArrayList<>();
                                        }
                                    }
                                    if (componentes.get(i).getPadre() != null && !componentes.get(i).getPadre().equals("null")) {
                                        padre = componentes.get(i).getPadre();
                                    }
                                    menu = new ComponenteMenu(padre, etiquetas);
                                }// genera un objeto agregar componente
                                AgregarComponente cmp = new AgregarComponente(componentes.get(i).getId(), componentes.get(i).getPagina(), componentes.get(i).getClase(), titulo, parrafo, img, video, menu);
// y manda a crear el componente
                                html.crearComponente(cmp, direccion);
                                menu = null;
                                titulo = null;
                                parrafo = null;
                                img = null;
                                video = null;
                            }

                        }// guarda en la base de datos 
                        guardarBaseDatos();
                        msg.mandarMensaje("SE MODIFICO CORRECTAMENTE EL COMPONENTE CON ID:" + modificarComponente.getId());

                    } else {//muestra el error
                        msg.mandarError("ERROR SEMANTICO: MODIFICAR COMPONENTE,NO EXISTE LA PAGINA CON ID:" + modificarComponente.getPagina());
                    }

                } else {//muestra el error
                    msg.mandarError("ERROR SEMANTICO: MODIFICAR COMPONENTE,NO EXISTE UN COMPONENTE CON EL ID:" + modificarComponente.getId());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//este metodo recorre los componentes y crea objetos componentes en base al id de una pagina y la direccion en donde esta ubicada la pagina
    public void ingresarComponentes(String idPagina, String direccion) {
        try {
            ComponenteImagen img = null;
            ComponenteMenu menu = null;
            ComponenteParrafo parrafo = null;
            ComponenteTitulo titulo = null;
            ComponenteVideo video = null;
            for (int i = 0; i < componentes.size(); i++) {// recorre los componentes
                if (componentes.get(i).getPagina().equals(idPagina)) {
                    String clase = componentes.get(i).getClase();
                    if (clase.equals("TITULO")) {// si es un titulo genera el objeto titulo
                        String alineacion = null;
                        if (componentes.get(i).getAlineacion() != null && !componentes.get(i).getAlineacion().equals("null")) {
                            alineacion = componentes.get(i).getAlineacion();
                        }
                        titulo = new ComponenteTitulo(componentes.get(i).getTexto(), alineacion);

                    } else if (clase.equals("PARRAFO")) {// crea un objeto parrafo
                        String alineacion = null, color = null;
                        if (componentes.get(i).getAlineacion() != null && !componentes.get(i).getAlineacion().equals("null")) {
                            alineacion = componentes.get(i).getAlineacion();
                        }
                        if (componentes.get(i).getColor() != null && !componentes.get(i).getColor().equals("null")) {
                            color = componentes.get(i).getColor();
                        }
                        parrafo = new ComponenteParrafo(componentes.get(i).getTexto(), alineacion, color);

                    } else if (clase.equals("VIDEO")) {// genera un objeto video
                        video = new ComponenteVideo(componentes.get(i).getOrigen(), Integer.parseInt(componentes.get(i).getAltura()), Integer.parseInt(componentes.get(i).getAncho()));

                    } else if (clase.equals("IMAGEN")) {// genera un objeto imagen
                        String alineacion = null;
                        if (componentes.get(i).getAlineacion() != null && !componentes.get(i).getAlineacion().equals("null")) {
                            alineacion = componentes.get(i).getAlineacion();
                        }
                        img = new ComponenteImagen(componentes.get(i).getOrigen(), alineacion, Integer.parseInt(componentes.get(i).getAltura()), Integer.parseInt(componentes.get(i).getAncho()));

                    } else if (clase.equals("MENU")) {// genera un objeto menu
                        ArrayList<String> etiquetas = componentes.get(i).getEtiquetas();
                        String padre = null;
                        if (etiquetas.size() == 1) {
                            if (etiquetas.get(0).equals("null")) {
                                etiquetas = new ArrayList<>();
                            }
                        }
                        if (componentes.get(i).getPadre() != null && !componentes.get(i).getPadre().equals("null")) {
                            padre = componentes.get(i).getPadre();
                        }
                        menu = new ComponenteMenu(padre, etiquetas);
                    }// genera el objeto agregar componente 
                    AgregarComponente cmp = new AgregarComponente(componentes.get(i).getId(), componentes.get(i).getPagina(), componentes.get(i).getClase(), titulo, parrafo, img, video, menu);

                    html.crearComponente(cmp, direccion);
                    menu = null;
                    titulo = null;
                    parrafo = null;
                    img = null;
                    video = null;

                }

            }
            guardarBaseDatos();// guarda en la base de datos
        } catch (Exception e) {//muestra el error
            msg.mandarError("SURGIO UN ERROR AL VER EL COMPONENTE");
            e.printStackTrace();
        }
    }

    public void limpiarPagina(String path) {
        try {// sirve para dejar una pagina .html en blanco
            File archivo = new File(path);
            FileWriter writer = new FileWriter(archivo, false);
            BufferedWriter escritor = new BufferedWriter(writer);
            escritor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
// genera un listado de las paginas hijas en base a un id de una pagina 
    public ArrayList<Pagina> paginasHijas(String padre) {
        ArrayList<Pagina> paginasHijas = new ArrayList<>();
        for (int i = 0; i < paginas.size(); i++) {
            if (paginas.get(i).getPadre() != null && paginas.get(i).getPadre().equals(padre)) {
                paginasHijas.add(paginas.get(i));
            }
        }
        return paginasHijas;
    }
// genera un listado de etiquetas en base a las etiquetas que le mande de parametro
    public ArrayList<Pagina> paginasEtiqueta(ArrayList<String> etiquetas) {
        ArrayList<Pagina> paginasEtiquetas = new ArrayList<>();
        ArrayList<String> etiquetasPaginas;
        boolean cumple = false;
        for (int i = 0; i < paginas.size(); i++) {
            cumple = false;// verifica que la pagina cumpla con todas las etiquetas 
            etiquetasPaginas = paginas.get(i).getEtiquetas();
            if (etiquetasPaginas.size() >= etiquetas.size()) {
                for (int j = 0; j < etiquetas.size(); j++) {
                    for (int k = 0; k < etiquetasPaginas.size(); k++) {
                        if (etiquetas.get(j).equals(etiquetasPaginas.get(k))) {
                            cumple = true;
                            break;
                        }
                        cumple = false;
                    }
                    if (cumple == false) {
                        break;
                    }

                }
            }
            if (cumple == true) {// si cumple con todos los filtros agrega la pagina a las que hay que mandar 
                paginasEtiquetas.add(paginas.get(i));
            }
        }
        return paginasEtiquetas;
    }
// filtra las paginas que tienen etiquetas y que tiene padre
    public ArrayList<Pagina> paginasFiltradasPorAmbos(ArrayList<Pagina> etiquetas, String padre) {
        ArrayList<Pagina> paginasMandar = new ArrayList<>();
        for (int i = 0; i < etiquetas.size(); i++) {
            if (etiquetas.get(i).getPadre().equals(padre)) {
                paginasMandar.add(etiquetas.get(i));
            }

        }
        return paginasMandar;
    }
// sirve para crear un componente en base a un objeto modificar el componente 
    public Componente objetoModificarComponente(ModificarComponente comp) {

        AgregarComponente componente = new AgregarComponente(comp.getId(), comp.getPagina(), comp.getClase(), comp.getCompTitulo(), comp.getCompParrafo(), comp.getCompImagen(), comp.getCompVideo(), comp.getCompMenu());
        return objetoComponente(componente);

    }
// genera un objeto componente en base a un objeto agregar componente
    public Componente objetoComponente(AgregarComponente comp) {
        String id = null, pagina = null, clase = null, texto = null, alineacion = null, color = null, origen = null, altura = null, ancho = null, padre = null;
        ArrayList<String> etiquetas = new ArrayList<>();
        if (comp.isEsImagen()) {// si el agregar componente es una imagen genera e objeto imagen 
            ComponenteImagen img = comp.getCompImagen();
            Componente componente = new Componente(comp.getId(), comp.getPagina(), comp.getClase(), texto, img.getAlineacion(), color, img.getOrigen(), Integer.toString(img.getAltura()), Integer.toString(img.getAncho()), padre, etiquetas);
            return componente;
        } else if (comp.isEsMenu()) {// si el agregar componente es un menu genera el objeto menu
            ComponenteMenu menu = comp.getCompMenu();
            Componente componente = new Componente(comp.getId(), comp.getPagina(), comp.getClase(), texto, alineacion, color, origen, altura, ancho, menu.getPadre(), menu.getEtiquetas());
            return componente;
        } else if (comp.isEsParrafo()) {// si el objeto es un parrafo genera este objeto 
            ComponenteParrafo parrafo = comp.getCompParrafo();
            Componente componente = new Componente(comp.getId(), comp.getPagina(), comp.getClase(), parrafo.getTexto(), parrafo.getAlineacion(), parrafo.getColor(), origen, altura, ancho, padre, etiquetas);
            return componente;
        } else if (comp.isEsTitulo()) {// si el objeto es un titulo genera este objeto 
            ComponenteTitulo titulo = comp.getCompTitulo();
            Componente componente = new Componente(comp.getId(), comp.getPagina(), comp.getClase(), titulo.getTexto(), titulo.getAlineacion(), color, origen, altura, ancho, padre, etiquetas);
            return componente;
        } else if (comp.isEsVideo()) {// y si es un video de igual forma
            ComponenteVideo video = comp.getCompVideo();
            Componente componente = new Componente(comp.getId(), comp.getPagina(), comp.getClase(), texto, alineacion, color, video.getOrigen(), Integer.toString(video.getAltura()), Integer.toString(video.getAncho()), padre, etiquetas);
            return componente;
        }
        return null;
    }

    public static ArrayList<Sitio> getSitios() {
        return sitios;
    }

    public static void setSitios(ArrayList<Sitio> sitios) {
        Acciones.sitios = sitios;
    }

    public static ArrayList<Pagina> getPaginas() {
        return paginas;
    }

    public static void setPaginas(ArrayList<Pagina> paginas) {
        Acciones.paginas = paginas;
    }

    public static ArrayList<Componente> getComponentes() {
        return componentes;
    }

    public static void setComponentes(ArrayList<Componente> componentes) {
        Acciones.componentes = componentes;
    }

}
