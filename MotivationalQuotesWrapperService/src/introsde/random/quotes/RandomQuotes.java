package introsde.random.quotes;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@Path("/randomQuote")
public class RandomQuotes {

	private static WebResource service;

	static {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		service = client.resource("http://inspirationalquotes.herokuapp.com");
	}

	@GET
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public RandomQuotes.JsonQuote getRandomQuote() {

		return service.path("/random_quote")
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON)
				.get(RandomQuotes.JsonQuote.class);
	}

	@XmlRootElement
	static class JsonQuote {

		private int id;

		private String content;
		private String created_at;
		private String updated_at;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getCreated_at() {
			return created_at;
		}

		public void setCreated_at(String created_at) {
			this.created_at = created_at;
		}

		public String getUpdated_at() {
			return updated_at;
		}

		public void setUpdated_at(String updated_at) {
			this.updated_at = updated_at;
		}

	}
}
