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

import finalproject.model.Activity;
import finalproject.model.Goal;
import finalproject.model.HealthProfile;

@Path("/suggest/")
public class SuggestActivitiesResource {
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Activity> suggestActivities(List<Goal> goals, HealthProfile hp) {
		
		ArrayList<Activity> results = new ArrayList<Activity>();
		
		for (Goal goal : goals) {
			results.addAll(suggestActivity(goal, hp));
		}
		
		return results;
	}
	
	private List<Activity> suggestActivity(Goal goal, HealthProfile hp) {
		if (goal.getType() == 0)
			return suggestWeightActivity(goal, hp);
		return null;
	}
	
	private List<Activity> suggestWeightActivity(Goal goal, HealthProfile hp) {
		// get data from goal
		double weight = Double.parseDouble(goal.getValue());
		String enddate = goal.getEnddate();
		
		// calculate (target date - now) 
		int remainingdays = getDaysFromNow(enddate);
		
		// calculate difficulty
		double difficulty = remainingdays / weight;
		
		List<Activity> result = new ArrayList<Activity>();
		
		// retrieve the activities
		List<Activity> activities = goal.getActivities();
		for (Activity activity : activities) {
			if (activity.getDifficultyvalue() == difficulty)
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
