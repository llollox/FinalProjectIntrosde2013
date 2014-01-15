package introsde.finalproject.service;

import introsde.finalproject.client.SuggestClient;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import finalproject.model.ExerciseHistory;
import finalproject.model.GoalChoosen;

@Path("/person/{p_id}/goal")
public class ExerciseActivityGoal {

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<GoalChoosen> getGoals(@PathParam("p_id") int pid) {

		List<GoalChoosen> goal = SuggestClient.getGoalsChoosen(pid);

		if (goal == null)
			return null;

		return goal;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public GoalChoosen createGoalChoosen(@PathParam("p_id") int pid, Json json) {

		GoalChoosen goalC = SuggestClient.createGoalChoosen(pid, json.goal);

		if (goalC == null)
			return null;

		return goalC;
	}

	@GET
	@Path("/{g_id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public GoalChoosen f(@PathParam("p_id") int pid, @PathParam("g_id") int gid) {

		GoalChoosen goal = SuggestClient.getGoal(pid, gid);

		if (goal == null)
			return null;

		return goal;
	}

	@POST
	@Path("/{g_id}/activity/{a_id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ExerciseHistory g(@PathParam("p_id") int pid,
			@PathParam("g_id") int gid, @PathParam("a_id") int aid,
			ExerciseHistory ex) {

		ex = SuggestClient.createExercise(pid, gid, aid, ex);

		return ex;
	}

	@XmlRootElement
	static class Json {

		private int goal;

		public int getGoal() {
			return goal;
		}

		public void setGoal(int goal) {
			this.goal = goal;
		}
	}
}
