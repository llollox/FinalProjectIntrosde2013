package introsde.finalproject.server;

import finalproject.server.StorageServicePublisher;
import introsde.finalproject.calories.server.CaloriesCalculatorPublisher;

import com.introsde.food.service.server.FoodServicePublisher;

public class ProjectRunner {

	public static void main(String[] args) throws Exception {

		new CaloriesCalculatorPublisher();
		new FoodServicePublisher();
		new StorageServicePublisher();
		new WebAppRestServer();
		new SuggestGoalActivityServer();

	}
}
