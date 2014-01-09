package com.introsde.adapters.edamam.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class EdamamResponse {

	private String uri;

	private Double yield;

	private Integer calories;

	private List<String> dietLabels = new ArrayList<String>();

	private List<String> healthLabels = new ArrayList<String>();

	private List<Object> cautions = new ArrayList<Object>();

	// private List<Nutrient> totalNutrients = new ArrayList<Nutrient>();

	private TotalNutrients totalNutrients;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Double getYield() {
		return yield;
	}

	public void setYield(Double yield) {
		this.yield = yield;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	public List<String> getDietLabels() {
		return dietLabels;
	}

	public void setDietLabels(List<String> dietLabels) {
		this.dietLabels = dietLabels;
	}

	public List<String> getHealthLabels() {
		return healthLabels;
	}

	public void setHealthLabels(List<String> healthLabels) {
		this.healthLabels = healthLabels;
	}

	public List<Object> getCautions() {
		return cautions;
	}

	public void setCautions(List<Object> cautions) {
		this.cautions = cautions;
	}

	public TotalNutrients getTotalNutrients() {
		return totalNutrients;
	}

	public void setTotalNutrients(TotalNutrients totalNutrients) {
		this.totalNutrients = totalNutrients;
	}

	// public List<Nutrient> getTotalNutrients() {
	// return totalNutrients;
	// }
	//
	// public void setTotalNutrients(List<Nutrient> totalNutrients) {
	// this.totalNutrients = totalNutrients;
	// }

	@Override
	public String toString() {
		return "\nEdamamResponse [uri=" + uri + ", yield=" + yield
				+ ", calories=" + calories + ", dietLabels=" + dietLabels
				+ ", healthLabels=" + healthLabels + ", cautions=" + cautions
				+ ", totalNutrients=" + totalNutrients + "]";
	}

}
