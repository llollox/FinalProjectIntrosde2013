package com.introsde.project.receipt.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Receipt {

	private Attributes attributes;
	private Attribution attribution;
	private Flavors flavors;
	private String id;
	private List<Images> images;
	private List<String> ingredientLines;
	private String name;
	private Double numberOfServings;
	private List<NutritionEstimates> nutritionEstimates;
	private Double rating;
	private Source source;
	private String totalTime;
	private Double totalTimeInSeconds;
	private String yield;

	public Attributes getAttributes() {
		return this.attributes;
	}

	@Override
	public String toString() {
		return "Receipt [attributes=" + attributes + ", attribution="
				+ attribution + ", flavors=" + flavors + ", id=" + id
				+ ", images=" + images + ", ingredientLines=" + ingredientLines
				+ ", name=" + name + ", numberOfServings=" + numberOfServings
				+ ", nutritionEstimates=" + nutritionEstimates + ", rating="
				+ rating + ", source=" + source + ", totalTime=" + totalTime
				+ ", totalTimeInSeconds=" + totalTimeInSeconds + ", yield="
				+ yield + "]";
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	public Attribution getAttribution() {
		return this.attribution;
	}

	public void setAttribution(Attribution attribution) {
		this.attribution = attribution;
	}

	public Flavors getFlavors() {
		return this.flavors;
	}

	public void setFlavors(Flavors flavors) {
		this.flavors = flavors;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Images> getImages() {
		return this.images;
	}

	public void setImages(List<Images> images) {
		this.images = images;
	}

	public List<String> getIngredientLines() {
		return this.ingredientLines;
	}

	public void setIngredientLines(List<String> ingredientLines) {
		this.ingredientLines = ingredientLines;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getNumberOfServings() {
		return this.numberOfServings;
	}

	public void setNumberOfServings(Double numberOfServings) {
		this.numberOfServings = numberOfServings;
	}

	public List<NutritionEstimates> getNutritionEstimates() {
		return this.nutritionEstimates;
	}

	public void setNutritionEstimates(
			List<NutritionEstimates> nutritionEstimates) {
		this.nutritionEstimates = nutritionEstimates;
	}

	public Double getRating() {
		return this.rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Source getSource() {
		return this.source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public String getTotalTime() {
		return this.totalTime;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}

	public Double getTotalTimeInSeconds() {
		return this.totalTimeInSeconds;
	}

	public void setTotalTimeInSeconds(Double totalTimeInSeconds) {
		this.totalTimeInSeconds = totalTimeInSeconds;
	}

	public String getYield() {
		return this.yield;
	}

	public void setYield(String yield) {
		this.yield = yield;
	}
}
