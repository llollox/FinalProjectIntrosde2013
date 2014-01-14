package finalproject.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import finalproject.utils.DatabaseUtil;
import finalproject.utils.DoubleDecimalAdapter;
import finalproject.utils.Utils;

@Entity
@XmlRootElement
@NamedQuery(name = "HealthProfile.findHp", query = "select hp from HealthProfile hp where hp.person.id = :pid and hp.id = :hpid")
public class HealthProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private Double height;
	private Double weight;
	private int minbloodpressure;
	private int maxbloodpressure;
	private int heartrate;
	private String date;

	@ManyToOne
	@JoinColumn(name = "idperson")
	private Person person;

	public HealthProfile() {
	}

	@XmlJavaTypeAdapter(DoubleDecimalAdapter.class)
	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	@XmlJavaTypeAdapter(DoubleDecimalAdapter.class)
	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public int getHeartrate() {
		return heartrate;
	}

	public void setHeartrate(int heartrate) {
		this.heartrate = heartrate;
	}

	public int getMinbloodpressure() {
		return minbloodpressure;
	}

	public void setMinbloodpressure(int minbloodpressure) {
		this.minbloodpressure = minbloodpressure;
	}

	public int getMaxbloodpressure() {
		return maxbloodpressure;
	}

	public void setMaxbloodpressure(int maxbloodpressure) {
		this.maxbloodpressure = maxbloodpressure;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@XmlTransient
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@XmlTransient
	public int getPersonId() {
		if (this.person != null)
			return this.person.getId();
		return -1;
	}

	public void setPersonId(int id) {
		Person p = Person.read(id);
		if (p != null)
			this.person = p;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// ##########################################
	// # CRUD
	// ##########################################

	public static HealthProfile read(int pid, int hpid) {
		EntityManager em = DatabaseUtil.createEntityManager();

		// HealthProfile h = em.find(HealthProfile.class, id);
		HealthProfile h = em
				.createNamedQuery("HealthProfile.findHp", HealthProfile.class)
				.setParameter("pid", pid).setParameter("hpid", hpid)
				.getSingleResult();

		em.close();
		return h;
	}

	public static HealthProfile create(int idperson, HealthProfile hp) {

		Person p = Person.read(idperson);

		if (p == null)
			return null;

		if (hp.getHeight() == null || hp.getWeight() == null)
			return null;

		// reset the id
		hp.setId(0);

		hp.setPerson(p);
		hp.setDate(getCurrentDate());

		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.persist(hp);
		tx.commit();

		em.close();
		return hp;
	}

	public static HealthProfile update(int idperson, HealthProfile hp) {

		Person p = Person.read(idperson);

		if (p == null)
			return null;

		HealthProfile hp_db = HealthProfile.read(idperson, hp.getId());

		if (hp_db == null)
			return null;

		if (hp_db.getPerson().getId() != idperson)
			return null;

		if (hp.getHeight() != 0)
			hp_db.setHeight(hp.getHeight());

		if (hp.getWeight() != 0)
			hp_db.setWeight(hp.getWeight());

		if (hp.getMinbloodpressure() != 0)
			hp_db.setMinbloodpressure(hp.getMinbloodpressure());

		if (hp.getMaxbloodpressure() != 0)
			hp_db.setMaxbloodpressure(hp.getMaxbloodpressure());

		if (hp.getHeartrate() != 0)
			hp_db.setHeartrate(hp.getHeartrate());

		if (Utils.isDateValid(hp.getDate()))
			hp_db.setDate(hp.getDate());

		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		hp_db = em.merge(hp_db);
		tx.commit();
		em.close();

		return hp_db;
	}

	public static boolean delete(int pid, int hpid) {
		HealthProfile p = read(pid, hpid);

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

	private static String getCurrentDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		df.setLenient(false);

		String date = null;
		try {
			date = df.format(new Date());
		} catch (Exception e) {
		}

		return date;
	}

}
