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

import finalproject.client.interfaces.CRUDExerciseHistory;
import finalproject.client.service.ExerciseHistoryService;
import finalproject.model.ExerciseHistory;

@Path("/exercisehistory")
public class ExerciseHistoryResource {

	public static CRUDExerciseHistory cexercisehistory = new ExerciseHistoryService()
			.getCRUD();

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createExerciseHistory(ExerciseHistory a) {

		int id = cexercisehistory.createExerciseHistory(a);
		if (id != -1) {
			return Response.status(Response.Status.OK).entity(id).build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ExerciseHistory getExerciseHistory(@PathParam("id") int id) {
		return cexercisehistory.readExerciseHistory(id);
	}

	@PUT
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateExerciseHistory(@PathParam("id") int id,
			ExerciseHistory json) {

		ExerciseHistory a = cexercisehistory.readExerciseHistory(id);

		if (a != null && json.getActivityChoosen() != null
				&& json.getDate() != null && json.getExercise() != null
				&& json.getPerson() != null) {

			// aggionro i dati
			a.setActivityChoosen(json.getActivityChoosen());
			a.setDate(json.getDate());
			a.setExercise(json.getExercise());
			a.setPerson(json.getPerson());

			// aggiorno nel db
			int _id = cexercisehistory.updateExerciseHistory(a);

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
	public Response deleteExerciseHistory(@PathParam("id") int id) {

		if (cexercisehistory.deleteExerciseHistory(id)) {

			return Response.status(Response.Status.OK).build();

		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

}
