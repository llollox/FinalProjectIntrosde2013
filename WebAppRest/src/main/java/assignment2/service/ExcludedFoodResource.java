package assignment2.service;

import it.unitn.sde.finalproject.CRUDExcludedFood;
import it.unitn.sde.finalproject.ExcludedFood;
import it.unitn.sde.finalproject.ExcludedFoodService;

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

@Path("/excludedfood")
public class ExcludedFoodResource {
	
	public static CRUDExcludedFood cexcludedfood = new ExcludedFoodService().getCRUD();

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createExcludedFood(ExcludedFood a) {
		
		int id = cexcludedfood.createExcludedFood(a);
		cexcludedfood.createExcludedFood(a);
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
	public ExcludedFood getExcludedFood(@PathParam("id") int id) {
		return cexcludedfood.readExcludedFood(id);
	}

	@PUT
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateExcludedFood(@PathParam("id") int id, ExcludedFood json) {

		ExcludedFood a = cexcludedfood.readExcludedFood(id);

		if (a != null && json.getName() != null
				&& json.getPerson() != null) {

			// aggionro i dati
			a.setName(json.getName());
			a.setPerson(json.getPerson());

			// aggiorno nel db
			int _id = cexcludedfood.updateExcludedFood(a);
			
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
	public Response deleteExcludedFood(@PathParam("id") int id) {

		if (cexcludedfood.deleteExcludedFood(id)) {

			return Response.status(Response.Status.OK).build();

		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

}
