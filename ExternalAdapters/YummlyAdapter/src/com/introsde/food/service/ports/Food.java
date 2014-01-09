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

		YummlyConnector connector = new YummlyConnector();
		return connector.getRecipe(recipeId);
	}

	public ReceiptFinder getRecipesByCalories(int minKcal, int maxKcal,
			int maxResults) {

		YummlyConnector connector = new YummlyConnector();
		return connector.getRecipesByCalories(minKcal, maxKcal, maxResults);
	}

	public EdamamResponse calculateIngredients(List<String> ingredients) {

		EdamamConnector connector = new EdamamConnector();
		return connector.get(ingredients);
	}

}
