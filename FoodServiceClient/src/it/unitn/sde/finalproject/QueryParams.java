package it.unitn.sde.finalproject;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for queryParams complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="queryParams">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="queryParams" type="{http://finalproject.sde.unitn.it/}keyValuePair" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queryParams", propOrder = { "queryParams" })
public class QueryParams {

	@XmlElement(nillable = true)
	protected List<KeyValuePair> queryParams;

	/**
	 * Gets the value of the queryParams property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the queryParams property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getQueryParams().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link KeyValuePair }
	 * 
	 * 
	 */
	public List<KeyValuePair> getQueryParams() {
		if (queryParams == null) {
			queryParams = new ArrayList<KeyValuePair>();
		}
		return this.queryParams;
	}

	public void setQueryParams(List<KeyValuePair> queryParams) {
		this.queryParams = queryParams;
	}

}
