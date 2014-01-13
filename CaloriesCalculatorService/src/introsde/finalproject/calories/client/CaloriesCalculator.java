
package introsde.finalproject.calories.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CaloriesCalculator", targetNamespace = "http://finalproject.sde.unitn.it/")
public interface CaloriesCalculator {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    public double getIdealWeight(
        @WebParam(name = "arg0", targetNamespace = "")
        double height,
        @WebParam(name = "arg1", targetNamespace = "")
        int sex);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    public double getIdealBMI(
        @WebParam(name = "arg0", targetNamespace = "")
        double height,
        @WebParam(name = "arg1", targetNamespace = "")
        int sex);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    public double getBMI(
        @WebParam(name = "arg0", targetNamespace = "")
        double height,
        @WebParam(name = "arg1", targetNamespace = "")
        double weight);
    
    /**
     * 
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    public String getBmiLabel(
        @WebParam(name = "arg0", targetNamespace = "")
        double bmi);

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
    public double getBMR(
        @WebParam(name = "arg0", targetNamespace = "")
        double height,
        @WebParam(name = "arg1", targetNamespace = "")
        double weight,
        @WebParam(name = "arg2", targetNamespace = "")
        double age,
        @WebParam(name = "arg3", targetNamespace = "")
        int sex);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    public double getIdealDailyCaloriesNeeded(
        @WebParam(name = "arg0", targetNamespace = "")
        double bmr,
        @WebParam(name = "arg1", targetNamespace = "")
        int exerciseTimesPerWeek);

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
    public double getDailyCaloriesNeededToManageWeight(
        @WebParam(name = "arg0", targetNamespace = "")
        double bmr,
        @WebParam(name = "arg1", targetNamespace = "")
        int exerciseTimesPerWeek,
        @WebParam(name = "arg2", targetNamespace = "")
        double weightDifference,
        @WebParam(name = "arg3", targetNamespace = "")
        int days);
    
    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    public double getTargetHeartRate(
        @WebParam(name = "arg0", targetNamespace = "")
        double age,
        @WebParam(name = "arg1", targetNamespace = "")
        int heartRate);
    
    /**
     * 
     * @param minbloodpressure
     * @param maxbloodpressure
     * @return
     *     returns The label associated that explain the value of these blood pressures
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    public String getBloodPressureLabel(
        @WebParam(name = "arg0", targetNamespace = "")
        double minbloodpressure,
        @WebParam(name = "arg1", targetNamespace = "")
        double maxbloodpressure);

}
