package finalproject.ports;

import java.util.List;

import javax.jws.WebService;

import finalproject.model.Goal;
import finalproject.model.Person;

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
	
	// GET PEOPLE
	public List<Person> getPeople() {
		return Person.getAll();
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
