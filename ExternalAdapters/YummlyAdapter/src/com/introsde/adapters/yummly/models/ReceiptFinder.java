package com.introsde.adapters.yummly.models;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ReceiptFinder {

	private Attribution attribution;
	private Criteria criteria;
	private FacetCounts facetCounts;
	private List<Matches> matches;
	private Double totalMatchCount;

	public Attribution getAttribution() {
		return this.attribution;
	}

	public void setAttribution(Attribution attribution) {
		this.attribution = attribution;
	}

	public Criteria getCriteria() {
		return this.criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	public FacetCounts getFacetCounts() {
		return this.facetCounts;
	}

	public void setFacetCounts(FacetCounts facetCounts) {
		this.facetCounts = facetCounts;
	}

	public List<Matches> getMatches() {
		return this.matches;
	}

	public void setMatches(List<Matches> matches) {
		this.matches = matches;
	}

	public Double getTotalMatchCount() {
		return this.totalMatchCount;
	}

	public void setTotalMatchCount(Double totalMatchCount) {
		this.totalMatchCount = totalMatchCount;
	}

	@Override
	public String toString() {
		return "ReceiptFinder [attribution=" + attribution + ", criteria="
				+ criteria + ", facetCounts=" + facetCounts + ", matches="
				+ matches + ", totalMatchCount=" + totalMatchCount + "]";
	}

}
