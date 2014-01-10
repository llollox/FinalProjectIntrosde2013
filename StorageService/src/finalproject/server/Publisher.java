package finalproject.server;

import javax.xml.ws.Endpoint;

import finalproject.ports.CRUDActivity;
import finalproject.ports.CRUDActivityChoosen;
import finalproject.ports.CRUDExcludedFood;
import finalproject.ports.CRUDExercise;
import finalproject.ports.CRUDExerciseCategory;
import finalproject.ports.CRUDExerciseHistory;
import finalproject.ports.CRUDFavouriteFood;
import finalproject.ports.CRUDGoal;
import finalproject.ports.CRUDPerson;
import finalproject.ports.CUHealthProfile;

public class Publisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/person", new CRUDPerson());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/healthprofile", new CUHealthProfile());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/goal", new CRUDGoal());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/activitychoosen", new CRUDActivityChoosen());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/exercisehistory", new CRUDExerciseHistory());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/activity", new CRUDActivity());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/excludedfood", new CRUDExcludedFood());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/favouritefood", new CRUDFavouriteFood());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/exercise", new CRUDExercise());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/exercisecategory", new CRUDExerciseCategory());
		
		System.out.println("Started Publisher");
	}
	
}
