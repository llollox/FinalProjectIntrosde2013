package finalproject.server;

import javax.xml.ws.Endpoint;

import finalproject.ports.CRUDActivity;
import finalproject.ports.CRUDExcludedFood;
import finalproject.ports.CRUDExercise;
import finalproject.ports.CRUDExerciseCategory;
import finalproject.ports.CRUDExerciseHistory;
import finalproject.ports.CRUDFavouriteFood;
import finalproject.ports.CRUDGoal;
import finalproject.ports.CRUDGoalChoosen;
import finalproject.ports.CRUDHealthProfile;
import finalproject.ports.CRUDPerson;

public class StorageServicePublisher {

	public StorageServicePublisher() {
		Endpoint.publish(
				"http://localhost:5910/lifestyle/storageservice/person",
				new CRUDPerson());
		Endpoint.publish(
				"http://localhost:5910/lifestyle/storageservice/healthprofile",
				new CRUDHealthProfile());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/goal",
				new CRUDGoal());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/goalchoosen",
				new CRUDGoalChoosen());
		Endpoint.publish(
				"http://localhost:5910/lifestyle/storageservice/exercisehistory",
				new CRUDExerciseHistory());
		Endpoint.publish(
				"http://localhost:5910/lifestyle/storageservice/activity",
				new CRUDActivity());
		Endpoint.publish(
				"http://localhost:5910/lifestyle/storageservice/excludedfood",
				new CRUDExcludedFood());
		Endpoint.publish(
				"http://localhost:5910/lifestyle/storageservice/favouritefood",
				new CRUDFavouriteFood());
		Endpoint.publish(
				"http://localhost:5910/lifestyle/storageservice/exercise",
				new CRUDExercise());
		Endpoint.publish(
				"http://localhost:5910/lifestyle/storageservice/exercisecategory",
				new CRUDExerciseCategory());

		System.out.println("Started Storage Service Publisher");
	}
	
	public static void main(String[] args) {
		new StorageServicePublisher();
	}

}
