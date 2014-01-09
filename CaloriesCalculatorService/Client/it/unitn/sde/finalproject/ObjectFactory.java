
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

    private final static QName _GetIdealDailyCaloriesNeeded_QNAME = new QName("http://finalproject.sde.unitn.it/", "getIdealDailyCaloriesNeeded");
    private final static QName _GetIdealWeight_QNAME = new QName("http://finalproject.sde.unitn.it/", "getIdealWeight");
    private final static QName _GetIdealWeightResponse_QNAME = new QName("http://finalproject.sde.unitn.it/", "getIdealWeightResponse");
    private final static QName _GetBMR_QNAME = new QName("http://finalproject.sde.unitn.it/", "getBMR");
    private final static QName _GetIdealBMI_QNAME = new QName("http://finalproject.sde.unitn.it/", "getIdealBMI");
    private final static QName _GetIdealBMIResponse_QNAME = new QName("http://finalproject.sde.unitn.it/", "getIdealBMIResponse");
    private final static QName _GetDailyCaloriesNeededToManageWeight_QNAME = new QName("http://finalproject.sde.unitn.it/", "getDailyCaloriesNeededToManageWeight");
    private final static QName _GetBMRResponse_QNAME = new QName("http://finalproject.sde.unitn.it/", "getBMRResponse");
    private final static QName _GetIdealDailyCaloriesNeededResponse_QNAME = new QName("http://finalproject.sde.unitn.it/", "getIdealDailyCaloriesNeededResponse");
    private final static QName _GetDailyCaloriesNeededToManageWeightResponse_QNAME = new QName("http://finalproject.sde.unitn.it/", "getDailyCaloriesNeededToManageWeightResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.unitn.sde.finalproject
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetIdealBMI }
     * 
     */
    public GetIdealBMI createGetIdealBMI() {
        return new GetIdealBMI();
    }

    /**
     * Create an instance of {@link GetBMR }
     * 
     */
    public GetBMR createGetBMR() {
        return new GetBMR();
    }

    /**
     * Create an instance of {@link GetIdealWeightResponse }
     * 
     */
    public GetIdealWeightResponse createGetIdealWeightResponse() {
        return new GetIdealWeightResponse();
    }

    /**
     * Create an instance of {@link GetDailyCaloriesNeededToManageWeight }
     * 
     */
    public GetDailyCaloriesNeededToManageWeight createGetDailyCaloriesNeededToManageWeight() {
        return new GetDailyCaloriesNeededToManageWeight();
    }

    /**
     * Create an instance of {@link GetIdealBMIResponse }
     * 
     */
    public GetIdealBMIResponse createGetIdealBMIResponse() {
        return new GetIdealBMIResponse();
    }

    /**
     * Create an instance of {@link GetIdealDailyCaloriesNeeded }
     * 
     */
    public GetIdealDailyCaloriesNeeded createGetIdealDailyCaloriesNeeded() {
        return new GetIdealDailyCaloriesNeeded();
    }

    /**
     * Create an instance of {@link GetIdealWeight }
     * 
     */
    public GetIdealWeight createGetIdealWeight() {
        return new GetIdealWeight();
    }

    /**
     * Create an instance of {@link GetIdealDailyCaloriesNeededResponse }
     * 
     */
    public GetIdealDailyCaloriesNeededResponse createGetIdealDailyCaloriesNeededResponse() {
        return new GetIdealDailyCaloriesNeededResponse();
    }

    /**
     * Create an instance of {@link GetBMRResponse }
     * 
     */
    public GetBMRResponse createGetBMRResponse() {
        return new GetBMRResponse();
    }

    /**
     * Create an instance of {@link GetDailyCaloriesNeededToManageWeightResponse }
     * 
     */
    public GetDailyCaloriesNeededToManageWeightResponse createGetDailyCaloriesNeededToManageWeightResponse() {
        return new GetDailyCaloriesNeededToManageWeightResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIdealDailyCaloriesNeeded }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "getIdealDailyCaloriesNeeded")
    public JAXBElement<GetIdealDailyCaloriesNeeded> createGetIdealDailyCaloriesNeeded(GetIdealDailyCaloriesNeeded value) {
        return new JAXBElement<GetIdealDailyCaloriesNeeded>(_GetIdealDailyCaloriesNeeded_QNAME, GetIdealDailyCaloriesNeeded.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIdealWeight }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "getIdealWeight")
    public JAXBElement<GetIdealWeight> createGetIdealWeight(GetIdealWeight value) {
        return new JAXBElement<GetIdealWeight>(_GetIdealWeight_QNAME, GetIdealWeight.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIdealWeightResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "getIdealWeightResponse")
    public JAXBElement<GetIdealWeightResponse> createGetIdealWeightResponse(GetIdealWeightResponse value) {
        return new JAXBElement<GetIdealWeightResponse>(_GetIdealWeightResponse_QNAME, GetIdealWeightResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBMR }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "getBMR")
    public JAXBElement<GetBMR> createGetBMR(GetBMR value) {
        return new JAXBElement<GetBMR>(_GetBMR_QNAME, GetBMR.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIdealBMI }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "getIdealBMI")
    public JAXBElement<GetIdealBMI> createGetIdealBMI(GetIdealBMI value) {
        return new JAXBElement<GetIdealBMI>(_GetIdealBMI_QNAME, GetIdealBMI.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIdealBMIResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "getIdealBMIResponse")
    public JAXBElement<GetIdealBMIResponse> createGetIdealBMIResponse(GetIdealBMIResponse value) {
        return new JAXBElement<GetIdealBMIResponse>(_GetIdealBMIResponse_QNAME, GetIdealBMIResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDailyCaloriesNeededToManageWeight }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "getDailyCaloriesNeededToManageWeight")
    public JAXBElement<GetDailyCaloriesNeededToManageWeight> createGetDailyCaloriesNeededToManageWeight(GetDailyCaloriesNeededToManageWeight value) {
        return new JAXBElement<GetDailyCaloriesNeededToManageWeight>(_GetDailyCaloriesNeededToManageWeight_QNAME, GetDailyCaloriesNeededToManageWeight.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBMRResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "getBMRResponse")
    public JAXBElement<GetBMRResponse> createGetBMRResponse(GetBMRResponse value) {
        return new JAXBElement<GetBMRResponse>(_GetBMRResponse_QNAME, GetBMRResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIdealDailyCaloriesNeededResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "getIdealDailyCaloriesNeededResponse")
    public JAXBElement<GetIdealDailyCaloriesNeededResponse> createGetIdealDailyCaloriesNeededResponse(GetIdealDailyCaloriesNeededResponse value) {
        return new JAXBElement<GetIdealDailyCaloriesNeededResponse>(_GetIdealDailyCaloriesNeededResponse_QNAME, GetIdealDailyCaloriesNeededResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDailyCaloriesNeededToManageWeightResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "getDailyCaloriesNeededToManageWeightResponse")
    public JAXBElement<GetDailyCaloriesNeededToManageWeightResponse> createGetDailyCaloriesNeededToManageWeightResponse(GetDailyCaloriesNeededToManageWeightResponse value) {
        return new JAXBElement<GetDailyCaloriesNeededToManageWeightResponse>(_GetDailyCaloriesNeededToManageWeightResponse_QNAME, GetDailyCaloriesNeededToManageWeightResponse.class, null, value);
    }

}
