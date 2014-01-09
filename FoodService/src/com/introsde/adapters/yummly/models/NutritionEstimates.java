package com.introsde.adapters.yummly.models;

/**
 * @author franz
 * 
 */
public class NutritionEstimates {

	private String attribute;
	private String description;
	private Unit unit;
	private Double value;

	public String getAttribute() {
		return this.attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Unit getUnit() {
		return this.unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Double getValue() {
		return this.value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "NutritionEstimates [attribute=" + attribute + ", description="
				+ description + ", unit=" + unit + ", value=" + value + "]";
	}

}
