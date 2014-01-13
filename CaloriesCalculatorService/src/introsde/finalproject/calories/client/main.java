package introsde.finalproject.calories.client;

public class main {

	public static void main(String[] args) {
		CaloriesCalculator cc = new CaloriesService().getCalculator();
		System.out.println("BMI = " + cc.getBMI(180, 80));
		System.out.println("HEARTRATE = " + cc.getTargetHeartRate(23, 70));
	}

}
