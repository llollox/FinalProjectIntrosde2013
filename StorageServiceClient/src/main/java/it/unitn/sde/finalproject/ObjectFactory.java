
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

    private final static QName _UpdateExercise_QNAME = new QName("http://finalproject.sde.unitn.it/", "updateExercise");
    private final static QName _CreateExerciseResponse_QNAME = new QName("http://finalproject.sde.unitn.it/", "createExerciseResponse");
    private final static QName _ReadExercise_QNAME = new QName("http://finalproject.sde.unitn.it/", "readExercise");
    private final static QName _DeleteExerciseResponse_QNAME = new QName("http://finalproject.sde.unitn.it/", "deleteExerciseResponse");
    private final static QName _DeleteExercise_QNAME = new QName("http://finalproject.sde.unitn.it/", "deleteExercise");
    private final static QName _UpdateExerciseResponse_QNAME = new QName("http://finalproject.sde.unitn.it/", "updateExerciseResponse");
    private final static QName _ReadExerciseResponse_QNAME = new QName("http://finalproject.sde.unitn.it/", "readExerciseResponse");
    private final static QName _Exercise_QNAME = new QName("http://finalproject.sde.unitn.it/", "exercise");
    private final static QName _CreateExercise_QNAME = new QName("http://finalproject.sde.unitn.it/", "createExercise");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.unitn.sde.finalproject
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateExercise }
     * 
     */
    public UpdateExercise createUpdateExercise() {
        return new UpdateExercise();
    }

    /**
     * Create an instance of {@link ReadExercise }
     * 
     */
    public ReadExercise createReadExercise() {
        return new ReadExercise();
    }

    /**
     * Create an instance of {@link CreateExerciseResponse }
     * 
     */
    public CreateExerciseResponse createCreateExerciseResponse() {
        return new CreateExerciseResponse();
    }

    /**
     * Create an instance of {@link Exercise }
     * 
     */
    public Exercise createExercise() {
        return new Exercise();
    }

    /**
     * Create an instance of {@link CreateExercise }
     * 
     */
    public CreateExercise createCreateExercise() {
        return new CreateExercise();
    }

    /**
     * Create an instance of {@link DeleteExerciseResponse }
     * 
     */
    public DeleteExerciseResponse createDeleteExerciseResponse() {
        return new DeleteExerciseResponse();
    }

    /**
     * Create an instance of {@link ReadExerciseResponse }
     * 
     */
    public ReadExerciseResponse createReadExerciseResponse() {
        return new ReadExerciseResponse();
    }

    /**
     * Create an instance of {@link UpdateExerciseResponse }
     * 
     */
    public UpdateExerciseResponse createUpdateExerciseResponse() {
        return new UpdateExerciseResponse();
    }

    /**
     * Create an instance of {@link DeleteExercise }
     * 
     */
    public DeleteExercise createDeleteExercise() {
        return new DeleteExercise();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateExercise }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "updateExercise")
    public JAXBElement<UpdateExercise> createUpdateExercise(UpdateExercise value) {
        return new JAXBElement<UpdateExercise>(_UpdateExercise_QNAME, UpdateExercise.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateExerciseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "createExerciseResponse")
    public JAXBElement<CreateExerciseResponse> createCreateExerciseResponse(CreateExerciseResponse value) {
        return new JAXBElement<CreateExerciseResponse>(_CreateExerciseResponse_QNAME, CreateExerciseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadExercise }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "readExercise")
    public JAXBElement<ReadExercise> createReadExercise(ReadExercise value) {
        return new JAXBElement<ReadExercise>(_ReadExercise_QNAME, ReadExercise.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteExerciseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "deleteExerciseResponse")
    public JAXBElement<DeleteExerciseResponse> createDeleteExerciseResponse(DeleteExerciseResponse value) {
        return new JAXBElement<DeleteExerciseResponse>(_DeleteExerciseResponse_QNAME, DeleteExerciseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteExercise }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "deleteExercise")
    public JAXBElement<DeleteExercise> createDeleteExercise(DeleteExercise value) {
        return new JAXBElement<DeleteExercise>(_DeleteExercise_QNAME, DeleteExercise.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateExerciseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "updateExerciseResponse")
    public JAXBElement<UpdateExerciseResponse> createUpdateExerciseResponse(UpdateExerciseResponse value) {
        return new JAXBElement<UpdateExerciseResponse>(_UpdateExerciseResponse_QNAME, UpdateExerciseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadExerciseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "readExerciseResponse")
    public JAXBElement<ReadExerciseResponse> createReadExerciseResponse(ReadExerciseResponse value) {
        return new JAXBElement<ReadExerciseResponse>(_ReadExerciseResponse_QNAME, ReadExerciseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exercise }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "exercise")
    public JAXBElement<Exercise> createExercise(Exercise value) {
        return new JAXBElement<Exercise>(_Exercise_QNAME, Exercise.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateExercise }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "createExercise")
    public JAXBElement<CreateExercise> createCreateExercise(CreateExercise value) {
        return new JAXBElement<CreateExercise>(_CreateExercise_QNAME, CreateExercise.class, null, value);
    }

}
