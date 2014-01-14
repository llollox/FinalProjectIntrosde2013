package finalproject.ports;

import java.util.List;

import javax.jws.WebService;
import javax.persistence.EntityManager;

import finalproject.client.interfaces.GoalWebInterface;
import finalproject.model.Activity;
import finalproject.model.Goal;
import finalproject.utils.DatabaseUtil;

@WebService(serviceName = "GoalService", portName = "CRUD", targetNamespace = "http://finalproject.sde.unitn.it/")
public class CRUDGoal implements GoalWebInterface {

	// GET GOALS
	public List<Goal> getGoals() {
		EntityManager em = DatabaseUtil.createEntityManager();
		List<Goal> list = em.createNamedQuery("Goal.findAll", Goal.class)
				.getResultList();
		;
		em.close();
		return list;
	}

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

	// ADD ACTIVITY TO GOAL
	public void linkActivity(int idgoal, int idactivity) {
		Activity a = Activity.read(idactivity);
		Goal g = Goal.read(idgoal);

		if (g.getActivities().contains(a))
			return;

		g.getActivities().add(a);
		a.getGoals().add(g);

		Goal.update(g);
	}

}
