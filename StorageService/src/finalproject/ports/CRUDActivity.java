package finalproject.ports;

import javax.jws.WebService;

import finalproject.model.Activity;
import finalproject.model.ActivityValueType;

@WebService(
		serviceName = "ActivityService",
		portName = "CRUD",
		targetNamespace = "http://finalproject.sde.unitn.it/"
)
public class CRUDActivity {

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
	
//	public void link(Activity activity, ActivityValueType valueType) {
//		
//	}

}
