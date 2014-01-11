package finalproject.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

import finalproject.utils.DatabaseUtil;

@NamedQuery(name="ExerciseCategory.findAll", query="SELECT p FROM ExerciseCategory p")
@Entity
@XmlRootElement
public class ExerciseCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	public ExerciseCategory() {}

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
	
	// ##########################################
	// # CRUD
	// ##########################################
	
	public static ExerciseCategory create(ExerciseCategory a) {
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
	
	public static ExerciseCategory read(int id) {
		EntityManager em = DatabaseUtil.createEntityManager();
		ExerciseCategory a = em.find(ExerciseCategory.class, id);
		em.close();
		return a;
	}
	
	public static ExerciseCategory update(ExerciseCategory a) {
		
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
		ExerciseCategory a = read(id);
		
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
