package finalproject.server;

import javax.xml.ws.Endpoint;

import finalproject.ports.CRUDActivity;
import finalproject.ports.CRUDActivityHistory;
import finalproject.ports.CRUDActivityHistoryValue;
import finalproject.ports.CRUDActivityValueType;
import finalproject.ports.CRUDGoal;
import finalproject.ports.CRUDPerson;
import finalproject.ports.CUHealthProfile;

public class Publisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/person", new CRUDPerson());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/healthprofile", new CUHealthProfile());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/goal", new CRUDGoal());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/activityvaluetype", new CRUDActivityValueType());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/activityhistory", new CRUDActivityHistory());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/activity", new CRUDActivity());
		Endpoint.publish("http://localhost:5910/lifestyle/storageservice/activityhistoryvalue", new CRUDActivityHistoryValue());
		
		System.out.println("Started Publisher");
	}
	
}
