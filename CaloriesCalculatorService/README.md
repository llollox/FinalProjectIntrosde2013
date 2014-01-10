##Calories Calculator

This is a simple SOAP service that provide some calories calculation stuff.

####Documentation

* <b>GET IDEAL WEIGHT</b> 
```java
public double getIdealWeight(double height)``` 
	- @PARAMS
		* <b>height</b> is the height of the person, you can pass both in meters or centimeters. 
	
	- @RETURN is a double that indicates ideal weight.
	
	The ideal weight is 52 kg + 1.9kg for each inch of height over 152.4cm (1 inch = 2.54cm).

* <b>GET IDEAL BMI</b> ```public double getIdealBMI(double height)``` 
	- @PARAMS
		* <b>height</b> is the height of the person, you can pass both in meters or centimeters. 
	
	- @RETURN the BMI calculated for a person that have this height.
	
	The BMI provides a reliable indicator of body fatness for most people and is used to screen for weight categories that may lead to health problems.

* <b>GET BMR</b> ```public double getBMR(double height, double weight, double age, int sex)``` 
	- @PARAMS
		* <b>height</b> can passed both in meters or centimeters.
		* <b>weight</b> can passed both in kg or grams.
		* <b>age</b> must be passed in years as double.
		* <b>sex</b> is the sex of that person, 1 for man and 0 for woman.
	
	- @RETURN the <b>BMR</b> calculated for a person that have this height and weight.
	
	The BMR is the amount of energy expended daily by humans and other animals at rest. Rest is defined as existing in a neutrally temperate environment while in the postabsorptive state.

* <b>GET IDEAL DAILY CALORIES NEEDED</b> 
  ```public double getIdealDailyCaloriesNeeded(double bmr, int exerciseAmountPerWeek)``` 
	- @PARAMS 
		* <b>bmr</b> is the amount of energy expended daily by humans and other animals at rest.
		* <b>exerciseAmountPerWeek</b> is the number of times that this person do exercise in a week.
	
	- @RETURN the amount of calories needed for that person to maintain his weight and doing this amount of exercise per week.

* <b>GET IDEAL DAILY CALORIES NEEDED TO MANAGE WEIGHT</b> 
  ```
  public double getDailyCaloriesNeededToManageWeight(double bmr, int exerciseAmountPerWeek, 
  double weightDifference, Date startDate, Date endDate)
  ```
	- @PARAMS
		* <b>bmr</b> is the amount of energy expended daily by humans and other animals at rest. 
		* <b>exerciseAmountPerWeek</b> is the number of times that this person do exercise in a week.
		* <b>weightDifference</b> weight difference that you want get or lose. You can pass it both in kg or grams.
		* <b>startDate</b> the day that you want to start this diet.
		* <b>endDate</b> the day that you want to finish this diet.

	- @RETURN the amount of calories needed for that person to maintain his weight and doing this amount of exercise per week. 