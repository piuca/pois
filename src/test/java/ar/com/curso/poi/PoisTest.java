package ar.com.curso.poi;

import ar.com.curso.poi.acciones.AccionesUsuario;
import ar.com.curso.poi.home.PoiHome;
import ar.com.curso.poi.home.ServicioHome;
import ar.com.curso.poi.objetos.Poi;
import ar.com.curso.poi.objetos.Servicio;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PoisTest {

	@Test
	public void testAiniciarServicios() {
		System.out.println("TEST 1: iniciarServicios");
		List<Servicio> servicios = AccionesUsuario.getServicios();
		// Devuelve el primer poi que encuentra y muestra su descripccion
		System.out.println("	Primer poi: " + servicios.get(0).getMapas().get(0).getPois().get(0).getDescripccion());
		System.out.println("Success!!");
	}

	@Test
	public void testBgetListPois() {
		System.out.println("TEST 2: getListPois");
		List<Poi> pois = ServicioHome.getListPois();
		for (Poi poi : pois) {
			System.out.println("	" + poi.descripccion + " Latitud: " + poi.x + " Longitud: " + poi.y);
		}
		System.out.println("Success!!");
	}

	@Test
	public void testCcalcularMasCercano() {
		System.out.println("TEST 3: calcularMasCercano");
		List<Servicio> servicios = AccionesUsuario.getServicios();
		// Obelisco (Lo mas cerca son Las Cuartetas)
		Poi poi = PoiHome.calcularMasCercano(servicios.get(0), -34.6037389, -58.38157039999999);
		Assert.assertTrue(poi.getDescripccion().equals("Las Cuartetas"));
		// Plaza Gral Lavalle (Lo mas cerca es el Teatro Colon)
		poi = PoiHome.calcularMasCercano(servicios.get(0), -34.60117460665871, -58.38461995124817);
		System.out.println("	" + poi.getDescripccion());
		// Cablevision (Lo mas cerca es pizzeria Los Campeones)
		poi = PoiHome.calcularMasCercano(servicios.get(0), -34.635820887967405, -58.374974727630615);
		System.out.println("	" + poi.getDescripccion());
		System.out.println("Success!!");
	}

	@Test
	public void testDagregarPoi() {
		System.out.println("TEST 4: agregarPoi");
		AccionesUsuario.agregarPoi(-34.609811042055554, -58.39261293411255, "Congreso de la Nacion", 10,
				"Buenos Aires Historico", "Turisticos");
		Poi poi = PoiHome.findPoiByNombre("Congreso de la Nacion");
		System.out.println("	" + poi.getX() + " " + poi.getY() + " " + poi.getDescripccion());
		System.out.println("Success!!");
	}
	
	@Test
	public void testEpoisEnRadioKm() {
		System.out.println("TEST 4: poisEnRadioKm");
		// Devuelve la lista de los pois en el radio de 0.3KM al Obelisco
		//List<Poi> poisEnRadio = AccionesUsuario.poisEnRadio(0.3, -34.6037389, -58.38157039999999);
		/*Assert.assertTrue(poisEnRadio.size() == 1);
		for (Poi poi : poisEnRadio) {
			System.out.println("	" + poi.getDescripccion());
		}*/
		System.out.println("Success!!");
	}
}
