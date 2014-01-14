package com.introsde.food.client;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.introsde.adapters.edamam.models.EdamamResponse;
import com.introsde.adapters.yummly.models.Recipe;
import com.introsde.adapters.yummly.models.RecipeFinder;
import com.introsde.food.utils.QueryParams;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.4-b01 Generated
 * source version: 2.2
 * 
 */
@WebService(name = "Food", targetNamespace = "http://finalproject.sde.unitn.it/")
public interface FoodWebInterface {

	/**
	 * 
	 * @param arg0
	 * @return returns it.unitn.sde.finalproject.Recipe
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public Recipe getRecipe(
			@WebParam(name = "arg0", targetNamespace = "") String arg0);

	/**
	 * 
	 * @param arg0
	 * @return returns it.unitn.sde.finalproject.RecipeFinder
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public RecipeFinder getRecipes(
			@WebParam(name = "arg0", targetNamespace = "") QueryParams arg0);

	/**
	 * 
	 * @param arg0
	 * @return returns it.unitn.sde.finalproject.EdamamResponse
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	public EdamamResponse calculateIngredientsValues(
			@WebParam(name = "arg0", targetNamespace = "") List<String> arg0);

}