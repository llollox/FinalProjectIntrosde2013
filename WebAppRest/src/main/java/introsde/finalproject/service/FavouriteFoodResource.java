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

import finalproject.client.interfaces.CRUDFavouriteFood;
import finalproject.client.service.FavouriteFoodService;
import finalproject.model.FavouriteFood;

@Path("/favouritefood")
public class FavouriteFoodResource {

	public static CRUDFavouriteFood cfavouritefood = new FavouriteFoodService()
			.getCRUD();

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createFavouriteFood(FavouriteFood a) {

		int id = cfavouritefood.createFavouriteFood(a);
		if (id != -1) {
			return Response.status(Response.Status.OK).entity(id).build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public FavouriteFood getFavouriteFood(@PathParam("id") int id) {
		return cfavouritefood.readFavouriteFood(id);
	}

	@PUT
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateFavouriteFood(@PathParam("id") int id,
			FavouriteFood json) {

		FavouriteFood a = cfavouritefood.readFavouriteFood(id);

		if (a != null && json.getName() != null && json.getPerson() != null) {

			// aggionro i dati
			a.setName(json.getName());
			a.setPerson(json.getPerson());

			// aggiorno nel db
			int _id = cfavouritefood.updateFavouriteFood(a);

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
	public Response deleteFavouriteFood(@PathParam("id") int id) {

		if (cfavouritefood.deleteFavouriteFood(id)) {

			return Response.status(Response.Status.OK).build();

		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

}
