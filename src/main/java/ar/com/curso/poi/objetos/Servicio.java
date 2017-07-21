package ar.com.curso.poi.objetos;

import java.util.List;

public class Servicio {

	String nombre;
	List<Mapa> mapas;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Mapa> getMapas() {
		return mapas;
	}

	public void setMapas(List<Mapa> mapa) {
		this.mapas = mapa;
	}

}
