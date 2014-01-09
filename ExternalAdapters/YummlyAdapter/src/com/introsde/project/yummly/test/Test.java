package com.introsde.project.yummly.test;

import javax.ws.rs.core.MediaType;

import com.introsde.project.receipt.finder.Matches;
import com.introsde.project.receipt.finder.ReceiptFinder;
import com.introsde.project.receipt.model.NutritionEstimates;
import com.introsde.project.receipt.model.Receipt;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ClientConfig config = new DefaultClientConfig();
		// Creating the client
		Client client = Client.create(config);
		// Instantiating a web resource that will be requested from BASEURI
		WebResource serviceList = client
				.resource("http://api.yummly.com/v1/api/recipes?nutrition.ENERC_KCAL.min=1200&nutrition.ENERC_KCAL.max=1500&maxResult=30&requirePictures=true&_app_id=ad98c4ce&_app_key=034eea1cd3f52cdd3a742772fca0d859");

		// Make HTTP requests and process resources you get in response

		ReceiptFinder rfv = serviceList.accept(MediaType.APPLICATION_JSON).get(
				ReceiptFinder.class);

		for (Matches m : rfv.getMatches()) {
			System.out.println(m.getId());

			WebResource serviceReciept = client
					.resource("http://api.yummly.com/v1/api/recipe/Maple-pie-recipe-305920?_app_id=ad98c4ce&_app_key=034eea1cd3f52cdd3a742772fca0d859");

			Receipt r = serviceReciept.accept(MediaType.APPLICATION_JSON).get(
					Receipt.class);
			for (NutritionEstimates n : r.getNutritionEstimates())
				System.out.println(n);

		}

	}

}
