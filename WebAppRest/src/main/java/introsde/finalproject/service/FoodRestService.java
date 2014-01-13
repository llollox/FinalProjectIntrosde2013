package introsde.finalproject.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.food.client.Food;
import com.food.client.FoodService;
import com.introsde.adapters.yummly.models.Matches;
import com.introsde.adapters.yummly.models.Recipe;
import com.introsde.adapters.yummly.models.RecipeFinder;
import com.introsde.food.utils.QueryParams;

@Path("/food/recipes")
public class FoodRestService {

	Food foodService = new FoodService().getFood();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Matches> getRecipesByCalories() {

		RecipeFinder finder = foodService.getRecipes(new QueryParams());
		return finder.getMatches();
	}

	@GET
	@Path("/{recipeId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Recipe getRecipe(@PathParam("recipeId") String recipeId) {

		return foodService.getRecipe(recipeId);
	}
}
