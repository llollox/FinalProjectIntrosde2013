
package it.unitn.sde.finalproject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for healthProfile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="healthProfile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="heartrate" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxbloodpressure" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="minbloodpressure" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "healthProfile", propOrder = {
    "date",
    "heartrate",
    "height",
    "id",
    "maxbloodpressure",
    "minbloodpressure",
    "weight"
})
@XmlSeeAlso({
    ExtendedHealthProfile.class
})
public class HealthProfile {

    protected String date;
    protected int heartrate;
    protected String height;
    protected int id;
    protected int maxbloodpressure;
    protected int minbloodpressure;
    protected String weight;

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Gets the value of the heartrate property.
     * 
     */
    public int getHeartrate() {
        return heartrate;
    }

    /**
     * Sets the value of the heartrate property.
     * 
     */
    public void setHeartrate(int value) {
        this.heartrate = value;
    }

    /**
     * Gets the value of the height property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeight(String value) {
        this.height = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the maxbloodpressure property.
     * 
     */
    public int getMaxbloodpressure() {
        return maxbloodpressure;
    }

    /**
     * Sets the value of the maxbloodpressure property.
     * 
     */
    public void setMaxbloodpressure(int value) {
        this.maxbloodpressure = value;
    }

    /**
     * Gets the value of the minbloodpressure property.
     * 
     */
    public int getMinbloodpressure() {
        return minbloodpressure;
    }

    /**
     * Sets the value of the minbloodpressure property.
     * 
     */
    public void setMinbloodpressure(int value) {
        this.minbloodpressure = value;
    }

    /**
     * Gets the value of the weight property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWeight() {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWeight(String value) {
        this.weight = value;
    }

}
