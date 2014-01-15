package finalproject.client.interfaces;

import java.util.List;

import javax.jws.WebService;

import finalproject.model.GoalChoosen;

@WebService(name = "CRUDGoalChoosen", targetNamespace = "http://finalproject.sde.unitn.it/")
public interface GoalChoosenWebInterface {

	// CREATE GOAL CHOOSEN
	public int create(GoalChoosen goal);

	// READ GOAL CHOOSEN
	public GoalChoosen read(int id);

	// UPDATE GOAL CHOOSEN
	public int update(GoalChoosen goal);

	// DELETE GOAL CHOOSEN
	public boolean delete(int id);

	public List<GoalChoosen> getGoalChoosenForPerson(int pid);
}
