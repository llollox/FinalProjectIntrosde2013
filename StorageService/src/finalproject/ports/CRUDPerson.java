package finalproject.ports;

import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import finalproject.model.Goal;
import finalproject.model.Person;
import finalproject.utils.DatabaseUtil;

@WebService(
		serviceName = "PersonService",
		portName = "CRUD",
		targetNamespace = "http://finalproject.sde.unitn.it/"
)
public class CRUDPerson {

	// CREATE PERSON
	public int createPerson(Person person) {
		Person p = Person.create(person);
		
		if (p == null)
			return -1;
		
		return p.getId();
	}
	
	// READ PERSON
	public Person readPerson(int id) {
		return Person.read(id);
	}

	// UPDATE PERSON
	public int updatePerson(Person person) {
		Person p = Person.update(person); 
		
		if (p == null)
			return -1;
		
		return p.getId();
	}

	// DELETE PERSON
	public boolean deletePerson(int id) {
		return Person.delete(id);
	}
	
	// ADD GOAL TO PERSON
	public void linkGoal(int idperson, int idgoal) {
		Person p = Person.read(idperson);
		Goal g = Goal.read(idgoal);
		
		if (p.getGoals().contains(g))
			return;
		
		p.getGoals().add(g);
		g.getPeople().add(p);
		
		Person.update(p);
	}
}
