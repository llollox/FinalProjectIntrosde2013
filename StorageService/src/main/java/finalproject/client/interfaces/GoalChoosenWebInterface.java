package finalproject.client.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import finalproject.model.Activity;
import finalproject.model.Goal;
import finalproject.model.GoalChoosen;
import finalproject.utils.DatabaseUtil;

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
}
