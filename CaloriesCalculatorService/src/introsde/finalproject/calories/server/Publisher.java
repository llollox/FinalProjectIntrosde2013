package introsde.finalproject.calories.server;

import introsde.finalproject.calories.port.CaloriesCalculator;

import javax.xml.ws.Endpoint;

public class Publisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:5990/calories/calculator",
				new CaloriesCalculator());

		System.out.println("Started Calories Calculator Publisher");
	}
}
