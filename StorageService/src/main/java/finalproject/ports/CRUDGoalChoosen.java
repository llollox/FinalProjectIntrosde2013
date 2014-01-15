package finalproject.ports;

import java.util.List;

import javax.jws.WebService;

import finalproject.client.interfaces.GoalChoosenWebInterface;
import finalproject.model.GoalChoosen;

@WebService(serviceName = "GoalChoosenService", portName = "CRUD", targetNamespace = "http://finalproject.sde.unitn.it/")
public class CRUDGoalChoosen implements GoalChoosenWebInterface {

	// CREATE GOAL CHOOSEN
	public int create(GoalChoosen goal) {
		GoalChoosen g = GoalChoosen.create(goal);

		if (g == null)
			return -1;

		return g.getId();
	}

	// READ GOAL CHOOSEN
	public GoalChoosen read(int id) {
		return GoalChoosen.read(id);
	}

	// UPDATE GOAL CHOOSEN
	public int update(GoalChoosen goal) {
		GoalChoosen g = GoalChoosen.update(goal);

		if (g == null)
			return -1;

		return g.getId();
	}

	// DELETE GOAL CHOOSEN
	public boolean delete(int id) {
		return GoalChoosen.delete(id);
	}

	public List<GoalChoosen> getGoalChoosenForPerson(int pid) {
		return GoalChoosen.getGoalChoosenForPerson(pid);
	}

}
