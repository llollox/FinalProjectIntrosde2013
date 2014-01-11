package assignment2.service;

import java.util.List;

import it.unitn.sde.finalproject.Goal;
import it.unitn.sde.finalproject.GoalService;
import it.unitn.sde.finalproject.CRUDGoal;
import it.unitn.sde.finalproject.CRUDPerson;
import it.unitn.sde.finalproject.Person;
import it.unitn.sde.finalproject.PersonService;

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

@Path("/goal")
public class GoalResource {
	
	public static CRUDGoal cgoal = new GoalService().getCRUD();

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
		if (id != -1){
			return Response.status(Response.Status.OK).entity(id).build();
		} 
		else {
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

		if (a != null
				&& json.getEnddate() != null
				&& json.getName() != null
				&& json.getValue() != null) {

			// aggionro i dati
			a.setEnddate(json.getEnddate());
			a.setName(json.getName());
			a.setValue(json.getValue());

			// aggiorno nel db
			int _id = cgoal.updateGoal(a);
			
			if (_id != -1) //data successiful updated!
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

}
