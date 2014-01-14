package introsde.finalproject.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import finalproject.client.interfaces.PersonWebInterface;
import finalproject.client.service.PersonService;
import finalproject.model.Person;

@Path("/search")
public class SearchService {

	PersonWebInterface cperson = new PersonService().getCRUD();

	/**
	 * GET
	 * 
	 * /search/birthdate?from=dd-mm-yyyy&to=dd-mm-yyyy
	 */

	@GET
	@Path("/birthdate")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Person> getPeopleByBirthdate(
			@QueryParam("to") String before_qp,
			@QueryParam("from") String after_qp) {

		return cperson.getPeopleByBirthdate(after_qp, before_qp);
	}

	/**
	 * GET
	 * 
	 * /search/profile?measure={height|weight}&min=MIN&max=MAX
	 */

	@GET
	@Path("/profile")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Person> getPeopleByMeasure(
			@QueryParam("measure") String measure,
			@QueryParam("max") Double max, @QueryParam("min") Double min) {

		if (measure == null
				|| (!measure.equals("height") && !measure.equals("weight")))
			return null;

		return cperson.getPeopleByMeasure(measure, min + "", max + "");
	}

	/**
	 * GET
	 * 
	 * /search/name?q=TEXT_TO_SEARCH
	 */

	@GET
	@Path("/name")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Person> getPeopleByMeasure(@QueryParam("q") String query) {

		return cperson.getPeopleByName(query);
	}

}
