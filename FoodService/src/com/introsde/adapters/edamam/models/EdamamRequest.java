package com.introsde.adapters.edamam.models;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EdamamRequest {

	List<String> ingr;

	public List<String> getIngr() {
		return ingr;
	}

	public void setIngr(List<String> ingr) {
		this.ingr = ingr;
	}

}
