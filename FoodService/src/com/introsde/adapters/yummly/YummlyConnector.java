package com.introsde.adapters.yummly;

import javax.ws.rs.core.MediaType;

import com.introsde.adapters.yummly.models.Receipt;
import com.introsde.adapters.yummly.models.ReceiptFinder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class YummlyConnector {

	private static final String APP_ID_KEY = "_app_id";
	private static final String APP_KEY_KEY = "_app_key";

	private static final String APP_ID_VALUE = "ad98c4ce";
	private static final String APP_KEY_VALUE = "034eea1cd3f52cdd3a742772fca0d859";

	private static final String TEXT_QUERY = "q";
	private static final String ALLOWED_INGR = "excludedIngredient[]";
	private static final String EXCLUDED_INGR = "allowedIngredient[]";
	private static final String ENERC_KCAL_MIN = "nutrition.ENERC_KCAL.min";
	private static final String ENERC_KCAL_MAX = "nutrition.ENERC_KCAL.max";
	private static final String MAX_RESULT = "maxResult";

	enum ATTR_NAME {
		K, NA, CHOLE, FATRN, FASAT, CHOCDF, FIBTG, PROCNT, VITC, CA, FE, SUGAR, ENERC_KCAL, FAT, VITA_IU
	}

	String pesce = "390^Pescetarian";

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
				.queryParam(APP_ID_KEY, APP_ID_VALUE)
				.queryParam(APP_KEY_KEY, APP_KEY_VALUE)
				.accept(MediaType.APPLICATION_JSON).get(Receipt.class);
	}

	public static ReceiptFinder getRecipesByCalories(int minKcal, int maxKcal,
			int maxResults) {

		if (minKcal < 0 || maxKcal < minKcal)
			return null;

		if (maxResults < 1)
			return null;

		return service.path("/recipes").queryParam("requirePictures", "true")
				.queryParam(ENERC_KCAL_MIN, minKcal + "")
				.queryParam(ENERC_KCAL_MAX, maxKcal + "")
				.queryParam(MAX_RESULT, maxResults + "")
				.queryParam(APP_ID_KEY, APP_ID_VALUE)
				.queryParam(APP_KEY_KEY, APP_KEY_VALUE)
				.accept(MediaType.APPLICATION_JSON).get(ReceiptFinder.class);
	}

	public static ReceiptFinder getRecipes(int minKcal, int maxKcal,
			int maxResults) {

		if (minKcal < 0 || maxKcal < minKcal)
			return null;

		if (maxResults < 1)
			return null;

		return service.path("/recipes").queryParam("requirePictures", "true")
				.queryParam(ENERC_KCAL_MIN, minKcal + "")
				.queryParam(ENERC_KCAL_MAX, maxKcal + "")
				.queryParam(MAX_RESULT, maxResults + "")
				.queryParam(APP_ID_KEY, APP_ID_VALUE)
				.queryParam(APP_KEY_KEY, APP_KEY_VALUE)
				.accept(MediaType.APPLICATION_JSON).get(ReceiptFinder.class);
	}

}
