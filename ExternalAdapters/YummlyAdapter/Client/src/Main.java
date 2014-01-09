import sun.nio.cs.ext.MacHebrew;
import it.unitn.sde.finalproject.Matches;
import it.unitn.sde.finalproject.ReadRecipes;
import it.unitn.sde.finalproject.ReadRecipesService;
import it.unitn.sde.finalproject.ReceiptFinder;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ReadRecipes recipeReader = new ReadRecipesService().getReadRecipes();

		ReceiptFinder r = recipeReader.getSpecificRecipe(200, 250, 20);

		for (Matches m : r.getMatches())
			System.out.println(recipeReader.getRecipe(m.getId()));
		
		
		
	}

}
