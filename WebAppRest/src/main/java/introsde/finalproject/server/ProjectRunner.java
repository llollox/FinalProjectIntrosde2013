package introsde.finalproject.server;

import java.io.IOException;
import java.net.InetAddress;

import introsde.finalproject.calories.port.CaloriesCalculator;

import javax.xml.ws.Endpoint;

import com.introsde.food.service.ports.Food;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

import finalproject.ports.CRUDActivity;
import finalproject.ports.CRUDActivityChoosen;
import finalproject.ports.CRUDExcludedFood;
import finalproject.ports.CRUDExercise;
import finalproject.ports.CRUDExerciseCategory;
import finalproject.ports.CRUDExerciseHistory;
import finalproject.ports.CRUDFavouriteFood;
import finalproject.ports.CRUDGoal;
import finalproject.ports.CRUDHealthProfile;
import finalproject.ports.CRUDPerson;

public class ProjectRunner {
	public static void main(String[] args) throws IllegalArgumentException,
	IOException{
		
        // CALORIES CALCULATOR SERVICE
		Endpoint.publish("http://localhost:5990/calories/calculator",
				new CaloriesCalculator());
		System.out.println("Started Calories Calculator Publisher");
		
		// FOOD SERVICE
		Endpoint.publish("http://localhost:5920/foodservice/recipes",
				new Food());
		System.out.println("Started Food Publisher");
		
		// STORAGE SERVICE
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/person", new CRUDPerson());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/healthprofile", new CRUDHealthProfile());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/goal", new CRUDGoal());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/activitychoosen", new CRUDActivityChoosen());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/exercisehistory", new CRUDExerciseHistory());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/activity", new CRUDActivity());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/excludedfood", new CRUDExcludedFood());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/favouritefood", new CRUDFavouriteFood());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/exercise", new CRUDExercise());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/exercisecategory", new CRUDExerciseCategory());
		System.out.println("Started Storage Service Publisher");
		
		
		// RESTONE SERVICE
		String protocol = "http://"; // of course...
		String port = ":5900/"; // you can use any other as long as it is not in
								// use
		String hostname = InetAddress.getLocalHost().getHostAddress();
		if (hostname.equals("127.0.0.1")) {
			hostname = "localhost";
		}
		String baseUrl = protocol + hostname + port;
		final HttpServer server = HttpServerFactory.create(baseUrl);
		server.start();
		System.out.println("Server starts on " + baseUrl
				+ "\n [kill the process to exit]");
	}
}
