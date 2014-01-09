package com.introsde.adapters.edamam;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.introsde.adapters.edamam.models.EdamamRequest;
import com.introsde.adapters.edamam.models.EdamamResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class EdamamConnector {

	private static final String EDAMAM_APP_ID = "0391102e";
	private static final String EDAMAM_APP_KEY = "49b4d54afcee8097e23228be928a81d1";

	WebResource service;

	public EdamamConnector() {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		service = client.resource("https://api.edamam.com/api");
	}

	public EdamamResponse get(List<String> ingr) {

		if (ingr == null || ingr.isEmpty())
			return null;

		EdamamRequest request = new EdamamRequest();
		request.setIngr(ingr);

		return service.path("/nutrient-info")
				.queryParam("app_id", EDAMAM_APP_ID)
				.queryParam("app_key", EDAMAM_APP_KEY)
				.queryParam("extractOnly", "")

				.type(MediaType.APPLICATION_JSON)

				.accept(MediaType.APPLICATION_JSON)
				.post(EdamamResponse.class, request);
	}

}
