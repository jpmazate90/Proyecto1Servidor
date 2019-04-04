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

    private static ArrayList<Sitio> sitios = new ArrayList<>();
    private static ArrayList<Pagina> paginas = new ArrayList<>();
    private static ArrayList<Componente> componentes = new ArrayList<>();
    private final String direccionApache = "/var/www/html";
    private HTML html;
    private SimpleDateFormat formato;
    private Mensajes msg = new Mensajes();

    public Acciones() {
        html = new HTML();
        formato = new SimpleDateFormat("yyyy-MM-dd");

    }

    public void accionNuevoSitioWeb(NuevoSitioWeb nuevoSitioWeb, String usuario) {
        System.out.println("Accion nuevoSitioWeb, id:" + nuevoSitioWeb.getId());
        ArrayList<String> etiquetas = new ArrayList<>();
        boolean existeId = existeIdSitio(nuevoSitioWeb.getId());
        if (existeId == false) {
            String direccionSitio = direccionApache + "/" + nuevoSitioWeb.getId();
            String indexSitio = direccionSitio + "/index.html";
            html.crearIndexSitio(nuevoSitioWeb, direccionSitio, indexSitio);
            String id = "_index" + nuevoSitioWeb.getId();
            Pagina pagina = new Pagina(id, id, nuevoSitioWeb.getId(), null, usuario, formato.format(nuevoSitioWeb.getFechaCreacion()), formato.format(nuevoSitioWeb.getFechaModificacion()), usuario, etiquetas, null);
            Sitio sitio = new Sitio(nuevoSitioWeb.getId(), nuevoSitioWeb.getUsuarioCreacion(), formato.format(nuevoSitioWeb.getFechaCreacion()), formato.format(nuevoSitioWeb.getFechaModificacion()), nuevoSitioWeb.getUsuarioModificacion());
            sitios.add(sitio);
            paginas.add(pagina);
            guardarBaseDatos();
            msg.mandarMensaje("SE CREO CORRECTAMENTE EL NUEVO SITIO WEB CON ID:"+nuevoSitioWeb.getId());
        } else {
            //mandar a la aplicacion cliente en XML
            msg.mandarError("ERROR SEMANTICO: NUEVO SITIO WEB,YA EXISTE EL ID PARA EL SITIO:"+nuevoSitioWeb.getId());
            
        }
    }

    public void guardarBaseDatos() {
        html.guardarBaseDatos(sitios, paginas, componentes);

    }

    public boolean existeIdSitio(String id) {
        for (int i = 0; i < sitios.size(); i++) {
            if (sitios.get(i).getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean existeIdPagina(String id) {
        for (int i = 0; i < paginas.size(); i++) {
            if (paginas.get(i).getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public Pagina paginaPorId(String id) {
        for (int i = 0; i < paginas.size(); i++) {
            if (paginas.get(i).getId().equals(id)) {
                return paginas.get(i);
            }
        }
        return null;
    }

    public boolean existeIdComponente(String id) {
        for (int i = 0; i < componentes.size(); i++) {
            if (componentes.get(i).getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void accionBorrarSitioWeb(BorrarSitioWeb borrarSitioWeb) {
        System.out.println("Accion borrarSitioWeb, id:" + borrarSitioWeb.getId());
        ArrayList<Sitio> sits = Acciones.sitios;
        ArrayList<Pagina> pags = Acciones.paginas;
        String idSitio = borrarSitioWeb.getId();
        BorrarPagina borrarPagina;

        boolean existeSitio = existeIdSitio(idSitio);
        if (existeSitio == true) {
            for (int i = 0; i < sits.size(); i++) {
                if (sits.get(i).getId().equals(borrarSitioWeb.getId())) {
                    idSitio = sits.get(i).getId();
                    sits.remove(i);
                    i--;
                    break;
                }
            }

            for (int i = 0; i < pags.size(); i++) {
                if (pags.get(i).getSitio().equals(idSitio)) {
                    borrarPagina = new BorrarPagina(pags.get(i).getId());
                    accionBorrarPagina(borrarPagina, true);
                    i--;
                }

            }
            String pathSitio = direccionApache + "/" + idSitio;
            File directorio = new File(pathSitio);
            if (directorio.isDirectory()) {
                html.borrarSitio(directorio);
                directorio.delete();
            } else {
                System.out.println("no es un directorio");
            }
            msg.mandarMensaje("SE BORRO CORRECTAMENTE EL SITIO WEB CON ID:"+borrarSitioWeb.getId());

        } else {
            msg.mandarError("ERROR SEMANTICO: BORRAR SITIO WEB, NO EXISTE EL ID PARA EL SITIO:"+borrarSitioWeb.getId());
        }

    }

    public void accionNuevaPagina(NuevaPagina nuevaPagina) {
        System.out.println("Accion nuevaPagina, id:" + nuevaPagina.getId());
        boolean existePagina = existeIdPagina(nuevaPagina.getId());
        boolean padre = true;
        if (existePagina == false) {
            boolean existeSitio = existeIdSitio(nuevaPagina.getSitio());
            if (existeSitio == true) {
                if (nuevaPagina.getPadre() != null) {
                    padre = existeIdPagina(nuevaPagina.getPadre());
                    if (padre == true) {
                        Pagina pagPadre = paginaPorId(nuevaPagina.getPadre());
                        if (!pagPadre.getSitio().equals(nuevaPagina.getSitio())) {
                            padre = false;
                            msg.mandarError("ERROR SEMANTICO: NUEVA PAGINA, NO ESTAN EN EL MISMO SITIO WEB LA PAGINA:"+nuevaPagina.getId()+", SU SITIO ES:"+nuevaPagina.getSitio()+", Y EL PADRE: "+nuevaPagina.getPadre()+", SU SITIO ES:"+pagPadre.getSitio()+". POR LO CUAL NO SE PUEDE CREAR LA PAGINA");
                        }
                    }
                }
                if (padre == true) {
                    Pagina paginaNueva;
                    String pathPagina = direccionApache + "/" + nuevaPagina.getSitio() + "/" + nuevaPagina.getId() + ".html";
                    html.crearPaginaWeb(nuevaPagina, pathPagina);
                    paginaNueva = new Pagina(nuevaPagina.getId(), nuevaPagina.getLink(), nuevaPagina.getSitio(), nuevaPagina.getPadre(), nuevaPagina.getUsuarioCreacion(), formato.format(nuevaPagina.getFechaCreacion()), formato.format(nuevaPagina.getFechaModificacion()), nuevaPagina.getUsuarioModificacion(), nuevaPagina.getEtiquetas(), nuevaPagina.getTitulo());
                    paginas.add(paginaNueva);
                    guardarBaseDatos();
                    msg.mandarMensaje("SE CREO CORRECTAMENTE LA NUEVA PAGINA CON ID:"+nuevaPagina.getId());
                } else {
                    msg.mandarError("ERROR SEMANTICO: NUEVA PAGINA, NO EXISTE UNA PAGINA CON ID:" + nuevaPagina.getPadre() + " PARA SER PADRE DENTRO DEL MISMO SITIO");
                }

            } else {
                msg.mandarError("ERROR SEMANTICO: NUEVA PAGINA, NO EXISTE NINGUN SITIO CON EL ID:" + nuevaPagina.getSitio());
            }
        } else {
            msg.mandarError("ERROR SEMANTICO: NUEVA PAGINA,YA EXISTE LA PAGINA CON ID:" + nuevaPagina.getId());
        }

    }

    public void accionBorrarPagina(BorrarPagina borrarPagina, boolean borrarIndex) {

        System.out.println("Accion borrarPagina, id:" + borrarPagina.getId());
        ArrayList<Pagina> pags = Acciones.paginas;
        ArrayList<Componente> comps = Acciones.componentes;
        String id = borrarPagina.getId();
        boolean existePag = existeIdPagina(borrarPagina.getId());
        if (existePag == true) {
            Pagina pagina = paginaPorId(borrarPagina.getId());
            if (borrarPagina.getId().startsWith("_index") && borrarPagina.getId().endsWith(pagina.getSitio()) && borrarIndex == false) {
                msg.mandarError("ERROR SEMANTICO: BORRAR PAGINA ,NO SE PUEDE BORRAR EL INDEX DEL SITIO:"+pagina.getSitio());
            } else {
                for (int i = 0; i < pags.size(); i++) {
                    if (pags.get(i).getId().equals(borrarPagina.getId())) {
                        pags.remove(i);
                        i--;
                        break;
                    }
                }
                for (int i = 0; i < comps.size(); i++) {
                    if (comps.get(i).getPagina().equals(id)) {
                        comps.remove(i);
                        i--;
                    }

                }

                for (int i = 0; i < pags.size(); i++) {
                    if (pags.get(i).getPadre() != null && pags.get(i).getPadre().equals(id)) {
                        for (int j = 0; j < comps.size(); j++) {
                            if (comps.get(j).getPagina().equals(pags.get(i).getId())) {
                                comps.remove(j);
                                j--;
                            }
                        }
                        String path1 = direccionApache + "/" + pags.get(i).getSitio() + "/" + pags.get(i).getId() + ".html";
                        pags.remove(i);
                        i--;
                        html.borrarPagina(path1);
                    }

                }
                String path = direccionApache + "/" + pagina.getSitio() + "/" + id + ".html";
                html.borrarPagina(path);
                guardarBaseDatos();
                msg.mandarMensaje("SE BORRO CORRECTAMENTE LA PAGINA CON ID:"+borrarPagina.getId());
            }
        } else {
            msg.mandarError("ERROR SEMANTICO: BORRAR PAGINA , NO EXISTE PAGINA CON ID:" + borrarPagina.getId()+" PARA BORRAR");
        }
    }

    public void accionModificarPagina(ModificarPagina modificarPagina) {
        System.out.println("Accion modificarPagina, id:" + modificarPagina.getId());

        String idPag = modificarPagina.getId();
        boolean existePag = existeIdPagina(idPag);
        if (existePag == true) {
            Pagina pagina = paginaPorId(idPag);
            pagina.setFechaModificacion(formato.format(modificarPagina.getDatefechaModificacion()));
            pagina.setUsuarioModificacion(modificarPagina.getUsuarioModificacion());
            if (modificarPagina.getTitulo() != null) {
                String id = pagina.getId();
                if (pagina.getId().startsWith("_index")) {
                    id = "index";
                }
                String link = direccionApache + "/" + pagina.getSitio() + "/" + id + ".html";
                limpiarPagina(link);
                html.crearTitulo(link, modificarPagina.getTitulo());
                ingresarComponentes(idPag, link);

            }
            if (modificarPagina.getEtiquetas() != null && modificarPagina.getEtiquetas().size() > 0) {
                pagina.setEtiquetas(modificarPagina.getEtiquetas());

            }
            guardarBaseDatos();
            msg.mandarMensaje("SE MODIFICO CORRECTAMENTE LA PAGINA CON ID:"+modificarPagina.getId());

        } else {
            msg.mandarError("ERROR SEMANTICO: MODIFICAR PAGINA, NO EXISTE LA PAGINA A MODIFICAR CON ID:" + idPag);
        }
    }

    public void accionAgregarComponente(AgregarComponente agregarComponente) {
        System.out.println("Accion agregarComponente, id:" + agregarComponente.getId());
        boolean existeComponente = existeIdComponente(agregarComponente.getId());
        if (existeComponente == false) {
            boolean existePagina = existeIdPagina(agregarComponente.getPagina());
            if (existePagina == true) {
                Pagina paginaId = paginaPorId(agregarComponente.getPagina());
                if (paginaId != null) {
                    String id = paginaId.getId();
                    if (paginaId.getId().startsWith("_index")) {
                        id = "index";
                    }
                    String link = direccionApache + "/" + paginaId.getSitio() + "/" + id + ".html";
                    html.crearComponente(agregarComponente, link);
                    Componente componente = objetoComponente(agregarComponente);
                    if (componente != null) {
                        componentes.add(componente);
                        guardarBaseDatos();
                        msg.mandarMensaje("SE CREO CORRECTAMENTE EL COMPONENTE CON ID:"+agregarComponente.getId());
                    } else {
                        System.out.println("El objeto es null");
                    }
                }
            } else {
                msg.mandarError("ERROR SEMANTICO: AGREGAR COMPONENTE,NO EXISTE LA PAGINA CON ID:" + agregarComponente.getPagina());
            }

        } else {
            msg.mandarError("ERROR SEMANTICO: AGREGAR COMPONENTE,YA EXISTE UN COMPONENTE CON EL ID:" + agregarComponente.getId());
        }
    }

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
            if (existeIdComponente == true) {
                boolean existePagina = existeIdPagina(borrarComponente.getPagina());
                if (existePagina == true) {
                    for (int i = 0; i < componentes.size(); i++) {
                        if (componentes.get(i).getId().equals(borrarComponente.getId())) {
                            idPagina = componentes.get(i).getPagina();
                            componentes.remove(i);
                            break;
                        }
                    }
                    if (idPagina != null) {
                        Pagina pagina = paginaPorId(idPagina);
                        String id = pagina.getId();
                        if (pagina.getId().startsWith("_index")) {
                            id = "index";
                        }
                        String direccion = direccionApache + "/" + pagina.getSitio() + "/" + id + ".html";
                        limpiarPagina(direccion);

                        if (pagina.getTitulo() != null && !pagina.getTitulo().equals("null")) {
                            html.crearTitulo(direccion, pagina.getTitulo());
                        }

                        for (int i = 0; i < componentes.size(); i++) {
                            if (componentes.get(i).getPagina().equals(idPagina)) {
                                String clase = componentes.get(i).getClase();
                                if (clase.equals("TITULO")) {
                                    String alineacion = null;
                                    if (componentes.get(i).getAlineacion() != null && !componentes.get(i).getAlineacion().equals("null")) {
                                        alineacion = componentes.get(i).getAlineacion();
                                    }
                                    titulo = new ComponenteTitulo(componentes.get(i).getTexto(), alineacion);

                                } else if (clase.equals("PARRAFO")) {
                                    String alineacion = null, color = null;
                                    if (componentes.get(i).getAlineacion() != null && !componentes.get(i).getAlineacion().equals("null")) {
                                        alineacion = componentes.get(i).getAlineacion();
                                    }
                                    if (componentes.get(i).getColor() != null && !componentes.get(i).getColor().equals("null")) {
                                        color = componentes.get(i).getColor();
                                    }
                                    parrafo = new ComponenteParrafo(componentes.get(i).getTexto(), alineacion, color);

                                } else if (clase.equals("VIDEO")) {
                                    video = new ComponenteVideo(componentes.get(i).getOrigen(), Integer.parseInt(componentes.get(i).getAltura()), Integer.parseInt(componentes.get(i).getAncho()));

                                } else if (clase.equals("IMAGEN")) {
                                    String alineacion = null;
                                    if (componentes.get(i).getAlineacion() != null && !componentes.get(i).getAlineacion().equals("null")) {
                                        alineacion = componentes.get(i).getAlineacion();
                                    }
                                    img = new ComponenteImagen(componentes.get(i).getOrigen(), alineacion, Integer.parseInt(componentes.get(i).getAltura()), Integer.parseInt(componentes.get(i).getAncho()));

                                } else if (clase.equals("MENU")) {
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
                                }
                                AgregarComponente cmp = new AgregarComponente(componentes.get(i).getId(), componentes.get(i).getPagina(), componentes.get(i).getClase(), titulo, parrafo, img, video, menu);

                                html.crearComponente(cmp, direccion);
                                menu = null;
                                titulo = null;
                                parrafo = null;
                                img = null;
                                video = null;

                            }

                        }
                        guardarBaseDatos();
                        msg.mandarMensaje("SE BORRO CORRECTAMENTE EL COMPONENTE CON ID:"+borrarComponente.getId());
                    }

                } else {
                    msg.mandarError("ERROR SEMANTICO: BORRAR COMPONENTE,NO EXISTE LA PAGINA CON ID:" + borrarComponente.getPagina());
                }
            } else {
                msg.mandarError("ERROR SEMANTICO: BORRAR COMPONENTE,NO EXISTE EL COMPONENTE CON EL ID:" + borrarComponente.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void accionModificarComponente(ModificarComponente modificarComponente,String usuario) {
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
            if (existeComponente == true) {
                boolean existePagina = existeIdPagina(modificarComponente.getPagina());
                if (existePagina == true) {
                    Pagina paginaId = paginaPorId(modificarComponente.getPagina());
                    
                    if (paginaId != null) {
                        String id = paginaId.getId();
                        if (paginaId.getId().startsWith("_index")) {
                            id = "index";
                        }
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

                        if (paginaId.getTitulo() != null && !paginaId.getTitulo().equals("null")) {
                            html.crearTitulo(direccion, paginaId.getTitulo());
                        }
                        for (int i = 0; i < pags.size(); i++) {
                            if(pags.get(i).getId().equals(paginaId.getId())){
                                Date fechaActual = new Date();
                                pags.get(i).setFechaModificacion(formato.format(fechaActual));
                                pags.get(i).setUsuarioModificacion(usuario);
                                break;
                            }
                        }

                        for (int i = 0; i < componentes.size(); i++) {
                            if (componentes.get(i).getPagina().equals(idPagina)) {
                                String clase = componentes.get(i).getClase();
                                if (clase.equals("TITULO")) {
                                    String alineacion = null;
                                    if (componentes.get(i).getAlineacion() != null && !componentes.get(i).getAlineacion().equals("null")) {
                                        alineacion = componentes.get(i).getAlineacion();
                                    }
                                    titulo = new ComponenteTitulo(componentes.get(i).getTexto(), alineacion);

                                } else if (clase.equals("PARRAFO")) {
                                    String alineacion = null, color = null;
                                    if (componentes.get(i).getAlineacion() != null && !componentes.get(i).getAlineacion().equals("null")) {
                                        alineacion = componentes.get(i).getAlineacion();
                                    }
                                    if (componentes.get(i).getColor() != null && !componentes.get(i).getColor().equals("null")) {
                                        color = componentes.get(i).getColor();
                                    }
                                    parrafo = new ComponenteParrafo(componentes.get(i).getTexto(), alineacion, color);

                                } else if (clase.equals("VIDEO")) {
                                    video = new ComponenteVideo(componentes.get(i).getOrigen(), Integer.parseInt(componentes.get(i).getAltura()), Integer.parseInt(componentes.get(i).getAncho()));

                                } else if (clase.equals("IMAGEN")) {
                                    String alineacion = null;
                                    if (componentes.get(i).getAlineacion() != null && !componentes.get(i).getAlineacion().equals("null")) {
                                        alineacion = componentes.get(i).getAlineacion();
                                    }
                                    img = new ComponenteImagen(componentes.get(i).getOrigen(), alineacion, Integer.parseInt(componentes.get(i).getAltura()), Integer.parseInt(componentes.get(i).getAncho()));

                                } else if (clase.equals("MENU")) {
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
                                }
                                AgregarComponente cmp = new AgregarComponente(componentes.get(i).getId(), componentes.get(i).getPagina(), componentes.get(i).getClase(), titulo, parrafo, img, video, menu);

                                html.crearComponente(cmp, direccion);
                                menu = null;
                                titulo = null;
                                parrafo = null;
                                img = null;
                                video = null;
                            }

                        }
                        guardarBaseDatos();
                        msg.mandarMensaje("SE MODIFICO CORRECTAMENTE EL COMPONENTE CON ID:"+modificarComponente.getId());
                        

                    } else {
                        msg.mandarError("ERROR SEMANTICO: MODIFICAR COMPONENTE,NO EXISTE LA PAGINA CON ID:" + modificarComponente.getPagina());
                    }

                } else {
                    msg.mandarError("ERROR SEMANTICO: MODIFICAR COMPONENTE,NO EXISTE UN COMPONENTE CON EL ID:" + modificarComponente.getId());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ingresarComponentes(String idPagina, String direccion) {
        try {
            ComponenteImagen img = null;
            ComponenteMenu menu = null;
            ComponenteParrafo parrafo = null;
            ComponenteTitulo titulo = null;
            ComponenteVideo video = null;
            for (int i = 0; i < componentes.size(); i++) {
                if (componentes.get(i).getPagina().equals(idPagina)) {
                    String clase = componentes.get(i).getClase();
                    if (clase.equals("TITULO")) {
                        String alineacion = null;
                        if (componentes.get(i).getAlineacion() != null && !componentes.get(i).getAlineacion().equals("null")) {
                            alineacion = componentes.get(i).getAlineacion();
                        }
                        titulo = new ComponenteTitulo(componentes.get(i).getTexto(), alineacion);

                    } else if (clase.equals("PARRAFO")) {
                        String alineacion = null, color = null;
                        if (componentes.get(i).getAlineacion() != null && !componentes.get(i).getAlineacion().equals("null")) {
                            alineacion = componentes.get(i).getAlineacion();
                        }
                        if (componentes.get(i).getColor() != null && !componentes.get(i).getColor().equals("null")) {
                            color = componentes.get(i).getColor();
                        }
                        parrafo = new ComponenteParrafo(componentes.get(i).getTexto(), alineacion, color);

                    } else if (clase.equals("VIDEO")) {
                        video = new ComponenteVideo(componentes.get(i).getOrigen(), Integer.parseInt(componentes.get(i).getAltura()), Integer.parseInt(componentes.get(i).getAncho()));

                    } else if (clase.equals("IMAGEN")) {
                        String alineacion = null;
                        if (componentes.get(i).getAlineacion() != null && !componentes.get(i).getAlineacion().equals("null")) {
                            alineacion = componentes.get(i).getAlineacion();
                        }
                        img = new ComponenteImagen(componentes.get(i).getOrigen(), alineacion, Integer.parseInt(componentes.get(i).getAltura()), Integer.parseInt(componentes.get(i).getAncho()));

                    } else if (clase.equals("MENU")) {
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
                    }
                    AgregarComponente cmp = new AgregarComponente(componentes.get(i).getId(), componentes.get(i).getPagina(), componentes.get(i).getClase(), titulo, parrafo, img, video, menu);

                    html.crearComponente(cmp, direccion);
                    menu = null;
                    titulo = null;
                    parrafo = null;
                    img = null;
                    video = null;

                }

            }
            guardarBaseDatos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void limpiarPagina(String path) {
        try {
            File archivo = new File(path);
            FileWriter writer = new FileWriter(archivo, false);
            BufferedWriter escritor = new BufferedWriter(writer);
            escritor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Pagina> paginasHijas(String padre) {
        ArrayList<Pagina> paginasHijas = new ArrayList<>();
        for (int i = 0; i < paginas.size(); i++) {
            if (paginas.get(i).getPadre() != null && paginas.get(i).getPadre().equals(padre)) {
                paginasHijas.add(paginas.get(i));
            }
        }
        return paginasHijas;
    }

    public ArrayList<Pagina> paginasEtiqueta(ArrayList<String> etiquetas) {
        ArrayList<Pagina> paginasEtiquetas = new ArrayList<>();
        ArrayList<String> etiquetasPaginas;
        boolean cumple = false;
        for (int i = 0; i < paginas.size(); i++) {
            cumple = false;
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
            if (cumple == true) {
                paginasEtiquetas.add(paginas.get(i));
            }
        }
        return paginasEtiquetas;
    }

    public ArrayList<Pagina> paginasFiltradasPorAmbos(ArrayList<Pagina> etiquetas, String padre) {
        ArrayList<Pagina> paginasMandar = new ArrayList<>();
        for (int i = 0; i < etiquetas.size(); i++) {
            if (etiquetas.get(i).getPadre().equals(padre)) {
                paginasMandar.add(etiquetas.get(i));
            }

        }
        return paginasMandar;
    }

    public Componente objetoModificarComponente(ModificarComponente comp) {

        AgregarComponente componente = new AgregarComponente(comp.getId(), comp.getPagina(), comp.getClase(), comp.getCompTitulo(), comp.getCompParrafo(), comp.getCompImagen(), comp.getCompVideo(), comp.getCompMenu());
        return objetoComponente(componente);

    }

    public Componente objetoComponente(AgregarComponente comp) {
        String id = null, pagina = null, clase = null, texto = null, alineacion = null, color = null, origen = null, altura = null, ancho = null, padre = null;
        ArrayList<String> etiquetas = new ArrayList<>();
        if (comp.isEsImagen()) {
            ComponenteImagen img = comp.getCompImagen();
            Componente componente = new Componente(comp.getId(), comp.getPagina(), comp.getClase(), texto, img.getAlineacion(), color, img.getOrigen(), Integer.toString(img.getAltura()), Integer.toString(img.getAncho()), padre, etiquetas);
            return componente;
        } else if (comp.isEsMenu()) {
            ComponenteMenu menu = comp.getCompMenu();
            Componente componente = new Componente(comp.getId(), comp.getPagina(), comp.getClase(), texto, alineacion, color, origen, altura, ancho, menu.getPadre(), menu.getEtiquetas());
            return componente;
        } else if (comp.isEsParrafo()) {
            ComponenteParrafo parrafo = comp.getCompParrafo();
            Componente componente = new Componente(comp.getId(), comp.getPagina(), comp.getClase(), parrafo.getTexto(), parrafo.getAlineacion(), parrafo.getColor(), origen, altura, ancho, padre, etiquetas);
            return componente;
        } else if (comp.isEsTitulo()) {
            ComponenteTitulo titulo = comp.getCompTitulo();
            Componente componente = new Componente(comp.getId(), comp.getPagina(), comp.getClase(), titulo.getTexto(), titulo.getAlineacion(), color, origen, altura, ancho, padre, etiquetas);
            return componente;
        } else if (comp.isEsVideo()) {
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
