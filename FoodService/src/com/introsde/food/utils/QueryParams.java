package com.introsde.food.utils;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class QueryParams {

	List<KeyValuePair> queryParams;

	public QueryParams() {
		super();
	}

	public List<KeyValuePair> getQueryParams() {
		return queryParams;
	}

	public void setQueryParams(List<KeyValuePair> queryParams) {
		this.queryParams = queryParams;
	}

}
