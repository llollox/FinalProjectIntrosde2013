package com.introsde.project.ports;

import javax.jws.WebService;
import javax.ws.rs.core.MediaType;

import com.introsde.project.receipt.finder.ReceiptFinder;
import com.introsde.project.receipt.model.Receipt;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@WebService(serviceName = "ReadRecipesService", portName = "ReadRecipes", targetNamespace = "http://finalproject.sde.unitn.it/")
public class ReadRecipes {

	private static final String APP_ID = "_app_id=ad98c4ce";
	private static final String APP_KEY = "_app_key=034eea1cd3f52cdd3a742772fca0d859";

	private Client client;

	public ReadRecipes() {

		ClientConfig config = new DefaultClientConfig();
		// Creating the client
		client = Client.create(config);
	}

	public Receipt getRecipe(String id) {

		WebResource serviceReciept = client
				.resource("http://api.yummly.com/v1/api/recipe/" + id + "?"
						+ APP_ID + "&" + APP_KEY);

		return serviceReciept.accept(MediaType.APPLICATION_JSON).get(
				Receipt.class);
	}

	public ReceiptFinder getSpecificRecipe(int minKcal, int maxKcal,
			int maxResults) {

		WebResource serviceList = client
				.resource("http://api.yummly.com/v1/api/recipes?requirePictures=true&"
						+ APP_ID
						+ "&"
						+ APP_KEY
						+ "&nutrition.ENERC_KCAL.min="
						+ minKcal
						+ "&nutrition.ENERC_KCAL.max="
						+ maxKcal
						+ "&maxResult=" + maxResults);

		return serviceList.accept(MediaType.APPLICATION_JSON).get(
				ReceiptFinder.class);
	}
}
