
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
@WebService(name = "CRUDGoalChoosen", targetNamespace = "http://finalproject.sde.unitn.it/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CRUDGoalChoosen {


    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "delete", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.Delete")
    @ResponseWrapper(localName = "deleteResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.DeleteResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CRUDGoalChoosen/deleteRequest", output = "http://finalproject.sde.unitn.it/CRUDGoalChoosen/deleteResponse")
    public boolean delete(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns it.unitn.sde.finalproject.GoalChoosen
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "read", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.Read")
    @ResponseWrapper(localName = "readResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.ReadResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CRUDGoalChoosen/readRequest", output = "http://finalproject.sde.unitn.it/CRUDGoalChoosen/readResponse")
    public GoalChoosen read(
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
    @RequestWrapper(localName = "create", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.Create")
    @ResponseWrapper(localName = "createResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.CreateResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CRUDGoalChoosen/createRequest", output = "http://finalproject.sde.unitn.it/CRUDGoalChoosen/createResponse")
    public int create(
        @WebParam(name = "arg0", targetNamespace = "")
        GoalChoosen arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "update", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.Update")
    @ResponseWrapper(localName = "updateResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.UpdateResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CRUDGoalChoosen/updateRequest", output = "http://finalproject.sde.unitn.it/CRUDGoalChoosen/updateResponse")
    public int update(
        @WebParam(name = "arg0", targetNamespace = "")
        GoalChoosen arg0);

}