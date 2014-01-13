package assignment2.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.food.client.Food;
import com.food.client.FoodService;
import com.introsde.adapters.yummly.models.Matches;
import com.introsde.adapters.yummly.models.Recipe;
import com.introsde.adapters.yummly.models.RecipeFinder;

@Path("/food/recipe")
public class FoodRestService {

	Food foodService = new FoodService().getFood();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Matches> getRecipesByCalories(
			@QueryParam("max") Integer maxKcal,
			@QueryParam("min") Integer minKcal,
			@QueryParam("maxResults") Integer maxResults) {

		if (maxKcal == null)
			maxKcal = 5000;

		if (minKcal == null)
			minKcal = 0;

		if (maxResults == null)
			maxResults = 20;

		RecipeFinder finder = foodService.getRecipes(null);
		return finder.getMatches();
	}

	@GET
	@Path("/{recipeId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Recipe getRecipe(@PathParam("recipeId") String recipeId) {

		return foodService.getRecipe(recipeId);
	}
}
