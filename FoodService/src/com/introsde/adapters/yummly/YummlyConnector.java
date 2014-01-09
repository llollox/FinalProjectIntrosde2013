package com.introsde.adapters.yummly;

import javax.ws.rs.core.MediaType;

import com.introsde.adapters.yummly.models.Receipt;
import com.introsde.adapters.yummly.models.ReceiptFinder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class YummlyConnector {

	private static final String YUMMLY_APP_ID = "ad98c4ce";
	private static final String YUMMLY_APP_KEY = "034eea1cd3f52cdd3a742772fca0d859";

	private static WebResource service;

	static {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		service = client.resource("http://api.yummly.com/v1/api");
	}

	public static Receipt getRecipe(String recipeId) {

		if (recipeId == null || recipeId.matches("\\s*"))
			return null;

		return service.path("/recipe").path(recipeId)
				.queryParam("_app_id", YUMMLY_APP_ID)
				.queryParam("_app_key", YUMMLY_APP_KEY)
				.accept(MediaType.APPLICATION_JSON).get(Receipt.class);
	}

	public static ReceiptFinder getRecipesByCalories(int minKcal, int maxKcal,
			int maxResults) {

		if (minKcal < 0 || maxKcal < minKcal)
			return null;

		if (maxResults < 1)
			return null;

		return service.path("/recipes").queryParam("requirePictures", "true")
				.queryParam("nutrition.ENERC_KCAL.min", minKcal + "")
				.queryParam("nutrition.ENERC_KCAL.max", maxKcal + "")
				.queryParam("maxResult", maxResults + "")
				.queryParam("_app_id", YUMMLY_APP_ID)
				.queryParam("_app_key", YUMMLY_APP_KEY)
				.accept(MediaType.APPLICATION_JSON).get(ReceiptFinder.class);
	}

}
