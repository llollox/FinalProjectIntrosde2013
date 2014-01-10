package finalproject.model;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import finalproject.utils.DatabaseUtil;

@Entity
@XmlRootElement
public class FavouriteFood {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private Person person;
	
	public FavouriteFood() {}

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

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}


	// ##########################################
	// # CRUD
	// ##########################################
	
	public static FavouriteFood create(FavouriteFood a) {
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
	
	public static FavouriteFood read(int id) {
		EntityManager em = DatabaseUtil.createEntityManager();
		FavouriteFood a = em.find(FavouriteFood.class, id);
		em.close();
		return a;
	}
	
	public static FavouriteFood update(FavouriteFood a) {
		
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
		FavouriteFood a = read(id);
		
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
