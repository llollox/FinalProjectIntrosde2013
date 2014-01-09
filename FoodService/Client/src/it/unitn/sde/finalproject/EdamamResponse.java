
package it.unitn.sde.finalproject;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for edamamResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="edamamResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="calories" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cautions" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dietLabels" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="healthLabels" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="totalNutrients" type="{http://finalproject.sde.unitn.it/}totalNutrients" minOccurs="0"/>
 *         &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="yield" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "edamamResponse", propOrder = {
    "calories",
    "cautions",
    "dietLabels",
    "healthLabels",
    "totalNutrients",
    "uri",
    "yield"
})
public class EdamamResponse {

    protected Integer calories;
    @XmlElement(nillable = true)
    protected List<Object> cautions;
    @XmlElement(nillable = true)
    protected List<String> dietLabels;
    @XmlElement(nillable = true)
    protected List<String> healthLabels;
    protected TotalNutrients totalNutrients;
    protected String uri;
    protected Double yield;

    /**
     * Gets the value of the calories property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCalories() {
        return calories;
    }

    /**
     * Sets the value of the calories property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCalories(Integer value) {
        this.calories = value;
    }

    /**
     * Gets the value of the cautions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cautions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCautions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getCautions() {
        if (cautions == null) {
            cautions = new ArrayList<Object>();
        }
        return this.cautions;
    }

    /**
     * Gets the value of the dietLabels property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dietLabels property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDietLabels().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDietLabels() {
        if (dietLabels == null) {
            dietLabels = new ArrayList<String>();
        }
        return this.dietLabels;
    }

    /**
     * Gets the value of the healthLabels property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the healthLabels property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHealthLabels().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getHealthLabels() {
        if (healthLabels == null) {
            healthLabels = new ArrayList<String>();
        }
        return this.healthLabels;
    }

    /**
     * Gets the value of the totalNutrients property.
     * 
     * @return
     *     possible object is
     *     {@link TotalNutrients }
     *     
     */
    public TotalNutrients getTotalNutrients() {
        return totalNutrients;
    }

    /**
     * Sets the value of the totalNutrients property.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalNutrients }
     *     
     */
    public void setTotalNutrients(TotalNutrients value) {
        this.totalNutrients = value;
    }

    /**
     * Gets the value of the uri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUri() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUri(String value) {
        this.uri = value;
    }

    /**
     * Gets the value of the yield property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getYield() {
        return yield;
    }

    /**
     * Sets the value of the yield property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setYield(Double value) {
        this.yield = value;
    }

}
