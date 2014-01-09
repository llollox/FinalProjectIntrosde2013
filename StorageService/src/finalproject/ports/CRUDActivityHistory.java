package finalproject.ports;

import javax.jws.WebService;

import finalproject.model.ActivityHistory;

@WebService(serviceName = "ActivityHistoryService", portName = "CRUD", targetNamespace = "http://finalproject.sde.unitn.it/")
public class CRUDActivityHistory {

	// CREATE ACTIVITYHISTORY
	public int createActivityHistory(ActivityHistory activityhistory) {
		ActivityHistory a = ActivityHistory.create(activityhistory);

		if (a == null)
			return -1;

		return a.getId();
	}

	// READ ACTIVITYHISTORY
	public ActivityHistory readActivityHistory(int id) {
		return ActivityHistory.read(id);
	}

	// UPDATE ACTIVITYHISTORY
	public int updateActivityHistory(ActivityHistory activityhistory) {
		ActivityHistory a = ActivityHistory.update(activityhistory);

		if (a == null)
			return -1;

		return a.getId();
	}

	// DELETE ACTIVITYHISTORY
	public boolean deleteActivityHistory(int id) {
		return ActivityHistory.delete(id);
	}

}
