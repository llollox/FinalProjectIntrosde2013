package finalproject.client.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import finalproject.model.Activity;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.4-b01 Generated
 * source version: 2.2
 * 
 */
@WebService(name = "CRUDActivity", targetNamespace = "http://finalproject.sde.unitn.it/")
public interface ActivityWebInterface {

	/**
	 * 
	 * @param arg0
	 * @return returns int
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public int createActivity(
			@WebParam(name = "arg0", targetNamespace = "") Activity arg0);

	/**
	 * 
	 * @param arg0
	 * @return returns it.unitn.sde.finalproject.Activity
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public Activity readActivity(
			@WebParam(name = "arg0", targetNamespace = "") int arg0);

	/**
	 * 
	 * @param arg0
	 * @return returns int
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public int updateActivity(
			@WebParam(name = "arg0", targetNamespace = "") Activity arg0);

	/**
	 * 
	 * @param arg0
	 * @return returns boolean
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public boolean deleteActivity(
			@WebParam(name = "arg0", targetNamespace = "") int arg0);

	/**
	 * 
	 * @return returns java.util.List<it.unitn.sde.finalproject.Activity>
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public List<Activity> getActivities();

	@WebMethod
	@WebResult(targetNamespace = "")
	public void linkExerciseCategory(
			@WebParam(name = "arg0", targetNamespace = "") int arg0,
			@WebParam(name = "arg1", targetNamespace = "") int arg1);
	
}
