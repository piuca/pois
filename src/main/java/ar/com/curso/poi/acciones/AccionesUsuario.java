package ar.com.curso.poi.acciones;

import ar.com.curso.poi.home.MapaHome;
import ar.com.curso.poi.home.PoiHome;
import ar.com.curso.poi.home.ServicioHome;
import ar.com.curso.poi.objetos.Mapa;
import ar.com.curso.poi.objetos.Poi;
import ar.com.curso.poi.objetos.Servicio;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class AccionesUsuario {

    static List<Servicio> servicios = null;

    public AccionesUsuario() {
        if (servicios == null) {
            IniciarObjetos.iniciarServicios();
        }
    }

    public static void agregarPoi(double x, double y, String descripccion, int itinerario, String nombreServicio,
            String nombreMapa) {
        Poi poi = new Poi(x, y, descripccion, itinerario);
        Servicio servicio = ServicioHome.findServicioByNombre(nombreServicio);
        if (servicio == null) {
            System.out.println("El servicio no existe");
        } else {
            Mapa mapa = MapaHome.findMapaByNombre(nombreMapa);
            if (mapa == null) {

                List<Poi> pois = new ArrayList<Poi>();
                pois.add(poi);
                MapaHome.alta(servicio, nombreMapa, pois);
            } else {
                mapa.getPois().add(poi);
            }
        }
    }

    @GET
    @Path("/test/nuevo")
    public String smoke() {
        return "OK nuevo";
    }

    @GET
    @Path("/poi-mas-cercano/{servicio}/{x}/{y}")
    public static String calcularMasCercano(@PathParam("servicio") String servicio, @PathParam("x") double x,
            @PathParam("y") double y) {
        Servicio ser = ServicioHome.findServicioByNombre(servicio);
        
        if (ser == null) {
            return "No se encontro el Servicio";
        }
        Poi poi = PoiHome.calcularMasCercano(ser, x, y);
        Gson gson = new Gson();
        return gson.toJson(poi);
    }

    @GET
    @Path("/poi-en-radio/{servicio}/{i}/{x}/{y}")
    public static String poisEnRadio(@PathParam("servicio") String servicioString, @PathParam("i") double i, @PathParam("x") double x,
            @PathParam("y") double y) {
        List<Poi> poisEnRadio = new ArrayList<Poi>();
        String poisString = "";
        Servicio servicio = ServicioHome.findServicioByNombre(servicioString);
        if(servicio == null){
            return "No se encontro el servicio";
        }
        for (Mapa mapa : servicio.getMapas()) {
            for (Poi poi : mapa.getPois()) {
                if (PoiHome.calcularDistancia(poi, x, y) < i) {
                    poisEnRadio.add(poi);
                    poisString = poisString + " - " + poi.getDescripccion();
                }
            }
        }
        
        return poisString;
    }

    @GET
    @Path("/pois-por-mapa/{servicio}/{mapa}")
    public static String listaPoisByMapa(@PathParam("servicio") String servicioString, @PathParam("mapa") String mapaString) {
        List<Poi> listaPois = new ArrayList<Poi>();
        Servicio ser = ServicioHome.findServicioByNombre(servicioString);
        String poisString = "";
        if (ser == null) {
            return "No se encontro el Servicio";
        }
        Mapa map = MapaHome.findMapaByNombreYServicio(ser, mapaString);
        if (map == null) {
            return "No se encontro el Mapa";
        }
        
        for (Poi poi : map.getPois()) {
            poisString = poisString + " - " + poi.getDescripccion();
        }
        return poisString;
    }

    @GET
    @Path("/itinerario-por-servicio/{servicio}")
    public static String listaPoisByServicio(@PathParam("servicio") String servicioString) {
        List<Poi> listaPois = new ArrayList<Poi>();
        Servicio ser = ServicioHome.findServicioByNombre(servicioString);
        String poisString = "";
        if (ser == null) {
            return "No se encontro el Servicio";
        }
        for (Mapa mapa : ser.getMapas()) {
            listaPois.addAll(mapa.getPois());
        }
        Collections.sort(listaPois);
        
        for (Poi poi : listaPois) {
            poisString = poisString + " - " + poi.getDescripccion();
        }
        return poisString;
    }
    
    public static List<Servicio> getServicios() {
        if (servicios == null) {
            IniciarObjetos.iniciarServicios();
        }
        return servicios;
    }

    public static void setServicios(List<Servicio> servicios) {
        AccionesUsuario.servicios = servicios;
    }

}
