package finalproject.model;

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
public class Exercise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String description;
	private Float difficultyvalue;

	@ManyToOne
	@JoinColumn(name = "idcategory")
	private ExerciseCategory category;

	public Exercise() {
	}

	@XmlTransient
	public ExerciseCategory getCategory() {
		return category;
	}

	public void setCategory(ExerciseCategory category) {
		this.category = category;
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

	public Float getDifficultyvalue() {
		return difficultyvalue;
	}

	public void setDifficultyvalue(Float difficultyvalue) {
		this.difficultyvalue = difficultyvalue;
	}

	// ##########################################
	// # CRUD
	// ##########################################

	public static Exercise create(Exercise a) {
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

	public static Exercise read(int id) {
		EntityManager em = DatabaseUtil.createEntityManager();
		Exercise a = em.find(Exercise.class, id);
		em.close();
		return a;
	}

	public static Exercise update(Exercise a) {

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
		Exercise a = read(id);

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

}
