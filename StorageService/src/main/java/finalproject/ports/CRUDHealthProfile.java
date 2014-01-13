package finalproject.ports;

import javax.jws.WebService;

import finalproject.model.HealthProfile;

@WebService(serviceName = "HealthProfileService", portName = "CRUD", targetNamespace = "http://finalproject.sde.unitn.it/")
public class CRUDHealthProfile {

	// CREATE HEALTHPROFILE
	public int createHealthProfile(int idperson, HealthProfile hp) {
		HealthProfile h = HealthProfile.create(idperson, hp);

		if (h == null)
			return -1;

		return h.getId();
	}

	// READ HEALTHPROFILE
	public HealthProfile readHealthProfile(int id) {
		return HealthProfile.read(id);
	}

	// UPDATE HEALTHPROFILE
	public int updateHealthProfile(int idperson, HealthProfile hp) {

		HealthProfile h = HealthProfile.update(idperson, hp);

		if (h == null)
			return -1;

		return h.getId();
	}

	// DELETE HEALTHPROFILE
	public boolean deleteHealthProfile(int id) {
		return HealthProfile.delete(id);
	}

}
