package finalproject.ports;

import java.util.List;

import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import finalproject.model.Activity;
import finalproject.model.Goal;
import finalproject.utils.DatabaseUtil;

@WebService(serviceName = "GoalService", portName = "CRUD", targetNamespace = "http://finalproject.sde.unitn.it/")
public class CRUDGoal {

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

	public void setGoalProgress(int idperson, int idgoal, double percentage) {
		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.createNativeQuery(
				"UPDATE Person_has_Goal SET percentage=?percentage WHERE idperson=?idperson and idgoal=?idgoal")
				.setParameter("percentage", percentage)
				.setParameter("idperson", idperson)
				.setParameter("idgoal", idgoal).executeUpdate();
		tx.commit();

		em.close();
	}

	public Double getGoalProgress(int idperson, int idgoal) {

		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Double result = (Double) em
				.createNativeQuery(
						"SELECT percentage FROM introsde.Person_has_Goal WHERE idperson =?idperson AND idgoal =?idgoal")
				.setParameter("idperson", idperson)
				.setParameter("idgoal", idgoal).getSingleResult();
		tx.commit();

		em.close();
		return result;
	}

}
