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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import finalproject.utils.DatabaseUtil;

@NamedQueries({ @NamedQuery(name = "GoalChoosen.getGoalsChoosenByPerson", query = "select g from GoalChoosen g where g.person.id = :pid") })
@Entity
@XmlRootElement
public class GoalChoosen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Transient
	private Double percentage;

	@ManyToOne
	@JoinColumn(name = "idperson")
	private Person person;

	@ManyToOne
	@JoinColumn(name = "idgoal")
	private Goal goal;

	@OneToMany(mappedBy = "goalchoosen", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ExerciseHistory> exercises = new ArrayList<ExerciseHistory>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@XmlElement(name = "exerciseHistory")
	public List<ExerciseHistory> getExercises() {
		return exercises;
	}

	public void setExercises(List<ExerciseHistory> exercises) {
		this.exercises = exercises;
	}

	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	public static List<GoalChoosen> getGoalChoosenForPerson(int pid) {
		EntityManager em = DatabaseUtil.createEntityManager();
		List<GoalChoosen> list = em
				.createNamedQuery("GoalChoosen.getGoalsChoosenByPerson",
						GoalChoosen.class).setParameter("pid", pid)
				.getResultList();
		em.close();
		return list;
	}

	// ##########################################
	// # CRUD
	// ##########################################

	public static GoalChoosen create(GoalChoosen g) {
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

	public static GoalChoosen read(int id) {
		EntityManager em = DatabaseUtil.createEntityManager();
		GoalChoosen g = em.find(GoalChoosen.class, id);
		em.close();
		return g;
	}

	public static GoalChoosen update(GoalChoosen g) {

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
		GoalChoosen g = read(id);

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

}
