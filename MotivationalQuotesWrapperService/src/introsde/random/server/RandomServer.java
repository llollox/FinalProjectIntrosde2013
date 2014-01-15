package introsde.random.server;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

public class RandomServer {

	public static final String URL_SERVER = "http://localhost:5930/";

	public RandomServer() throws Exception {

		final HttpServer server = HttpServerFactory.create(URL_SERVER);
		server.start();
		System.out.println("Random Quotes Service Started");
	}
}