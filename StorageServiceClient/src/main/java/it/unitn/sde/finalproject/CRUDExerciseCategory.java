
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
@WebService(name = "CRUDExerciseCategory", targetNamespace = "http://finalproject.sde.unitn.it/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CRUDExerciseCategory {


    /**
     * 
     * @return
     *     returns java.util.List<it.unitn.sde.finalproject.ExerciseCategory>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCategories", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.GetCategories")
    @ResponseWrapper(localName = "getCategoriesResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.GetCategoriesResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CRUDExerciseCategory/getCategoriesRequest", output = "http://finalproject.sde.unitn.it/CRUDExerciseCategory/getCategoriesResponse")
    public List<ExerciseCategory> getCategories();

    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createExerciseCategory", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.CreateExerciseCategory")
    @ResponseWrapper(localName = "createExerciseCategoryResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.CreateExerciseCategoryResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CRUDExerciseCategory/createExerciseCategoryRequest", output = "http://finalproject.sde.unitn.it/CRUDExerciseCategory/createExerciseCategoryResponse")
    public int createExerciseCategory(
        @WebParam(name = "arg0", targetNamespace = "")
        ExerciseCategory arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns it.unitn.sde.finalproject.ExerciseCategory
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "readExerciseCategory", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.ReadExerciseCategory")
    @ResponseWrapper(localName = "readExerciseCategoryResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.ReadExerciseCategoryResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CRUDExerciseCategory/readExerciseCategoryRequest", output = "http://finalproject.sde.unitn.it/CRUDExerciseCategory/readExerciseCategoryResponse")
    public ExerciseCategory readExerciseCategory(
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
    @RequestWrapper(localName = "updateExerciseCategory", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.UpdateExerciseCategory")
    @ResponseWrapper(localName = "updateExerciseCategoryResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.UpdateExerciseCategoryResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CRUDExerciseCategory/updateExerciseCategoryRequest", output = "http://finalproject.sde.unitn.it/CRUDExerciseCategory/updateExerciseCategoryResponse")
    public int updateExerciseCategory(
        @WebParam(name = "arg0", targetNamespace = "")
        ExerciseCategory arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteExerciseCategory", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.DeleteExerciseCategory")
    @ResponseWrapper(localName = "deleteExerciseCategoryResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.DeleteExerciseCategoryResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CRUDExerciseCategory/deleteExerciseCategoryRequest", output = "http://finalproject.sde.unitn.it/CRUDExerciseCategory/deleteExerciseCategoryResponse")
    public boolean deleteExerciseCategory(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}
