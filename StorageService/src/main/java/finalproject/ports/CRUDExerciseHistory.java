package finalproject.ports;

import javax.jws.WebService;

import finalproject.model.ExerciseHistory;

@WebService(serviceName = "ExerciseHistoryService", portName = "CRUD", targetNamespace = "http://finalproject.sde.unitn.it/")
public class CRUDExerciseHistory {

	// CREATE EXERCISEHISTORY
	public int createExerciseHistory(ExerciseHistory exercisehistory) {
		ExerciseHistory a = ExerciseHistory.create(exercisehistory);

		if (a == null)
			return -1;

		return a.getId();
	}

	// READ EXERCISEHISTORY
	public ExerciseHistory readExerciseHistory(int id) {
		return ExerciseHistory.read(id);
	}

	// UPDATE EXERCISEHISTORY
	public int updateExerciseHistory(ExerciseHistory exercisehistory) {
		ExerciseHistory a = ExerciseHistory.update(exercisehistory);

		if (a == null)
			return -1;

		return a.getId();
	}

	// DELETE EXERCISEHISTORY
	public boolean deleteExerciseHistory(int id) {
		return ExerciseHistory.delete(id);
	}

}
