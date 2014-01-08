package finalproject.ports;

import javax.jws.WebService;

import finalproject.model.Goal;

@WebService(
	serviceName = "GoalService",
	portName = "CRUD",
	targetNamespace = "http://finalproject.sde.unitn.it/"
)
public class CRUDGoal {

	// CREATE GOAL
	public int createGoal(Goal goal) {
		Goal g = Goal.create(goal);

		if (g == null)
			return -1;

		return g.getId();
	}

	// READ GOAL
	public Goal readGoal(int id) {
		return Goal.read(id);
	}

	// UPDATE GOAL
	public int updateGoal(Goal goal) {
		Goal g = Goal.update(goal);

		if (g == null)
			return -1;

		return g.getId();
	}

	// DELETE GOAL
	public boolean deleteGoal(int id) {
		return Goal.delete(id);
	}
	
}
