package ar.com.curso.poi.controladores;

import javax.ws.rs.Path;
import javax.ws.rs.GET;

@Path("/")
public class ControladorHome {

	@GET
	@Path("/test")
	public String hola(){
		return "Test OK!";
	}
}
