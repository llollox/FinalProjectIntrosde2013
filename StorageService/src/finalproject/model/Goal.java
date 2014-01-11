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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import finalproject.utils.DatabaseUtil;

@NamedQuery(name="Goal.findAll", query="SELECT p FROM Goal p")
@Entity
@XmlRootElement
public class Goal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String value;
	private String enddate;
	
	@ManyToMany(mappedBy="goals", fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
	private List<Person> people = new ArrayList<Person>();
	
	@ManyToMany
	@JoinTable(name = "Goal_has_Activity", joinColumns = { @JoinColumn(name = "idgoal", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "idactivity", referencedColumnName = "id") })
	private List<Activity> activities = new ArrayList<Activity>();
	
	public Goal() {}
	
	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	@XmlTransient
	public List<Person> getPeople() {
		return people;
	}

	public void setPeople(List<Person> persons) {
		this.people = persons;
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	@XmlElement(name = "activities")
	public List<Activity> getActivities() {
		return activities;
	}
	
	// ##########################################
	// # CRUD
	// ##########################################
	
	public static Goal create(Goal g) {
		// reset id
		g.setId(0);
		
		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(g);
		tx.commit();
	    
		em.close();
		return g;
	}
	
	public static Goal read(int id) {
		EntityManager em = DatabaseUtil.createEntityManager();
		Goal g = em.find(Goal.class, id);
		em.close();
		return g;
	}
	
	public static Goal update(Goal g) {
		
		if (g.getId() <= 0)
			return null;
		
		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		g = em.merge(g);
		tx.commit();
		em.close();

	    return g;
	}
	
	public static boolean delete(int id) {
		Goal g = read(id);
		
		if (g == null)
			return false;
		
		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
	    g = em.merge(g);
	    em.remove(g);
	    tx.commit();
	    
	    em.close();
	    
	    return true;
	}
	
	@Override
    public boolean equals(Object object) {
        
		boolean equal = false;
		
        if (object != null && object instanceof Goal) {
            equal = this.id == ((Goal) object).getId();
        }

        return equal;
    }
	
}
