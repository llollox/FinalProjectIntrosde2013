package com.food.client;

import java.util.ArrayList;
import java.util.List;

import com.introsde.adapters.edamam.models.ENERC_KCAL;
import com.introsde.adapters.edamam.models.EdamamResponse;
import com.introsde.adapters.yummly.Yummly;
import com.introsde.adapters.yummly.models.Matches;
import com.introsde.adapters.yummly.models.RecipeFinder;
import com.introsde.food.utils.KeyValuePair;
import com.introsde.food.utils.QueryParams;

public class ClientTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Food foodService = new FoodService().getFood();

		// ReceiptFinder r = foodService.getRecipesByCalories(200, 250, 30);

		// for (Matches m : r.getMatches())
		// System.out.println(foodService.getRecipe(m.getId()).getName());

		// List<String> ingrList = new ArrayList<String>();
		//
		// ingrList.add("20g butter");
		// ingrList.add("30g oil");
		// ingrList.add("300g meat");
		//
		// EdamamResponse res =
		// foodService.calculateIngredientsValues(ingrList);
		//
		// System.out.println("Calories: " + res.getCalories());
		// System.out.println("Total Daily: "
		// + res.getTotalDaily().getENERCKCAL().getLabel() + " "
		// + res.getTotalDaily().getENERCKCAL().getQuantity() + " "
		// + res.getTotalDaily().getENERCKCAL().getUnit());
		//
		// System.out.println("Total Nutrients: "
		// + res.getTotalNutrients().getENERCKCAL().getLabel() + " "
		// + res.getTotalNutrients().getENERCKCAL().getQuantity() + " "
		// + res.getTotalNutrients().getENERCKCAL().getUnit());

		ArrayList<String> allowed = new ArrayList<String>(), excuded = new ArrayList<String>();

		allowed.add("oil");
		allowed.add("butter");
		allowed.add("vinegar");

		excuded.add("mint");
		excuded.add("chicken");

		QueryParams params = new QueryParams();

		List<KeyValuePair> list = new ArrayList<KeyValuePair>();

		for (String ingr : allowed) {
			list.add(new KeyValuePair(Yummly.ALLOWED_INGREDIENT, ingr));
		}

		for (String ingr : excuded) {
			list.add(new KeyValuePair(Yummly.EXCLUDED_INGREDIENT, ingr));
		}

		params.setQueryParams(list);

		RecipeFinder finder = foodService.getRecipes(params);

		p(finder, foodService);

	}

	static void p(RecipeFinder finder, Food food) {

		for (Matches m : finder.getMatches()) {

//			EdamamResponse response = food.calculateIngredientsValues(m
//					.getIngredients());
//
//			System.out.println("--------------------------");
//			System.out.println(m.getRecipeName());
//			System.out.println(m.getIngredients());
//			System.out.println(response.getCalories());
//
//			ENERC_KCAL kcal = response.getTotalDaily().getENERC_KCAL();
//			System.out.println(kcal.getLabel() + " " + kcal.getQuantity() + " "
//					+ kcal.getUnit());
//			System.out.println(response.getHealthLabels());
//			System.out.println(response.getDietLabels());
//			System.out.println(m.getRating());
//			System.out.println(m.getId());
			System.out.println(m);
		}
	}
}
