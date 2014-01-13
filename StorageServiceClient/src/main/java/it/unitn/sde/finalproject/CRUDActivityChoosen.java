
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
@WebService(name = "CRUDActivityChoosen", targetNamespace = "http://finalproject.sde.unitn.it/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CRUDActivityChoosen {


    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createActivityChoosen", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.CreateActivityChoosen")
    @ResponseWrapper(localName = "createActivityChoosenResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.CreateActivityChoosenResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CRUDActivityChoosen/createActivityChoosenRequest", output = "http://finalproject.sde.unitn.it/CRUDActivityChoosen/createActivityChoosenResponse")
    public int createActivityChoosen(
        @WebParam(name = "arg0", targetNamespace = "")
        ActivityChoosen arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns it.unitn.sde.finalproject.ActivityChoosen
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "readActivityChoosen", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.ReadActivityChoosen")
    @ResponseWrapper(localName = "readActivityChoosenResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.ReadActivityChoosenResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CRUDActivityChoosen/readActivityChoosenRequest", output = "http://finalproject.sde.unitn.it/CRUDActivityChoosen/readActivityChoosenResponse")
    public ActivityChoosen readActivityChoosen(
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
    @RequestWrapper(localName = "updateActivityChoosen", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.UpdateActivityChoosen")
    @ResponseWrapper(localName = "updateActivityChoosenResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.UpdateActivityChoosenResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CRUDActivityChoosen/updateActivityChoosenRequest", output = "http://finalproject.sde.unitn.it/CRUDActivityChoosen/updateActivityChoosenResponse")
    public int updateActivityChoosen(
        @WebParam(name = "arg0", targetNamespace = "")
        ActivityChoosen arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteActivityChoosen", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.DeleteActivityChoosen")
    @ResponseWrapper(localName = "deleteActivityChoosenResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.DeleteActivityChoosenResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CRUDActivityChoosen/deleteActivityChoosenRequest", output = "http://finalproject.sde.unitn.it/CRUDActivityChoosen/deleteActivityChoosenResponse")
    public boolean deleteActivityChoosen(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}
