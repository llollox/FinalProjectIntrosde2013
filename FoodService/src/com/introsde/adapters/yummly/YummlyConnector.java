package com.introsde.adapters.yummly;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.introsde.adapters.yummly.models.Receipt;
import com.introsde.adapters.yummly.models.ReceiptFinder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class YummlyConnector {

	private static final String APP_ID_VALUE = "ad98c4ce";
	private static final String APP_KEY_VALUE = "034eea1cd3f52cdd3a742772fca0d859";

	private static final String APP_ID_KEY = "_app_id";
	private static final String APP_KEY_KEY = "_app_key";

	private static final String ENERC_KCAL_MAX = "nutrition.ENERC_KCAL.max";
	private static final String ENERC_KCAL_MIN = "nutrition.ENERC_KCAL.min";

	private static final String MAX_RESULTS = "maxResult";

	private static final String ALLOWED_INGREDIENTS = "allowedIngredient[]";
	private static final String EXCLUDED_INGREDIENTS = "excludedIngredient[]";

	private static final String TEXT_QUERY = "q";

	private static final String ALLOWED_DIET = "allowedDiet[]";

	private static final String PESCETARIAN = "390^Pescetarian";
	private static final String LACTO_OVO_VEGETARIAN = "387^Lacto-ovo vegetarian";
	private static final String LACTO_VEGETARIAN = "388^Lacto vegetarian";
	private static final String OVO_VEGETARIAN = "389^Ovo vegetarian";

	private static WebResource service;

	enum ATTR_NAME {
		K, NA, CHOLE, FATRN, FASAT, CHOCDF, FIBTG, PROCNT, VITC, CA, FE, SUGAR, ENERC_KCAL, FAT, VITA_IU
	}

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

		return service
				.path("/recipes")
				// parameter to get recipes with pictures
				.queryParam("requirePictures", "true")
				.queryParam(ENERC_KCAL_MIN, minKcal + "")
				.queryParam(ENERC_KCAL_MAX, maxKcal + "")
				.queryParam(MAX_RESULTS, maxResults + "")
				.queryParam(APP_ID_KEY, APP_ID_VALUE)
				.queryParam(APP_KEY_KEY, APP_KEY_VALUE)
				.accept(MediaType.APPLICATION_JSON).get(ReceiptFinder.class);
	}

	public static void getRecipes(String textQuery,
			List<String> includedIngredients, List<String> excludedIngredients,
			int maxResults) {

		service.path("/recipes");

		MultivaluedMap<String, String> map = new MultivaluedMapImpl();

		for (String ingr : includedIngredients) {
			map.add(ALLOWED_INGREDIENTS, ingr);
		}

		for (String ingr : excludedIngredients) {
			map.add(EXCLUDED_INGREDIENTS, ingr);
		}

		if (!map.isEmpty()) {
			service.queryParams(map);
		}

		if (textQuery != null)
			service.queryParam(TEXT_QUERY, textQuery);

		service.queryParam(APP_ID_KEY, APP_ID_VALUE)
				.queryParam(MAX_RESULTS, maxResults + "")
				.queryParam(APP_KEY_KEY, APP_KEY_VALUE)
				.accept(MediaType.APPLICATION_JSON).get(ReceiptFinder.class);

	}
}
