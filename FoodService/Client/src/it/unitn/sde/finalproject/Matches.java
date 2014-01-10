package it.unitn.sde.finalproject;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "matches", propOrder = { "attributes", "flavors", "id",
		"imageUrlsBySize", "ingredients", "rating", "recipeName",
		"smallImageUrls", "sourceDisplayName", "totalTimeInSeconds" })
public class Matches {

	protected Attributes attributes;
	protected String flavors;
	protected String id;
	protected ImageUrlsBySize imageUrlsBySize;
	@XmlElement(nillable = true)
	protected List<String> ingredients;
	protected Double rating;
	protected String recipeName;
	@XmlElement(nillable = true)
	protected List<SmallImageUrls> smallImageUrls;
	protected String sourceDisplayName;
	protected Double totalTimeInSeconds;

	/**
	 * Gets the value of the attributes property.
	 * 
	 * @return possible object is {@link Attributes }
	 * 
	 */
	public Attributes getAttributes() {
		return attributes;
	}

	/**
	 * Sets the value of the attributes property.
	 * 
	 * @param value
	 *            allowed object is {@link Attributes }
	 * 
	 */
	public void setAttributes(Attributes value) {
		this.attributes = value;
	}

	/**
	 * Gets the value of the flavors property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFlavors() {
		return flavors;
	}

	/**
	 * Sets the value of the flavors property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFlavors(String value) {
		this.flavors = value;
	}

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * Gets the value of the imageUrlsBySize property.
	 * 
	 * @return possible object is {@link ImageUrlsBySize }
	 * 
	 */
	public ImageUrlsBySize getImageUrlsBySize() {
		return imageUrlsBySize;
	}

	/**
	 * Sets the value of the imageUrlsBySize property.
	 * 
	 * @param value
	 *            allowed object is {@link ImageUrlsBySize }
	 * 
	 */
	public void setImageUrlsBySize(ImageUrlsBySize value) {
		this.imageUrlsBySize = value;
	}

	/**
	 * Gets the value of the ingredients property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the ingredients property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getIngredients().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	public List<String> getIngredients() {
		if (ingredients == null) {
			ingredients = new ArrayList<String>();
		}
		return this.ingredients;
	}

	/**
	 * Gets the value of the rating property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getRating() {
		return rating;
	}

	/**
	 * Sets the value of the rating property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setRating(Double value) {
		this.rating = value;
	}

	/**
	 * Gets the value of the recipeName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRecipeName() {
		return recipeName;
	}

	/**
	 * Sets the value of the recipeName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRecipeName(String value) {
		this.recipeName = value;
	}

	/**
	 * Gets the value of the smallImageUrls property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the smallImageUrls property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSmallImageUrls().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link SmallImageUrls }
	 * 
	 * 
	 */
	public List<SmallImageUrls> getSmallImageUrls() {
		if (smallImageUrls == null) {
			smallImageUrls = new ArrayList<SmallImageUrls>();
		}
		return this.smallImageUrls;
	}

	/**
	 * Gets the value of the sourceDisplayName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSourceDisplayName() {
		return sourceDisplayName;
	}

	/**
	 * Sets the value of the sourceDisplayName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSourceDisplayName(String value) {
		this.sourceDisplayName = value;
	}

	/**
	 * Gets the value of the totalTimeInSeconds property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getTotalTimeInSeconds() {
		return totalTimeInSeconds;
	}

	/**
	 * Sets the value of the totalTimeInSeconds property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setTotalTimeInSeconds(Double value) {
		this.totalTimeInSeconds = value;
	}

}
