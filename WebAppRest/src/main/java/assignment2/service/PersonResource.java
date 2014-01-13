package assignment2.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import finalproject.client.interfaces.CRUDPerson;
import finalproject.client.service.PersonService;
import finalproject.model.Person;

@Path("/person/")
public class PersonResource {

	public static CRUDPerson cperson = new PersonService().getCRUD();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Person> getPeople() {
		List<Person> list = cperson.getPeople();
		return list;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createPerson(Person person) {

		int personId = cperson.createPerson(person);
		if (personId != -1) {
			return Response.status(Response.Status.OK).entity(personId).build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/{p_id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Person getPerson(@PathParam("p_id") int p_id) {
		return cperson.readPerson(p_id);
	}

	@PUT
	@Path("/{p_id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updatePerson(@PathParam("p_id") int p_id, Person json) {

		Person dbPerson = cperson.readPerson(p_id);

		if (dbPerson != null && json.getFirstname() != null
				&& json.getLastname() != null && json.getBirthdate() != null
				&& json.getSex() != null) {

			// aggionro i dati della persona
			dbPerson.setFirstname(json.getFirstname());
			dbPerson.setLastname(json.getLastname());
			dbPerson.setBirthdate(json.getBirthdate());
			dbPerson.setSex(json.getSex());

			// aggiorno nel db la persona
			int personId = cperson.updatePerson(dbPerson);

			if (personId != -1) // data successiful updated!
				return Response.status(Response.Status.OK).entity(dbPerson)
						.build();
			else
				return Response.status(Response.Status.BAD_REQUEST).build();

		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@DELETE
	@Path("/{p_id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deletePerson(@PathParam("p_id") int p_id) {

		if (cperson.deletePerson(p_id)) {

			return Response.status(Response.Status.OK).build();

		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/birthdate?from={start}&to={end}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Person> getPeopleByBirthdate(@PathParam("start") String start,
			@PathParam("end") String end) {
		return cperson.getPeopleByBirthdate(start, end);
	}

	@GET
	@Path("/measure?name={name}&min={min}&max={max}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Person> getPeopleByMeasure(@PathParam("name") String name,
			@PathParam("min") String min, @PathParam("max") String max) {
		return cperson.getPeopleByMeasure(name, min, max);
	}

	@GET
	@Path("/name?contains={name}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Person> getPeopleByName(@PathParam("name") String name) {
		return cperson.getPeopleByName(name);
	}

}
