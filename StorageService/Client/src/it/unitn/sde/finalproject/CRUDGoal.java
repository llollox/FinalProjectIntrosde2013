
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
@WebService(name = "CRUDGoal", targetNamespace = "http://finalproject.sde.unitn.it/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CRUDGoal {


    /**
     * 
     * @param arg0
     * @return
     *     returns it.unitn.sde.finalproject.Goal
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "readGoal", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.ReadGoal")
    @ResponseWrapper(localName = "readGoalResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.ReadGoalResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CRUDGoal/readGoalRequest", output = "http://finalproject.sde.unitn.it/CRUDGoal/readGoalResponse")
    public Goal readGoal(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createGoal", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.CreateGoal")
    @ResponseWrapper(localName = "createGoalResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.CreateGoalResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CRUDGoal/createGoalRequest", output = "http://finalproject.sde.unitn.it/CRUDGoal/createGoalResponse")
    public int createGoal(
        @WebParam(name = "arg0", targetNamespace = "")
        Goal arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateGoal", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.UpdateGoal")
    @ResponseWrapper(localName = "updateGoalResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.UpdateGoalResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CRUDGoal/updateGoalRequest", output = "http://finalproject.sde.unitn.it/CRUDGoal/updateGoalResponse")
    public int updateGoal(
        @WebParam(name = "arg0", targetNamespace = "")
        Goal arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteGoal", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.DeleteGoal")
    @ResponseWrapper(localName = "deleteGoalResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.DeleteGoalResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CRUDGoal/deleteGoalRequest", output = "http://finalproject.sde.unitn.it/CRUDGoal/deleteGoalResponse")
    public boolean deleteGoal(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}
