
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

    private final static QName _InsertValueResponse_QNAME = new QName("http://finalproject.sde.unitn.it/", "insertValueResponse");
    private final static QName _DeleteValue_QNAME = new QName("http://finalproject.sde.unitn.it/", "deleteValue");
    private final static QName _ActivityHistoryValue_QNAME = new QName("http://finalproject.sde.unitn.it/", "activityHistoryValue");
    private final static QName _UpdateValue_QNAME = new QName("http://finalproject.sde.unitn.it/", "updateValue");
    private final static QName _DeleteValueResponse_QNAME = new QName("http://finalproject.sde.unitn.it/", "deleteValueResponse");
    private final static QName _InsertValue_QNAME = new QName("http://finalproject.sde.unitn.it/", "insertValue");
    private final static QName _ReadValue_QNAME = new QName("http://finalproject.sde.unitn.it/", "readValue");
    private final static QName _ReadValueResponse_QNAME = new QName("http://finalproject.sde.unitn.it/", "readValueResponse");
    private final static QName _UpdateValueResponse_QNAME = new QName("http://finalproject.sde.unitn.it/", "updateValueResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.unitn.sde.finalproject
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateValueResponse }
     * 
     */
    public UpdateValueResponse createUpdateValueResponse() {
        return new UpdateValueResponse();
    }

    /**
     * Create an instance of {@link InsertValueResponse }
     * 
     */
    public InsertValueResponse createInsertValueResponse() {
        return new InsertValueResponse();
    }

    /**
     * Create an instance of {@link InsertValue }
     * 
     */
    public InsertValue createInsertValue() {
        return new InsertValue();
    }

    /**
     * Create an instance of {@link ReadValue }
     * 
     */
    public ReadValue createReadValue() {
        return new ReadValue();
    }

    /**
     * Create an instance of {@link ReadValueResponse }
     * 
     */
    public ReadValueResponse createReadValueResponse() {
        return new ReadValueResponse();
    }

    /**
     * Create an instance of {@link UpdateValue }
     * 
     */
    public UpdateValue createUpdateValue() {
        return new UpdateValue();
    }

    /**
     * Create an instance of {@link DeleteValueResponse }
     * 
     */
    public DeleteValueResponse createDeleteValueResponse() {
        return new DeleteValueResponse();
    }

    /**
     * Create an instance of {@link DeleteValue }
     * 
     */
    public DeleteValue createDeleteValue() {
        return new DeleteValue();
    }

    /**
     * Create an instance of {@link ActivityHistoryValue }
     * 
     */
    public ActivityHistoryValue createActivityHistoryValue() {
        return new ActivityHistoryValue();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertValueResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "insertValueResponse")
    public JAXBElement<InsertValueResponse> createInsertValueResponse(InsertValueResponse value) {
        return new JAXBElement<InsertValueResponse>(_InsertValueResponse_QNAME, InsertValueResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "deleteValue")
    public JAXBElement<DeleteValue> createDeleteValue(DeleteValue value) {
        return new JAXBElement<DeleteValue>(_DeleteValue_QNAME, DeleteValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivityHistoryValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "activityHistoryValue")
    public JAXBElement<ActivityHistoryValue> createActivityHistoryValue(ActivityHistoryValue value) {
        return new JAXBElement<ActivityHistoryValue>(_ActivityHistoryValue_QNAME, ActivityHistoryValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "updateValue")
    public JAXBElement<UpdateValue> createUpdateValue(UpdateValue value) {
        return new JAXBElement<UpdateValue>(_UpdateValue_QNAME, UpdateValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteValueResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "deleteValueResponse")
    public JAXBElement<DeleteValueResponse> createDeleteValueResponse(DeleteValueResponse value) {
        return new JAXBElement<DeleteValueResponse>(_DeleteValueResponse_QNAME, DeleteValueResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "insertValue")
    public JAXBElement<InsertValue> createInsertValue(InsertValue value) {
        return new JAXBElement<InsertValue>(_InsertValue_QNAME, InsertValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "readValue")
    public JAXBElement<ReadValue> createReadValue(ReadValue value) {
        return new JAXBElement<ReadValue>(_ReadValue_QNAME, ReadValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadValueResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "readValueResponse")
    public JAXBElement<ReadValueResponse> createReadValueResponse(ReadValueResponse value) {
        return new JAXBElement<ReadValueResponse>(_ReadValueResponse_QNAME, ReadValueResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateValueResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "updateValueResponse")
    public JAXBElement<UpdateValueResponse> createUpdateValueResponse(UpdateValueResponse value) {
        return new JAXBElement<UpdateValueResponse>(_UpdateValueResponse_QNAME, UpdateValueResponse.class, null, value);
    }

}
