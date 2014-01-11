
package it.unitn.sde.finalproject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for activity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="activity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="activitygroup" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="aerobic" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="difficultyvalue" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "activity", propOrder = {
    "activitygroup",
    "aerobic",
    "description",
    "difficultyvalue",
    "id",
    "type",
    "value"
})
public class Activity {

    protected int activitygroup;
    protected int aerobic;
    protected String description;
    protected int difficultyvalue;
    protected int id;
    protected int type;
    protected float value;

    /**
     * Gets the value of the activitygroup property.
     * 
     */
    public int getActivitygroup() {
        return activitygroup;
    }

    /**
     * Sets the value of the activitygroup property.
     * 
     */
    public void setActivitygroup(int value) {
        this.activitygroup = value;
    }

    /**
     * Gets the value of the aerobic property.
     * 
     */
    public int getAerobic() {
        return aerobic;
    }

    /**
     * Sets the value of the aerobic property.
     * 
     */
    public void setAerobic(int value) {
        this.aerobic = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the difficultyvalue property.
     * 
     */
    public int getDifficultyvalue() {
        return difficultyvalue;
    }

    /**
     * Sets the value of the difficultyvalue property.
     * 
     */
    public void setDifficultyvalue(int value) {
        this.difficultyvalue = value;
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
     * Gets the value of the type property.
     * 
     */
    public int getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     */
    public void setType(int value) {
        this.type = value;
    }

    /**
     * Gets the value of the value property.
     * 
     */
    public float getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(float value) {
        this.value = value;
    }

}
