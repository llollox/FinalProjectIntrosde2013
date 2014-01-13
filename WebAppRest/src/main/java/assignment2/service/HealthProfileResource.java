package assignment2.service;

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

import finalproject.client.interfaces.CRUDHealthProfile;
import finalproject.client.service.HealthProfileService;
import finalproject.client.service.PersonService;
import finalproject.model.HealthProfile;
import finalproject.model.Person;

@Path("/healthprofile")
public class HealthProfileResource {

	public static CRUDHealthProfile chealthprofile = new HealthProfileService()
			.getCRUD();

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createHealthProfile(HealthProfile a) {

		int id = chealthprofile.createHealthProfile(a.getPersonId(), a);
		if (id != -1) {
			return Response.status(Response.Status.OK).entity(id).build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public HealthProfile getHealthProfile(@PathParam("id") int id) {
		return chealthprofile.readHealthProfile(id);
	}

	@PUT
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateHealthProfile(@PathParam("id") int id,
			HealthProfile json) {

		HealthProfile a = chealthprofile.readHealthProfile(id);
		Person p = new PersonService().getCRUD().readPerson(a.getPersonId());

		if (a != null && p != null && json.getDate() != null) {

			// aggionro i dati
			a.setMinbloodpressure(json.getMinbloodpressure());
			a.setMaxbloodpressure(json.getMaxbloodpressure());
			a.setDate(json.getDate());
			a.setHeartrate(json.getHeartrate());
			a.setHeight(json.getHeight());
			a.setWeight(json.getWeight());

			// aggiorno nel db
			int _id = chealthprofile.updateHealthProfile(json.getPersonId(), a);

			if (_id != -1) // data successiful updated!
				return Response.status(Response.Status.OK).entity(a).build();
			else
				return Response.status(Response.Status.BAD_REQUEST).build();

		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@DELETE
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteHealthProfile(@PathParam("id") int id) {

		if (chealthprofile.deleteHealthProfile(id)) {

			return Response.status(Response.Status.OK).build();

		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

}
