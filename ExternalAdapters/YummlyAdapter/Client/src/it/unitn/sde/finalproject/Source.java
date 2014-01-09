
package it.unitn.sde.finalproject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for source complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="source">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sourceDisplayName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourceRecipeUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourceSiteUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "source", propOrder = {
    "sourceDisplayName",
    "sourceRecipeUrl",
    "sourceSiteUrl"
})
public class Source {

    protected String sourceDisplayName;
    protected String sourceRecipeUrl;
    protected String sourceSiteUrl;

    /**
     * Gets the value of the sourceDisplayName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceDisplayName() {
        return sourceDisplayName;
    }

    /**
     * Sets the value of the sourceDisplayName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceDisplayName(String value) {
        this.sourceDisplayName = value;
    }

    /**
     * Gets the value of the sourceRecipeUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceRecipeUrl() {
        return sourceRecipeUrl;
    }

    /**
     * Sets the value of the sourceRecipeUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceRecipeUrl(String value) {
        this.sourceRecipeUrl = value;
    }

    /**
     * Gets the value of the sourceSiteUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceSiteUrl() {
        return sourceSiteUrl;
    }

    /**
     * Sets the value of the sourceSiteUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceSiteUrl(String value) {
        this.sourceSiteUrl = value;
    }

}
