package introsde.finalproject.client;

import finalproject.model.ExerciseHistory;
import finalproject.model.GoalChoosen;
import introsde.finalproject.server.SuggestGoalActivityServer;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class SuggestClient {

	private static WebResource service;

	static {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		service = client.resource(SuggestGoalActivityServer.URL_SERVER);
	}

	public static List<GoalChoosen> getGoalsChoosen(int pid) {

		return service.path("suggest").path("person").path(pid + "")
				.accept(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<GoalChoosen>>() {
				});
	}

	public static GoalChoosen getGoal(int pid, int gid) {

		return service.path("suggest").path("person").path(pid + "")
				.path("goal").path(gid + "").accept(MediaType.APPLICATION_JSON)
				.get(GoalChoosen.class);
	}

	public static GoalChoosen createGoalChoosen(int pid, int gid) {

		return service.path("suggest").path("person").path(pid + "")
				.path("goal").path(gid + "").accept(MediaType.APPLICATION_JSON)
				.post(GoalChoosen.class);
	}

	public static ExerciseHistory createExercise(int pid, int gid, int aid,
			ExerciseHistory ex) {

		return service.path("suggest").path("person").path(pid + "")
				.path("goal").path(gid + "").path("activity").path(aid + "")
				.accept(MediaType.APPLICATION_JSON)
				.post(ExerciseHistory.class, ex);
	}

}
