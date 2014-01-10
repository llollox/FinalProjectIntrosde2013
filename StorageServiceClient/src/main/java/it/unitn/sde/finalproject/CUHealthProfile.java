
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
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CUHealthProfile", targetNamespace = "http://finalproject.sde.unitn.it/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CUHealthProfile {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createHealthProfile", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.CreateHealthProfile")
    @ResponseWrapper(localName = "createHealthProfileResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.CreateHealthProfileResponse")
    public int createHealthProfile(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        HealthProfile arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateHealthProfile", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.UpdateHealthProfile")
    @ResponseWrapper(localName = "updateHealthProfileResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.UpdateHealthProfileResponse")
    public int updateHealthProfile(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        HealthProfile arg1);

}