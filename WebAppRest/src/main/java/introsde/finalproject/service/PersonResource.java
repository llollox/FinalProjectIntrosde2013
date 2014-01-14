package introsde.finalproject.service;

import introsde.finalproject.calories.client.CaloriesCalculator;
import introsde.finalproject.calories.client.CaloriesService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import finalproject.client.interfaces.PersonWebInterface;
import finalproject.client.service.PersonService;
import finalproject.model.ExtendedHealthProfile;
import finalproject.model.HealthProfile;
import finalproject.model.Person;

@Path("/person")
public class PersonResource {

	PersonWebInterface cperson = new PersonService().getCRUD();
	CaloriesCalculator caloriesCalculator = new CaloriesService()
			.getCalculator();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Person> getPeople() throws ParseException {
		return cperson.getPeople();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createPerson(Person person) {

		int personId = cperson.createPerson(person);
		if (personId != -1) {
			return Response.status(Response.Status.OK)
					.entity(cperson.readPerson(personId)).build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/{p_id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Person getPerson(@PathParam("p_id") int p_id) throws ParseException {
		Person p = cperson.readPerson(p_id);

		if (p != null) {
			p.setExtendedhealthprofile(getExtendedHealthProfile(p));
		}

		return p;
	}

	@PUT
	@Path("/{p_id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updatePerson(@PathParam("p_id") int p_id, Person json) {

		// aggiorno nel db la persona
		int personId = cperson.updatePerson(json);

		if (personId != -1) // data successiful updated!
			return Response.status(Response.Status.OK)
					.entity(cperson.readPerson(personId)).build();
		else
			return Response.status(Response.Status.BAD_REQUEST).build();

	}

	@DELETE
	@Path("/{p_id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deletePerson(@PathParam("p_id") int p_id) {

		p_id = cperson.deletePerson(p_id);

		if (p_id != -1) {
			return Response.status(Response.Status.OK)
					.entity("{\"id\":\"" + p_id + "\"}").build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/birthdate")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Person> getPeopleByBirthdate(@QueryParam("start") String start,
			@QueryParam("end") String end) {

		return cperson.getPeopleByBirthdate(start, end);
	}

	@GET
	@Path("/measure")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Person> getPeopleByMeasure(@QueryParam("name") String name,
			@QueryParam("min") Double min, @QueryParam("max") Double max) {

		if (name == null || (!name.equals("height") && !name.equals("weight")))
			return null;

		return cperson.getPeopleByMeasure(name, min + "", max + "");
	}

	@GET
	@Path("/name")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Person> getPeopleByName(@QueryParam("contains") String name) {

		return cperson.getPeopleByName(name);
	}

	private ExtendedHealthProfile getExtendedHealthProfile(Person person)
			throws ParseException {

		if (person.getHealthProfileHistory() != null
				&& person.getHealthProfileHistory().size() > 0) {

			HealthProfile hp = person.getHealthProfileHistory().get(
					person.getHealthProfileHistory().size() - 1);

			ExtendedHealthProfile exp = new ExtendedHealthProfile(hp);

			// TODO CALCOLARE L'ETA' CORRETTA
			int age = getAge(person.getBirthdate());

			exp.setAge(age);

			exp.setBloodPressureLabel(caloriesCalculator.getBloodPressureLabel(
					hp.getMinbloodpressure(), hp.getMaxbloodpressure()));

			exp.setBmi(caloriesCalculator.getBMI(hp.getHeight(), hp.getWeight()));

			exp.setBmiLabel(caloriesCalculator.getBmiLabel(exp.getBmi()));

			exp.setBmr(caloriesCalculator.getBMR(hp.getHeight(),
					hp.getWeight(), age, person.getSex()));

			exp.setIdealBmi(caloriesCalculator.getIdealBMI(hp.getHeight(),
					person.getSex()));

			// TODO check what is exercise times per week
			exp.setIdealKcal(caloriesCalculator.getIdealDailyCaloriesNeeded(
					exp.getBmr(), 2));

			exp.setIdealWeight(caloriesCalculator.getIdealWeight(
					hp.getHeight(), person.getSex()));

			// TODO set managed kcal
			// exp.setMenagedWeightKcal(menagedWeightKcal);

			exp.setTargetHearthRate(caloriesCalculator.getTargetHeartRate(age,
					hp.getHeartrate()));

			return exp;
		} else {
			return null;
		}

	}

	private int getAge(String birthDate) throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date date = dateFormat.parse(birthDate);
		Calendar c = Calendar.getInstance();

		int currentYear = c.get(Calendar.YEAR);

		c.setTime(date);

		int birthYear = c.get(Calendar.YEAR);

		return currentYear - birthYear;
	}

}
