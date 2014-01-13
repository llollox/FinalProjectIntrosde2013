package introsde.finalproject.crawler;

import finalproject.model.HealthProfile;
import finalproject.model.Person;
import introsde.finalproject.service.HealthProfileResource;
import introsde.finalproject.service.PersonResource;

import java.text.ParseException;
import java.util.GregorianCalendar;
import java.util.Random;

public class FakeData {

	private static Random random = new Random();
	public static PersonResource ps = new PersonResource();
	public static HealthProfileResource hps = new HealthProfileResource();
	public static GregorianCalendar gc = new GregorianCalendar();

	public static void main(String[] args) throws ParseException {
		System.out.println(ps.getPeople().size());
		for (Person p : ps.getPeople()) {
			System.out.println(p.toString());
			int num_healthProfiles = randBetween(1, 5);

			for (int i = 0; i < num_healthProfiles; i++) {

				int year = randBetween(
						Integer.parseInt(p.getBirthdate().substring(0, 4)),
						2013);
				gc.set(gc.YEAR, year);
				int dayOfYear = randBetween(1,
						gc.getActualMaximum(gc.DAY_OF_YEAR));
				gc.set(gc.DAY_OF_YEAR, dayOfYear);

				HealthProfile hp = new HealthProfile();
				hp.setPersonId(p.getId());
				hp.setWeight(doubleRandBetween((double) 60.1, (double) 115.1));
				hp.setHeight(doubleRandBetween((double) 1.55, (double) 2.15));
				hp.setDate(gc.get(gc.YEAR) + "-" + gc.get(gc.MONTH) + "-"
						+ gc.get(gc.DAY_OF_MONTH));
				hp.setHeartrate(randBetween(60, 90));
				hp.setMinbloodpressure(randBetween(60, 110));
				hp.setMaxbloodpressure(randBetween(
						hp.getMinbloodpressure() + 10, 180));

				System.out.println("[weight = " + hp.getWeight()
						+ "] [height = " + hp.getHeight() + "] [date = "
						+ hp.getDate() + "]");

				hps.createHealthProfile(p.getId(), hp);
			}
		}
	}

	public static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

	public static Double doubleRandBetween(Double start, Double end) {
		return start + (end - start) * random.nextDouble();
	}
}
