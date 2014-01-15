package introsde.finalproject.server;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

public class SuggestGoalActivityServer {

	public static final String URL_SERVER = "http://localhost:3000/";

	public SuggestGoalActivityServer() throws Exception {

		final HttpServer server = HttpServerFactory.create(URL_SERVER);
		server.start();
		System.out.println("Suggest Activity Service Started");
	}
}