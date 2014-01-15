package finalproject.client;

import finalproject.client.interfaces.ExcludedFoodWebInterface;
import finalproject.client.interfaces.FavouriteFoodWebInterface;
import finalproject.client.interfaces.PersonWebInterface;
import finalproject.client.service.ExcludedFoodService;
import finalproject.client.service.FavouriteFoodService;
import finalproject.client.service.PersonService;
import finalproject.model.ExcludedFood;
import finalproject.model.FavouriteFood;
import finalproject.model.Person;

public class ClientTest {

	public static void main(String[] args) {
		PersonWebInterface pp = new PersonService().getCRUD();
		System.out.println(pp.readPerson(1).getFirstname());
/*
		PersonWebInterface pp = new PersonService().getCRUD();
		FavouriteFoodWebInterface ff = new FavouriteFoodService().getCRUD();
		ExcludedFoodWebInterface ee = new ExcludedFoodService().getCRUD();

		Person p = pp.readPerson(23);

		// FAVOURITE TEST
		FavouriteFood fav = new FavouriteFood();

		fav.setName("pizza");
		fav.setPerson(p);

		int fid = ff.createFavouriteFood(fav);

		fav = ff.readFavouriteFood(fid);

		fav.setName("pepperoni");

		ff.updateFavouriteFood(fav);

		for (FavouriteFood f : ff.getPersonsFavouriteFood(p.getId()))
			System.out.println(f.getName());

		ff.deleteFavouriteFood(fav.getId());

		// EXCLUDED TEST
		ExcludedFood ex = new ExcludedFood();

		ex.setPerson(p);
		ex.setName("salad");

		int eid = ee.createExcludedFood(ex);

		ex = ee.readExcludedFood(eid);

		ex.setName("oil");

		ee.updateExcludedFood(ex);

		for (ExcludedFood f : ee.getPersonsExcludedFood(p.getId()))
			System.out.println(f.getName());

		ee.deleteExcludedFood(eid);
*/
	}
}
