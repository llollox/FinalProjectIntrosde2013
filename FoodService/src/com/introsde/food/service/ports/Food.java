package com.introsde.food.service.ports;

import java.util.List;

import javax.jws.WebService;

import com.introsde.adapters.edamam.EdamamConnector;
import com.introsde.adapters.edamam.models.EdamamResponse;
import com.introsde.adapters.yummly.YummlyConnector;
import com.introsde.adapters.yummly.models.Receipt;
import com.introsde.adapters.yummly.models.ReceiptFinder;

@WebService(serviceName = "FoodService", portName = "food", targetNamespace = "http://finalproject.sde.unitn.it/")
public class Food {

	public Receipt getRecipe(String recipeId) {

		return YummlyConnector.getRecipe(recipeId);
	}

	public ReceiptFinder get20RecipesByCalories(int minKcal, int maxKcal) {

		final int SIZE = 20;

		return YummlyConnector.getRecipesByCalories(minKcal, maxKcal, SIZE);
	}

	public ReceiptFinder getRecipesByCalories(int minKcal, int maxKcal,
			int maxResults) {

		return YummlyConnector.getRecipesByCalories(minKcal, maxKcal,
				maxResults);
	}

	public EdamamResponse calculateIngredientsValues(List<String> ingredients) {

		return EdamamConnector.get(ingredients);
	}

}
