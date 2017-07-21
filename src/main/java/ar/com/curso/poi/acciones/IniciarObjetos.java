package ar.com.curso.poi.acciones;

import ar.com.curso.poi.objetos.Mapa;
import ar.com.curso.poi.objetos.Poi;
import ar.com.curso.poi.objetos.Servicio;
import java.util.ArrayList;
import java.util.List;

public class IniciarObjetos {

	public static List<Servicio> iniciarServicios() {
		Servicio ser = new Servicio();
		ser.setNombre("buenos-aires");
		ser.setMapas(IniciarObjetos.iniciarMapas());
		List<Servicio> listServicios = new ArrayList<Servicio>();
		listServicios.add(ser);
		AccionesUsuario.setServicios(listServicios);
		return listServicios;
	}

	public static List<Mapa> iniciarMapas() {
		List<Mapa> listaMapas = new ArrayList<Mapa>();
		Mapa map = new Mapa();
		map.setNombre("Pizzerias");
		map.setPois(IniciarObjetos.iniciarPizerias());
		listaMapas.add(map);
		map = new Mapa();
		map.setNombre("Teatros");
		map.setPois(IniciarObjetos.iniciarTeatros());
		listaMapas.add(map);
		map = new Mapa();
		map.setNombre("Turisticos");
		map.setPois(IniciarObjetos.iniciarTuristicos());
		listaMapas.add(map);
		return listaMapas;
	}

	public static List<Poi> iniciarPizerias() {
		List<Poi> listaPois = new ArrayList<Poi>();
		listaPois.add(new Poi(-34.60375, -58.37857459999998, "Las Cuartetas", 10));
		listaPois.add(new Poi(-34.6033254, -58.37733479999997, "El palacio de la pizza", 10));
		listaPois.add(new Poi(-34.5978366, -58.385456499999975, "El Cuartito", 10));
		listaPois.add(new Poi(-34.6380618, -58.37459510000002, "Los Campeones", 10));
		listaPois.add(new Poi(-34.593858, -58.388540000000035, "Los Maestros", 10));
		listaPois.add(new Poi(-34.635339, -58.35865609999996, "Banchero La Boca", 10));
		listaPois.add(new Poi(-34.6040836, -58.385822899999994, "Guerrin", 9));
		listaPois.add(new Poi(-34.624068, -58.51163700000001, "El Fortin", 10));
		listaPois.add(new Poi(-34.616778, -58.38578699999999, "El mazacote", 10));
		listaPois.add(new Poi(-34.6175461, -58.37171810000001, "Pirilo", 1));
		listaPois.add(new Poi(-34.5898819, -58.436939499999994, "Angelin", 12));
		return listaPois;
	}

	public static List<Poi> iniciarTeatros() {
		List<Poi> listaPois = new ArrayList<Poi>();
		listaPois.add(new Poi(-34.5872593, -58.373786199999984, "San Paolo", 10));
		listaPois.add(new Poi(-34.6087392, -58.43202740000004, "El coliseo", 10));
		listaPois.add(new Poi(-34.60103330781445, -58.38308572769165, "Colon", 10));
		// listaPois.add(new Poi(-34.6037925, -58.37889340000004, "Opera", 10));
		listaPois.add(new Poi(-34.6042735, -58.38849749999997, "San Martin", 10));
		listaPois.add(new Poi(-34.5989248, -58.3838528, "Cervantes", 10));
		listaPois.add(new Poi(-34.603059, -58.37787100000003, "El maipo", 10));
		listaPois.add(new Poi(-34.5963107, -58.3920248, "La comedia", 10));
		listaPois.add(new Poi(-34.5966705, -58.3835469, "Teatro del globo", 10));
		return listaPois;
	}

	public static List<Poi> iniciarTuristicos() {
		List<Poi> listaPois = new ArrayList<Poi>();
		listaPois.add(new Poi(-34.6087392, -58.373786199999984, "Cabildo", 10));
		listaPois.add(new Poi(-34.6075694, -58.3732574, "Catedral", 10));
		listaPois.add(new Poi(-20.4547765, -54.60207120000001, "Convento San Francisco", 10));
		return listaPois;
	}

}
