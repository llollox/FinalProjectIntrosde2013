
package it.unitn.sde.finalproject;

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
@WebService(name = "ReadRecipes", targetNamespace = "http://finalproject.sde.unitn.it/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ReadRecipes {


    /**
     * 
     * @param arg0
     * @return
     *     returns it.unitn.sde.finalproject.Receipt
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getRecipe", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.GetRecipe")
    @ResponseWrapper(localName = "getRecipeResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.GetRecipeResponse")
    @Action(input = "http://finalproject.sde.unitn.it/ReadRecipes/getRecipeRequest", output = "http://finalproject.sde.unitn.it/ReadRecipes/getRecipeResponse")
    public Receipt getRecipe(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns it.unitn.sde.finalproject.ReceiptFinder
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getSpecificRecipe", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.GetSpecificRecipe")
    @ResponseWrapper(localName = "getSpecificRecipeResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.GetSpecificRecipeResponse")
    @Action(input = "http://finalproject.sde.unitn.it/ReadRecipes/getSpecificRecipeRequest", output = "http://finalproject.sde.unitn.it/ReadRecipes/getSpecificRecipeResponse")
    public ReceiptFinder getSpecificRecipe(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2);

}
