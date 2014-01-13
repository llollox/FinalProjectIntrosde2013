
package it.unitn.sde.finalproject;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for recipeFinder complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="recipeFinder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="attribution" type="{http://finalproject.sde.unitn.it/}attribution" minOccurs="0"/>
 *         &lt;element name="criteria" type="{http://finalproject.sde.unitn.it/}criteria" minOccurs="0"/>
 *         &lt;element name="facetCounts" type="{http://finalproject.sde.unitn.it/}facetCounts" minOccurs="0"/>
 *         &lt;element name="matches" type="{http://finalproject.sde.unitn.it/}matches" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="totalMatchCount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recipeFinder", propOrder = {
    "attribution",
    "criteria",
    "facetCounts",
    "matches",
    "totalMatchCount"
})
public class RecipeFinder {

    protected Attribution attribution;
    protected Criteria criteria;
    protected FacetCounts facetCounts;
    @XmlElement(nillable = true)
    protected List<Matches> matches;
    protected Double totalMatchCount;

    /**
     * Gets the value of the attribution property.
     * 
     * @return
     *     possible object is
     *     {@link Attribution }
     *     
     */
    public Attribution getAttribution() {
        return attribution;
    }

    /**
     * Sets the value of the attribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Attribution }
     *     
     */
    public void setAttribution(Attribution value) {
        this.attribution = value;
    }

    /**
     * Gets the value of the criteria property.
     * 
     * @return
     *     possible object is
     *     {@link Criteria }
     *     
     */
    public Criteria getCriteria() {
        return criteria;
    }

    /**
     * Sets the value of the criteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link Criteria }
     *     
     */
    public void setCriteria(Criteria value) {
        this.criteria = value;
    }

    /**
     * Gets the value of the facetCounts property.
     * 
     * @return
     *     possible object is
     *     {@link FacetCounts }
     *     
     */
    public FacetCounts getFacetCounts() {
        return facetCounts;
    }

    /**
     * Sets the value of the facetCounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacetCounts }
     *     
     */
    public void setFacetCounts(FacetCounts value) {
        this.facetCounts = value;
    }

    /**
     * Gets the value of the matches property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the matches property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMatches().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Matches }
     * 
     * 
     */
    public List<Matches> getMatches() {
        if (matches == null) {
            matches = new ArrayList<Matches>();
        }
        return this.matches;
    }

    /**
     * Gets the value of the totalMatchCount property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTotalMatchCount() {
        return totalMatchCount;
    }

    /**
     * Sets the value of the totalMatchCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTotalMatchCount(Double value) {
        this.totalMatchCount = value;
    }

}
