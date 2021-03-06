
package introsde.finalproject.calories.port;

import java.io.ObjectInputStream.GetField;
import java.util.Calendar;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(
		serviceName = "CaloriesService",
		portName = "Calculator",
		targetNamespace = "http://finalproject.sde.unitn.it/"
)
public class CaloriesCalculator {
	
	public static double NO_EXERCISE = 1.2; // NO Exercise done!
	public static double LIGHT_EXERCISE = 1.375; // Light exercise (1???3 days per week)
	public static double MODERATE_EXERCISE = 1.55; // Moderate exercise (3???5 days per week)
	public static double HEAVY_EXERCISE = 1.725; // Heavy exercise (6???7 days per week)
	public static double VERY_HEAVY_EXERCISE = 1.9; // Very heavy exercise (twice per day, extra heavy workouts)
	
	/**
	 * 
	 * @param height is the height of the person, you can pass both in meters or centimeters.
	 * @return is a double that indicates ideal weight.
	 * The ideal weight is 52 kg + 1.9kg for each inch of height over 152.4cm (1 inch = 2.54cm).
	 * 
	 */	
	@WebMethod
    public double getIdealWeight(double height, int sex){
    	if (height < 4) //height in meters
    		height = height * 100.0; //height converted in cm	
    	switch (sex) {
		case 0:
			return (100.0 * 0.45359237) + ((height-152.4)/2.54) * (5 * 0.45359237);
		case 1:
			return (106.0 * 0.45359237) + ((height-152.4)/2.54) * (6 * 0.45359237);
		}
    	return -1;
    }
    
    /**
	 * 
	 * @param height is the height of the person, you can pass both in meters or centimeters.
	 * @return the IDEAL BMI calculated for a person that have this height.
	 * The BMI provides a reliable indicator of body fatness for most people and is used to screen for weight categories that may lead to health problems.
	 * 
	 */
	@WebMethod
    public double getIdealBMI(double height, int sex){
    	if (height > 4) //height in centimeters
    		height = height / 100.0; //height converted in meters	
    	return getIdealWeight(height,sex) / (height * height);	
    }
	
	 /**
	 * 
	 * @param height is the height of the person, you can pass both in meters or centimeters.
	 * @param weight can passed both in kg or grams.
	 * @return the BMI calculated for a person that have this height.
	 * The BMI provides a reliable indicator of body fatness for most people and is used to screen for weight categories that may lead to health problems.
	 * 
	 */
	@WebMethod
    public double getBMI(double height, double weight){
    	if (height > 4) //height in centimeters
    		height = height / 100.0; //height converted in meters
    	if (weight > 1000) //weight in grams
    		weight = weight / 1000.0;
    	return weight / (height * height);	
    }
	
	/**
   	 * @param bmi (double) is the bmi of a person. 
   	 * @return The label associated that explain the value of this bmi
   	 */
	@WebMethod
	public String getBmiLabel(double bmi){
		if (bmi <= 18.5)
			return "Underweight";
		else if (bmi > 18.5 && bmi <= 25)
			return "Normal";
		else if (bmi > 25 && bmi <= 30)
			return "Overweight";
		else if (bmi > 30)
			return "Obese";
		return null;
	}
    
    /**
	 * 
	 * @param height can passed both in meters or centimeters.
	 * @param weight can passed both in kg or grams.
	 * @param age must be passed in years as double.
	 * @param sex is the sex of that person, 1 for man and 0 for woman.
	 * @return the BMR calculated for a person that have this height and weight.
	 * The BMR is the amount of energy expended daily by humans and other animals at rest. Rest is defined as existing in a neutrally temperate environment while in the postabsorptive state.
	 * @see http://en.wikipedia.org/wiki/Basal_metabolic_rate
	 */	
	@WebMethod
    public double getBMR(double height, double weight, double age, int sex){
    	if (height < 4) //height in meters
    		height = height * 100.0; //height converted in cm	
    	if (weight > 1000) //weight in grams
    		weight = weight / 1000.0;
    	
    	if (sex == 1)
    		return 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
    	else if (sex == 0)
    		return 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
    	else 
    		return -1; //sex not recognized!
    }
    
