
package it.unitn.sde.finalproject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for criteria complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="criteria">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="allowedIngredients" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="excludedIngredients" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requirePictures" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="terms" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criteria", propOrder = {
    "allowedIngredients",
    "excludedIngredients",
    "requirePictures",
    "terms"
})
public class Criteria {

    protected String allowedIngredients;
    protected String excludedIngredients;
    protected boolean requirePictures;
    protected String terms;

    /**
     * Gets the value of the allowedIngredients property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllowedIngredients() {
        return allowedIngredients;
    }

    /**
     * Sets the value of the allowedIngredients property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllowedIngredients(String value) {
        this.allowedIngredients = value;
    }

    /**
     * Gets the value of the excludedIngredients property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExcludedIngredients() {
        return excludedIngredients;
    }

    /**
     * Sets the value of the excludedIngredients property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExcludedIngredients(String value) {
        this.excludedIngredients = value;
    }

    /**
     * Gets the value of the requirePictures property.
     * 
     */
    public boolean isRequirePictures() {
        return requirePictures;
    }

    /**
     * Sets the value of the requirePictures property.
     * 
     */
    public void setRequirePictures(boolean value) {
        this.requirePictures = value;
    }

    /**
     * Gets the value of the terms property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerms() {
        return terms;
    }

    /**
     * Sets the value of the terms property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerms(String value) {
        this.terms = value;
    }

}
