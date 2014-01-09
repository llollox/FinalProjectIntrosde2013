
package calories;

import java.util.Calendar;
import java.util.Date;

public class CaloriesUtils {
	
	public static double NO_EXERCISE = 1.2; // NO Exercise done!
	public static double LIGHT_EXERCISE = 1.375; // Light exercise (1–3 days per week)
	public static double MODERATE_EXERCISE = 1.55; // Moderate exercise (3–5 days per week)
	public static double HEAVY_EXERCISE = 1.725; // Heavy exercise (6–7 days per week)
	public static double VERY_HEAVY_EXERCISE = 1.9; // Very heavy exercise (twice per day, extra heavy workouts)
	
	/**
	 * 
	 * @param height is the height of the person, you can pass both in meters or centimeters.
	 * @return is a double that indicates ideal weight.
	 * The ideal weight is 52 kg + 1.9kg for each inch of height over 152.4cm (1 inch = 2.54cm).
	 * 
	 */	
    public static double getIdealWeight(double height){
    	if (height < 4) //height in meters
    		height = height * 100.0; //height converted in cm	
    	return 52 + (((height - 152.4)/2.54) * 1.9);	
    }
    
    /**
	 * 
	 * @param height is the height of the person, you can pass both in meters or centimeters.
	 * @return the BMI calculated for a person that have this height.
	 * The BMI provides a reliable indicator of body fatness for most people and is used to screen for weight categories that may lead to health problems.
	 * 
	 */	
    public static double getIdealBMI(double height){
    	if (height > 4) //height in centimeters
    		height = height / 100.0; //height converted in meters	
    	return CaloriesUtils.getIdealWeight(height) / (height * height);	
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
    public static double getBMR(double height, double weight, double age, int sex){
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
    public static double getIdealDailyCaloriesNeeded(double bmr, int exerciseAmountPerWeek){
    	switch (exerciseAmountPerWeek) {
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
    	return 0;
    }
    
    /**
   	 * @param bmr (double) is the amount of energy expended daily by humans and other animals at rest. 
   	 * @param exerciseAmountPerWeek (int) is the number of times that this person do exercise in a week
   	 * @param weightDifference (double) weight difference that you want get or lose. You can pass it both in kg or grams.
   	 * @param startDate the day that you want to start this diet.
   	 * @param endDate the day that you want to finish this diet.
   	 * @return the amount of calories needed for that person to manage his weight in the period that he have specified.
   	 */
    public static double getDailyCaloriesNeededToManageWeight(double bmr, int exerciseAmountPerWeek, double weightDifference, Date startDate, Date endDate){
    	if (weightDifference > 1000) //weight in grams
    		weightDifference = weightDifference / 1000.0;
    	double weeksDifference = daysBetween(startDate, endDate)/7.0;
    	if ((double) weightDifference / weeksDifference > 1.0) // impossible to reach!
    		return -1.0;
    	else{
    		double dailyCaloriesNeededToManageWeight = getIdealDailyCaloriesNeeded(bmr, exerciseAmountPerWeek) - ((double) weightDifference * 7800) / (daysBetween(startDate, endDate));
    		if (dailyCaloriesNeededToManageWeight < bmr)
    			return -1; //impossible to reach
    		else
    			return dailyCaloriesNeededToManageWeight;
    	}
    }
    
    public static void main (String[] args){
    	Calendar c = Calendar.getInstance();
    	c.add(Calendar.DAY_OF_MONTH, 100);
    	System.out.println("Calories Needed Per Week To Lose 10kg in 100days!!");
    	for (int i = 0;i<10;i++){
    		System.out.println("Amount Exercise = "+  i + 
    				" Calories = "  + getDailyCaloriesNeededToManageWeight(getBMR(175, 68.5, 23, 1),i, 10, new Date(), c.getTime()));
    	}
    	
    }
    
    public static int daysBetween(Date d1, Date d2){
    	if (d2.getTime() == d1.getTime())
    		return 0;
    	else
    		return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24)) + 1;
     }
}
