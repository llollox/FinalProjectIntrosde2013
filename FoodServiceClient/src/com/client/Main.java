package com.client;

import it.unitn.sde.finalproject.EdamamResponse;
import it.unitn.sde.finalproject.Food;
import it.unitn.sde.finalproject.FoodService;

import java.util.ArrayList;
import java.util.List;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Food foodService = new FoodService().getFood();

		// ReceiptFinder r = foodService.getRecipesByCalories(200, 250, 30);

		// for (Matches m : r.getMatches())
		// System.out.println(foodService.getRecipe(m.getId()).getName());

		List<String> ingr = new ArrayList<String>();

		ingr.add("20g butter");
		ingr.add("30g oil");
		ingr.add("300g meat");

		EdamamResponse res = foodService.calculateIngredientsValues(ingr);

		System.out.println("Calories: " + res.getCalories());
		System.out.println("Total Daily: "
				+ res.getTotalDaily().getENERCKCAL().getLabel() + " "
				+ res.getTotalDaily().getENERCKCAL().getQuantity() + " "
				+ res.getTotalDaily().getENERCKCAL().getUnit());

		System.out.println("Total Nutrients: "
				+ res.getTotalNutrients().getENERCKCAL().getLabel() + " "
				+ res.getTotalNutrients().getENERCKCAL().getQuantity() + " "
				+ res.getTotalNutrients().getENERCKCAL().getUnit());

	}
}
