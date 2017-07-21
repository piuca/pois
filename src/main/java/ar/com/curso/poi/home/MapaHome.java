package ar.com.curso.poi.home;

import ar.com.curso.poi.acciones.AccionesUsuario;
import ar.com.curso.poi.objetos.Mapa;
import ar.com.curso.poi.objetos.Poi;
import ar.com.curso.poi.objetos.Servicio;
import java.util.List;



public class MapaHome {

    public static Mapa findMapaByNombreYServicio(Servicio servicio, String name) {
            for (Mapa mapa : servicio.getMapas()) {
                  if (mapa.getNombre().equals(name)) {
                        return mapa;
                  }
            }
            return null;
      }

	public static Mapa findMapaByNombre(String name) {
		for (Servicio servicio : AccionesUsuario.getServicios()) {
			for (Mapa mapa : servicio.getMapas()) {
				if (mapa.getNombre().equals(name)) {
					return mapa;
				}
			}
		}
		return null;
	}

	public static void alta(Servicio servicio, String nombre, List<Poi> pois) {
		Mapa map = new Mapa();
		map.setNombre(nombre);
		map.setPois(pois);
		servicio.getMapas().add(map);
	}

}