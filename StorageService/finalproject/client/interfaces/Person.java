
package finalproject.client.interfaces;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for person complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="person">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="birthdate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="exerciseTimesPerWeek" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="extendedhealthprofile" type="{http://interfaces.client.finalproject/}extendedHealthProfile" minOccurs="0"/>
 *         &lt;element name="firstname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{http://interfaces.client.finalproject/}goalChoosen" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="healthprofilehistory" type="{http://interfaces.client.finalproject/}healthProfile" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="healthprofile" type="{http://interfaces.client.finalproject/}healthProfile" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lastname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sex" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "person", propOrder = {
    "birthdate",
    "exerciseTimesPerWeek",
    "extendedhealthprofile",
    "firstname",
    "goalChoosen",
    "healthprofilehistory",
    "healthprofile",
    "id",
    "lastname",
    "sex"
})
public class Person {

    protected String birthdate;
    protected Integer exerciseTimesPerWeek;
    protected ExtendedHealthProfile extendedhealthprofile;
    protected String firstname;
    @XmlElement(namespace = "http://interfaces.client.finalproject/")
    protected List<GoalChoosen> goalChoosen;
    protected List<HealthProfile> healthprofilehistory;
    protected HealthProfile healthprofile;
    protected int id;
    protected String lastname;
    protected Integer sex;

    /**
     * Gets the value of the birthdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     * Sets the value of the birthdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthdate(String value) {
        this.birthdate = value;
    }

    /**
     * Gets the value of the exerciseTimesPerWeek property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getExerciseTimesPerWeek() {
        return exerciseTimesPerWeek;
    }

    /**
     * Sets the value of the exerciseTimesPerWeek property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setExerciseTimesPerWeek(Integer value) {
        this.exerciseTimesPerWeek = value;
    }

    /**
     * Gets the value of the extendedhealthprofile property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedHealthProfile }
     *     
     */
    public ExtendedHealthProfile getExtendedhealthprofile() {
        return extendedhealthprofile;
    }

    /**
     * Sets the value of the extendedhealthprofile property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedHealthProfile }
     *     
     */
    public void setExtendedhealthprofile(ExtendedHealthProfile value) {
        this.extendedhealthprofile = value;
    }

    /**
     * Gets the value of the firstname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the value of the firstname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstname(String value) {
        this.firstname = value;
    }

    /**
     * Gets the value of the goalChoosen property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the goalChoosen property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGoalChoosen().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GoalChoosen }
     * 
     * 
     */
    public List<GoalChoosen> getGoalChoosen() {
        if (goalChoosen == null) {
            goalChoosen = new ArrayList<GoalChoosen>();
        }
        return this.goalChoosen;
    }

    /**
     * Gets the value of the healthprofilehistory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the healthprofilehistory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHealthprofilehistory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HealthProfile }
     * 
     * 
     */
    public List<HealthProfile> getHealthprofilehistory() {
        if (healthprofilehistory == null) {
            healthprofilehistory = new ArrayList<HealthProfile>();
        }
        return this.healthprofilehistory;
    }

    /**
     * Gets the value of the healthprofile property.
     * 
     * @return
     *     possible object is
     *     {@link HealthProfile }
     *     
     */
    public HealthProfile getHealthprofile() {
        return healthprofile;
    }

    /**
     * Sets the value of the healthprofile property.
     * 
     * @param value
     *     allowed object is
     *     {@link HealthProfile }
     *     
     */
    public void setHealthprofile(HealthProfile value) {
        this.healthprofile = value;
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
     * Gets the value of the lastname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the value of the lastname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastname(String value) {
        this.lastname = value;
    }

    /**
     * Gets the value of the sex property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * Sets the value of the sex property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSex(Integer value) {
        this.sex = value;
    }

}
