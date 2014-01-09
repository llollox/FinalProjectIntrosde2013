package com.introsde.project.receipt.finder;

public class Criteria {

	private String allowedIngredients;
	private String excludedIngredients;
	private boolean requirePictures;
	private String terms;

	public String getAllowedIngredients() {
		return this.allowedIngredients;
	}

	public void setAllowedIngredients(String allowedIngredients) {
		this.allowedIngredients = allowedIngredients;
	}

	public String getExcludedIngredients() {
		return this.excludedIngredients;
	}

	public void setExcludedIngredients(String excludedIngredients) {
		this.excludedIngredients = excludedIngredients;
	}

	public boolean getRequirePictures() {
		return this.requirePictures;
	}

	public void setRequirePictures(boolean requirePictures) {
		this.requirePictures = requirePictures;
	}

	public String getTerms() {
		return this.terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}
}
