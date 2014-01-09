package it.unitn.sde.finalproject.client;

import it.unitn.sde.finalproject.CaloriesCalculator;
import it.unitn.sde.finalproject.CaloriesService;

import java.util.Calendar;
import java.util.Date;

public class Main {
  public static void main (String[] args){
	 
	 CaloriesCalculator cc = new CaloriesService().getCalculator();
	  
	Calendar c = Calendar.getInstance();
	c.add(Calendar.DAY_OF_MONTH, 100);
	System.out.println("Calories Needed Per Week To Lose 10kg in 100days!!");
	for (int i = 0;i<10;i++){
		System.out.println("Amount Exercise = "+  i + 
				" Calories = "  + cc.getDailyCaloriesNeededToManageWeight(cc.getBMR(175, 68.5, 23, 1),i, 10, new Date(), c.getTime()));
	}
	
}
}
