package ar.com.curso.poi.objetos;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

public class Mapa {

	String nombre;
	List<Poi> pois;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Poi> getPois() {
		return pois;
	}

	public void setPois(List<Poi> pois) {
		this.pois = pois;
	}

}
