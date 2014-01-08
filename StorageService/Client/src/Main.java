import it.unitn.sde.finalproject.*;

import java.util.*;



public class Main {
	
	public static void main(String[] args) {
		CRUDPerson cperson = new PersonService().getCRUD();
		CRUDGoal cgoal = new GoalService().getCRUD();
		
		cperson.linkgoal(1, 2);
	}

}
