
package it.unitn.sde.finalproject;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CaloriesCalculator", targetNamespace = "http://finalproject.sde.unitn.it/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CaloriesCalculator {


    /**
     * 
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getIdealWeight", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.GetIdealWeight")
    @ResponseWrapper(localName = "getIdealWeightResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.GetIdealWeightResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CaloriesCalculator/getIdealWeightRequest", output = "http://finalproject.sde.unitn.it/CaloriesCalculator/getIdealWeightResponse")
    public double getIdealWeight(
        @WebParam(name = "arg0", targetNamespace = "")
        double arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getIdealBMI", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.GetIdealBMI")
    @ResponseWrapper(localName = "getIdealBMIResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.GetIdealBMIResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CaloriesCalculator/getIdealBMIRequest", output = "http://finalproject.sde.unitn.it/CaloriesCalculator/getIdealBMIResponse")
    public double getIdealBMI(
        @WebParam(name = "arg0", targetNamespace = "")
        double arg0);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getBMR", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.GetBMR")
    @ResponseWrapper(localName = "getBMRResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.GetBMRResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CaloriesCalculator/getBMRRequest", output = "http://finalproject.sde.unitn.it/CaloriesCalculator/getBMRResponse")
    public double getBMR(
        @WebParam(name = "arg0", targetNamespace = "")
        double arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        double arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        double arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        int arg3);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getIdealDailyCaloriesNeeded", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.GetIdealDailyCaloriesNeeded")
    @ResponseWrapper(localName = "getIdealDailyCaloriesNeededResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.GetIdealDailyCaloriesNeededResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CaloriesCalculator/getIdealDailyCaloriesNeededRequest", output = "http://finalproject.sde.unitn.it/CaloriesCalculator/getIdealDailyCaloriesNeededResponse")
    public double getIdealDailyCaloriesNeeded(
        @WebParam(name = "arg0", targetNamespace = "")
        double arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

    /**
     * 
     * @param date2
     * @param date
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDailyCaloriesNeededToManageWeight", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.GetDailyCaloriesNeededToManageWeight")
    @ResponseWrapper(localName = "getDailyCaloriesNeededToManageWeightResponse", targetNamespace = "http://finalproject.sde.unitn.it/", className = "it.unitn.sde.finalproject.GetDailyCaloriesNeededToManageWeightResponse")
    @Action(input = "http://finalproject.sde.unitn.it/CaloriesCalculator/getDailyCaloriesNeededToManageWeightRequest", output = "http://finalproject.sde.unitn.it/CaloriesCalculator/getDailyCaloriesNeededToManageWeightResponse")
    public double getDailyCaloriesNeededToManageWeight(
        @WebParam(name = "arg0", targetNamespace = "")
        double arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        double arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        Date date,
        @WebParam(name = "arg4", targetNamespace = "")
        Date date2);

}
