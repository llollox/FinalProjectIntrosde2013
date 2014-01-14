package finalproject.ports;

import javax.jws.WebService;

import finalproject.client.interfaces.HealthProfileWebInterface;
import finalproject.model.HealthProfile;

@WebService(serviceName = "HealthProfileService", portName = "CRUD", targetNamespace = "http://finalproject.sde.unitn.it/")
public class CRUDHealthProfile implements HealthProfileWebInterface {

	// CREATE HEALTHPROFILE
	public int createHealthProfile(int idperson, HealthProfile hp) {
		HealthProfile h = HealthProfile.create(idperson, hp);

		if (h == null)
			return -1;

		return h.getId();
	}

	// READ HEALTHPROFILE
	public HealthProfile readHealthProfile(int pid, int hpid) {
		return HealthProfile.read(pid, hpid);
	}

	// UPDATE HEALTHPROFILE
	public int updateHealthProfile(int idperson, HealthProfile hp) {

		HealthProfile h = HealthProfile.update(idperson, hp);

		if (h == null)
			return -1;

		return h.getId();
	}

	// DELETE HEALTHPROFILE
	public boolean deleteHealthProfile(int pid, int hpid) {
		return HealthProfile.delete(pid, hpid);
	}

}
