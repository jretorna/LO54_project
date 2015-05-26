package fr.utbm.concentrateur.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/collect")
public class SpringCollectBean {

	
	@GET
	public String getReleve() {
		return "get releve";
	}
}
