package com.introsde.adapters.yummly.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ImageUrlsBySize {

	private String bigImage;
	private String smallImage;

	@XmlElement(name = "_360")
	public String getBigImage() {
		return bigImage;
	}

	public void setBigImage(String bigImage) {
		this.bigImage = bigImage;
	}

	@XmlElement(name = "_90")
	public String getSmallImage() {
		return smallImage;
	}

	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}

	@Override
	public String toString() {
		return "ImageUrlsBySize [bigImage=" + bigImage + ", smallImage="
				+ smallImage + "]";
	}

}
