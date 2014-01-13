package introsde.finalproject.calories.client;

public class Client {

	public static void main(String[] args) {
		CaloriesCalculator cc = new CaloriesService().getCalculator();
		System.out.println("BMI 15 -> LABEL = " + cc.getBmiLabel((double)15));
		System.out.println("BMI 20 -> LABEL = " + cc.getBmiLabel((double)20));
		System.out.println("BMI 24 -> LABEL = " + cc.getBmiLabel((double)24));
		System.out.println("BMI 28 -> LABEL = " + cc.getBmiLabel((double)28));
		System.out.println("BMI 32 -> LABEL = " + cc.getBmiLabel((double)32));
		System.out.println("BLOADPRESSURE 80,120 -> LABEL = " + cc.getBloodPressureLabel(80, 120));
		System.out.println("BLOADPRESSURE 75,130 -> LABEL = " + cc.getBloodPressureLabel(75, 130));
		System.out.println("BLOADPRESSURE 65,85 -> LABEL = " + cc.getBloodPressureLabel(65, 85));
		System.out.println("BLOADPRESSURE 120,140 -> LABEL = " + cc.getBloodPressureLabel(120, 140));
	}

}
