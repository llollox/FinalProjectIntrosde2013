package finalproject.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import finalproject.utils.DatabaseUtil;

@Entity
@XmlRootElement
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private Integer sex;
	private String firstname;
	private String lastname;
	private String birthdate;

	@ManyToMany
	@JoinTable(name = "Person_has_Goal", joinColumns = { @JoinColumn(name = "idperson", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "idgoal", referencedColumnName = "id") })
	private List<Goal> goals = new ArrayList<Goal>();

	@OneToMany(mappedBy = "person", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<HealthProfile> healthprofiles = new ArrayList<HealthProfile>();

	public Person() {
	}

	public List<Goal> getGoals() {
		return goals;
	}

	public void setGoals(List<Goal> goals) {
		this.goals = goals;
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

	// READ ONLY ELEMENTS

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

		if (p.getBirthdate() != null && !isDateValid(p.getBirthdate()))
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

		if (p.getId() <= 0)
			return null;

		if (p.getFirstname() == null || p.getLastname() == null)
			return null;

		if (p.getSex() == null || (p.getSex() != 1 && p.getSex() != 0))
			return null;

		if (p.getBirthdate() != null && !isDateValid(p.getBirthdate()))
			return null;

		Person person = Person.read(p.getId());
		person.setFirstname(p.getFirstname());
		person.setLastname(p.getLastname());

		if (p.getBirthdate() != null)
			person.setBirthdate(p.getBirthdate());

		if ((p.getGoals() != null) || (p.getGoals().size() != 0))
			person.setGoals(p.getGoals());

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

	private static boolean isDateValid(String date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		df.setLenient(false);

		try {
			df.parse(date);
		} catch (ParseException e) {
			return false;
		}

		if (date.length() != 10)
			return false;

		return true;
	}

}
