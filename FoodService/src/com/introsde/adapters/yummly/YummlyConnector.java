package com.introsde.adapters.yummly;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.introsde.adapters.yummly.models.Recipe;
import com.introsde.adapters.yummly.models.RecipeFinder;
import com.introsde.food.utils.KeyValuePair;
import com.introsde.food.utils.QueryParams;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class YummlyConnector {

	private static WebResource service;

	static {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		service = client.resource("http://api.yummly.com/v1/api");
	}

	// public static RecipeFinder getRecipes(int minKcal, int maxKcal) {
	//
	// if (minKcal < 0 || maxKcal < minKcal)
	// return null;
	//
	// MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
	//
	// queryParams.add(Yummly.KCAL_MIN, minKcal + "");
	// queryParams.add(Yummly.KCAL_MAX, maxKcal + "");
	//
	// return retrive(queryParams, null, null);
	// }
	//
	// public static RecipeFinder getRecipes(int minKcal, int maxKcal,
	// int maxResults) {
	//
	// if (minKcal < 0 || maxKcal < minKcal)
	// return null;
	//
	// if (maxResults < 1)
	// return null;
	//
	// MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
	//
	// queryParams.add(Yummly.KCAL_MIN, minKcal + "");
	// queryParams.add(Yummly.KCAL_MAX, maxKcal + "");
	// queryParams.add(Yummly.MAX_RESULTS, maxResults + "");
	//
	// return retrive(queryParams, null, null);
	// }
	//
	// public static RecipeFinder getRecipes(String textQuery) {
	//
	// MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
	// queryParams.add(Yummly.SEARCH_TEXT, textQuery);
	//
	// return retrive(queryParams, null, null);
	// }
	//
	// public static RecipeFinder getRecipes(String textQuery, int maxResults) {
	//
	// MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
	// queryParams.add(Yummly.SEARCH_TEXT, textQuery);
	// queryParams.add(Yummly.MAX_RESULTS, maxResults + "");
	//
	// return retrive(queryParams, null, null);
	// }
	//
	// public static RecipeFinder getRecipes(String textQuery,
	// List<String> includedIngredients, List<String> excludedIngredients) {
	//
	// MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
	// queryParams.add(Yummly.SEARCH_TEXT, textQuery);
	//
	// return retrive(queryParams, includedIngredients, excludedIngredients);
	// }
	//
	// public static RecipeFinder getRecipes(String textQuery,
	// List<String> includedIngredients, List<String> excludedIngredients,
	// int maxResults) {
	//
	// MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
	// queryParams.add(Yummly.SEARCH_TEXT, textQuery);
	// queryParams.add(Yummly.MAX_RESULTS, maxResults + "");
	//
	// return retrive(queryParams, includedIngredients, excludedIngredients);
	// }
	//
	// public static RecipeFinder getRecipes(List<String> includedIngredients,
	// List<String> excludedIngredients) {
	//
	// return retrive(null, includedIngredients, excludedIngredients);
	// }
	//
	// public static RecipeFinder getRecipes(List<String> includedIngredients,
	// List<String> excludedIngredients, int maxResults) {
	//
	// MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
	// queryParams.add(Yummly.MAX_RESULTS, maxResults + "");
	//
	// return retrive(queryParams, includedIngredients, excludedIngredients);
	// }
	//
	// public static RecipeFinder getRecipes(
	// MultivaluedMap<String, String> queryParams,
	// List<String> includedIngredients, List<String> excludedIngredients) {
	//
	// return retrive(queryParams, includedIngredients, excludedIngredients);
	// }
	//
	// public static RecipeFinder getRecipes(
	// MultivaluedMap<String, String> queryParams) {
	//
	// if (queryParams == null) {
	// queryParams = new MultivaluedMapImpl();
	// }
	//
	// return retrive(queryParams, null, null);
	// }

	public static RecipeFinder getRecipes(QueryParams params) {

		MultivaluedMapImpl queryParams = new MultivaluedMapImpl();

		if (params != null)
			for (KeyValuePair pair : params.getQueryParams())
				queryParams.add(pair.getKey(), pair.getValue());

		return retrive(queryParams, null, null);
	}

	// *******************************************************************
	//
	// TWO METHODS THAT CONNECTS AND GETS ALL THE INFORMATIONS FROM YUMMLY
	//
	// *******************************************************************

	private static RecipeFinder retrive(
			MultivaluedMap<String, String> queryParams,
			List<String> includedIngredients, List<String> excludedIngredients) {

		if (queryParams == null) {
			queryParams = new MultivaluedMapImpl();
		}

		if (includedIngredients != null)
			for (String ingr : includedIngredients)
				queryParams.add(Yummly.ALLOWED_INGREDIENT, ingr);

		if (excludedIngredients != null)
			for (String ingr : excludedIngredients)
				queryParams.add(Yummly.EXCLUDED_INGREDIENT, ingr);

		if (!queryParams.containsKey(Yummly.MAX_RESULTS))
			queryParams.add(Yummly.MAX_RESULTS, "5");

		// parameter to get recipes with pictures
		queryParams.add("requirePictures", "true");
		// add app key and id
		queryParams.add(Yummly.APP_ID_KEY, Yummly.APP_ID_VALUE);
		queryParams.add(Yummly.APP_KEY_KEY, Yummly.APP_KEY_VALUE);

		return service.path("/recipes").queryParams(queryParams)
				.accept(MediaType.APPLICATION_JSON).get(RecipeFinder.class);
	}

	public static Recipe getRecipe(String recipeId) {

		if (recipeId == null || recipeId.matches("\\s*"))
			return null;

		return service.path("/recipe").path(recipeId)
				.queryParam(Yummly.APP_ID_KEY, Yummly.APP_ID_VALUE)
				.queryParam(Yummly.APP_KEY_KEY, Yummly.APP_KEY_VALUE)
				.accept(MediaType.APPLICATION_JSON).get(Recipe.class);
	}
}
