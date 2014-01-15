package introsde.finalproject.service;

import finalproject.model.GoalChoosen;
import introsde.finalproject.model.GoalExtended;
import introsde.finalproject.server.SuggestGoalActivityServer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public GoalExtended getGoals(@PathParam("p_id") int id) {

		GoalExtended goal = service.path("suggest").path("person")
				.path(id + "").accept(MediaType.APPLICATION_JSON)
				.get(GoalExtended.class);

		if (goal == null)
			return null;

		return goal;
	}

	@GET
	@Path("/{g_id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public GoalChoosen f(@PathParam("p_id") int pid, @PathParam("g_id") int gid) {

		GoalChoosen goal = service.path("suggest").path("person")
				.path(pid + "").path("goal").path(gid + "")
				.accept(MediaType.APPLICATION_JSON).get(GoalChoosen.class);

		if (goal == null)
			return null;

		return goal;
	}

}
