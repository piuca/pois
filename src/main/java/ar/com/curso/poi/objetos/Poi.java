package ar.com.curso.poi.objetos;


public class Poi implements Comparable<Poi>{

	public double x;
	public double y;
	public String descripccion;
	public int itinerario;

	public Poi(double x, double y, String descripcion, int itinerario) {
		this.x = x;
		this.y = y;
		this.descripccion = descripcion;
		this.itinerario = itinerario;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String getDescripccion() {
		return descripccion;
	}

	public void setDescripccion(String descripccion) {
		this.descripccion = descripccion;
	}

	public int getItinerario() {
		return itinerario;
	}

	public void setItinerario(int itinerario) {
		this.itinerario = itinerario;
	}

	public int compareTo(Poi o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
