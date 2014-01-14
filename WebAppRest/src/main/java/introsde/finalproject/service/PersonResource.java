package introsde.finalproject.service;

import introsde.finalproject.calories.client.CaloriesCalculator;
import introsde.finalproject.calories.client.CaloriesService;
import introsde.finalproject.utils.Utils;

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

import finalproject.client.interfaces.GoalWebInterface;
import finalproject.client.interfaces.PersonWebInterface;
import finalproject.client.service.GoalService;
import finalproject.client.service.PersonService;
import finalproject.model.ExtendedHealthProfile;
import finalproject.model.Goal;
import finalproject.model.HealthProfile;
import finalproject.model.Person;

@Path("/person")
public class PersonResource {

	PersonWebInterface cperson = new PersonService().getCRUD();
	CaloriesCalculator caloriesCalculator = new CaloriesService()
			.getCalculator();

	/**
	 * GET
	 * 
	 * /person
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Person> getPeople() throws ParseException {
		return cperson.getPeople();
	}

	/**
	 * POST
	 * 
	 * /person
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createPerson(Person person) {

		int personId = cperson.createPerson(person);
		if (personId != -1)
			return Response.ok(cperson.readPerson(personId)).build();

		else
			return Response.status(Response.Status.BAD_REQUEST).build();
	}

	/**
	 * GET
	 * 
	 * /person/{id}
	 */
	@GET
	@Path("/{p_id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Person getPerson(@PathParam("p_id") int p_id) throws ParseException {

		Person p = cperson.readPerson(p_id);

		if (p != null)
			p.setExtendedhealthprofile(getExtendedHealthProfile(p));

		return p;
	}

	/**
	 * GET
	 * 
	 * /person/link?idperson={id_p}&idgoal={id_g}
	 */
	@GET
	@Path("/link")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response link(@QueryParam("idperson") int idperson,
			@QueryParam("idgoal") int idgoal) {

		cperson.linkGoal(idperson, idgoal);

		return Response.ok().build();
	}

	/**
	 * PUT
	 * 
	 * /person/goalprogress?idperson={id_p}&idgoal={id_g}
	 */
	@GET
	@Path("/goalprogress")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response setGoalProgress(@QueryParam("idperson") int idperson,
			@QueryParam("idgoal") int idgoal, Double progress) {

		cperson.setGoalProgress(idperson, idgoal, progress);

		return Response.ok().build();
	}

	/**
	 * GET
	 * 
	 * /person/goalprogress?idperson={id_p}&idgoal={id_g}
	 */
	@POST
	@Path("/goalprogress")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getGoalProgress(@QueryParam("idperson") int idperson,
			@QueryParam("idgoal") int idgoal) {

		return Response.ok(cperson.getGoalProgress(idperson, idgoal)).build();
	}

	/**
	 * PUT
	 * 
	 * /person/goalvalue?idperson={id_p}&idgoal={id_g}
	 */
	@GET
	@Path("/goalvalue")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response setGoalValue(@QueryParam("idperson") int idperson,
			@QueryParam("idgoal") int idgoal, String value) {

		cperson.setGoalValue(idperson, idgoal, value);

		return Response.ok().build();
	}

	/**
	 * GET
	 * 
	 * /person/goalvalue?idperson={id_p}&idgoal={id_g}
	 */
	@POST
	@Path("/goalvalue")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getGoalValue(@QueryParam("idperson") int idperson,
			@QueryParam("idgoal") int idgoal) {

		return Response.ok(cperson.getGoalValue(idperson, idgoal)).build();
	}

	/**
	 * PUT
	 * 
	 * /person/goalvalue?idperson={id_p}&idgoal={id_g}
	 */
	@GET
	@Path("/goalenddate")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response setGoalEndDate(@QueryParam("idperson") int idperson,
			@QueryParam("idgoal") int idgoal, String enddate) {

		cperson.setGoalEndDate(idperson, idgoal, enddate);

		return Response.ok().build();
	}

	/**
	 * GET
	 * 
	 * /person/goalenddate?idperson={id_p}&idgoal={id_g}
	 */
	@POST
	@Path("/goalenddate")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getGoalEndDate(@QueryParam("idperson") int idperson,
			@QueryParam("idgoal") int idgoal) {

		return Response.ok(cperson.getGoalEndDate(idperson, idgoal)).build();
	}

	/**
	 * PUT
	 * 
	 * /person/{id}
	 */
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

	/**
	 * DELETE
	 * 
	 * /person/{id}
	 */
	@DELETE
	@Path("/{p_id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deletePerson(@PathParam("p_id") int p_id) {

		p_id = cperson.deletePerson(p_id);

		if (p_id != -1)
			return Response.ok(Utils.jsonId(p_id)).build();
		else
			return Response.status(Response.Status.BAD_REQUEST).build();
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
