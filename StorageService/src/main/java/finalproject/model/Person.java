package finalproject.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import finalproject.utils.DatabaseUtil;
import finalproject.utils.Utils;

@NamedQueries({
		@NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
		@NamedQuery(name = "Person.findByBirthdate", query = "SELECT p FROM Person p WHERE p.birthdate < :end AND p.birthdate > :start"),
		@NamedQuery(name = "Person.getByHeight", query = "SELECT p FROM Person p, HealthProfile h WHERE h.height <= :max AND h.height >= :min AND h.person.id = p.id"),
		@NamedQuery(name = "Person.getByWeight", query = "SELECT p FROM Person p, HealthProfile h WHERE h.weight <= :max AND h.weight >= :min AND h.person.id = p.id"),
		@NamedQuery(name = "Person.findByName", query = "SELECT p FROM Person p WHERE (p.firstname LIKE CONCAT(CONCAT('%', :name), '%')) OR (p.lastname LIKE CONCAT(CONCAT('%', :name), '%'))") })
@Entity
@XmlRootElement(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private Integer sex;
	private String firstname;
	private String lastname;
	private String birthdate;
	private Integer exerciseTimesPerWeek;

	@Transient
	private ExtendedHealthProfile extendedhealthprofile;

	// @ManyToMany
	// @JoinTable(name = "Person_has_Goal", joinColumns = { @JoinColumn(name =
	// "idperson", referencedColumnName = "id") }, inverseJoinColumns = {
	// @JoinColumn(name = "idgoal", referencedColumnName = "id") })
	// private List<Goal> goals = new ArrayList<Goal>();

	@OneToMany(mappedBy = "person", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<GoalChoosen> goalchoosen = new ArrayList<GoalChoosen>();

	@OneToMany(mappedBy = "person", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<HealthProfile> healthprofiles = new ArrayList<HealthProfile>();

	public Person() {
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getExerciseTimesPerWeek() {
		return exerciseTimesPerWeek;
	}

	public void setExerciseTimesPerWeek(Integer exerciseTimesPerWeek) {
		this.exerciseTimesPerWeek = exerciseTimesPerWeek;
	}

	public ExtendedHealthProfile getExtendedhealthprofile() {
		return extendedhealthprofile;
	}

	public void setExtendedhealthprofile(
			ExtendedHealthProfile extendedhealthprofile) {
		this.extendedhealthprofile = extendedhealthprofile;
	}

	// READ ONLY ELEMENTS

	public static List<Person> getAll() {
		EntityManager em = DatabaseUtil.createEntityManager();
		List<Person> list = em.createNamedQuery("Person.findAll", Person.class)
				.getResultList();
		;
		em.close();
		return list;
	}

	// @XmlElement(name = "goals")
	// public List<Goal> getGoals() {
	// return goals;
	// }

	@XmlTransient
	public List<GoalChoosen> getGoalchoosen() {
		return goalchoosen;
	}

	@XmlElement(name = "healthprofile")
	public HealthProfile getHealthprofile() {
		if (healthprofiles.size() == 0)
			return null;
		return healthprofiles.get(healthprofiles.size() - 1);
	}

	@XmlElement(name = "healthprofilehistory")
	public List<HealthProfile> getHealthProfileHistory() {
		return this.healthprofiles;
	}

	// ##########################################
	// # CRUD
	// ##########################################

	public static Person create(Person p) {
		// reset id
		p.setId(0);

		if (p.getFirstname() == null || p.getLastname() == null)
			return null;

		if (p.getSex() == null || (p.getSex() != 1 && p.getSex() != 0))
			return null;

		if (p.getBirthdate() != null && !Utils.isDateValid(p.getBirthdate()))
			return null;

		if (p.getExerciseTimesPerWeek() == null
				|| p.getExerciseTimesPerWeek() < 0
				|| p.getExerciseTimesPerWeek() > 7)
			return null;

		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.persist(p);
		tx.commit();

		em.close();
		return p;
	}

	public static Person read(int id) {
		EntityManager em = DatabaseUtil.createEntityManager();
		Person p = em.find(Person.class, id);
		em.close();
		return p;
	}

	public static Person update(Person p) {
		Person person = Person.read(p.getId());

		if (person == null)
			return null;

		if (p.getId() <= 0)
			return null;

		if (p.getFirstname() == null || p.getLastname() == null)
			return null;

		if (p.getSex() == null || (p.getSex() != 1 && p.getSex() != 0))
			return null;

		if (p.getBirthdate() != null && !Utils.isDateValid(p.getBirthdate()))
			return null;

		if (p.getExerciseTimesPerWeek() == null)
			return null;

		person.setFirstname(p.getFirstname());
		person.setLastname(p.getLastname());
		person.setSex(p.getSex());
		person.setExerciseTimesPerWeek(p.getExerciseTimesPerWeek());
		person.setBirthdate(p.getBirthdate());

		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		person = em.merge(person);
		tx.commit();
		em.close();

		return person;
	}

	public static boolean delete(int id) {
		Person p = read(id);

		if (p == null)
			return false;

		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		p = em.merge(p);
		em.remove(p);
		tx.commit();

		em.close();

		return true;
	}

	public static List<Person> getByBirthdate(String start, String end) {
		EntityManager em = DatabaseUtil.createEntityManager();
		List<Person> list = em
				.createNamedQuery("Person.findByBirthdate", Person.class)
				.setParameter("start", start).setParameter("end", end)
				.getResultList();
		;
		em.close();
		return list;
	}

	public static List<Person> getByHeight(String min, String max) {
		EntityManager em = DatabaseUtil.createEntityManager();
		List<Person> list = em
				.createNamedQuery("Person.getByHeight", Person.class)
				.setParameter("min", Double.parseDouble(min))
				.setParameter("max", Double.parseDouble(max)).getResultList();
		em.close();
		return list;
	}

	public static List<Person> getByWeight(String min, String max) {
		EntityManager em = DatabaseUtil.createEntityManager();
		List<Person> list = em
				.createNamedQuery("Person.getByWeight", Person.class)
				.setParameter("min", Double.parseDouble(min))
				.setParameter("max", Double.parseDouble(max)).getResultList();
		;
		em.close();
		return list;
	}

	public static List<Person> getByName(String name) {
		EntityManager em = DatabaseUtil.createEntityManager();
		List<Person> list = em
				.createNamedQuery("Person.findByName", Person.class)
				.setParameter("name", name).getResultList();
		;
		em.close();
		return list;
	}

}
