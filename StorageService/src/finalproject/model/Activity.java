package finalproject.model;

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
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String description;
	private boolean daily;
	private boolean weekly;
	private boolean monthly;
	
	@ManyToMany(mappedBy="activities")
	private Set<ActivityValueType> valuetypes = new HashSet<ActivityValueType>();
	
	@ManyToMany(mappedBy="activities", fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
	private List<Goal> goals = new ArrayList<Goal>();
	
	public Activity() {}
	
	@XmlTransient
	public List<Goal> getGoals() {
		return goals;
	}

	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDaily() {
		return daily;
	}

	public void setDaily(boolean daily) {
		this.daily = daily;
	}

	public boolean isWeekly() {
		return weekly;
	}

	public void setWeekly(boolean weekly) {
		this.weekly = weekly;
	}

	public boolean isMonthly() {
		return monthly;
	}

	public void setMonthly(boolean monthly) {
		this.monthly = monthly;
	}

	public Set<ActivityValueType> getValuetypes() {
		return valuetypes;
	}
	
	public void setValuetypes(Set<ActivityValueType> valuetypes) {
		this.valuetypes = valuetypes;
	}
	
	// ##########################################
	// # CRUD
	// ##########################################

	public static Activity create(Activity a) {
		// reset id
		a.setId(0);
		
		if (a.getDescription() == null)
			return null;
		
		if (!isPeriodCorrect(a))
			return null;
		
		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(a);
		tx.commit();
	    
		em.close();
		return a;
	}
	
	public static Activity read(int id) {
		EntityManager em = DatabaseUtil.createEntityManager();
		Activity a = em.find(Activity.class, id);
		em.close();
		return a;
	}
	
	public static Activity update(Activity a) {
		
		if (a.getId() <= 0)
			return null;
		
		if (a.getDescription() == null)
			return null;
		
		if (!isPeriodCorrect(a))
			return null;
		
		Activity activity = Activity.read(a.getId());
		
		activity.setDescription(a.getDescription());
		activity.setDaily(a.isDaily());
		activity.setWeekly(a.isWeekly());
		activity.setMonthly(a.isMonthly());
		
		
		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		activity = em.merge(activity);
		tx.commit();
		em.close();

	    return activity;
	}
	
	public static boolean delete(int id) {
		Activity a = read(id);
		
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
	
	private static boolean isPeriodCorrect(Activity a) {
		return !(a.isDaily() && a.isWeekly() && !a.isMonthly() ||
			   a.isDaily() && !a.isWeekly() && a.isMonthly() ||
			   !a.isDaily() && a.isWeekly() && a.isMonthly() ||
			   a.isDaily() && a.isWeekly() && a.isMonthly());
	}
	
	@Override
    public boolean equals(Object object) {
        
		boolean equal = false;
		
        if (object != null && object instanceof Activity) {
            equal = this.id == ((Activity) object).getId();
        }

        return equal;
    }
	
}
