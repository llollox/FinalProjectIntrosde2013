
package it.unitn.sde.finalproject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for activityHistoryValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="activityHistoryValue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="activityHistoryId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valueTypeId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "activityHistoryValue", propOrder = {
    "activityHistoryId",
    "id",
    "value",
    "valueTypeId"
})
public class ActivityHistoryValue {

    protected int activityHistoryId;
    protected int id;
    protected String value;
    protected int valueTypeId;

    /**
     * Gets the value of the activityHistoryId property.
     * 
     */
    public int getActivityHistoryId() {
        return activityHistoryId;
    }

    /**
     * Sets the value of the activityHistoryId property.
     * 
     */
    public void setActivityHistoryId(int value) {
        this.activityHistoryId = value;
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
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the valueTypeId property.
     * 
     */
    public int getValueTypeId() {
        return valueTypeId;
    }

    /**
     * Sets the value of the valueTypeId property.
     * 
     */
    public void setValueTypeId(int value) {
        this.valueTypeId = value;
    }

}
