package introsde.finalproject.service;

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

import finalproject.client.interfaces.HealthProfileWebInterface;
import finalproject.client.service.HealthProfileService;
import finalproject.model.HealthProfile;

@Path("/person/{p_id}/healthprofile")
public class HealthProfileResource {

	public static HealthProfileWebInterface soap = new HealthProfileService()
			.getCRUD();

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createHealthProfile(@PathParam("p_id") int pid,
			HealthProfile hp) {

		int hp_id = soap.createHealthProfile(pid, hp);
		if (hp_id != -1) {
			return Response.status(Response.Status.OK)
					.entity(soap.readHealthProfile(pid, hp_id)).build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/{hp_id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public HealthProfile getHealthProfile(@PathParam("p_id") int pid,
			@PathParam("hp_id") int hp_id) {
		return soap.readHealthProfile(pid, hp_id);
	}

	@PUT
	@Path("/{hp_id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateHealthProfile(@PathParam("p_id") int pid,
			@PathParam("hp_id") int hp_id, HealthProfile json) {

		json.setId(hp_id);
		// aggiorno nel db
		int id = soap.updateHealthProfile(pid, json);

		if (id != -1) // data successiful updated!
			return Response.status(Response.Status.OK)
					.entity(soap.readHealthProfile(pid, hp_id)).build();
		else
			return Response.status(Response.Status.BAD_REQUEST).build();

	}

	@DELETE
	@Path("/{hp_id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteHealthProfile(@PathParam("p_id") int pid,
			@PathParam("hp_id") int hp_id) {

		if (soap.deleteHealthProfile(pid, hp_id) != -1) {

			return Response.status(Response.Status.OK).build();

		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

}
