package com.introsde.project.yummly.test;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.introsde.project.receipt.finder.Matches;
import com.introsde.project.receipt.finder.ReceiptFinder;
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
		WebResource service = client.resource(getBaseURI());
		// Make HTTP requests and process resources you get in response

		ReceiptFinder rfv = service.accept(MediaType.APPLICATION_JSON).get(
				ReceiptFinder.class);

		for (Matches m : rfv.getMatches())
			System.out.println(m.getId());

		// // Making a GET request on BASEURI/rest/helloworld with
		// // Accept header equal text/plain
		// System.out.println(service.path("rest").path("helloworld")
		// .accept(MediaType.TEXT_PLAIN).get(ClientResponse.class)
		// .toString());
		// // Get plain text
		// System.out.println(service.path("rest").path("helloworld")
		// .accept(MediaType.TEXT_PLAIN).get(String.class));
		// // Get XML
		// System.out.println(service.path("rest").path("helloworld")
		// .accept(MediaType.TEXT_XML).get(String.class));
		// // The HTML
		// System.out.println(service.path("rest").path("helloworld")
		// .accept(MediaType.TEXT_HTML).get(String.class));
	}

	private static URI getBaseURI() {
		return UriBuilder
				.fromUri(
						"http://api.yummly.com/v1/api/recipes?nutrition.ENERC_KCAL.min=200&nutrition.ENERC_KCAL.max=350&maxResult=20&requirePictures=true&_app_id=ad98c4ce&_app_key=034eea1cd3f52cdd3a742772fca0d859")
				.build();
		// return UriBuilder
		// .fromUri(
		// "http://api.yummly.com/v1/api/recipe/Easiest-mashed-potatoes-recipe_-period_-306457?_app_id=ad98c4ce&_app_key=034eea1cd3f52cdd3a742772fca0d859")
		// .build();

	}

}
