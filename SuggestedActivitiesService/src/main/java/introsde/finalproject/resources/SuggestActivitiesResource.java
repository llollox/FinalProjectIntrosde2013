package introsde.finalproject.resources;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import finalproject.client.interfaces.ActivityWebInterface;
import finalproject.client.interfaces.ExerciseHistoryWebInterface;
import finalproject.client.interfaces.GoalChoosenWebInterface;
import finalproject.client.interfaces.GoalWebInterface;
import finalproject.client.interfaces.PersonWebInterface;
import finalproject.client.service.ActivityService;
import finalproject.client.service.ExerciseHistoryService;
import finalproject.client.service.GoalChoosenService;
import finalproject.client.service.GoalService;
import finalproject.client.service.PersonService;
import finalproject.model.Activity;
import finalproject.model.ExerciseHistory;
import finalproject.model.GoalChoosen;
import finalproject.model.Person;

@Path("/suggest/person/{p_id}")
public class SuggestActivitiesResource {

	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	GoalWebInterface goal = new GoalService().getCRUD();
	GoalChoosenWebInterface goalChossen = new GoalChoosenService().getCRUD();
	PersonWebInterface person = new PersonService().getCRUD();
	ExerciseHistoryWebInterface exHist = new ExerciseHistoryService().getCRUD();
	ActivityWebInterface activity = new ActivityService().getCRUD();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<GoalChoosen> getExtendedGoalsForPerson(@PathParam("p_id") int id) {

		List<GoalChoosen> goals = goalChossen.getGoalChoosenForPerson(id);

		// filter(goals) TODO not yet implemented

		return calculatePercentage(goals);
	}

	@GET
	@Path("/goal/{g_id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public GoalChoosen getExerciseForPerson(@PathParam("p_id") int pid,
			@PathParam("g_id") int gid) {

		return calculatePercentage(goalChossen.read(gid));
	}

	@POST
	@Path("/goal/{g_id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public GoalChoosen insertChoosenGoal(@PathParam("p_id") int pid,
			@PathParam("g_id") int gid) {

		Person p = person.readPerson(pid);

		System.out.println(p.getId() + " " + p.getFirstname());

		GoalChoosen choosenGoal = new GoalChoosen();

		choosenGoal.setGoal(goal.readGoal(gid));
		choosenGoal.setPerson(p);

		int id = goalChossen.create(choosenGoal);

		if (id == -1)
			return null;

		return calculatePercentage(goalChossen.read(id));
	}

	@POST
	@Path("/goal/{g_id}/activity/{a_id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ExerciseHistory insertExercise(@PathParam("p_id") int pid,
			@PathParam("g_id") int gid, @PathParam("a_id") int aid,
			ExerciseHistory ex) {

		ex.setActivity(activity.readActivity(aid));
		ex.setGoalchoosen(goalChossen.read(gid));
		ex.setDate(df.format(new Date()));

		int exid = exHist.createExerciseHistory(ex);

		if (exid == -1)
			return null;

		return exHist.readExerciseHistory(exid);
	}

	private List<GoalChoosen> calculatePercentage(List<GoalChoosen> goalList) {

		if (goalList != null && !goalList.isEmpty()) {

			for (GoalChoosen g : goalList) {

				// List<Activity> activities = g.getGoal().getActivities();
				//
				// for (Activity a : activities)
				// ;

				List<ExerciseHistory> ese = g.getExercises();
				// Double percentage = new Double(0);

				for (ExerciseHistory e : ese) {

					Activity a = e.getActivity();

					a.setPercentage((double) 0);

				}

				g.setPercentage((double) 0);
			}

		}
		return goalList;
	}

	private GoalChoosen calculatePercentage(GoalChoosen g) {

		if (g != null) {

			List<ExerciseHistory> ese = g.getExercises();
			// Double percentage = new Double(0);

			for (ExerciseHistory e : ese) {

				Activity a = e.getActivity();

				a.setPercentage((double) 0);

			}

			g.setPercentage((double) 0);

		}

		return g;
	}

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
