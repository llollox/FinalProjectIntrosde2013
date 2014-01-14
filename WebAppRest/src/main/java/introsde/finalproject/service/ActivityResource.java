package introsde.finalproject.service;

import java.util.List;

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

import finalproject.client.interfaces.ActivityWebInterface;
import finalproject.client.service.ActivityService;
import finalproject.model.Activity;

@Path("/activity")
public class ActivityResource {

	public static ActivityWebInterface cactivity = new ActivityService()
			.getCRUD();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Activity> getActivities() {
		return cactivity.getActivities();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createActivity(Activity a) {

		int id = cactivity.createActivity(a);
		if (id != -1) {
			return Response.status(Response.Status.OK).entity(id).build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Activity getActivity(@PathParam("id") int id) {
		return cactivity.readActivity(id);
	}

	@PUT
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateActivity(@PathParam("id") int id, Activity json) {

		Activity a = cactivity.readActivity(id);

		if (a != null && json.getDescription() != null) {

			// aggionro i dati
			a.setActivitygroup(json.getActivitygroup());
			a.setAerobic(json.getAerobic());
			a.setDescription(json.getDescription());
			a.setType(json.getType());
			a.setValue(json.getValue());

			// aggiorno nel db
			int _id = cactivity.updateActivity(a);

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
	public Response deleteActivity(@PathParam("id") int id) {

		if (cactivity.deleteActivity(id)) {

			return Response.status(Response.Status.OK).build();

		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

}
