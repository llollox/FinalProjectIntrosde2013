
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
 *         &lt;element name="CHOCDF" type="{http://finalproject.sde.unitn.it/}chocdf" minOccurs="0"/>
 *         &lt;element name="CHOLE" type="{http://finalproject.sde.unitn.it/}chole" minOccurs="0"/>
 *         &lt;element name="ENERC_KCAL" type="{http://finalproject.sde.unitn.it/}enercKCAL" minOccurs="0"/>
 *         &lt;element name="FASAT" type="{http://finalproject.sde.unitn.it/}fasat" minOccurs="0"/>
 *         &lt;element name="FAT" type="{http://finalproject.sde.unitn.it/}fat" minOccurs="0"/>
 *         &lt;element name="FATRN" type="{http://finalproject.sde.unitn.it/}fatrn" minOccurs="0"/>
 *         &lt;element name="FIBTG" type="{http://finalproject.sde.unitn.it/}fibtg" minOccurs="0"/>
 *         &lt;element name="NA" type="{http://finalproject.sde.unitn.it/}na" minOccurs="0"/>
 *         &lt;element name="PROCNT" type="{http://finalproject.sde.unitn.it/}procnt" minOccurs="0"/>
 *         &lt;element name="SUGAR" type="{http://finalproject.sde.unitn.it/}sugar" minOccurs="0"/>
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
    "chocdf",
    "chole",
    "enerckcal",
    "fasat",
    "fat",
    "fatrn",
    "fibtg",
    "na",
    "procnt",
    "sugar"
})
public class TotalNutrients {

    @XmlElement(name = "CHOCDF")
    protected Chocdf chocdf;
    @XmlElement(name = "CHOLE")
    protected Chole chole;
    @XmlElement(name = "ENERC_KCAL")
    protected EnercKCAL enerckcal;
    @XmlElement(name = "FASAT")
    protected Fasat fasat;
    @XmlElement(name = "FAT")
    protected Fat fat;
    @XmlElement(name = "FATRN")
    protected Fatrn fatrn;
    @XmlElement(name = "FIBTG")
    protected Fibtg fibtg;
    @XmlElement(name = "NA")
    protected Na na;
    @XmlElement(name = "PROCNT")
    protected Procnt procnt;
    @XmlElement(name = "SUGAR")
    protected Sugar sugar;

    /**
     * Gets the value of the chocdf property.
     * 
     * @return
     *     possible object is
     *     {@link Chocdf }
     *     
     */
    public Chocdf getCHOCDF() {
        return chocdf;
    }

    /**
     * Sets the value of the chocdf property.
     * 
     * @param value
     *     allowed object is
     *     {@link Chocdf }
     *     
     */
    public void setCHOCDF(Chocdf value) {
        this.chocdf = value;
    }

    /**
     * Gets the value of the chole property.
     * 
     * @return
     *     possible object is
     *     {@link Chole }
     *     
     */
    public Chole getCHOLE() {
        return chole;
    }

    /**
     * Sets the value of the chole property.
     * 
     * @param value
     *     allowed object is
     *     {@link Chole }
     *     
     */
    public void setCHOLE(Chole value) {
        this.chole = value;
    }

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

    /**
     * Gets the value of the fasat property.
     * 
     * @return
     *     possible object is
     *     {@link Fasat }
     *     
     */
    public Fasat getFASAT() {
        return fasat;
    }

    /**
     * Sets the value of the fasat property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fasat }
     *     
     */
    public void setFASAT(Fasat value) {
        this.fasat = value;
    }

    /**
     * Gets the value of the fat property.
     * 
     * @return
     *     possible object is
     *     {@link Fat }
     *     
     */
    public Fat getFAT() {
        return fat;
    }

    /**
     * Sets the value of the fat property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fat }
     *     
     */
    public void setFAT(Fat value) {
        this.fat = value;
    }

    /**
     * Gets the value of the fatrn property.
     * 
     * @return
     *     possible object is
     *     {@link Fatrn }
     *     
     */
    public Fatrn getFATRN() {
        return fatrn;
    }

    /**
     * Sets the value of the fatrn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fatrn }
     *     
     */
    public void setFATRN(Fatrn value) {
        this.fatrn = value;
    }

    /**
     * Gets the value of the fibtg property.
     * 
     * @return
     *     possible object is
     *     {@link Fibtg }
     *     
     */
    public Fibtg getFIBTG() {
        return fibtg;
    }

    /**
     * Sets the value of the fibtg property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fibtg }
     *     
     */
    public void setFIBTG(Fibtg value) {
        this.fibtg = value;
    }

    /**
     * Gets the value of the na property.
     * 
     * @return
     *     possible object is
     *     {@link Na }
     *     
     */
    public Na getNA() {
        return na;
    }

    /**
     * Sets the value of the na property.
     * 
     * @param value
     *     allowed object is
     *     {@link Na }
     *     
     */
    public void setNA(Na value) {
        this.na = value;
    }

    /**
     * Gets the value of the procnt property.
     * 
     * @return
     *     possible object is
     *     {@link Procnt }
     *     
     */
    public Procnt getPROCNT() {
        return procnt;
    }

    /**
     * Sets the value of the procnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Procnt }
     *     
     */
    public void setPROCNT(Procnt value) {
        this.procnt = value;
    }

    /**
     * Gets the value of the sugar property.
     * 
     * @return
     *     possible object is
     *     {@link Sugar }
     *     
     */
    public Sugar getSUGAR() {
        return sugar;
    }

    /**
     * Sets the value of the sugar property.
     * 
     * @param value
     *     allowed object is
     *     {@link Sugar }
     *     
     */
    public void setSUGAR(Sugar value) {
        this.sugar = value;
    }

}
