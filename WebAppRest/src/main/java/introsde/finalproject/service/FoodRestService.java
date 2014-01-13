package introsde.finalproject.service;

import java.util.List;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.food.client.Food;
import com.food.client.FoodService;
import com.introsde.adapters.yummly.Yummly;
import com.introsde.adapters.yummly.models.Matches;
import com.introsde.adapters.yummly.models.Recipe;
import com.introsde.adapters.yummly.models.RecipeFinder;
import com.introsde.food.utils.KeyValuePair;
import com.introsde.food.utils.QueryParams;

@Path("/food")
public class FoodRestService {

	Food foodService = new FoodService().getFood();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Matches> getRecipesByCalories() {
		List<Matches> list;
		do {
			RecipeFinder finder = foodService.getRecipes(getRandomPrams());
			list = finder.getMatches();

		} while (list == null || list.size() < 10);

		for (Matches m : list)
			addImagesUrl(m.getSmallImageUrls());

		return list;
	}

	@GET
	@Path("/{recipeId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Recipe getRecipe(@PathParam("recipeId") String recipeId) {

		return foodService.getRecipe(recipeId);
	}

	private void addImagesUrl(List<String> listUrls) {

		String url = listUrls.get(0);

		listUrls.add(url.replace(".s.", ".m."));
		listUrls.add(url.replace(".s.", ".l."));
		listUrls.add(url.replace(".s.", ".xl."));

	}

	private Random rand = new Random(System.currentTimeMillis());

	private QueryParams getRandomPrams() {
		QueryParams params = new QueryParams();

		for (int n = 0; n < 2; n++) {
			params.add(new KeyValuePair(Yummly.ALLOWED_INGREDIENT, ingr[rand
					.nextInt(ingr.length)]));
		}

		return params;
	}

	String[] ingr = new String[] { "onion", "pepper", "butter", "cheese",
			"salad", "chicken", "chilly", "potato", "fish", "spaghetti",
			"tuna", "oil", "meat", "tomato", "bacon", "zucchini", "salami",
			"bread", "egg" };

}
