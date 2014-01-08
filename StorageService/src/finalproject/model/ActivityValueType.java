package finalproject.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import finalproject.utils.DatabaseUtil;

@Entity
@XmlRootElement
public class ActivityValueType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@ManyToMany
//	@JoinTable(name = "Activity_has_ActivityValueTypes", joinColumns = { @JoinColumn(name = "idactivity", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "idvaluetype", referencedColumnName = "id") })
	@JoinTable(name = "Activity_has_ActivityValueTypes",
	            joinColumns = @JoinColumn(name = "idvaluetype"),
	            inverseJoinColumns = @JoinColumn(name = "idactivity"))
    private Set<Activity> activities = new HashSet<Activity>();
	
	public ActivityValueType() {}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@XmlTransient
	public Set<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// ##########################################
	// # CRUD
	// ##########################################

	public static ActivityValueType create(ActivityValueType a) {
		// reset id
		a.setId(0);

		if (a.getName() == null)
			return null;

		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.persist(a);
		tx.commit();

		em.close();
		return a;
	}

	public static ActivityValueType read(int id) {
		EntityManager em = DatabaseUtil.createEntityManager();
		ActivityValueType a = em.find(ActivityValueType.class, id);
		em.close();
		return a;
	}

	// TODO Check updates
	public static ActivityValueType update(ActivityValueType a) {

		if (a.getId() <= 0)
			return null;

		if (a.getName() == null)
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
		ActivityValueType a = read(id);

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
	
	@Override
    public boolean equals(Object object) {
        
		boolean equal = false;
		
        if (object != null && object instanceof ActivityValueType) {
            equal = this.id == ((ActivityValueType) object).getId();
        }

        return equal;
    }
}
