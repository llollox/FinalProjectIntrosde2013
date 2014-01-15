
package finalproject.client.interfaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for extendedHealthProfile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="extendedHealthProfile">
 *   &lt;complexContent>
 *     &lt;extension base="{http://interfaces.client.finalproject/}healthProfile">
 *       &lt;sequence>
 *         &lt;element name="age" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="bloodPressureLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bmi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bmiLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bmr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idealBmi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idealKcal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idealWeight" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="menagedWeightKcal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="targetHearthRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "extendedHealthProfile", propOrder = {
    "age",
    "bloodPressureLabel",
    "bmi",
    "bmiLabel",
    "bmr",
    "idealBmi",
    "idealKcal",
    "idealWeight",
    "menagedWeightKcal",
    "targetHearthRate"
})
public class ExtendedHealthProfile
    extends HealthProfile
{

    protected Integer age;
    protected String bloodPressureLabel;
    protected String bmi;
    protected String bmiLabel;
    protected String bmr;
    protected String idealBmi;
    protected String idealKcal;
    protected String idealWeight;
    protected String menagedWeightKcal;
    protected String targetHearthRate;

    /**
     * Gets the value of the age property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAge(Integer value) {
        this.age = value;
    }

    /**
     * Gets the value of the bloodPressureLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBloodPressureLabel() {
        return bloodPressureLabel;
    }

    /**
     * Sets the value of the bloodPressureLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBloodPressureLabel(String value) {
        this.bloodPressureLabel = value;
    }

    /**
     * Gets the value of the bmi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBmi() {
        return bmi;
    }

    /**
     * Sets the value of the bmi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBmi(String value) {
        this.bmi = value;
    }

    /**
     * Gets the value of the bmiLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBmiLabel() {
        return bmiLabel;
    }

    /**
     * Sets the value of the bmiLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBmiLabel(String value) {
        this.bmiLabel = value;
    }

    /**
     * Gets the value of the bmr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBmr() {
        return bmr;
    }

    /**
     * Sets the value of the bmr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBmr(String value) {
        this.bmr = value;
    }

    /**
     * Gets the value of the idealBmi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdealBmi() {
        return idealBmi;
    }

    /**
     * Sets the value of the idealBmi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdealBmi(String value) {
        this.idealBmi = value;
    }

    /**
     * Gets the value of the idealKcal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdealKcal() {
        return idealKcal;
    }

    /**
     * Sets the value of the idealKcal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdealKcal(String value) {
        this.idealKcal = value;
    }

    /**
     * Gets the value of the idealWeight property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdealWeight() {
        return idealWeight;
    }

    /**
     * Sets the value of the idealWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdealWeight(String value) {
        this.idealWeight = value;
    }

    /**
     * Gets the value of the menagedWeightKcal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMenagedWeightKcal() {
        return menagedWeightKcal;
    }

    /**
     * Sets the value of the menagedWeightKcal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMenagedWeightKcal(String value) {
        this.menagedWeightKcal = value;
    }

    /**
     * Gets the value of the targetHearthRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetHearthRate() {
        return targetHearthRate;
    }

    /**
     * Sets the value of the targetHearthRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetHearthRate(String value) {
        this.targetHearthRate = value;
    }

}
