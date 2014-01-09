
package it.unitn.sde.finalproject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for imageUrlsBySize complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="imageUrlsBySize">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_90" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "imageUrlsBySize", propOrder = {
    "_90"
})
public class ImageUrlsBySize {

    protected String _90;

    /**
     * Gets the value of the 90 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get90() {
        return _90;
    }

    /**
     * Sets the value of the 90 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set90(String value) {
        this._90 = value;
    }

}
