package introsde.finalproject.service;

import introsde.finalproject.utils.Utils;

import java.util.ArrayList;
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

import com.food.client.Food;
import com.food.client.FoodService;
import com.introsde.adapters.yummly.Yummly;
import com.introsde.adapters.yummly.models.Matches;
import com.introsde.adapters.yummly.models.Recipe;
import com.introsde.adapters.yummly.models.RecipeFinder;
import com.introsde.food.utils.KeyValuePair;
import com.introsde.food.utils.QueryParams;

import finalproject.client.interfaces.ExcludedFoodWebInterface;
import finalproject.client.interfaces.FavouriteFoodWebInterface;
import finalproject.client.interfaces.PersonWebInterface;
import finalproject.client.service.ExcludedFoodService;
import finalproject.client.service.FavouriteFoodService;
import finalproject.client.service.PersonService;
import finalproject.model.ExcludedFood;
import finalproject.model.FavouriteFood;
import finalproject.model.Person;

@Path("person/{p_id}/food")
public class FoodRestService {

	Food foodService = new FoodService().getFood();
	PersonWebInterface perSoap = new PersonService().getCRUD();

	FavouriteFoodWebInterface favSoap = new FavouriteFoodService().getCRUD();
	ExcludedFoodWebInterface exclSoap = new ExcludedFoodService().getCRUD();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Recipe> getRecipes(@PathParam("p_id") int p_id) {

		List<FavouriteFood> favouriteList = favSoap
				.getPersonsFavouriteFood(p_id);
		List<ExcludedFood> excludedList = exclSoap.getPersonsExcludedFood(p_id);

		QueryParams params = new QueryParams();

		for (FavouriteFood f : favouriteList)
			params.add(new KeyValuePair(Yummly.ALLOWED_INGREDIENT, f.getName()));

		for (ExcludedFood e : excludedList)
			params.add(new KeyValuePair(Yummly.ALLOWED_INGREDIENT, e.getName()));

		RecipeFinder finder = foodService.getRecipes(params);

		List<Matches> list = finder.getMatches();
		List<Recipe> recipeList = new ArrayList<Recipe>();

		for (Matches m : list)
			recipeList.add(foodService.getRecipe(m.getId()));

		return recipeList;
	}

	@GET
	@Path("/{recipeId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Recipe getRecipe(@PathParam("recipeId") String recipeId) {

		return foodService.getRecipe(recipeId);
	}

	// ********************************************************************
	// FAVOURITE
	// ********************************************************************

	@GET
	@Path("/favourite")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<FavouriteFood> readFavourites(@PathParam("p_id") int p_id) {

		Person p = perSoap.readPerson(p_id);

		if (p == null)
			return null;

		return favSoap.getPersonsFavouriteFood(p.getId());
	}

	@POST
	@Path("/favourite")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createFood(@PathParam("p_id") int p_id, FavouriteFood food) {

		Person p = perSoap.readPerson(p_id);

		if (p == null || food.getName() == null)
			return Response.status(Response.Status.BAD_REQUEST).build();

		food.setPerson(p);
		int id = favSoap.createFavouriteFood(food);

		if (id != -1)
			return Response.ok(favSoap.readFavouriteFood(id)).build();

		else
			return Response.status(Response.Status.BAD_REQUEST).build();
	}

	@PUT
	@Path("/favourite/{f_id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateFood(@PathParam("p_id") int p_id,
			@PathParam("f_id") int f_id, FavouriteFood food) {

		Person p = perSoap.readPerson(p_id);

		if (p == null || food.getName() == null)
			return Response.status(Response.Status.BAD_REQUEST).build();

		FavouriteFood old = favSoap.readFavouriteFood(f_id);

		if (p_id != old.getPerson().getId())
			return Response.status(Response.Status.BAD_REQUEST).build();

		old.setName(food.getName());

		int id = favSoap.updateFavouriteFood(old);

		if (id != -1)
			return Response.ok(favSoap.readFavouriteFood(id)).build();

		else
			return Response.status(Response.Status.BAD_REQUEST).build();
	}

	@DELETE
	@Path("/favourite/{f_id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteFood(@PathParam("p_id") int p_id,
			@PathParam("f_id") int f_id) {

		Person p = perSoap.readPerson(p_id);

		if (p == null)
			return Response.status(Response.Status.BAD_REQUEST).build();

		FavouriteFood food = favSoap.readFavouriteFood(f_id);

		if (p_id != food.getPerson().getId())
			return Response.status(Response.Status.BAD_REQUEST).build();

		if (favSoap.deleteFavouriteFood(f_id))
			return Response.ok(Utils.jsonId(f_id)).build();

		else
			return Response.status(Response.Status.BAD_REQUEST).build();
	}

	// ********************************************************************
	// EXCLUDED
	// ********************************************************************

	@GET
	@Path("/excluded")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<ExcludedFood> readExcluded(@PathParam("p_id") int p_id) {

		Person p = perSoap.readPerson(p_id);

		if (p == null)
			return null;

		return exclSoap.getPersonsExcludedFood(p.getId());
	}

	@POST
	@Path("/excluded")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createExcluded(@PathParam("p_id") int p_id,
			ExcludedFood food) {

		Person p = perSoap.readPerson(p_id);

		if (p == null || food.getName() == null)
			return Response.status(Response.Status.BAD_REQUEST).build();

		food.setPerson(p);
		int id = exclSoap.createExcludedFood(food);

		if (id != -1)
			return Response.ok(exclSoap.readExcludedFood(id)).build();

		else
			return Response.status(Response.Status.BAD_REQUEST).build();
	}

	@PUT
	@Path("/excluded/{f_id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateExcluded(@PathParam("p_id") int p_id,
			@PathParam("f_id") int f_id, ExcludedFood food) {

		Person p = perSoap.readPerson(p_id);

		if (p == null || food.getName() == null)
			return Response.status(Response.Status.BAD_REQUEST).build();

		ExcludedFood old = exclSoap.readExcludedFood(f_id);

		if (p_id != old.getPerson().getId())
			return Response.status(Response.Status.BAD_REQUEST).build();

		old.setName(food.getName());

		int id = exclSoap.updateExcludedFood(old);

		if (id != -1)
			return Response.ok(exclSoap.readExcludedFood(id)).build();

		else
			return Response.status(Response.Status.BAD_REQUEST).build();
	}

	@DELETE
	@Path("/excluded/{f_id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteExcluded(@PathParam("p_id") int p_id,
			@PathParam("f_id") int f_id) {

		Person p = perSoap.readPerson(p_id);

		if (p == null)
			return Response.status(Response.Status.BAD_REQUEST).build();

		ExcludedFood food = exclSoap.readExcludedFood(f_id);

		if (p_id != food.getPerson().getId())
			return Response.status(Response.Status.BAD_REQUEST).build();

		if (exclSoap.deleteExcludedFood(f_id))
			return Response.ok(Utils.jsonId(f_id)).build();

		else
			return Response.status(Response.Status.BAD_REQUEST).build();
	}

}
