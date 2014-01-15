package introsde.finalproject.resources;

import introsde.finalproject.model.GoalExtended;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import finalproject.client.interfaces.GoalChoosenWebInterface;
import finalproject.client.interfaces.PersonWebInterface;
import finalproject.client.service.GoalChoosenService;
import finalproject.client.service.PersonService;
import finalproject.model.GoalChoosen;

@Path("/suggest/person/{p_id}")
public class SuggestActivitiesResource {

	@GET
	public Response getExerciseForPerson() {
		return Response.ok().build();
	}

	GoalChoosenWebInterface goal = new GoalChoosenService().getCRUD();
	PersonWebInterface person = new PersonService().getCRUD();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public GoalExtended getExtendedGoalsForPerson(@PathParam("p_id") int id) {

		List<GoalChoosen> goals = goal.getGoalChoosenForPerson(id);

		/**
		 * 
		 * TODO ADD SOME STUFF LIKE FILTERING
		 */
		return new GoalExtended(goals);
	}

	@GET
	@Path("/goal/{g_id}")
	public GoalChoosen getExerciseForPerson(@PathParam("p_id") int pid,
			@PathParam("g_id") int gid) {

		return goal.read(gid);
	}

	// @POST
	// public void insertExercise() {
	// }
	//
	// @POST
	// public void insertGoal() {
	//
	// }
	//
	// @PUT
	// public void updateExercise() {
	// }
	//
	// @PUT
	// public void updateGoal() {
	//
	// }

	// public void getWeeklyWorkout() {
	// }
	//
	// // ????????????????????????????????????????
	// public void getPersonExerciseHistory() {
	// }
	//
	// private ActivityWebInterface c = new ActivityService().getCRUD();
	// private GoalWebInterface g = new GoalService().getCRUD();
	//
	// private int ID_GENERAL_ACTIVITY = 1;
	// private double THRESHOLD_IHB = 0.5;
	// private double THRESHOLD_GHB = 0.8;
	//
	// @GET
	// @Path("/{p_id}")
	// @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	// public List<Activity> suggestActivities(@PathParam("p_id") int p_id) {
	//
	// Person person = new PersonService().getCRUD().readPerson(p_id);
	//
	// if (person == null)
	// return null;
	//
	// ArrayList<Activity> results = new ArrayList<Activity>();
	//
	// // List<Goal> goals = person.getGoals();
	// // for (Goal goal : goals) {
	// // results.addAll(suggestActivities(goal, person));
	// // }
	//
	// return results;
	// }
	//
	// // private List<Activity> suggestActivities(Goal goal, Person person) {
	// // if (goal.getType() == 0)
	// // return suggestWeightActivities(goal, person);
	// // if (goal.getType() == 1)
	// // return suggestGeneralActivities(goal, person);
	// // if (goal.getType() == 2)
	// // return suggestImportantHealthBenefits(goal, person);
	// // if (goal.getType() == 3)
	// // return suggestGreaterHealthBenefits(goal, person);
	// // return null;
	// // }
	//
	// /**
	// * WEIGHT
	// */
	// private List<Activity> suggestWeightActivities(Goal goal, Person person)
	// {
	// List<Activity> result = new ArrayList<Activity>();
	//
	// // String value = g.getGoalValue(person.getId(), goal.getId());
	// // String enddate = g.getGoalEndDate(person.getId(), goal.getId());
	//
	// double weight = 5;// Double.parseDouble(value);
	//
	// // calculate (target date - now)
	// int remainingdays = 1;// getDaysFromNow(enddate);
	//
	// // if the date is malformated or < than the current date
	// if (remainingdays == -1)
	// return null;
	//
	// // calculate difficulty
	// double difficulty = remainingdays / weight;
	//
	// // retrieve the activities
	// // List<Activity> activities = goal.getActivities();
	// // for (Activity activity : activities) {
	// // if (activity.getDifficultyvalue() == difficulty)
	// // result.add(activity);
	// // }
	//
	// return result;
	// }
	//
	// /**
	// * GENERAL
	// */
	// private List<Activity> suggestGeneralActivities(Goal goal, Person person)
	// {
	// List<Activity> result = new ArrayList<Activity>();
	//
	// result.add(c.readActivity(ID_GENERAL_ACTIVITY));
	//
	// return result;
	// }
	//
	// /**
	// * IMPORTANT HEALTH BENEFITS
	// */
	// private List<Activity> suggestImportantHealthBenefits(Goal goal,
	// Person person) {
	// List<Activity> result = new ArrayList<Activity>();
	//
	// // retrieve the activities
	// // List<Activity> activities = goal.getActivities();
	// // for (Activity activity : activities) {
	// // if (activity.getDifficultyvalue() >= THRESHOLD_IHB)
	// // result.add(activity);
	// // }
	//
	// return result;
	// }
	//
	// /**
	// * GREATER HEALTH BENEFITS
	// */
	// private List<Activity> suggestGreaterHealthBenefits(Goal goal, Person
	// person) {
	// List<Activity> result = new ArrayList<Activity>();
	//
	// // retrieve the activities
	// // List<Activity> activities = goal.getActivities();
	// // for (Activity activity : activities) {
	// // if (activity.getDifficultyvalue() >= THRESHOLD_GHB)
	// // result.add(activity);
	// // }
	//
	// return result;
	// }
	//
	// private int getDaysFromNow(String date) {
	//
	// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	//
	// Date d;
	// try {
	// d = dateFormat.parse(date);
	// } catch (ParseException e) {
	// return -1;
	// }
	//
	// Calendar c = Calendar.getInstance();
	//
	// long diff = d.getTime() - c.getTimeInMillis();
	//
	// return (int) (diff / (1000 * 60 * 60 * 24)) + 1;
	// }

}
