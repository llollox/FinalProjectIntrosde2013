
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

    private final static QName _CreateExerciseCategoryResponse_QNAME = new QName("http://finalproject.sde.unitn.it/", "createExerciseCategoryResponse");
    private final static QName _GetCategoriesResponse_QNAME = new QName("http://finalproject.sde.unitn.it/", "getCategoriesResponse");
    private final static QName _ReadExerciseCategory_QNAME = new QName("http://finalproject.sde.unitn.it/", "readExerciseCategory");
    private final static QName _UpdateExerciseCategoryResponse_QNAME = new QName("http://finalproject.sde.unitn.it/", "updateExerciseCategoryResponse");
    private final static QName _UpdateExerciseCategory_QNAME = new QName("http://finalproject.sde.unitn.it/", "updateExerciseCategory");
    private final static QName _GetCategories_QNAME = new QName("http://finalproject.sde.unitn.it/", "getCategories");
    private final static QName _DeleteExerciseCategory_QNAME = new QName("http://finalproject.sde.unitn.it/", "deleteExerciseCategory");
    private final static QName _ExerciseCategory_QNAME = new QName("http://finalproject.sde.unitn.it/", "exerciseCategory");
    private final static QName _ReadExerciseCategoryResponse_QNAME = new QName("http://finalproject.sde.unitn.it/", "readExerciseCategoryResponse");
    private final static QName _CreateExerciseCategory_QNAME = new QName("http://finalproject.sde.unitn.it/", "createExerciseCategory");
    private final static QName _DeleteExerciseCategoryResponse_QNAME = new QName("http://finalproject.sde.unitn.it/", "deleteExerciseCategoryResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.unitn.sde.finalproject
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExerciseCategory }
     * 
     */
    public ExerciseCategory createExerciseCategory() {
        return new ExerciseCategory();
    }

    /**
     * Create an instance of {@link GetCategories }
     * 
     */
    public GetCategories createGetCategories() {
        return new GetCategories();
    }

    /**
     * Create an instance of {@link DeleteExerciseCategory }
     * 
     */
    public DeleteExerciseCategory createDeleteExerciseCategory() {
        return new DeleteExerciseCategory();
    }

    /**
     * Create an instance of {@link ReadExerciseCategory }
     * 
     */
    public ReadExerciseCategory createReadExerciseCategory() {
        return new ReadExerciseCategory();
    }

    /**
     * Create an instance of {@link GetCategoriesResponse }
     * 
     */
    public GetCategoriesResponse createGetCategoriesResponse() {
        return new GetCategoriesResponse();
    }

    /**
     * Create an instance of {@link UpdateExerciseCategoryResponse }
     * 
     */
    public UpdateExerciseCategoryResponse createUpdateExerciseCategoryResponse() {
        return new UpdateExerciseCategoryResponse();
    }

    /**
     * Create an instance of {@link UpdateExerciseCategory }
     * 
     */
    public UpdateExerciseCategory createUpdateExerciseCategory() {
        return new UpdateExerciseCategory();
    }

    /**
     * Create an instance of {@link ReadExerciseCategoryResponse }
     * 
     */
    public ReadExerciseCategoryResponse createReadExerciseCategoryResponse() {
        return new ReadExerciseCategoryResponse();
    }

    /**
     * Create an instance of {@link CreateExerciseCategoryResponse }
     * 
     */
    public CreateExerciseCategoryResponse createCreateExerciseCategoryResponse() {
        return new CreateExerciseCategoryResponse();
    }

    /**
     * Create an instance of {@link CreateExerciseCategory }
     * 
     */
    public CreateExerciseCategory createCreateExerciseCategory() {
        return new CreateExerciseCategory();
    }

    /**
     * Create an instance of {@link DeleteExerciseCategoryResponse }
     * 
     */
    public DeleteExerciseCategoryResponse createDeleteExerciseCategoryResponse() {
        return new DeleteExerciseCategoryResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateExerciseCategoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "createExerciseCategoryResponse")
    public JAXBElement<CreateExerciseCategoryResponse> createCreateExerciseCategoryResponse(CreateExerciseCategoryResponse value) {
        return new JAXBElement<CreateExerciseCategoryResponse>(_CreateExerciseCategoryResponse_QNAME, CreateExerciseCategoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCategoriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "getCategoriesResponse")
    public JAXBElement<GetCategoriesResponse> createGetCategoriesResponse(GetCategoriesResponse value) {
        return new JAXBElement<GetCategoriesResponse>(_GetCategoriesResponse_QNAME, GetCategoriesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadExerciseCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "readExerciseCategory")
    public JAXBElement<ReadExerciseCategory> createReadExerciseCategory(ReadExerciseCategory value) {
        return new JAXBElement<ReadExerciseCategory>(_ReadExerciseCategory_QNAME, ReadExerciseCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateExerciseCategoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "updateExerciseCategoryResponse")
    public JAXBElement<UpdateExerciseCategoryResponse> createUpdateExerciseCategoryResponse(UpdateExerciseCategoryResponse value) {
        return new JAXBElement<UpdateExerciseCategoryResponse>(_UpdateExerciseCategoryResponse_QNAME, UpdateExerciseCategoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateExerciseCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "updateExerciseCategory")
    public JAXBElement<UpdateExerciseCategory> createUpdateExerciseCategory(UpdateExerciseCategory value) {
        return new JAXBElement<UpdateExerciseCategory>(_UpdateExerciseCategory_QNAME, UpdateExerciseCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCategories }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "getCategories")
    public JAXBElement<GetCategories> createGetCategories(GetCategories value) {
        return new JAXBElement<GetCategories>(_GetCategories_QNAME, GetCategories.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteExerciseCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "deleteExerciseCategory")
    public JAXBElement<DeleteExerciseCategory> createDeleteExerciseCategory(DeleteExerciseCategory value) {
        return new JAXBElement<DeleteExerciseCategory>(_DeleteExerciseCategory_QNAME, DeleteExerciseCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExerciseCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "exerciseCategory")
    public JAXBElement<ExerciseCategory> createExerciseCategory(ExerciseCategory value) {
        return new JAXBElement<ExerciseCategory>(_ExerciseCategory_QNAME, ExerciseCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadExerciseCategoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "readExerciseCategoryResponse")
    public JAXBElement<ReadExerciseCategoryResponse> createReadExerciseCategoryResponse(ReadExerciseCategoryResponse value) {
        return new JAXBElement<ReadExerciseCategoryResponse>(_ReadExerciseCategoryResponse_QNAME, ReadExerciseCategoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateExerciseCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "createExerciseCategory")
    public JAXBElement<CreateExerciseCategory> createCreateExerciseCategory(CreateExerciseCategory value) {
        return new JAXBElement<CreateExerciseCategory>(_CreateExerciseCategory_QNAME, CreateExerciseCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteExerciseCategoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "deleteExerciseCategoryResponse")
    public JAXBElement<DeleteExerciseCategoryResponse> createDeleteExerciseCategoryResponse(DeleteExerciseCategoryResponse value) {
        return new JAXBElement<DeleteExerciseCategoryResponse>(_DeleteExerciseCategoryResponse_QNAME, DeleteExerciseCategoryResponse.class, null, value);
    }

}
