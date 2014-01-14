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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import finalproject.utils.DatabaseUtil;

@NamedQuery(name = "Activity.findAll", query = "SELECT p FROM Activity p")
@Entity
@XmlRootElement
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String description;
	private Integer value;

	@ManyToMany
	@JoinTable(name = "Activity_has_categories", joinColumns = { @JoinColumn(name = "idactivity", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "idcategory", referencedColumnName = "id") })
	private List<ExerciseCategory> categories = new ArrayList<ExerciseCategory>();

	@ManyToMany(mappedBy = "activities", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Goal> goals = new ArrayList<Goal>();

	public Activity() {
	}

	public Activity(String description, Integer value) {
		super();
		this.description = description;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

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

	@XmlElement(name = "exerciseCategory")
	public List<ExerciseCategory> getCategories() {
		return categories;
	}

	// ##########################################
	// # CRUD
	// ##########################################

	public static Activity create(Activity a) {
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

	public static Activity read(int id) {
		EntityManager em = DatabaseUtil.createEntityManager();
		Activity a = em.find(Activity.class, id);
		em.close();
		return a;
	}

	public static Activity update(Activity a) {

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

	// private static boolean isPeriodCorrect(Activity a) {
	// return !(a.isDaily() && a.isWeekly() && !a.isMonthly() ||
	// a.isDaily() && !a.isWeekly() && a.isMonthly() ||
	// !a.isDaily() && a.isWeekly() && a.isMonthly() ||
	// a.isDaily() && a.isWeekly() && a.isMonthly());
	// }

	@Override
	public boolean equals(Object object) {

		boolean equal = false;

		if (object != null && object instanceof Activity) {
			equal = this.id == ((Activity) object).getId();
		}

		return equal;
	}

}
