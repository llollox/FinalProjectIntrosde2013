package finalproject.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
public class ExerciseHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String date;
	private Integer value;

	@ManyToOne
	@JoinColumn(name = "idactivity")
	private Activity activity;

	@ManyToOne
	@JoinColumn(name = "idgoalchoosen")
	private GoalChoosen goalchoosen;

	public ExerciseHistory() {
	}

	@XmlTransient
	public GoalChoosen getGoalchoosen() {
		return goalchoosen;
	}

	public void setGoalchoosen(GoalChoosen goalchoosen) {
		this.goalchoosen = goalchoosen;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity exercise) {
		this.activity = exercise;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

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

	// ##########################################
	// # CRUD
	// ##########################################

	public static ExerciseHistory create(ExerciseHistory ex) {
		// reset id
		ex.setId(0);

		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.persist(ex);
		tx.commit();

		em.close();
		return ex;
	}

	public static ExerciseHistory read(int id) {
		EntityManager em = DatabaseUtil.createEntityManager();
		ExerciseHistory a = em.find(ExerciseHistory.class, id);
		em.close();
		return a;
	}

	public static ExerciseHistory update(ExerciseHistory a) {

		if (a.getId() <= 0)
			return null;

		if (a.getDate() != null && !isDateValid(a.getDate()))
			return null;

		if (a.getGoalchoosen() == null || a.getActivity() == null)
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
		ExerciseHistory a = read(id);

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
