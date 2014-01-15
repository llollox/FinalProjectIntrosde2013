package introsde.finalproject.service;

import introsde.random.quotes.RandomQuotes;
import introsde.random.server.RandomServer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@Path("/randomQuote")
public class RandomQuotesResource {

	private static WebResource service;

	static {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		service = client.resource(RandomServer.URL_SERVER);
	}

	@GET
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public RandomQuotes.JsonQuote getRandomQuote() {

		return service.path("quote").path("motivational")
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON)
				.get(RandomQuotes.JsonQuote.class);
	}
}
