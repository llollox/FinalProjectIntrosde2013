package finalproject.client.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import finalproject.model.ExerciseHistory;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.4-b01 Generated
 * source version: 2.2
 * 
 */
@WebService(name = "CRUDExerciseHistory", targetNamespace = "http://finalproject.sde.unitn.it/")
public interface ExerciseHistoryWebInterface {

	/**
	 * 
	 * @param arg0
	 * @return returns int
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public int createExerciseHistory(
			@WebParam(name = "arg0", targetNamespace = "") ExerciseHistory arg0);

	/**
	 * 
	 * @param arg0
	 * @return returns it.unitn.sde.finalproject.ExerciseHistory
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public ExerciseHistory readExerciseHistory(
			@WebParam(name = "arg0", targetNamespace = "") int arg0);

	/**
	 * 
	 * @param arg0
	 * @return returns int
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public int updateExerciseHistory(
			@WebParam(name = "arg0", targetNamespace = "") ExerciseHistory arg0);

	/**
	 * 
	 * @param arg0
	 * @return returns boolean
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public boolean deleteExerciseHistory(
			@WebParam(name = "arg0", targetNamespace = "") int arg0);

}
