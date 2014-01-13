
package it.unitn.sde.finalproject;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Food", targetNamespace = "http://finalproject.sde.unitn.it/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Food {


    /**
     * 
     * @param arg0
     * @return
     *     returns it.unitn.sde.finalproject.Recipe
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getRecipe", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.GetRecipe")
    @ResponseWrapper(localName = "getRecipeResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.GetRecipeResponse")
    @Action(input = "http://finalproject.sde.unitn.it/Food/getRecipeRequest", output = "http://finalproject.sde.unitn.it/Food/getRecipeResponse")
    public Recipe getRecipe(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns it.unitn.sde.finalproject.RecipeFinder
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getRecipes", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.GetRecipes")
    @ResponseWrapper(localName = "getRecipesResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.GetRecipesResponse")
    @Action(input = "http://finalproject.sde.unitn.it/Food/getRecipesRequest", output = "http://finalproject.sde.unitn.it/Food/getRecipesResponse")
    public RecipeFinder getRecipes(
        @WebParam(name = "arg0", targetNamespace = "")
        QueryParams arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns it.unitn.sde.finalproject.EdamamResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "calculateIngredientsValues", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.CalculateIngredientsValues")
    @ResponseWrapper(localName = "calculateIngredientsValuesResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.CalculateIngredientsValuesResponse")
    @Action(input = "http://finalproject.sde.unitn.it/Food/calculateIngredientsValuesRequest", output = "http://finalproject.sde.unitn.it/Food/calculateIngredientsValuesResponse")
    public EdamamResponse calculateIngredientsValues(
        @WebParam(name = "arg0", targetNamespace = "")
        List<String> arg0);

}
