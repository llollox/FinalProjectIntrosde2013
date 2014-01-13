
package it.unitn.sde.finalproject;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.unitn.sde.finalproject package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EdamamResponse_QNAME = new QName("http://finalproject.sde.unitn.it/", "edamamResponse");
    private final static QName _CalculateIngredientsValues_QNAME = new QName("http://finalproject.sde.unitn.it/", "calculateIngredientsValues");
    private final static QName _CalculateIngredientsValuesResponse_QNAME = new QName("http://finalproject.sde.unitn.it/", "calculateIngredientsValuesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.unitn.sde.finalproject
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EdamamResponse }
     * 
     */
    public EdamamResponse createEdamamResponse() {
        return new EdamamResponse();
    }

    /**
     * Create an instance of {@link CalculateIngredientsValues }
     * 
     */
    public CalculateIngredientsValues createCalculateIngredientsValues() {
        return new CalculateIngredientsValues();
    }

    /**
     * Create an instance of {@link CalculateIngredientsValuesResponse }
     * 
     */
    public CalculateIngredientsValuesResponse createCalculateIngredientsValuesResponse() {
        return new CalculateIngredientsValuesResponse();
    }

    /**
     * Create an instance of {@link EnercKCAL }
     * 
     */
    public EnercKCAL createEnercKCAL() {
        return new EnercKCAL();
    }

    /**
     * Create an instance of {@link TotalNutrients }
     * 
     */
    public TotalNutrients createTotalNutrients() {
        return new TotalNutrients();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EdamamResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "edamamResponse")
    public JAXBElement<EdamamResponse> createEdamamResponse(EdamamResponse value) {
        return new JAXBElement<EdamamResponse>(_EdamamResponse_QNAME, EdamamResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateIngredientsValues }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "calculateIngredientsValues")
    public JAXBElement<CalculateIngredientsValues> createCalculateIngredientsValues(CalculateIngredientsValues value) {
        return new JAXBElement<CalculateIngredientsValues>(_CalculateIngredientsValues_QNAME, CalculateIngredientsValues.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateIngredientsValuesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "calculateIngredientsValuesResponse")
    public JAXBElement<CalculateIngredientsValuesResponse> createCalculateIngredientsValuesResponse(CalculateIngredientsValuesResponse value) {
        return new JAXBElement<CalculateIngredientsValuesResponse>(_CalculateIngredientsValuesResponse_QNAME, CalculateIngredientsValuesResponse.class, null, value);
    }

}
