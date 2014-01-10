package finalproject.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import finalproject.utils.DatabaseUtil;

@Entity
@XmlRootElement
public class ActivityChoosen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String date;
	private float percentage;
	
	private Person person;
	private Activity activity;
	private Goal goal;
	
	public ActivityChoosen() {}
	
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

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}
	
	
	// ##########################################
	// # CRUD
	// ##########################################

	public static ActivityChoosen create(ActivityChoosen a) {
		// reset id
		a.setId(0);
		
		if (a.getDate() != null && !isDateValid(a.getDate()))
			return null;
		
		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(a);
		tx.commit();
	    
		em.close();
		return a;
	}
	
	public static ActivityChoosen read(int id) {
		EntityManager em = DatabaseUtil.createEntityManager();
		ActivityChoosen a = em.find(ActivityChoosen.class, id);
		em.close();
		return a;
	}
	
	public static ActivityChoosen update(ActivityChoosen a) {
		
		if (a.getId() <= 0)
			return null;
		
		if (a.getDate() != null && !isDateValid(a.getDate()))
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
		ActivityChoosen a = read(id);
		
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
	
//	private static boolean isPeriodCorrect(Activity a) {
//		return !(a.isDaily() && a.isWeekly() && !a.isMonthly() ||
//			   a.isDaily() && !a.isWeekly() && a.isMonthly() ||
//			   !a.isDaily() && a.isWeekly() && a.isMonthly() ||
//			   a.isDaily() && a.isWeekly() && a.isMonthly());
//	}
	
	@Override
    public boolean equals(Object object) {
        
		boolean equal = false;
		
        if (object != null && object instanceof ActivityChoosen) {
            equal = this.id == ((ActivityChoosen) object).getId();
        }

        return equal;
    }
	
}
