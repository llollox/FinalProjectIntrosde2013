package finalproject.client.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import finalproject.model.ExcludedFood;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.4-b01 Generated
 * source version: 2.2
 * 
 */
@WebService(name = "CRUDExcludedFood", targetNamespace = "http://finalproject.sde.unitn.it/")
public interface CRUDExcludedFood {

	/**
	 * 
	 * @param arg0
	 * @return returns int
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public int createExcludedFood(
			@WebParam(name = "arg0", targetNamespace = "") ExcludedFood arg0);

	/**
	 * 
	 * @param arg0
	 * @return returns int
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public int updateExcludedFood(
			@WebParam(name = "arg0", targetNamespace = "") ExcludedFood arg0);

	/**
	 * 
	 * @param arg0
	 * @return returns it.unitn.sde.finalproject.ExcludedFood
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public ExcludedFood readExcludedFood(
			@WebParam(name = "arg0", targetNamespace = "") int arg0);

	/**
	 * 
	 * @param arg0
	 * @return returns boolean
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public boolean deleteExcludedFood(
			@WebParam(name = "arg0", targetNamespace = "") int arg0);

}