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

import finalproject.client.interfaces.CRUDExercise;
import finalproject.client.service.ExerciseService;
import finalproject.model.Exercise;

@Path("/exercise")
public class ExerciseResource {

	public static CRUDExercise cexercise = new ExerciseService().getCRUD();

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createExercise(Exercise a) {

		int id = cexercise.createExercise(a);
		if (id != -1) {
			return Response.status(Response.Status.OK).entity(id).build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Exercise getExercise(@PathParam("id") int id) {
		return cexercise.readExercise(id);
	}

	@PUT
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateExercise(@PathParam("id") int id, Exercise json) {

		Exercise a = cexercise.readExercise(id);

		if (a != null && json.getDescription() != null) {

			// aggiorno i dati
			a.setAerobic(json.getAerobic());
			a.setDescription(json.getDescription());
			a.setDifficultyvalue(json.getDifficultyvalue());

			// aggiorno nel db
			int _id = cexercise.updateExercise(a);

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
	public Response deleteExercise(@PathParam("id") int id) {

		if (cexercise.deleteExercise(id)) {

			return Response.status(Response.Status.OK).build();

		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

}
