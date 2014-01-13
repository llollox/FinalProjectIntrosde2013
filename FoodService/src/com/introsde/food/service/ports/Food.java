package com.introsde.food.service.ports;

import java.util.List;

import javax.jws.WebService;

import com.introsde.adapters.edamam.EdamamConnector;
import com.introsde.adapters.edamam.models.EdamamResponse;
import com.introsde.adapters.yummly.Yummly;
import com.introsde.adapters.yummly.YummlyConnector;
import com.introsde.adapters.yummly.models.RecipeFinder;
import com.sun.jersey.core.util.MultivaluedMapImpl;

@WebService(serviceName = "FoodService", portName = "food", targetNamespace = "http://finalproject.sde.unitn.it/")
public class Food {

	public RecipeFinder getRecipes1(int minKcal, int maxKcal) {

		return YummlyConnector.getRecipes(minKcal, maxKcal);
	}

	public RecipeFinder getRecipes2(int minKcal, int maxKcal, int maxResults) {

		return YummlyConnector.getRecipes(minKcal, maxKcal, maxResults);
	}

	public RecipeFinder getRecipes3(String textQuery) {

		return YummlyConnector.getRecipes(textQuery);
	}

	public RecipeFinder getRecipes4(String textQuery, int maxResults) {

		return YummlyConnector.getRecipes(textQuery, maxResults);
	}

	public RecipeFinder getRecipes5(String textQuery,
			List<String> includedIngredients, List<String> excludedIngredients) {

		return YummlyConnector.getRecipes(textQuery, includedIngredients,
				excludedIngredients);
	}

	public RecipeFinder getRecipes6(String textQuery,
			List<String> includedIngredients, List<String> excludedIngredients,
			int maxResults) {

		return YummlyConnector.getRecipes(textQuery, includedIngredients,
				excludedIngredients, maxResults);
	}

	public RecipeFinder getRecipes7(List<String> includedIngredients,
			List<String> excludedIngredients) {

		return YummlyConnector.getRecipes(includedIngredients,
				excludedIngredients);
	}

	public RecipeFinder getRecipes8(List<String> includedIngredients,
			List<String> excludedIngredients, int maxResults) {

		return YummlyConnector.getRecipes(includedIngredients,
				excludedIngredients, maxResults);
	}

	public RecipeFinder getRecipes9(MultivaluedMapImpl queryParams,
			List<String> includedIngredients, List<String> excludedIngredients) {

		return YummlyConnector.getRecipes(queryParams, includedIngredients,
				excludedIngredients);
	}

	public RecipeFinder getRecipes10(MultivaluedMapImpl queryParams,
			List<String> includedIngredients, List<String> excludedIngredients,
			int maxResults) {

		if (queryParams == null)
			queryParams = new MultivaluedMapImpl();

		queryParams.add(Yummly.MAX_RESULTS, maxResults + "");

		return YummlyConnector.getRecipes(queryParams, includedIngredients,
				excludedIngredients);
	}

	public RecipeFinder getRecipes11(MultivaluedMapImpl queryParams) {

		return YummlyConnector.getRecipes(queryParams);
	}

	public EdamamResponse calculateIngredientsValues(List<String> ingredients) {

		return EdamamConnector.get(ingredients);
	}

}
