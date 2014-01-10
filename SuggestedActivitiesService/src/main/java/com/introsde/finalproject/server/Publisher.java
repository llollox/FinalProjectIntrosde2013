package com.introsde.finalproject.server;

import javax.xml.ws.Endpoint;

import com.introsde.finalproject.prot.SuggestedActivities;

public class Publisher {
	public static void main(String[] args){
		Endpoint.publish("http://localhost:5980/suggested/activities", new SuggestedActivities());
		System.out.println("Started Calories Calculator Publisher");
	}
}
