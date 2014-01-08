
package it.unitn.sde.finalproject;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "CRUDActivityHistoryValue", targetNamespace = "http://finalproject.sde.unitn.it/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CRUDActivityHistoryValue {


    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insertValue", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.InsertValue")
    @ResponseWrapper(localName = "insertValueResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.InsertValueResponse")
    public int insertValue(
        @WebParam(name = "arg0", targetNamespace = "")
        ActivityHistoryValue arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns it.unitn.sde.finalproject.ActivityHistoryValue
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "readValue", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.ReadValue")
    @ResponseWrapper(localName = "readValueResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.ReadValueResponse")
    public ActivityHistoryValue readValue(
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
    @RequestWrapper(localName = "updateValue", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.UpdateValue")
    @ResponseWrapper(localName = "updateValueResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.UpdateValueResponse")
    public int updateValue(
        @WebParam(name = "arg0", targetNamespace = "")
        ActivityHistoryValue arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteValue", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.DeleteValue")
    @ResponseWrapper(localName = "deleteValueResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.DeleteValueResponse")
    public boolean deleteValue(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}
