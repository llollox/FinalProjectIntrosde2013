package finalproject.ports;

import javax.jws.WebService;

import finalproject.model.ExcludedFood;

@WebService(serviceName = "ExcludedFoodService", portName = "CRUD", targetNamespace = "http://finalproject.sde.unitn.it/")
public class CRUDExcludedFood {

	// CREATE FOOD
	public int createExcludedFood(ExcludedFood food) {
		ExcludedFood a = ExcludedFood.create(food);

		if (a == null)
			return -1;

		return a.getId();
	}

	// READ FOOD
	public ExcludedFood readExcludedFood(int id) {
		return ExcludedFood.read(id);
	}

	// UPDATE FOOD
	public int updateExcludedFood(ExcludedFood food) {
		ExcludedFood a = ExcludedFood.update(food);

		if (a == null)
			return -1;

		return a.getId();
	}

	// DELETE FOOD
	public boolean deleteExcludedFood(int id) {
		return ExcludedFood.delete(id);
	}

}
