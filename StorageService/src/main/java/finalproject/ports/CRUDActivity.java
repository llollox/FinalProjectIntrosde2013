package finalproject.ports;

import java.util.List;

import javax.jws.WebService;
import javax.persistence.EntityManager;

import finalproject.client.interfaces.ActivityWebInterface;
import finalproject.model.Activity;
import finalproject.utils.DatabaseUtil;

@WebService(serviceName = "ActivityService", portName = "CRUD", targetNamespace = "http://finalproject.sde.unitn.it/")
public class CRUDActivity implements ActivityWebInterface {

	// GET ACTIVITIES
	public List<Activity> getActivities() {
		EntityManager em = DatabaseUtil.createEntityManager();
		List<Activity> list = em.createNamedQuery("Activity.findAll",
				Activity.class).getResultList();
		;
		em.close();
		return list;
	}

	// CREATE ACTIVITY
	public int createActivity(Activity activity) {
		Activity a = Activity.create(activity);

		if (a == null)
			return -1;

		return a.getId();
	}

	// READ ACTIVITY
	public Activity readActivity(int id) {
		return Activity.read(id);
	}

	// UPDATE ACTIVITY
	public int updateActivity(Activity activity) {
		Activity a = Activity.update(activity);

		if (a == null)
			return -1;

		return a.getId();
	}

	// DELETE ACTIVITY
	public boolean deleteActivity(int id) {
		return Activity.delete(id);
	}

}
