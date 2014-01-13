package com.introsde.food.service.server;

import javax.xml.ws.Endpoint;

import com.introsde.food.service.ports.Food;

public class FoodServicePublisher {

	public FoodServicePublisher() {
		Endpoint.publish("http://localhost:5920/foodservice/recipes", new Food());

		System.out.println("Started Food Publisher");
	}

}
