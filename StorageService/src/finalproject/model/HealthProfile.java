package finalproject.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import finalproject.utils.DatabaseUtil;

@Entity
@XmlRootElement
public class HealthProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private double height;
	private double weight;
	private int bloodpressure;
	private int heartrate;
	private String date;
	
	@ManyToOne
	@JoinColumn(name = "idperson")
	private Person person;
	
	public HealthProfile() {}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getBloodpressure() {
		return bloodpressure;
	}

	public void setBloodpressure(int bloodpressure) {
		this.bloodpressure = bloodpressure;
	}

	public int getHeartrate() {
		return heartrate;
	}

	public void setHeartrate(int heartrate) {
		this.heartrate = heartrate;
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

	public static HealthProfile read(int id) {
		EntityManager em = DatabaseUtil.createEntityManager();
		HealthProfile h = em.find(HealthProfile.class, id);
		em.close();
		return h;
	}
	
	public static HealthProfile create(int idperson, HealthProfile hp) {
		
		// reset the id
		hp.setId(0);
		
		hp.setPerson(Person.read(idperson));
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
		
		HealthProfile newHP = HealthProfile.read(hp.getId());
		
		// if the healthprofile does not exist create it
		if (newHP == null) {
			hp.setPerson(Person.read(idperson));
			hp.setDate(getCurrentDate());
			
			EntityManager em = DatabaseUtil.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
			em.persist(hp);
			tx.commit();
		    
			em.close();
			return hp;
		}
		
		// if the "healthprofile" does not belong to the person with id "idperson"
		if (newHP.getPerson().getId() != idperson)
			return null;
		
		// update only the properties which are not null
		
		if (hp.getHeight() != 0)
			newHP.setHeight(hp.getHeight());
		
		if (hp.getWeight() != 0)
			newHP.setWeight(hp.getWeight());
		
		if (hp.getBloodpressure() != 0)
			newHP.setBloodpressure(hp.getBloodpressure());
		
		if (hp.getHeartrate() != 0)
			newHP.setHeartrate(hp.getHeartrate());
		
		// not updating date on purpose
		// since the date is set when the healthprofile is created
		
		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		newHP = em.merge(newHP);
		tx.commit();
		em.close();
		
	    return newHP;
	}
	
	public static boolean delete(int id) {
		HealthProfile p = read(id);

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
			date = df.format(Calendar.getInstance().getTime());
		} catch (Exception e) {}
		
		return date;
	}

}
