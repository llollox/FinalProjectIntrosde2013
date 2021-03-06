package finalproject.ports;

import java.util.List;

import javax.jws.WebService;

import finalproject.model.FavouriteFood;

@WebService(serviceName = "FavouriteFoodService", portName = "CRUD", targetNamespace = "http://finalproject.sde.unitn.it/")
public class CRUDFavouriteFood implements
		finalproject.client.interfaces.FavouriteFoodWebInterface {

	// CREATE FOOD
	public int createFavouriteFood(FavouriteFood food) {
		FavouriteFood a = FavouriteFood.create(food);

		if (a == null)
			return -1;

		return a.getId();
	}

	// READ FOOD
	public FavouriteFood readFavouriteFood(int id) {
		return FavouriteFood.read(id);
	}

	// UPDATE FOOD
	public int updateFavouriteFood(FavouriteFood food) {
		FavouriteFood a = FavouriteFood.update(food);

		if (a == null)
			return -1;

		return a.getId();
	}

	// DELETE FOOD
	public boolean deleteFavouriteFood(int id) {
		return FavouriteFood.delete(id);
	}

	/** GET PERSONAL FOOD */
	public List<FavouriteFood> getPersonsFavouriteFood(int pid) {
		return FavouriteFood.getPersonFood(pid);

	}

}