    /**
	 * @param bmr is the amount of energy expended daily by humans and other animals at rest. 
	 * @param exerciseAmountPerWeek is the number of times that this person do exercise in a week
	 * @return the amount of calories needed for that person to maintain his weight and doing this amount of exercise per week.
	 */
	@WebMethod
    public double getIdealDailyCaloriesNeeded(double bmr, int exerciseTimesPerWeek){
    	switch (exerciseTimesPerWeek) {
		case 0:
			return bmr * NO_EXERCISE;
		case 1:
			return bmr * (LIGHT_EXERCISE - 0.1);
		case 2:
			return bmr * LIGHT_EXERCISE;
		case 3:
			return bmr * (LIGHT_EXERCISE + 0.1);
		case 4:
			return bmr * MODERATE_EXERCISE;
		case 5:
			return bmr * (MODERATE_EXERCISE + 0.1);
		case 6:
			return bmr * (HEAVY_EXERCISE - 0.025);
		case 7:
			return bmr * (HEAVY_EXERCISE + 0.075) ;
		case 8:
			return bmr * VERY_HEAVY_EXERCISE;
		case 9:
			return bmr * (VERY_HEAVY_EXERCISE + 0.1);
		default:
			break;
		}
    	return -1;
    }
    
    /**
   	 * @param bmr (double) is the amount of energy expended daily by humans and other animals at rest. 
   	 * @param exerciseTimesPerWeek (int) is the number of times that this person do exercise in a week
   	 * @param weightDifference (double) weight difference that you want get or lose. You can pass it both in kg or grams.
   	 * @param startDate the day that you want to start this diet.
   	 * @param endDate the day that you want to finish this diet.
   	 * @return the amount of calories needed for that person to manage his weight in the period that he have specified.
   	 */
	@WebMethod
    public double getDailyCaloriesNeededToManageWeight(double bmr, int exerciseTimesPerWeek, double weightDifference, int days){
    	if (weightDifference > 1000) //weight in grams
    		weightDifference = weightDifference / 1000.0;
    	
    	double weeksDifference = days/7.0;
    	double difficultCoefficient = (double) weightDifference / weeksDifference;
    	
    	if (Math.abs(difficultCoefficient) > 1) 
    		return -1.0;  // impossible to reach!
    	else{
    		double dailyCaloriesNeeded = getIdealDailyCaloriesNeeded(bmr, exerciseTimesPerWeek);
    		double dailyCaloriesNeededManaged =	dailyCaloriesNeeded + ((double) weightDifference * 7800) / (double) days;
    		if (dailyCaloriesNeededManaged < bmr)
    			return -1; //impossible to reach
    		else
    			return dailyCaloriesNeededManaged;
    	}
    }
	
	/**
   	 * @param age (double) is the age of a person. 
   	 * @param heartRate (int) average bpm of his heart. 
   	 * @return The Target Heart Rate (THR) at which you MAXIMIZE the benefits of cardiovascular activity when you exercise in this zone of your target heart rate
   	 */
	@WebMethod
	public double getTargetHeartRate(double age, int heartRate){
		double maximumHeartRate = 220 - age;
		double heartRateReserve = maximumHeartRate - heartRate;
		double lowerLimit = (heartRateReserve * 0.6) + heartRate;
		double upperLimit = (heartRateReserve * 0.8) + heartRate;
		return (upperLimit + lowerLimit)/2;
	}
	
	/**
   	 * @param minbloodpressure (double) is minimum blood pressure of the person
   	 * @param maxnbloodpressure (double) is maximum blood pressure of the person 
   	 * @return The label associated that explain the value of these blood pressures.
   	 */
	@WebMethod
	public String getBloodPressureLabel(double minbloodpressure, double maxbloodpressure){
		if (isBetween(maxbloodpressure, 91, 120))
			return "Normal";
		else if (isBetween(maxbloodpressure, 121, 140))
			return "High";
		else if (isBetween(maxbloodpressure, 0, 90))
			return "Low";
		else if (isBetween(maxbloodpressure, 141, 250))
			return "Very High";
		return null;
	}
    
	private static boolean isBetween(double value, double lowerbound, double upperbound){
		if (value >= lowerbound && value <= upperbound)
			return true;
		else 
			return false;
	}
	
    private static int daysBetween(Date d1, Date d2){
    	if (d2.getTime() == d1.getTime())
    		return 0;
    	else
    		return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24)) + 1;
     }
}
