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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import finalproject.utils.DatabaseUtil;

@Entity
@XmlRootElement
public class ActivityHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String date;
	
	@ManyToOne
	@JoinColumn(name = "idperson")
	private Person person;
	
	@ManyToOne
	@JoinColumn(name = "idactivity")
	private Activity activity;
	
	@OneToMany(mappedBy="ActivityHistory", fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
	private List<ActivityHistoryValue> values = new ArrayList<ActivityHistoryValue>();
	
	public ActivityHistory() {}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPersonId() {
		if (person == null)
			return -1;
		return person.getId();
	}

	public void setPersonId(int id) {
		Person p = Person.read(id);
		if (p != null)
			this.person = p;
	}

	public int getActivityId() {
		if (activity == null)
			return -1;
		return activity.getId();
	}

	public void setActivityId(int id) {
		Activity a = Activity.read(id);
		if (a != null)
			this.activity = a;
	}
	
	// READ ONLY

	public List<ActivityHistoryValue> getValues() {
		return values;
	}
	
	// ##########################################
	// # CRUD
	// ##########################################
	
	public static ActivityHistory create(ActivityHistory a) {
		// reset id
		a.setId(0);
		
		if (a.getDate() != null && !isDateValid(a.getDate()))
			return null;
		
		if (a.getPersonId() == -1 || a.getActivityId() == -1)
			return null;
		
		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(a);
		tx.commit();
	    
		em.close();
		return a;
	}
	
	public static ActivityHistory read(int id) {
		EntityManager em = DatabaseUtil.createEntityManager();
		ActivityHistory a = em.find(ActivityHistory.class, id);
		em.close();
		return a;
	}
	
	public static ActivityHistory update(ActivityHistory a) {
		
		if (a.getId() <= 0)
			return null;
		
		if (a.getDate() != null && !isDateValid(a.getDate()))
			return null;
		
		if (Activity.read(a.getActivityId()) == null || Person.read(a.getPersonId()) == null)
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
		ActivityHistory a = read(id);
		
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
