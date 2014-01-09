package com.introsde.adapters.yummly.models;

public class Images {

	private String hostedLargeUrl;
	private String hostedSmallUrl;
	private ImageUrlsBySize imageUrlsBySize;

	public String getHostedLargeUrl() {
		return this.hostedLargeUrl;
	}

	public void setHostedLargeUrl(String hostedLargeUrl) {
		this.hostedLargeUrl = hostedLargeUrl;
	}

	public String getHostedSmallUrl() {
		return this.hostedSmallUrl;
	}

	public void setHostedSmallUrl(String hostedSmallUrl) {
		this.hostedSmallUrl = hostedSmallUrl;
	}

	public ImageUrlsBySize getImageUrlsBySize() {
		return this.imageUrlsBySize;
	}

	public void setImageUrlsBySize(ImageUrlsBySize imageUrlsBySize) {
		this.imageUrlsBySize = imageUrlsBySize;
	}
}
