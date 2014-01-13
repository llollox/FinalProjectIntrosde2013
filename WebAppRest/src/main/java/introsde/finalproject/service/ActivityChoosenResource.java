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

import finalproject.client.interfaces.CRUDActivityChoosen;
import finalproject.client.service.ActivityChoosenService;
import finalproject.model.ActivityChoosen;

@Path("/activitychoosen")
public class ActivityChoosenResource {

	public static CRUDActivityChoosen cactivitychoosen = new ActivityChoosenService()
			.getCRUD();

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createActivityChoosen(ActivityChoosen a) {

		int id = cactivitychoosen.createActivityChoosen(a);
		if (id != -1) {
			return Response.status(Response.Status.OK).entity(id).build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ActivityChoosen getActivityChoosen(@PathParam("id") int id) {
		return cactivitychoosen.readActivityChoosen(id);
	}

	@PUT
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateActivityChoosen(@PathParam("id") int id,
			ActivityChoosen json) {

		ActivityChoosen a = cactivitychoosen.readActivityChoosen(id);

		if (a != null && json.getActivity() != null && json.getDate() != null
				&& json.getGoal() != null && json.getPerson() != null) {

			// aggionro i dati
			a.setActivity(json.getActivity());
			a.setDate(json.getDate());
			a.setGoal(json.getGoal());
			a.setPercentage(json.getPercentage());
			a.setPerson(json.getPerson());

			// aggiorno nel db
			int _id = cactivitychoosen.updateActivityChoosen(a);

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
	public Response deleteActivityChoosen(@PathParam("id") int id) {

		if (cactivitychoosen.deleteActivityChoosen(id)) {

			return Response.status(Response.Status.OK).build();

		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

}
