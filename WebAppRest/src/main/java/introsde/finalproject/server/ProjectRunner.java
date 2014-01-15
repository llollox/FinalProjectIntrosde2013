package introsde.finalproject.server;

import finalproject.server.StorageServicePublisher;
import introsde.finalproject.calories.server.CaloriesCalculatorPublisher;
import introsde.random.server.RandomServer;

import com.introsde.food.service.server.FoodServicePublisher;

public class ProjectRunner {

	public static void main(String[] args) throws Exception {

		new CaloriesCalculatorPublisher();
		new FoodServicePublisher();
		new StorageServicePublisher();
		new SuggestGoalActivityServer();
		new RandomServer();
		new WebAppRestServer();

	}
}
