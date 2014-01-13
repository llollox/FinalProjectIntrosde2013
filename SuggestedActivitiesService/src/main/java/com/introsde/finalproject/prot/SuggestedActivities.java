package com.introsde.finalproject.prot;

import javax.jws.WebService;

@WebService(serviceName = "SuggestedActivityService", portName = "SuggestedActivity", targetNamespace = "http://finalproject.sde.unitn.it/")
public class SuggestedActivities {

	/**
	 * 
	 * @param goalList
	 *            is the list of goals that the person has chosen
	 * @param hp
	 *            is the health profile of the person.
	 * @return The list of suggested activities for that person based on his
	 *         health profile and goals choosen.
	 * 
	 */
	// // @WebMethod
	// public Activity[] getSuggestedActivities(HealthProfile hp, Goal[]
	// goalList) {
	// for (Goal goal : goalList) {
	//
	// }
	// return null;
	//
	// }

}
