//package assignment2.service;
//
//
//import it.unitn.sde.finalproject.Food;
//import it.unitn.sde.finalproject.FoodService;
//import it.unitn.sde.finalproject.Matches;
//import it.unitn.sde.finalproject.Receipt;
//import it.unitn.sde.finalproject.ReceiptFinder;
//
//import java.util.List;
//
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
//import javax.ws.rs.core.MediaType;
//
//@Path("/food/recipe")
//public class FoodRestService {
//
//	@GET
//	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	public List<Matches> getRecipesByCalories(
//			@QueryParam("max") Integer maxKcal,
//			@QueryParam("min") Integer minKcal,
//			@QueryParam("maxResults") Integer maxResults) {
//
//		Food foodService = new FoodService().getFood();
//
//		if (maxKcal == null)
//			maxKcal = 5000;
//
//		if (minKcal == null)
//			minKcal = 0;
//
//		if (maxResults == null)
//			maxResults = 20;
//
//		ReceiptFinder finder = foodService.getRecipesByCalories(minKcal,
//				maxKcal, maxResults);
//		return finder.getMatches();
//	}
//
//	@GET
//	@Path("/{recipeId}")
//	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	public Receipt getRecipe(@PathParam("recipeId") String recipeId) {
//
//		Food foodService = new FoodService().getFood();
//
//		return foodService.getRecipe(recipeId);
//	}
//}
