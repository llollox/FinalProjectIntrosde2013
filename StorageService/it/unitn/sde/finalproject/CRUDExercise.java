
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
@WebService(name = "CRUDExercise", targetNamespace = "http://finalproject.sde.unitn.it/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CRUDExercise {


    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createExercise", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.CreateExercise")
    @ResponseWrapper(localName = "createExerciseResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.CreateExerciseResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CRUDExercise/createExerciseRequest", output = "http://finalproject.sde.unitn.it/CRUDExercise/createExerciseResponse")
    public int createExercise(
        @WebParam(name = "arg0", targetNamespace = "")
        Exercise arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns it.unitn.sde.finalproject.Exercise
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "readExercise", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.ReadExercise")
    @ResponseWrapper(localName = "readExerciseResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.ReadExerciseResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CRUDExercise/readExerciseRequest", output = "http://finalproject.sde.unitn.it/CRUDExercise/readExerciseResponse")
    public Exercise readExercise(
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
    @RequestWrapper(localName = "updateExercise", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.UpdateExercise")
    @ResponseWrapper(localName = "updateExerciseResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.UpdateExerciseResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CRUDExercise/updateExerciseRequest", output = "http://finalproject.sde.unitn.it/CRUDExercise/updateExerciseResponse")
    public int updateExercise(
        @WebParam(name = "arg0", targetNamespace = "")
        Exercise arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteExercise", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.DeleteExercise")
    @ResponseWrapper(localName = "deleteExerciseResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.DeleteExerciseResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CRUDExercise/deleteExerciseRequest", output = "http://finalproject.sde.unitn.it/CRUDExercise/deleteExerciseResponse")
    public boolean deleteExercise(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}
