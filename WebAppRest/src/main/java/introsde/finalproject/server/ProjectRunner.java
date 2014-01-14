package introsde.finalproject.server;

import finalproject.server.StorageServicePublisher;
import introsde.finalproject.calories.server.CaloriesCalculatorPublisher;

import java.io.IOException;

import com.introsde.food.service.server.FoodServicePublisher;

public class ProjectRunner {

	public static void main(String[] args) throws IllegalArgumentException,
			IOException {

		new CaloriesCalculatorPublisher();
		new FoodServicePublisher();
		new StorageServicePublisher();
		new WebAppRestServer();
		
	}
}
