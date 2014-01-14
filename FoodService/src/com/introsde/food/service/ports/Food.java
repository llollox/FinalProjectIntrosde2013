package com.introsde.food.service.ports;

import java.util.List;

import javax.jws.WebService;

import com.introsde.adapters.edamam.EdamamConnector;
import com.introsde.adapters.edamam.models.EdamamResponse;
import com.introsde.adapters.yummly.YummlyConnector;
import com.introsde.adapters.yummly.models.Recipe;
import com.introsde.adapters.yummly.models.RecipeFinder;
import com.introsde.food.client.FoodWebInterface;
import com.introsde.food.utils.QueryParams;

@WebService(serviceName = "FoodService", portName = "food", targetNamespace = "http://finalproject.sde.unitn.it/")
public class Food implements FoodWebInterface {

	public Recipe getRecipe(String recipeId) {

		return YummlyConnector.getRecipe(recipeId);
	}

	public RecipeFinder getRecipes(QueryParams queryParams) {

		return YummlyConnector.getRecipes(queryParams);
	}

	public EdamamResponse calculateIngredientsValues(List<String> ingredients) {

		return EdamamConnector.get(ingredients);
	}

}
