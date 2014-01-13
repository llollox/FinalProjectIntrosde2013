package com.introsde.adapters.yummly;

import java.util.ArrayList;

import com.introsde.adapters.edamam.EdamamConnector;
import com.introsde.adapters.edamam.models.ENERC_KCAL;
import com.introsde.adapters.edamam.models.EdamamResponse;
import com.introsde.adapters.yummly.models.Matches;
import com.introsde.adapters.yummly.models.RecipeFinder;

public class Yummly {

	public static final String APP_ID_VALUE = "ad98c4ce";
	public static final String APP_KEY_VALUE = "034eea1cd3f52cdd3a742772fca0d859";

	public static final String APP_ID_KEY = "_app_id";
	public static final String APP_KEY_KEY = "_app_key";

	public static final String KCAL_MAX = "nutrition.ENERC_KCAL.max";
	public static final String KCAL_MIN = "nutrition.ENERC_KCAL.min";

	public static final String PROTEIN_MAX = "nutrition.PROCNT.max";
	public static final String PROTEIN_MIN = "nutrition.PROCNT.min";

	public static final String FAT_MAX = "nutrition.FAT.max";
	public static final String FAT_MIN = "nutrition.FAT.min";

	public static final String CARBOHYDRATE_MAX = "nutrition.CHOCDF.max";
	public static final String CARBOHYDRATE_MIN = "nutrition.CHOCDF.min";

	public static final String MAX_RESULTS = "maxResult";

	public static final String ALLOWED_INGREDIENT = "allowedIngredient[]";
	public static final String EXCLUDED_INGREDIENT = "excludedIngredient[]";

	public static final String SEARCH_TEXT = "q";

	public static final String ALLOWED_DIET = "allowedDiet[]";

	public static final String PESCETARIAN = "390^Pescetarian";
	public static final String LACTO_OVO_VEGETARIAN = "387^Lacto-ovo vegetarian";
	public static final String LACTO_VEGETARIAN = "388^Lacto vegetarian";
	public static final String OVO_VEGETARIAN = "389^Ovo vegetarian";

	public static void main(String[] args) {

		ArrayList<String> allowed = new ArrayList<String>(), excuded = new ArrayList<String>();

		allowed.add("oil");
		allowed.add("butter");
		allowed.add("vinegar");

		excuded.add("mint");
		excuded.add("chicken");

		RecipeFinder finder = YummlyConnector.getRecipes(allowed, excuded);

		p(finder);
	}

	static void p(RecipeFinder finder) {

		for (Matches m : finder.getMatches()) {

			EdamamResponse response = EdamamConnector.get(m.getIngredients());

			System.out.println("--------------------------");
			System.out.println(m.getRecipeName());
			System.out.println(m.getIngredients());
			System.out.println(response.getCalories());

			ENERC_KCAL kcal = response.getTotalDaily().getENERC_KCAL();
			System.out.println(kcal.getLabel() + " " + kcal.getQuantity() + " "
					+ kcal.getUnit());
			System.out.println(response.getHealthLabels());
			System.out.println(response.getDietLabels());
			System.out.println(m.getRating());
			System.out.println(m.getId());
		}
	}
}