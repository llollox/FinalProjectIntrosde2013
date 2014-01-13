package com.client;

import it.unitn.sde.finalproject.EdamamResponse;
import it.unitn.sde.finalproject.EnercKCAL;
import it.unitn.sde.finalproject.Food;
import it.unitn.sde.finalproject.FoodService;

import java.util.ArrayList;
import java.util.List;

import com.introsde.adapters.yummly.models.Matches;
import com.introsde.adapters.yummly.models.RecipeFinder;

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

		ArrayList<String> allowed = new ArrayList<String>(), excuded = new ArrayList<String>();

		allowed.add("oil");
		allowed.add("butter");
		allowed.add("vinegar");

		excuded.add("mint");
		excuded.add("chicken");

		//RecipeFinder finder = foodService.getRecipes(allowed, excuded);
//		p(finder, foodService);

	}

	static void p(RecipeFinder finder, Food food) {

		for (Matches m : finder.getMatches()) {

			EdamamResponse response = food.calculateIngredientsValues(m
					.getIngredients());

			System.out.println("--------------------------");
			System.out.println(m.getRecipeName());
			System.out.println(m.getIngredients());
			System.out.println(response.getCalories());

			EnercKCAL kcal = response.getTotalDaily().getENERCKCAL();
			System.out.println(kcal.getLabel() + " " + kcal.getQuantity() + " "
					+ kcal.getUnit());
			System.out.println(response.getHealthLabels());
			System.out.println(response.getDietLabels());
			System.out.println(m.getRating());
			System.out.println(m.getId());
		}
	}

}
