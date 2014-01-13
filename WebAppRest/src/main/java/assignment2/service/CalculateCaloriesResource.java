package assignment2.service;

import introsde.finalproject.calories.client.CaloriesCalculator;
import introsde.finalproject.calories.client.CaloriesService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/calculate")
public class CalculateCaloriesResource {

	public static CaloriesCalculator cc = new CaloriesService().getCalculator();

	@GET
	@Path("/idealweight")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getIdealWeight(@QueryParam("height") double height,
			@QueryParam("sex") int sex) {

		if (height > 0) {
			double idealWeight = cc.getIdealWeight(height, sex);
			if (idealWeight != -1)
				return Response.status(Response.Status.OK)
						.entity("" + idealWeight).build();
			else
				return Response.status(Response.Status.BAD_REQUEST).build();
		} else
			return Response.status(Response.Status.BAD_REQUEST).build();
	}

	@GET
	@Path("/idealbmi")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getIdealBMI(@QueryParam("height") double height,
			@QueryParam("sex") int sex) {

		if (height > 0) {
			double idealBmi = cc.getIdealBMI(height, sex);
			if (idealBmi != -1)
				return Response.status(Response.Status.OK)
						.entity("" + idealBmi).build();
			else
				return Response.status(Response.Status.BAD_REQUEST).build();
		} else
			return Response.status(Response.Status.BAD_REQUEST).build();
	}

	@GET
	@Path("/bmi")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getBMI(@QueryParam("height") double height,
			@QueryParam("weight") double weight) {

		if (height > 0 && weight > 0) {
			return Response.status(Response.Status.OK)
					.entity("" + cc.getBMI(height, weight)).build();
		} else
			return Response.status(Response.Status.BAD_REQUEST).build();
	}

	@GET
	@Path("/bmr")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getBMR(@QueryParam("height") double height,
			@QueryParam("weight") double weight, @QueryParam("age") double age,
			@QueryParam("sex") int sex) {

		if (height > 0 && weight > 0 && age > 0) {
			return Response.status(Response.Status.OK)
					.entity("" + cc.getBMR(height, weight, age, sex)).build();
		} else
			return Response.status(Response.Status.BAD_REQUEST).build();
	}

	@GET
	@Path("/dailycalories")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getIdealDailyCaloriesNeeded(@QueryParam("bmr") double bmr,
			@QueryParam("exerciseTimesPerWeek") int exerciseTimesPerWeek) {

		if (bmr > 0) {
			return Response
					.status(Response.Status.OK)
					.entity(""
							+ cc.getIdealDailyCaloriesNeeded(bmr,
									exerciseTimesPerWeek)).build();
		} else
			return Response.status(Response.Status.BAD_REQUEST).build();
	}

	@GET
	@Path("/dailycaloriesmanaged")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getDailyCaloriesNeededToManageWeight(
			@QueryParam("bmr") double bmr,
			@QueryParam("exerciseTimesPerWeek") int exerciseTimesPerWeek,
			@QueryParam("weightDifference") String weightDifference,
			@QueryParam("days") int days) {

		if (bmr > 0 && weightDifference != null && days > 0) {

			return Response
					.status(Response.Status.OK)
					.entity(""
							+ cc.getDailyCaloriesNeededToManageWeight(bmr,
									exerciseTimesPerWeek,
									Integer.parseInt(weightDifference), days))
					.build();
		} else
			return Response.status(Response.Status.BAD_REQUEST).build();
	}

}
