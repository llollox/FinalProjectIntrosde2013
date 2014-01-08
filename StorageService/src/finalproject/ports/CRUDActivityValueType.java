package finalproject.ports;

import javax.jws.WebService;

import finalproject.model.Activity;
import finalproject.model.ActivityValueType;

@WebService(
		serviceName = "ActivityValueTypeService",
		portName = "CRUD",
		targetNamespace = "http://finalproject.sde.unitn.it/"
)
public class CRUDActivityValueType {

	// CREATE ACTIVITY VALUE TYPE
	public int createType(ActivityValueType type) {
		ActivityValueType t = ActivityValueType.create(type);

		if (t == null)
			return -1;

		return t.getId();
	}

	// READ ACTIVITY VALUE TYPE
	public ActivityValueType readType(int id) {
		return ActivityValueType.read(id);
	}

	// UPDATE ACTIVITY VALUE TYPE
	public int updateType(ActivityValueType type) {
		ActivityValueType t = ActivityValueType.update(type);

		if (t == null)
			return -1;

		return t.getId();
	}

	// DELETE ACTIVITY VALUE TYPE
	public boolean deleteType(int id) {
		return ActivityValueType.delete(id);
	}
	
}
