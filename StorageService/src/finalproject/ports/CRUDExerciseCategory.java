package finalproject.ports;

import javax.jws.WebService;

import finalproject.model.ExerciseCategory;

@WebService(serviceName = "ExerciseCategoryService", portName = "CRUD", targetNamespace = "http://finalproject.sde.unitn.it/")
public class CRUDExerciseCategory {

	// CREATE CATEGORY
	public int createExerciseCategory(ExerciseCategory exercise) {
		ExerciseCategory a = ExerciseCategory.create(exercise);

		if (a == null)
			return -1;

		return a.getId();
	}

	// READ CATEGORY
	public ExerciseCategory readExerciseCategory(int id) {
		return ExerciseCategory.read(id);
	}

	// UPDATE CATEGORY
	public int updateExerciseCategory(ExerciseCategory exercise) {
		ExerciseCategory a = ExerciseCategory.update(exercise);

		if (a == null)
			return -1;

		return a.getId();
	}

	// DELETE CATEGORY
	public boolean deleteExerciseCategory(int id) {
		return ExerciseCategory.delete(id);
	}

}
