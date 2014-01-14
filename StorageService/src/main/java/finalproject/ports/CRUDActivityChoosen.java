package finalproject.ports;

import javax.jws.WebService;

import finalproject.client.interfaces.ActivityChoosenWebInterface;
import finalproject.model.ActivityChoosen;

@WebService(serviceName = "ActivityChoosenService", portName = "CRUD", targetNamespace = "http://finalproject.sde.unitn.it/")
public class CRUDActivityChoosen implements ActivityChoosenWebInterface {

	// CREATE ACTIVITY
	public int createActivityChoosen(ActivityChoosen activity) {
		ActivityChoosen a = ActivityChoosen.create(activity);

		if (a == null)
			return -1;

		return a.getId();
	}

	// READ ACTIVITY
	public ActivityChoosen readActivityChoosen(int id) {
		return ActivityChoosen.read(id);
	}

	// UPDATE ACTIVITY
	public int updateActivityChoosen(ActivityChoosen activity) {
		ActivityChoosen a = ActivityChoosen.update(activity);

		if (a == null)
			return -1;

		return a.getId();
	}

	// DELETE ACTIVITY
	public boolean deleteActivityChoosen(int id) {
		return ActivityChoosen.delete(id);
	}

}
