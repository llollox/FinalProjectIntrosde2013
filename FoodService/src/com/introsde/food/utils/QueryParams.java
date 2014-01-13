package com.introsde.food.utils;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class QueryParams {

	private List<KeyValuePair> queryParams;

	public QueryParams() {
		super();
		queryParams = new ArrayList<KeyValuePair>();
	}

	public void add(KeyValuePair keyValue) {
		queryParams.add(keyValue);
	}

	public List<KeyValuePair> getQueryParams() {
		return queryParams;
	}

	public void setQueryParams(List<KeyValuePair> queryParams) {
		this.queryParams = queryParams;
	}

}
