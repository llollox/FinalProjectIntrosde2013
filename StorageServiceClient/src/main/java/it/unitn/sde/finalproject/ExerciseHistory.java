
package it.unitn.sde.finalproject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for exerciseHistory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exerciseHistory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="activityChoosen" type="{http://finalproject.sde.unitn.it/}activityChoosen" minOccurs="0"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="exercise" type="{http://finalproject.sde.unitn.it/}exercise" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="person" type="{http://finalproject.sde.unitn.it/}person" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exerciseHistory", propOrder = {
    "activityChoosen",
    "date",
    "exercise",
    "id",
    "person"
})
public class ExerciseHistory {

    protected ActivityChoosen activityChoosen;
    protected String date;
    protected Exercise exercise;
    protected int id;
    protected Person person;

    /**
     * Gets the value of the activityChoosen property.
     * 
     * @return
     *     possible object is
     *     {@link ActivityChoosen }
     *     
     */
    public ActivityChoosen getActivityChoosen() {
        return activityChoosen;
    }

    /**
     * Sets the value of the activityChoosen property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivityChoosen }
     *     
     */
    public void setActivityChoosen(ActivityChoosen value) {
        this.activityChoosen = value;
    }

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
     * Gets the value of the exercise property.
     * 
     * @return
     *     possible object is
     *     {@link Exercise }
     *     
     */
    public Exercise getExercise() {
        return exercise;
    }

    /**
     * Sets the value of the exercise property.
     * 
     * @param value
     *     allowed object is
     *     {@link Exercise }
     *     
     */
    public void setExercise(Exercise value) {
        this.exercise = value;
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
     * Gets the value of the person property.
     * 
     * @return
     *     possible object is
     *     {@link Person }
     *     
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Sets the value of the person property.
     * 
     * @param value
     *     allowed object is
     *     {@link Person }
     *     
     */
    public void setPerson(Person value) {
        this.person = value;
    }

}
