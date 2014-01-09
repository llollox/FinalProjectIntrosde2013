package com.introsde.project.server;

import javax.xml.ws.Endpoint;

import com.introsde.project.ports.ReadRecipes;

public class Publisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:5920/food/readrecipes",
				new ReadRecipes());

		System.out.println("Started Publisher");
	}

}
