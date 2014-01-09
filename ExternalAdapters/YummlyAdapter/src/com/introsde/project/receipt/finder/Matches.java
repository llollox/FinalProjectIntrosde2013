package com.introsde.project.receipt.finder;

import java.util.List;

public class Matches {

	private Attributes attributes;
	private String flavors;
	private String id;
	private ImageUrlsBySize imageUrlsBySize;
	private List<String> ingredients;
	private Double rating;
	private String recipeName;
	private List<SmallImageUrls> smallImageUrls;
	private String sourceDisplayName;
	private Double totalTimeInSeconds;

	@Override
	public String toString() {
		return "Matches [attributes=" + attributes + ", flavors=" + flavors
				+ ", id=" + id + ", imageUrlsBySize=" + imageUrlsBySize
				+ ", ingredients=" + ingredients + ", rating=" + rating
				+ ", recipeName=" + recipeName + ", smallImageUrls="
				+ smallImageUrls + ", sourceDisplayName=" + sourceDisplayName
				+ ", totalTimeInSeconds=" + totalTimeInSeconds + "]";
	}

	public Attributes getAttributes() {
		return this.attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	public String getFlavors() {
		return this.flavors;
	}

	public void setFlavors(String flavors) {
		this.flavors = flavors;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ImageUrlsBySize getImageUrlsBySize() {
		return this.imageUrlsBySize;
	}

	public void setImageUrlsBySize(ImageUrlsBySize imageUrlsBySize) {
		this.imageUrlsBySize = imageUrlsBySize;
	}

	public List<String> getIngredients() {
		return this.ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public Double getRating() {
		return this.rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getRecipeName() {
		return this.recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public List<SmallImageUrls> getSmallImageUrls() {
		return this.smallImageUrls;
	}

	public void setSmallImageUrls(List<SmallImageUrls> smallImageUrls) {
		this.smallImageUrls = smallImageUrls;
	}

	public String getSourceDisplayName() {
		return this.sourceDisplayName;
	}

	public void setSourceDisplayName(String sourceDisplayName) {
		this.sourceDisplayName = sourceDisplayName;
	}

	public Double getTotalTimeInSeconds() {
		return this.totalTimeInSeconds;
	}

	public void setTotalTimeInSeconds(Double totalTimeInSeconds) {
		this.totalTimeInSeconds = totalTimeInSeconds;
	}
}
