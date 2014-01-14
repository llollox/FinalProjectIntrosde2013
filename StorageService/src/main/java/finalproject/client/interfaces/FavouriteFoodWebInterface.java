package finalproject.client.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import finalproject.model.FavouriteFood;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.4-b01 Generated
 * source version: 2.2
 * 
 */
@WebService(name = "CRUDFavouriteFood", targetNamespace = "http://finalproject.sde.unitn.it/")
public interface FavouriteFoodWebInterface {

	/**
	 * 
	 * @param arg0
	 * @return returns int
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public int createFavouriteFood(
			@WebParam(name = "arg0", targetNamespace = "") FavouriteFood arg0);

	/**
	 * 
	 * @param arg0
	 * @return returns it.unitn.sde.finalproject.FavouriteFood
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public FavouriteFood readFavouriteFood(
			@WebParam(name = "arg0", targetNamespace = "") int arg0);

	/**
	 * 
	 * @param arg0
	 * @return returns int
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public int updateFavouriteFood(
			@WebParam(name = "arg0", targetNamespace = "") FavouriteFood arg0);

	/**
	 * 
	 * @param arg0
	 * @return returns boolean
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public boolean deleteFavouriteFood(
			@WebParam(name = "arg0", targetNamespace = "") int arg0);

	/**
	 * 
	 * @param arg0
	 * @return returns List<FavouriteFood>
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public List<FavouriteFood> getPersonsFavouriteFood(
			@WebParam(name = "arg0", targetNamespace = "") int arg0);

}