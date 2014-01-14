package introsde.finalproject.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import finalproject.client.interfaces.ActivityWebInterface;
import finalproject.client.interfaces.GoalWebInterface;
import finalproject.client.service.ActivityService;
import finalproject.client.service.GoalService;
import finalproject.model.Activity;
import finalproject.model.Goal;
import finalproject.model.Person;

@Path("/suggest/")
public class SuggestActivitiesResource {
	
	private ActivityWebInterface c = new ActivityService().getCRUD();
	private GoalWebInterface g = new GoalService().getCRUD();
	
	private int ID_GENERAL_ACTIVITY = 1;
	private double THRESHOLD_IHB = 0.5;
	private double THRESHOLD_GHB = 0.8;
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Activity> suggestActivities(Person person) {
		
		ArrayList<Activity> results = new ArrayList<Activity>();
		
		List<Goal> goals = person.getGoals();
		for (Goal goal : goals) {
			results.addAll(suggestActivities(goal, person));
		}
		
		return results;
	}
	
	private List<Activity> suggestActivities(Goal goal, Person person) {
		if (goal.getType() == 0)
			return suggestWeightActivities(goal, person);
		if (goal.getType() == 1)
			return suggestGeneralActivities(goal, person);
		if (goal.getType() == 2)
			return suggestImportantHealthBenefits(goal, person);
		if (goal.getType() == 3)
			return suggestGreaterHealthBenefits(goal, person);
		return null;
	}

	/**
	 * WEIGHT
	 */
	private List<Activity> suggestWeightActivities(Goal goal, Person person) {
		List<Activity> result = new ArrayList<Activity>();
		
		String value = g.getGoalValue(person.getId(), goal.getId());
		String enddate = g.getGoalEndDate(person.getId(), goal.getId());
		
		double weight = Double.parseDouble(value);
		
		// calculate (target date - now) 
		int remainingdays = getDaysFromNow(enddate);
		
		// if the date is malformated or < than the current date
		if (remainingdays == -1)
			return null;
		
		// calculate difficulty
		double difficulty = remainingdays / weight;
		
		// retrieve the activities
		List<Activity> activities = goal.getActivities();
		for (Activity activity : activities) {
			if (activity.getDifficultyvalue() == difficulty)
				result.add(activity);
		}
		
		return result;
	}
	
	/**
	 * GENERAL
	 */
	private List<Activity> suggestGeneralActivities(Goal goal, Person person) {
		List<Activity> result = new ArrayList<Activity>();

		result.add(c.readActivity(ID_GENERAL_ACTIVITY));
		
		return result;
	}
	
	/**
	 * IMPORTANT HEALTH BENEFITS
	 */
	private List<Activity> suggestImportantHealthBenefits(Goal goal, Person person) {
		List<Activity> result = new ArrayList<Activity>();
		
		// retrieve the activities
		List<Activity> activities = goal.getActivities();
		for (Activity activity : activities) {
			if (activity.getDifficultyvalue() >= THRESHOLD_IHB)
				result.add(activity);
		}
		
		return result;
	}
	
	/**
	 * GREATER HEALTH BENEFITS
	 */
	private List<Activity> suggestGreaterHealthBenefits(Goal goal, Person person) {
		List<Activity> result = new ArrayList<Activity>();
		
		// retrieve the activities
		List<Activity> activities = goal.getActivities();
		for (Activity activity : activities) {
			if (activity.getDifficultyvalue() >= THRESHOLD_GHB)
				result.add(activity);
		}
		
		return result;
	}
	
	private int getDaysFromNow(String date) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date d;
		try {
			d = dateFormat.parse(date);
		} catch (ParseException e) {
			return -1;
		}
		
		Calendar c = Calendar.getInstance();
		
		long diff = d.getTime() - c.getTimeInMillis();
		
		return (int) (diff / (1000 * 60 * 60 * 24)) + 1;
	}
	
}
