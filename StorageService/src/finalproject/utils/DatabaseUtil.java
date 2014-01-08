package finalproject.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseUtil {

	private static EntityManagerFactory emf;
	
	public static EntityManager createEntityManager() {
        if (emf == null) { 
        	emf = Persistence.createEntityManagerFactory("finalproject-jpa");
        }
         
        return emf.createEntityManager();
    }
	
}
