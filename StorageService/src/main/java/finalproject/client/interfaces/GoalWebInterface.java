package finalproject.client.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import finalproject.model.Goal;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.4-b01 Generated
 * source version: 2.2
 * 
 */
@WebService(name = "CRUDGoal", targetNamespace = "http://finalproject.sde.unitn.it/")
public interface GoalWebInterface {

	/**
	 * 
	 * @return returns java.util.List<it.unitn.sde.finalproject.Goal>
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public List<Goal> getGoals();

	/**
	 * 
	 * @param arg0
	 * @return returns int
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public int createGoal(
			@WebParam(name = "arg0", targetNamespace = "") Goal arg0);

	/**
	 * 
	 * @param arg0
	 * @return returns it.unitn.sde.finalproject.Goal
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public Goal readGoal(@WebParam(name = "arg0", targetNamespace = "") int arg0);

	/**
	 * 
	 * @param arg0
	 * @return returns int
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "updateGoal", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.UpdateGoal")
	@ResponseWrapper(localName = "updateGoalResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.UpdateGoalResponse")
	@Action(input = "http://finalproject.sde.unitn.it/CRUDGoal/updateGoalRequest", output = "http://finalproject.sde.unitn.it/CRUDGoal/updateGoalResponse")
	public int updateGoal(
			@WebParam(name = "arg0", targetNamespace = "") Goal arg0);

	/**
	 * 
	 * @param arg0
	 * @return returns boolean
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public boolean deleteGoal(
			@WebParam(name = "arg0", targetNamespace = "") int arg0);

	/**
	 * 
	 * @param arg1
	 * @param arg0
	 */
	@WebMethod
	public void linkActivity(
			@WebParam(name = "arg0", targetNamespace = "") int arg0,
			@WebParam(name = "arg1", targetNamespace = "") int arg1);

	/**
	 * 
	 * @param arg2
	 * @param arg1
	 * @param arg0
	 */
	@WebMethod
	public void setGoalProgress(
			@WebParam(name = "arg0", targetNamespace = "") int arg0,
			@WebParam(name = "arg1", targetNamespace = "") int arg1,
			@WebParam(name = "arg2", targetNamespace = "") double arg2);

	/**
	 * 
	 * @param arg1
	 * @param arg0
	 * @return returns java.lang.Double
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public Double getGoalProgress(
			@WebParam(name = "arg0", targetNamespace = "") int arg0,
			@WebParam(name = "arg1", targetNamespace = "") int arg1);
	
	/**
	 * 
	 * @param arg2
	 * @param arg1
	 * @param arg0
	 */
	@WebMethod
	public void setGoalValue(
			@WebParam(name = "arg0", targetNamespace = "") int arg0,
			@WebParam(name = "arg1", targetNamespace = "") int arg1,
			@WebParam(name = "arg2", targetNamespace = "") String arg2);

	/**
	 * 
	 * @param arg1
	 * @param arg0
	 * @return returns java.lang.Double
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public String getGoalValue(
			@WebParam(name = "arg0", targetNamespace = "") int arg0,
			@WebParam(name = "arg1", targetNamespace = "") int arg1);
	
	/**
	 * 
	 * @param arg2
	 * @param arg1
	 * @param arg0
	 */
	@WebMethod
	public void setGoalEndDate(
			@WebParam(name = "arg0", targetNamespace = "") int arg0,
			@WebParam(name = "arg1", targetNamespace = "") int arg1,
			@WebParam(name = "arg2", targetNamespace = "") String arg2);

	/**
	 * 
	 * @param arg1
	 * @param arg0
	 * @return returns java.lang.Double
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public String getGoalEndDate(
			@WebParam(name = "arg0", targetNamespace = "") int arg0,
			@WebParam(name = "arg1", targetNamespace = "") int arg1);

}
