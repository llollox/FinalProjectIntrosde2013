import it.unitn.sde.finalproject.Food;
import it.unitn.sde.finalproject.FoodService;
import it.unitn.sde.finalproject.Matches;
import it.unitn.sde.finalproject.ReceiptFinder;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Food recipeReader = new FoodService().getFood();

		ReceiptFinder r = recipeReader.getRecipesByCalories(200, 250, 20);

		for (Matches m : r.getMatches())
			System.out.println(recipeReader.getRecipe(m.getId()).getName());

	}

}
