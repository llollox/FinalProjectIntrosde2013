package finalproject.ports;

import java.util.List;

import javax.jws.WebService;
import javax.persistence.EntityManager;

import finalproject.model.ExerciseCategory;
import finalproject.utils.DatabaseUtil;

@WebService(serviceName = "ExerciseCategoryService", portName = "CRUD", targetNamespace = "http://finalproject.sde.unitn.it/")
public class CRUDExerciseCategory {

	// GET CATEGORIES
	public List<ExerciseCategory> getCategories() {
		EntityManager em = DatabaseUtil.createEntityManager();
		List<ExerciseCategory> list = em.createNamedQuery(
				"ExerciseCategory.findAll", ExerciseCategory.class)
				.getResultList();
		;
		em.close();
		return list;
	}

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
