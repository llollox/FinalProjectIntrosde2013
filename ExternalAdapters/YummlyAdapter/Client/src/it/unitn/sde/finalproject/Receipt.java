package it.unitn.sde.finalproject;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for receipt complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="receipt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="attributes" type="{http://finalproject.sde.unitn.it/}attributes" minOccurs="0"/>
 *         &lt;element name="attribution" type="{http://finalproject.sde.unitn.it/}attribution" minOccurs="0"/>
 *         &lt;element name="flavors" type="{http://finalproject.sde.unitn.it/}flavors" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="images" type="{http://finalproject.sde.unitn.it/}images" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ingredientLines" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numberOfServings" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="nutritionEstimates" type="{http://finalproject.sde.unitn.it/}nutritionEstimates" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="rating" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="source" type="{http://finalproject.sde.unitn.it/}source" minOccurs="0"/>
 *         &lt;element name="totalTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalTimeInSeconds" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="yield" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "receipt", propOrder = { "attributes", "attribution",
		"flavors", "id", "images", "ingredientLines", "name",
		"numberOfServings", "nutritionEstimates", "rating", "source",
		"totalTime", "totalTimeInSeconds", "yield" })
public class Receipt {

	@Override
	public String toString() {
		return "Receipt [attributes=" + attributes + ", attribution="
				+ attribution + ", flavors=" + flavors + ", id=" + id
				+ ", images=" + images + ", ingredientLines=" + ingredientLines
				+ ", name=" + name + ", numberOfServings=" + numberOfServings
				+ ", nutritionEstimates=" + nutritionEstimates + ", rating="
				+ rating + ", source=" + source + ", totalTime=" + totalTime
				+ ", totalTimeInSeconds=" + totalTimeInSeconds + ", yield="
				+ yield + "]";
	}

	protected Attributes attributes;
	protected Attribution attribution;
	protected Flavors flavors;
	protected String id;
	@XmlElement(nillable = true)
	protected List<Images> images;
	@XmlElement(nillable = true)
	protected List<String> ingredientLines;
	protected String name;
	protected Double numberOfServings;
	@XmlElement(nillable = true)
	protected List<NutritionEstimates> nutritionEstimates;
	protected Double rating;
	protected Source source;
	protected String totalTime;
	protected Double totalTimeInSeconds;
	protected String yield;

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
	 * Gets the value of the attribution property.
	 * 
	 * @return possible object is {@link Attribution }
	 * 
	 */
	public Attribution getAttribution() {
		return attribution;
	}

	/**
	 * Sets the value of the attribution property.
	 * 
	 * @param value
	 *            allowed object is {@link Attribution }
	 * 
	 */
	public void setAttribution(Attribution value) {
		this.attribution = value;
	}

	/**
	 * Gets the value of the flavors property.
	 * 
	 * @return possible object is {@link Flavors }
	 * 
	 */
	public Flavors getFlavors() {
		return flavors;
	}

	/**
	 * Sets the value of the flavors property.
	 * 
	 * @param value
	 *            allowed object is {@link Flavors }
	 * 
	 */
	public void setFlavors(Flavors value) {
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
	 * Gets the value of the images property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the images property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getImages().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Images }
	 * 
	 * 
	 */
	public List<Images> getImages() {
		if (images == null) {
			images = new ArrayList<Images>();
		}
		return this.images;
	}

	/**
	 * Gets the value of the ingredientLines property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the ingredientLines property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getIngredientLines().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	public List<String> getIngredientLines() {
		if (ingredientLines == null) {
			ingredientLines = new ArrayList<String>();
		}
		return this.ingredientLines;
	}

	/**
	 * Gets the value of the name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Gets the value of the numberOfServings property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getNumberOfServings() {
		return numberOfServings;
	}

	/**
	 * Sets the value of the numberOfServings property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setNumberOfServings(Double value) {
		this.numberOfServings = value;
	}

	/**
	 * Gets the value of the nutritionEstimates property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the nutritionEstimates property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getNutritionEstimates().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link NutritionEstimates }
	 * 
	 * 
	 */
	public List<NutritionEstimates> getNutritionEstimates() {
		if (nutritionEstimates == null) {
			nutritionEstimates = new ArrayList<NutritionEstimates>();
		}
		return this.nutritionEstimates;
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
	 * Gets the value of the source property.
	 * 
	 * @return possible object is {@link Source }
	 * 
	 */
	public Source getSource() {
		return source;
	}

	/**
	 * Sets the value of the source property.
	 * 
	 * @param value
	 *            allowed object is {@link Source }
	 * 
	 */
	public void setSource(Source value) {
		this.source = value;
	}

	/**
	 * Gets the value of the totalTime property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTotalTime() {
		return totalTime;
	}

	/**
	 * Sets the value of the totalTime property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTotalTime(String value) {
		this.totalTime = value;
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

	/**
	 * Gets the value of the yield property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getYield() {
		return yield;
	}

	/**
	 * Sets the value of the yield property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setYield(String value) {
		this.yield = value;
	}

}
