package introsde.finalproject.service;

import java.util.List;

import finalproject.model.GoalChoosen;
import introsde.finalproject.server.SuggestGoalActivityServer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@Path("/person/{p_id}/goal")
public class ExerciseActivityGoal {

	private static WebResource service;

	static {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		service = client.resource(SuggestGoalActivityServer.URL_SERVER);
	}

	@GET
	public List<GoalChoosen> getGoals(@PathParam("p_id") int id) {

		// return service.
		return null;
	}

}
