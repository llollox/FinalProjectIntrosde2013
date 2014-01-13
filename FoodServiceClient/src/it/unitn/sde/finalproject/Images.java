
package it.unitn.sde.finalproject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for images complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="images">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hostedLargeUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hostedSmallUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="imageUrlsBySize" type="{http://finalproject.sde.unitn.it/}imageUrlsBySize" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "images", propOrder = {
    "hostedLargeUrl",
    "hostedSmallUrl",
    "imageUrlsBySize"
})
public class Images {

    protected String hostedLargeUrl;
    protected String hostedSmallUrl;
    protected ImageUrlsBySize imageUrlsBySize;

    /**
     * Gets the value of the hostedLargeUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHostedLargeUrl() {
        return hostedLargeUrl;
    }

    /**
     * Sets the value of the hostedLargeUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHostedLargeUrl(String value) {
        this.hostedLargeUrl = value;
    }

    /**
     * Gets the value of the hostedSmallUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHostedSmallUrl() {
        return hostedSmallUrl;
    }

    /**
     * Sets the value of the hostedSmallUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHostedSmallUrl(String value) {
        this.hostedSmallUrl = value;
    }

    /**
     * Gets the value of the imageUrlsBySize property.
     * 
     * @return
     *     possible object is
     *     {@link ImageUrlsBySize }
     *     
     */
    public ImageUrlsBySize getImageUrlsBySize() {
        return imageUrlsBySize;
    }

    /**
     * Sets the value of the imageUrlsBySize property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageUrlsBySize }
     *     
     */
    public void setImageUrlsBySize(ImageUrlsBySize value) {
        this.imageUrlsBySize = value;
    }

}
