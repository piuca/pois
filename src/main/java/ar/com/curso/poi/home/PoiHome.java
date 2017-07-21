package ar.com.curso.poi.home;

import ar.com.curso.poi.acciones.AccionesUsuario;
import ar.com.curso.poi.objetos.Mapa;
import ar.com.curso.poi.objetos.Poi;
import ar.com.curso.poi.objetos.Servicio;


public class PoiHome {

	public static double calcularDistancia(Poi poi, double x, double y) {
		double radioTierra = 6371;// en kil�metros
		double dLat = Math.toRadians(x - poi.getX());
		double dLng = Math.toRadians(y - poi.getY());
		double sindLat = Math.sin(dLat / 2);
		double sindLng = Math.sin(dLng / 2);
		double va1 = Math.pow(sindLat, 2)
				+ Math.pow(sindLng, 2) * Math.cos(Math.toRadians(poi.getX())) * Math.cos(Math.toRadians(x));
		double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
		double distancia = radioTierra * va2;

		return distancia;

		// Calculo sin tomar en cuenta curvatura de la tierra
		// double cateto1 = x - poi.getX();
		// double cateto2 = y - poi.getY();
		// double hipotenusa = Math.sqrt(cateto1 * cateto1 + cateto2 * cateto2);
		// return hipotenusa;
	}

	public static Poi calcularMasCercano(Servicio ser, double x, double y) {
		double auxDistancia = 0;
		Poi auxPoi = null;
		for (Mapa mapa : ser.getMapas()) {
			for (Poi poi : mapa.getPois()) {
				if (auxDistancia == 0) {
					auxPoi = poi;
					auxDistancia = calcularDistancia(poi, x, y);
				} else {
					double dis = calcularDistancia(poi, x, y);
					if (dis < auxDistancia) {
						auxDistancia = dis;
						auxPoi = poi;
					}
				}
			}
		}
		return auxPoi;
	}

	public static Poi findPoiByNombre(String name) {
		for (Servicio servicio : AccionesUsuario.getServicios()) {
			for (Mapa mapa : servicio.getMapas()) {
				for (Poi poi : mapa.getPois()) {
					if (poi.getDescripccion().equals(name)) {
						return poi;
					}
				}
			}
		}
		return null;
	}
}
