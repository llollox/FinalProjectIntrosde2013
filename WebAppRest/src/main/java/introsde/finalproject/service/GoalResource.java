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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import finalproject.client.interfaces.GoalWebInterface;
import finalproject.client.service.GoalService;
import finalproject.model.Goal;

@Path("/goal")
public class GoalResource {

	public static GoalWebInterface cgoal = new GoalService().getCRUD();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Goal> getGoals() {
		return cgoal.getGoals();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createGoal(Goal a) {

		int id = cgoal.createGoal(a);
		if (id != -1) {
			return Response.status(Response.Status.OK).entity(id).build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Goal getGoal(@PathParam("id") int id) {
		return cgoal.readGoal(id);
	}

	@PUT
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateGoal(@PathParam("id") int id, Goal json) {

		Goal a = cgoal.readGoal(id);

		if (a != null && json.getName() != null) {

			a.setName(json.getName());

			// aggiorno nel db
			int _id = cgoal.updateGoal(a);

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
	public Response deleteGoal(@PathParam("id") int id) {

		if (cgoal.deleteGoal(id)) {

			return Response.status(Response.Status.OK).build();

		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	/**
	 * GET
	 * 
	 * /goal/link?idgoal={id_g}&idactivity={id_a}
	 */
	@GET
	@Path("/link")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response link(@QueryParam("idgoal") int idgoal,
			@QueryParam("idactivity") int idactivity) {

		cgoal.linkActivity(idgoal, idactivity);

		return Response.ok().build();
	}

}
