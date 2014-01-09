##Calories Calculator

This is a simple SOAP service that provide some calories calculation stuff.

####Documentation

* <b>GET IDEAL WEIGHT</b>
	- @PARAMS
		* <b>height</b> is the height of the person, you can pass both in meters or centimeters. 
	
	- @RETURN is a double that indicates ideal weight.
	
	```public double getIdealWeight(double height)``` 
	
	The ideal weight is 52 kg + 1.9kg for each inch of height over 152.4cm (1 inch = 2.54cm).

* <b>GET IDEAL BMI</b>
	
	@param <b>height</b> is the height of the person, you can pass both in meters or centimeters. 
	
	@return the BMI calculated for a person that have this height.
	
	```public double getIdealBMI(double height)``` 
	
	The BMI provides a reliable indicator of body fatness for most people and is used to screen for weight categories that may lead to health problems.

* <b>GET BMR</b>
	
	@param <b>height</b> can passed both in meters or centimeters.
	
	@param <b>weight</b> can passed both in kg or grams.
	
	@param <b>age</b> must be passed in years as double.
	
	@param <b>sex</b> is the sex of that person, 1 for man and 0 for woman.
	
	@return the <b>BMR</b> calculated for a person that have this height and weight.
	
	```public double getBMR(double height, double weight, double age, int sex)``` 
	
	The BMR is the amount of energy expended daily by humans and other animals at rest. Rest is defined as existing in a neutrally temperate environment while in the postabsorptive state.

* <b>GET IDEAL DAILY CALORIES NEEDED</b>
	
	@param <b>bmr</b> is the amount of energy expended daily by humans and other animals at rest.
	
	@param <b>exerciseAmountPerWeek</b> is the number of times that this person do exercise in a week.
	
	@return the amount of calories needed for that person to maintain his weight and doing this amount of exercise per week.
	
	```public double getIdealDailyCaloriesNeeded(double bmr, int exerciseAmountPerWeek)``` 

* <b>GET IDEAL DAILY CALORIES NEEDED</b>
	
	@param <b>bmr</b> is the amount of energy expended daily by humans and other animals at rest. 
	
	@param <b>exerciseAmountPerWeek</b> is the number of times that this person do exercise in a week.

	@param <b>weightDifference</b> weight difference that you want get or lose. You can pass it both in kg or grams.

	@param <b>startDate</b> the day that you want to start this diet.

	@param <b>endDate</b> the day that you want to finish this diet.

	@return the amount of calories needed for that person to maintain his weight and doing this amount of exercise per week.
	
	```public double getDailyCaloriesNeededToManageWeight(double bmr, int exerciseAmountPerWeek, double weightDifference, Date startDate, Date endDate)``` 