package ar.com.curso.poi.home;

import ar.com.curso.poi.acciones.AccionesUsuario;
import ar.com.curso.poi.objetos.Mapa;
import ar.com.curso.poi.objetos.Poi;
import ar.com.curso.poi.objetos.Servicio;
import java.util.ArrayList;
import java.util.List;



public class ServicioHome {

	public static List<Poi> getListPois() {
		List<Poi> pois = new ArrayList<Poi>();
		for (Servicio servicios : AccionesUsuario.getServicios()) {
			for (Mapa mapa : servicios.getMapas()) {
				pois.addAll(mapa.getPois());
			}
		}
		return pois;
	}

	public static Servicio findServicioByNombre(String name) {
		for (Servicio servicio : AccionesUsuario.getServicios()) {
			if (servicio.getNombre().equals(name)) {
				return servicio;
			}
		}
		return null;
	}

}
