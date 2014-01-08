package finalproject.ports;

import javax.jws.WebService;

import finalproject.model.HealthProfile;

@WebService(
		serviceName = "HealthProfileService",
		portName = "CRUD",
		targetNamespace = "http://finalproject.sde.unitn.it/"
)
public class CUHealthProfile {

	// CREATE HEALTHPROFILE
	public int createHealthProfile(int idperson, HealthProfile hp) {
		HealthProfile h = HealthProfile.create(idperson, hp);
		
		if (h == null)
			return -1;
		
		return h.getId(); 
	}
	
	// UPDATE HEALTHPROFILE
	public int updateHealthProfile(int idperson, HealthProfile hp) {
		
		HealthProfile h = HealthProfile.update(idperson, hp);
		
		if (h == null)
			return -1;
		
		return h.getId(); 
	}
	
}
