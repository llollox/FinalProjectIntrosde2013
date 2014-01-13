package com.introsde.food.service.ports;

import java.util.List;

import javax.jws.WebService;

import com.introsde.adapters.edamam.EdamamConnector;
import com.introsde.adapters.edamam.models.EdamamResponse;
import com.introsde.adapters.yummly.YummlyConnector;
import com.introsde.adapters.yummly.models.Recipe;
import com.introsde.adapters.yummly.models.RecipeFinder;

@WebService(serviceName = "FoodService", portName = "food", targetNamespace = "http://finalproject.sde.unitn.it/")
public class Food {

	public Recipe getRecipe(String recipeId) {

		return YummlyConnector.getRecipe(recipeId);
	}

	public RecipeFinder getRecipesByCalories(int minKcal, int maxKcal) {

		return YummlyConnector.getRecipes(minKcal, maxKcal);
	}

	public RecipeFinder getRecipesByCalories(int minKcal, int maxKcal,
			int maxResults) {

		return YummlyConnector.getRecipes(minKcal, maxKcal, maxResults);
	}

	public EdamamResponse calculateIngredientsValues(List<String> ingredients) {

		return EdamamConnector.get(ingredients);
	}

}
