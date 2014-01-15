package introsde.finalproject.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import finalproject.model.GoalChoosen;

@XmlRootElement
public class GoalExtended {

	private List<GoalChoosen> goals;

	public GoalExtended(List<GoalChoosen> goals) {
		super();
		this.goals = goals;
	}

	public GoalExtended() {
		super();
	}

	public List<GoalChoosen> getGoals() {
		return goals;
	}

	public void setGoals(List<GoalChoosen> goals) {
		this.goals = goals;
	}

}
