package finalproject.ports;

import java.util.List;

import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import finalproject.client.interfaces.PersonWebInterface;
import finalproject.model.Person;
import finalproject.utils.DatabaseUtil;

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
		// Person p = Person.read(idperson);
		// Goal g = Goal.read(idgoal);
		//
		// if (p.getGoals().contains(g))
		// return;
		//
		// p.getGoals().add(g);
		// g.getPeople().add(p);
		//
		// Person.update(p);
	}
	
	public void setGoalProgress(int idperson, int idgoal, double percentage) {
		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.createNativeQuery(
				"UPDATE Person_has_Goal SET percentage=?percentage WHERE idperson=?idperson and idgoal=?idgoal")
				.setParameter("percentage", percentage)
				.setParameter("idperson", idperson)
				.setParameter("idgoal", idgoal).executeUpdate();
		tx.commit();

		em.close();
	}

	public Double getGoalProgress(int idperson, int idgoal) {

		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Double result = (Double) em
				.createNativeQuery(
						"SELECT percentage FROM introsde.Person_has_Goal WHERE idperson =?idperson AND idgoal =?idgoal")
				.setParameter("idperson", idperson)
				.setParameter("idgoal", idgoal).getSingleResult();
		tx.commit();

		em.close();
		return result;
	}

	public void setGoalValue(int idperson, int idgoal, String value) {
		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.createNativeQuery(
				"UPDATE Person_has_Goal SET value=?value WHERE idperson=?idperson and idgoal=?idgoal")
				.setParameter("value", value)
				.setParameter("idperson", idperson)
				.setParameter("idgoal", idgoal).executeUpdate();
		tx.commit();

		em.close();
	}

	public String getGoalValue(int idperson, int idgoal) {
		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		String result = (String) em
				.createNativeQuery(
						"SELECT value FROM introsde.Person_has_Goal WHERE idperson =?idperson AND idgoal =?idgoal")
				.setParameter("idperson", idperson)
				.setParameter("idgoal", idgoal).getSingleResult();
		tx.commit();

		em.close();
		return result;
	}
	
	public void setGoalEndDate(int idperson, int idgoal, String enddate) {
		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.createNativeQuery(
				"UPDATE Person_has_Goal SET enddate=?enddate WHERE idperson=?idperson and idgoal=?idgoal")
				.setParameter("enddate", enddate)
				.setParameter("idperson", idperson)
				.setParameter("idgoal", idgoal).executeUpdate();
		tx.commit();

		em.close();
	}

	public String getGoalEndDate(int idperson, int idgoal) {
		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		String result = (String) em
				.createNativeQuery(
						"SELECT enddate FROM introsde.Person_has_Goal WHERE idperson =?idperson AND idgoal =?idgoal")
				.setParameter("idperson", idperson)
				.setParameter("idgoal", idgoal).getSingleResult();
		tx.commit();

		em.close();
		return result;
	}
}
