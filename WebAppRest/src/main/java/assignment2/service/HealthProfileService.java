package assignment2.service;

import it.unitn.sde.finalproject.CRUDPerson;
import it.unitn.sde.finalproject.CUHealthProfile;
import it.unitn.sde.finalproject.HealthProfile;
import it.unitn.sde.finalproject.Person;

import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import assignment2.hibernate.HealthProfileDB;
import assignment2.hibernate.PersonDB;

@Path("/person/{p_id}/healthprofile")
public class HealthProfileService {
	
	public static CRUDPerson cperson = new it.unitn.sde.finalproject.PersonService().getCRUD();
	public static CUHealthProfile chp = new it.unitn.sde.finalproject.HealthProfileService().getCRUD();
	
	/**
	 * GET POST
	 * 
	 * /person/{p_id}/healthprofile
	 */

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ArrayList<HealthProfile> getPersonHealthProfileHistory(
			@PathParam("p_id") Long p_id) {

//		ArrayList<HealthProfile> history = HealthProfileDB
//				.getPersonHealthProfileHistory(p_id);
//
//		return !history.isEmpty() ? history : null;
		return null;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ArrayList<HealthProfile> setHealthProfile(
			@PathParam("p_id") int p_id, HealthProfile json) {
		
		int hpId = chp.createHealthProfile(p_id, json);

//		if (dbPerson != null && json != null && json.getHeight() != null
//				&& json.getWeight() != null) {
//
//			// metto nella history il corrente perche ora lo aggiorno
//			HealthProfileDB.saveHealthProfile(new HealthProfile(dbPerson
//					.getPerson_id(), dbPerson.getWeight(),
//					dbPerson.getHeight(), dbPerson.getLastupdate()));
//
//			// aggiorno la persona col nuovo hp
//			dbPerson.setLastupdate(new Date());
//			dbPerson.setHeight(json.getHeight());
//			dbPerson.setWeight(json.getWeight());
//
//			dbPerson = PersonDB.updatePerson(dbPerson);
//		}
//
//		ArrayList<HealthProfile> history = HealthProfileDB
//				.getPersonHealthProfileHistory(p_id);
//
//		return !history.isEmpty() ? history : null;
		return null;
	}

	/**
	 * GET PUT DELETE
	 * 
	 * /person/{p_id}/healthprofile/{hp_id}
	 */

	@GET
	@Path("/{hp_id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public HealthProfile getHealthProfile(@PathParam("p_id") Long p_id,
			@PathParam("hp_id") Long hp_id) {

//		return HealthProfileDB.getSpecificHealthProfile(p_id, hp_id);
		return null;
	}

	@PUT
	@Path("/{hp_id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateHealthProfileX(@PathParam("p_id") Long p_id,
			@PathParam("hp_id") Long hp_id, HealthProfile newHp) {

//		HealthProfile dbHp = HealthProfileDB.getSpecificHealthProfile(p_id,
//				hp_id);
//		if (dbHp != null && newHp.getWeight() != null
//				&& newHp.getHeight() != null) {
//
//			dbHp.setHeight(newHp.getHeight());
//			dbHp.setWeight(newHp.getWeight());
//
//			dbHp = HealthProfileDB.updateHealthProfile(dbHp);
//
//			return Response.status(Response.Status.OK).entity(dbHp).build();
//		}
//
//		return Response.status(Response.Status.BAD_REQUEST).build();
		return null;
	}

	@DELETE
	@Path("/{hp_id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteHealthProfileX(@PathParam("p_id") Long p_id,
			@PathParam("hp_id") Long hp_id) {

//		HealthProfile hp = HealthProfileDB
//				.getSpecificHealthProfile(p_id, hp_id);
//
//		if (hp != null) {
//			HealthProfileDB.deleteHealthProfile(hp_id);
//
//			return Response.status(Response.Status.OK).entity(hp).build();
//		}
//
//		return Response.status(Response.Status.BAD_REQUEST).build();
		return null;
	}

}
