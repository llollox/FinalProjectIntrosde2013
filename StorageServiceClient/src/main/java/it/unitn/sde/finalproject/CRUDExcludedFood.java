
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
@WebService(name = "CRUDExcludedFood", targetNamespace = "http://finalproject.sde.unitn.it/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CRUDExcludedFood {


    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createExcludedFood", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.CreateExcludedFood")
    @ResponseWrapper(localName = "createExcludedFoodResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.CreateExcludedFoodResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CRUDExcludedFood/createExcludedFoodRequest", output = "http://finalproject.sde.unitn.it/CRUDExcludedFood/createExcludedFoodResponse")
    public int createExcludedFood(
        @WebParam(name = "arg0", targetNamespace = "")
        ExcludedFood arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateExcludedFood", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.UpdateExcludedFood")
    @ResponseWrapper(localName = "updateExcludedFoodResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.UpdateExcludedFoodResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CRUDExcludedFood/updateExcludedFoodRequest", output = "http://finalproject.sde.unitn.it/CRUDExcludedFood/updateExcludedFoodResponse")
    public int updateExcludedFood(
        @WebParam(name = "arg0", targetNamespace = "")
        ExcludedFood arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns it.unitn.sde.finalproject.ExcludedFood
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "readExcludedFood", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.ReadExcludedFood")
    @ResponseWrapper(localName = "readExcludedFoodResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.ReadExcludedFoodResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CRUDExcludedFood/readExcludedFoodRequest", output = "http://finalproject.sde.unitn.it/CRUDExcludedFood/readExcludedFoodResponse")
    public ExcludedFood readExcludedFood(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteExcludedFood", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.DeleteExcludedFood")
    @ResponseWrapper(localName = "deleteExcludedFoodResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.DeleteExcludedFoodResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CRUDExcludedFood/deleteExcludedFoodRequest", output = "http://finalproject.sde.unitn.it/CRUDExcludedFood/deleteExcludedFoodResponse")
    public boolean deleteExcludedFood(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}
