
package it.unitn.sde.finalproject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for totalNutrients complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="totalNutrients">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ENERC_KCAL" type="{http://finalproject.sde.unitn.it/}enercKCAL" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "totalNutrients", propOrder = {
    "enerckcal"
})
public class TotalNutrients {

    @XmlElement(name = "ENERC_KCAL")
    protected EnercKCAL enerckcal;

    /**
     * Gets the value of the enerckcal property.
     * 
     * @return
     *     possible object is
     *     {@link EnercKCAL }
     *     
     */
    public EnercKCAL getENERCKCAL() {
        return enerckcal;
    }

    /**
     * Sets the value of the enerckcal property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnercKCAL }
     *     
     */
    public void setENERCKCAL(EnercKCAL value) {
        this.enerckcal = value;
    }

}
