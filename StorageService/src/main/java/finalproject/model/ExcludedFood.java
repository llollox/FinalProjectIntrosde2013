package finalproject.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import finalproject.utils.DatabaseUtil;

@Entity
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ExcludedFood.getFoodPerson", query = "select f from ExcludedFood f where f.person.id = :pid") })
public class ExcludedFood {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private Person person;

	public ExcludedFood() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlTransient
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	// ##########################################
	// # CRUD
	// ##########################################

	public static List<ExcludedFood> getPersonFood(int pid) {
		EntityManager em = DatabaseUtil.createEntityManager();
		List<ExcludedFood> list = em
				.createNamedQuery("ExcludedFood.getFoodPerson",
						ExcludedFood.class).setParameter("pid", pid)
				.getResultList();
		em.close();
		return list;
	}

	public static ExcludedFood create(ExcludedFood a) {
		// reset id
		a.setId(0);

		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.persist(a);
		tx.commit();

		em.close();
		return a;
	}

	public static ExcludedFood read(int id) {
		EntityManager em = DatabaseUtil.createEntityManager();
		ExcludedFood a = em.find(ExcludedFood.class, id);
		em.close();
		return a;
	}

	public static ExcludedFood update(ExcludedFood a) {

		if (a.getId() <= 0)
			return null;

		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		a = em.merge(a);
		tx.commit();
		em.close();

		return a;
	}

	public static boolean delete(int id) {
		ExcludedFood a = read(id);

		if (a == null)
			return false;

		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		a = em.merge(a);
		em.remove(a);
		tx.commit();

		em.close();

		return true;
	}

}
