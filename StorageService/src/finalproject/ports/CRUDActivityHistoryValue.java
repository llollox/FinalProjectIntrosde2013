package finalproject.ports;

import javax.jws.WebService;

import finalproject.model.ActivityHistoryValue;

@WebService(serviceName = "ActivityHistoryValueService", portName = "CRUD", targetNamespace = "http://finalproject.sde.unitn.it/")
public class CRUDActivityHistoryValue {

	// CREATE A NEW ACTIVITY HISTORY VALUE
	public int insertValue(ActivityHistoryValue value) {
		ActivityHistoryValue a = ActivityHistoryValue.create(value);

		if (a == null)
			return -1;

		return a.getId();
	}

	// READ ACTIVITY HISTORY VALUE
	public ActivityHistoryValue readValue(int id) {
		return ActivityHistoryValue.read(id);
	}

	// UPDATE ACTIVITY HISTORY VALUE
	public int updateValue(ActivityHistoryValue value) {
		ActivityHistoryValue a = ActivityHistoryValue.update(value);

		if (a == null)
			return -1;

		return a.getId();
	}

	// DELETE ACTIVITY HISTORY VALUE
	public boolean deleteValue(int id) {
		return ActivityHistoryValue.delete(id);
	}

}
