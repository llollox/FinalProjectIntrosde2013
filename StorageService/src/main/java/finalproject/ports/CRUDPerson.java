package finalproject.ports;

import java.util.List;

import javax.jws.WebService;

import finalproject.client.interfaces.PersonWebInterface;
import finalproject.model.Goal;
import finalproject.model.Person;

@WebService(serviceName = "PersonService", portName = "CRUD", targetNamespace = "http://finalproject.sde.unitn.it/")
public class CRUDPerson implements PersonWebInterface {

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

	// GET PEOPLE BY NAME
	public List<Person> getPeopleByName(String name) {
		return Person.getByName(name);
	}

	// GET PEOPLE BY BIRTHDATE
	public List<Person> getPeopleByBirthdate(String start, String end) {
		return Person.getByBirthdate(start, end);
	}

	// GET PEOPLE BY MASURE
	public List<Person> getPeopleByMeasure(String measure, String min,
			String max) {
		if (measure.equals("height"))
			return Person.getByHeight(min, max);
		else if (measure.equals("weight"))
			return Person.getByWeight(min, max);

		return null;
	}

	// UPDATE PERSON
	public int updatePerson(Person person) {
		Person p = Person.update(person);

		if (p == null)
			return -1;

		return p.getId();
	}

	// DELETE PERSON
	public int deletePerson(int id) {
		return Person.delete(id) ? id : -1;
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
