
package it.unitn.sde.finalproject;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="daily" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="monthly" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="valuetypes" type="{http://finalproject.sde.unitn.it/}activityValueType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="weekly" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "activity", propOrder = {
    "daily",
    "description",
    "id",
    "monthly",
    "valuetypes",
    "weekly"
})
public class Activity {

    protected boolean daily;
    protected String description;
    protected int id;
    protected boolean monthly;
    @XmlElement(nillable = true)
    protected List<ActivityValueType> valuetypes;
    protected boolean weekly;

    /**
     * Gets the value of the daily property.
     * 
     */
    public boolean isDaily() {
        return daily;
    }

    /**
     * Sets the value of the daily property.
     * 
     */
    public void setDaily(boolean value) {
        this.daily = value;
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
     * Gets the value of the monthly property.
     * 
     */
    public boolean isMonthly() {
        return monthly;
    }

    /**
     * Sets the value of the monthly property.
     * 
     */
    public void setMonthly(boolean value) {
        this.monthly = value;
    }

    /**
     * Gets the value of the valuetypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valuetypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValuetypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActivityValueType }
     * 
     * 
     */
    public List<ActivityValueType> getValuetypes() {
        if (valuetypes == null) {
            valuetypes = new ArrayList<ActivityValueType>();
        }
        return this.valuetypes;
    }

    /**
     * Gets the value of the weekly property.
     * 
     */
    public boolean isWeekly() {
        return weekly;
    }

    /**
     * Sets the value of the weekly property.
     * 
     */
    public void setWeekly(boolean value) {
        this.weekly = value;
    }

}
