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

import finalproject.client.interfaces.ExerciseCategoryWebInterface;
import finalproject.client.service.ExerciseCategoryService;
import finalproject.model.ExerciseCategory;

@Path("/exercisecategory")
public class ExerciseCategoryResource {

	public static ExerciseCategoryWebInterface cexercisecategory = new ExerciseCategoryService()
			.getCRUD();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<ExerciseCategory> getCategories() {
		return cexercisecategory.getCategories();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createExerciseCategory(ExerciseCategory a) {

		int id = cexercisecategory.createExerciseCategory(a);
		if (id != -1) {
			return Response.status(Response.Status.OK).entity(id).build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ExerciseCategory getExerciseCategory(@PathParam("id") int id) {
		return cexercisecategory.readExerciseCategory(id);
	}

	@PUT
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateExerciseCategory(@PathParam("id") int id,
			ExerciseCategory json) {

		ExerciseCategory a = cexercisecategory.readExerciseCategory(id);

		if (a != null && json.getName() != null) {

			// aggionro i dati
			a.setName(json.getName());

			// aggiorno nel db
			int _id = cexercisecategory.updateExerciseCategory(a);

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
	public Response deleteExerciseCategory(@PathParam("id") int id) {

		if (cexercisecategory.deleteExerciseCategory(id)) {

			return Response.status(Response.Status.OK).build();

		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

}
