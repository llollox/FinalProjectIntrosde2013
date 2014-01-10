package finalproject.ports;

import javax.jws.WebService;

import finalproject.model.Exercise;

@WebService(serviceName = "ExerciseService", portName = "CRUD", targetNamespace = "http://finalproject.sde.unitn.it/")
public class CRUDExercise {

	// CREATE EXERCISE
	public int createExercise(Exercise exercise) {
		Exercise a = Exercise.create(exercise);

		if (a == null)
			return -1;

		return a.getId();
	}

	// READ EXERCISE
	public Exercise readExercise(int id) {
		return Exercise.read(id);
	}

	// UPDATE EXERCISE
	public int updateExercise(Exercise exercise) {
		Exercise a = Exercise.update(exercise);

		if (a == null)
			return -1;

		return a.getId();
	}

	// DELETE EXERCISE
	public boolean deleteExercise(int id) {
		return Exercise.delete(id);
	}

}
