
package it.unitn.sde.finalproject;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for goalChoosen complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="goalChoosen">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://finalproject.sde.unitn.it/}exerciseHistory" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://finalproject.sde.unitn.it/}goal" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "goalChoosen", propOrder = {
    "exerciseHistory",
    "goal",
    "id"
})
public class GoalChoosen {

    @XmlElement(namespace = "http://finalproject.sde.unitn.it/")
    protected List<ExerciseHistory> exerciseHistory;
    @XmlElement(namespace = "http://finalproject.sde.unitn.it/")
    protected Goal goal;
    protected int id;

    /**
     * Gets the value of the exerciseHistory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exerciseHistory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExerciseHistory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExerciseHistory }
     * 
     * 
     */
    public List<ExerciseHistory> getExerciseHistory() {
        if (exerciseHistory == null) {
            exerciseHistory = new ArrayList<ExerciseHistory>();
        }
        return this.exerciseHistory;
    }

    /**
     * Gets the value of the goal property.
     * 
     * @return
     *     possible object is
     *     {@link Goal }
     *     
     */
    public Goal getGoal() {
        return goal;
    }

    /**
     * Sets the value of the goal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Goal }
     *     
     */
    public void setGoal(Goal value) {
        this.goal = value;
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

}
