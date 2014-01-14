package introsde.finalproject.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import finalproject.client.interfaces.ActivityWebInterface;
import finalproject.client.service.ActivityService;
import finalproject.model.Activity;
import finalproject.model.Goal;
import finalproject.model.HealthProfile;
import finalproject.ports.CRUDActivity;

@Path("/suggest/")
public class SuggestActivitiesResource {
	
	ActivityWebInterface c = new ActivityService().getCRUD();
	final int ID_GENERAL_ACTIVITY = 1;
	final double THRESHOLD_IHB = 0.5;
	final double THRESHOLD_GHB = 0.8;
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Activity> suggestActivities(List<Goal> goals, HealthProfile hp) {
		
		ArrayList<Activity> results = new ArrayList<Activity>();
		
		for (Goal goal : goals) {
			results.addAll(suggestActivities(goal, hp));
		}
		
		return results;
	}
	
	private List<Activity> suggestActivities(Goal goal, HealthProfile hp) {
		if (goal.getType() == 0)
			return suggestWeightActivities(goal, hp);
		if (goal.getType() == 1)
			return suggestGeneralActivities(goal, hp);
		if (goal.getType() == 2)
			return suggestImportantHealthBenefits(goal, hp);
		return null;
	}

	/**
	 * WEIGHT
	 */
	private List<Activity> suggestWeightActivities(Goal goal, HealthProfile hp) {
		List<Activity> result = new ArrayList<Activity>();
		
		// get weight to loose/gain
		double weight = Double.parseDouble(goal.getValue());
		String enddate = goal.getEnddate();
		
		// calculate (target date - now) 
		int remainingdays = getDaysFromNow(enddate);
		
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
	private List<Activity> suggestGeneralActivities(Goal goal, HealthProfile hp) {
		List<Activity> result = new ArrayList<Activity>();

		result.add(c.readActivity(ID_GENERAL_ACTIVITY));
		
		return result;
	}
	
	/**
	 * IMPORTANT HEALTH BENEFITS
	 */
	private List<Activity> suggestImportantHealthBenefits(Goal goal, HealthProfile hp) {
		List<Activity> result = new ArrayList<Activity>();
		
		// retrieve the activities
		List<Activity> activities = goal.getActivities();
		for (Activity activity : activities) {
			if (activity.getDifficultyvalue() >= THRESHOLD_IHB)
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
