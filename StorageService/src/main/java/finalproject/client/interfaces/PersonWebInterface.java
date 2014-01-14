package finalproject.client.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import finalproject.model.Person;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.4-b01 Generated
 * source version: 2.2
 * 
 */
@WebService(name = "CRUDPerson", targetNamespace = "http://finalproject.sde.unitn.it/")
public interface PersonWebInterface {

	/**
	 * 
	 * @param arg0
	 * @return returns int
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public int createPerson(
			@WebParam(name = "arg0", targetNamespace = "") Person arg0);

	/**
	 * 
	 * @param arg0
	 * @return returns it.unitn.sde.finalproject.Person
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public Person readPerson(
			@WebParam(name = "arg0", targetNamespace = "") int arg0);

	/**
	 * 
	 * @return returns java.util.List<it.unitn.sde.finalproject.Person>
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public List<Person> getPeople();

	/**
	 * 
	 * @param arg0
	 * @return returns java.util.List<it.unitn.sde.finalproject.Person>
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public List<Person> getPeopleByName(
			@WebParam(name = "arg0", targetNamespace = "") String arg0);

	/**
	 * 
	 * @param arg1
	 * @param arg0
	 * @return returns java.util.List<it.unitn.sde.finalproject.Person>
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public List<Person> getPeopleByBirthdate(
			@WebParam(name = "arg0", targetNamespace = "") String arg0,
			@WebParam(name = "arg1", targetNamespace = "") String arg1);

	/**
	 * 
	 * @param arg2
	 * @param arg1
	 * @param arg0
	 * @return returns java.util.List<it.unitn.sde.finalproject.Person>
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public List<Person> getPeopleByMeasure(
			@WebParam(name = "arg0", targetNamespace = "") String arg0,
			@WebParam(name = "arg1", targetNamespace = "") String arg1,
			@WebParam(name = "arg2", targetNamespace = "") String arg2);

	/**
	 * 
	 * @param arg0
	 * @return returns int
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public int updatePerson(
			@WebParam(name = "arg0", targetNamespace = "") Person arg0);

	/**
	 * 
	 * @param arg0
	 * @return returns boolean
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public int deletePerson(
			@WebParam(name = "arg0", targetNamespace = "") int arg0);

	/**
	 * 
	 * @param arg1
	 * @param arg0
	 */
	@WebMethod
	public void linkGoal(
			@WebParam(name = "arg0", targetNamespace = "") int arg0,
			@WebParam(name = "arg1", targetNamespace = "") int arg1);

}