
package finalproject.client.interfaces;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the finalproject.client.interfaces package. 
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

    private final static QName _Activity_QNAME = new QName("http://interfaces.client.finalproject/", "activity");
    private final static QName _GetPeopleByMeasureResponse_QNAME = new QName("http://interfaces.client.finalproject/", "getPeopleByMeasureResponse");
    private final static QName _GoalChoosen_QNAME = new QName("http://interfaces.client.finalproject/", "goalChoosen");
    private final static QName _ReadResponse_QNAME = new QName("http://interfaces.client.finalproject/", "readResponse");
    private final static QName _Read_QNAME = new QName("http://interfaces.client.finalproject/", "read");
    private final static QName _GetPeopleByMeasure_QNAME = new QName("http://interfaces.client.finalproject/", "getPeopleByMeasure");
    private final static QName _Delete_QNAME = new QName("http://interfaces.client.finalproject/", "delete");
    private final static QName _CreateResponse_QNAME = new QName("http://interfaces.client.finalproject/", "createResponse");
    private final static QName _GetPeopleByBirthdate_QNAME = new QName("http://interfaces.client.finalproject/", "getPeopleByBirthdate");
    private final static QName _GetPeople_QNAME = new QName("http://interfaces.client.finalproject/", "getPeople");
    private final static QName _UpdateResponse_QNAME = new QName("http://interfaces.client.finalproject/", "updateResponse");
    private final static QName _DeleteResponse_QNAME = new QName("http://interfaces.client.finalproject/", "deleteResponse");
    private final static QName _Goal_QNAME = new QName("http://interfaces.client.finalproject/", "goal");
    private final static QName _HealthProfile_QNAME = new QName("http://interfaces.client.finalproject/", "healthProfile");
    private final static QName _Create_QNAME = new QName("http://interfaces.client.finalproject/", "create");
    private final static QName _Exercise_QNAME = new QName("http://interfaces.client.finalproject/", "exercise");
    private final static QName _ExerciseCategory_QNAME = new QName("http://interfaces.client.finalproject/", "exerciseCategory");
    private final static QName _ExtendedHealthProfile_QNAME = new QName("http://interfaces.client.finalproject/", "extendedHealthProfile");
    private final static QName _GetPeopleResponse_QNAME = new QName("http://interfaces.client.finalproject/", "getPeopleResponse");
    private final static QName _GetPeopleByName_QNAME = new QName("http://interfaces.client.finalproject/", "getPeopleByName");
    private final static QName _GetPeopleByNameResponse_QNAME = new QName("http://interfaces.client.finalproject/", "getPeopleByNameResponse");
    private final static QName _Person_QNAME = new QName("http://interfaces.client.finalproject/", "person");
    private final static QName _GetPeopleByBirthdateResponse_QNAME = new QName("http://interfaces.client.finalproject/", "getPeopleByBirthdateResponse");
    private final static QName _Update_QNAME = new QName("http://interfaces.client.finalproject/", "update");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: finalproject.client.interfaces
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Update }
     * 
     */
    public Update createUpdate() {
        return new Update();
    }

    /**
     * Create an instance of {@link GetPeopleByBirthdateResponse }
     * 
     */
    public GetPeopleByBirthdateResponse createGetPeopleByBirthdateResponse() {
        return new GetPeopleByBirthdateResponse();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link GetPeopleByNameResponse }
     * 
     */
    public GetPeopleByNameResponse createGetPeopleByNameResponse() {
        return new GetPeopleByNameResponse();
    }

    /**
     * Create an instance of {@link GetPeopleByName }
     * 
     */
    public GetPeopleByName createGetPeopleByName() {
        return new GetPeopleByName();
    }

    /**
     * Create an instance of {@link GetPeopleResponse }
     * 
     */
    public GetPeopleResponse createGetPeopleResponse() {
        return new GetPeopleResponse();
    }

    /**
     * Create an instance of {@link ExtendedHealthProfile }
     * 
     */
    public ExtendedHealthProfile createExtendedHealthProfile() {
        return new ExtendedHealthProfile();
    }

    /**
     * Create an instance of {@link Exercise }
     * 
     */
    public Exercise createExercise() {
        return new Exercise();
    }

    /**
     * Create an instance of {@link ExerciseCategory }
     * 
     */
    public ExerciseCategory createExerciseCategory() {
        return new ExerciseCategory();
    }

    /**
     * Create an instance of {@link HealthProfile }
     * 
     */
    public HealthProfile createHealthProfile() {
        return new HealthProfile();
    }

    /**
     * Create an instance of {@link Create }
     * 
     */
    public Create createCreate() {
        return new Create();
    }

    /**
     * Create an instance of {@link Goal }
     * 
     */
    public Goal createGoal() {
        return new Goal();
    }

    /**
     * Create an instance of {@link DeleteResponse }
     * 
     */
    public DeleteResponse createDeleteResponse() {
        return new DeleteResponse();
    }

    /**
     * Create an instance of {@link UpdateResponse }
     * 
     */
    public UpdateResponse createUpdateResponse() {
        return new UpdateResponse();
    }

    /**
     * Create an instance of {@link GetPeople }
     * 
     */
    public GetPeople createGetPeople() {
        return new GetPeople();
    }

    /**
     * Create an instance of {@link GetPeopleByBirthdate }
     * 
     */
    public GetPeopleByBirthdate createGetPeopleByBirthdate() {
        return new GetPeopleByBirthdate();
    }

    /**
     * Create an instance of {@link CreateResponse }
     * 
     */
    public CreateResponse createCreateResponse() {
        return new CreateResponse();
    }

    /**
     * Create an instance of {@link Delete }
     * 
     */
    public Delete createDelete() {
        return new Delete();
    }

    /**
     * Create an instance of {@link GetPeopleByMeasure }
     * 
     */
    public GetPeopleByMeasure createGetPeopleByMeasure() {
        return new GetPeopleByMeasure();
    }

    /**
     * Create an instance of {@link Read }
     * 
     */
    public Read createRead() {
        return new Read();
    }

    /**
     * Create an instance of {@link ReadResponse }
     * 
     */
    public ReadResponse createReadResponse() {
        return new ReadResponse();
    }

    /**
     * Create an instance of {@link GoalChoosen }
     * 
     */
    public GoalChoosen createGoalChoosen() {
        return new GoalChoosen();
    }

    /**
     * Create an instance of {@link GetPeopleByMeasureResponse }
     * 
     */
    public GetPeopleByMeasureResponse createGetPeopleByMeasureResponse() {
        return new GetPeopleByMeasureResponse();
    }

    /**
     * Create an instance of {@link Activity }
     * 
     */
    public Activity createActivity() {
        return new Activity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Activity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.client.finalproject/", name = "activity")
    public JAXBElement<Activity> createActivity(Activity value) {
        return new JAXBElement<Activity>(_Activity_QNAME, Activity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPeopleByMeasureResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.client.finalproject/", name = "getPeopleByMeasureResponse")
    public JAXBElement<GetPeopleByMeasureResponse> createGetPeopleByMeasureResponse(GetPeopleByMeasureResponse value) {
        return new JAXBElement<GetPeopleByMeasureResponse>(_GetPeopleByMeasureResponse_QNAME, GetPeopleByMeasureResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GoalChoosen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.client.finalproject/", name = "goalChoosen")
    public JAXBElement<GoalChoosen> createGoalChoosen(GoalChoosen value) {
        return new JAXBElement<GoalChoosen>(_GoalChoosen_QNAME, GoalChoosen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.client.finalproject/", name = "readResponse")
    public JAXBElement<ReadResponse> createReadResponse(ReadResponse value) {
        return new JAXBElement<ReadResponse>(_ReadResponse_QNAME, ReadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Read }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.client.finalproject/", name = "read")
    public JAXBElement<Read> createRead(Read value) {
        return new JAXBElement<Read>(_Read_QNAME, Read.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPeopleByMeasure }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.client.finalproject/", name = "getPeopleByMeasure")
    public JAXBElement<GetPeopleByMeasure> createGetPeopleByMeasure(GetPeopleByMeasure value) {
        return new JAXBElement<GetPeopleByMeasure>(_GetPeopleByMeasure_QNAME, GetPeopleByMeasure.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Delete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.client.finalproject/", name = "delete")
    public JAXBElement<Delete> createDelete(Delete value) {
        return new JAXBElement<Delete>(_Delete_QNAME, Delete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.client.finalproject/", name = "createResponse")
    public JAXBElement<CreateResponse> createCreateResponse(CreateResponse value) {
        return new JAXBElement<CreateResponse>(_CreateResponse_QNAME, CreateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPeopleByBirthdate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.client.finalproject/", name = "getPeopleByBirthdate")
    public JAXBElement<GetPeopleByBirthdate> createGetPeopleByBirthdate(GetPeopleByBirthdate value) {
        return new JAXBElement<GetPeopleByBirthdate>(_GetPeopleByBirthdate_QNAME, GetPeopleByBirthdate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPeople }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.client.finalproject/", name = "getPeople")
    public JAXBElement<GetPeople> createGetPeople(GetPeople value) {
        return new JAXBElement<GetPeople>(_GetPeople_QNAME, GetPeople.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.client.finalproject/", name = "updateResponse")
    public JAXBElement<UpdateResponse> createUpdateResponse(UpdateResponse value) {
        return new JAXBElement<UpdateResponse>(_UpdateResponse_QNAME, UpdateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.client.finalproject/", name = "deleteResponse")
    public JAXBElement<DeleteResponse> createDeleteResponse(DeleteResponse value) {
        return new JAXBElement<DeleteResponse>(_DeleteResponse_QNAME, DeleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Goal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.client.finalproject/", name = "goal")
    public JAXBElement<Goal> createGoal(Goal value) {
        return new JAXBElement<Goal>(_Goal_QNAME, Goal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HealthProfile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.client.finalproject/", name = "healthProfile")
    public JAXBElement<HealthProfile> createHealthProfile(HealthProfile value) {
        return new JAXBElement<HealthProfile>(_HealthProfile_QNAME, HealthProfile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Create }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.client.finalproject/", name = "create")
    public JAXBElement<Create> createCreate(Create value) {
        return new JAXBElement<Create>(_Create_QNAME, Create.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exercise }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.client.finalproject/", name = "exercise")
    public JAXBElement<Exercise> createExercise(Exercise value) {
        return new JAXBElement<Exercise>(_Exercise_QNAME, Exercise.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExerciseCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.client.finalproject/", name = "exerciseCategory")
    public JAXBElement<ExerciseCategory> createExerciseCategory(ExerciseCategory value) {
        return new JAXBElement<ExerciseCategory>(_ExerciseCategory_QNAME, ExerciseCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExtendedHealthProfile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.client.finalproject/", name = "extendedHealthProfile")
    public JAXBElement<ExtendedHealthProfile> createExtendedHealthProfile(ExtendedHealthProfile value) {
        return new JAXBElement<ExtendedHealthProfile>(_ExtendedHealthProfile_QNAME, ExtendedHealthProfile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPeopleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.client.finalproject/", name = "getPeopleResponse")
    public JAXBElement<GetPeopleResponse> createGetPeopleResponse(GetPeopleResponse value) {
        return new JAXBElement<GetPeopleResponse>(_GetPeopleResponse_QNAME, GetPeopleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPeopleByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.client.finalproject/", name = "getPeopleByName")
    public JAXBElement<GetPeopleByName> createGetPeopleByName(GetPeopleByName value) {
        return new JAXBElement<GetPeopleByName>(_GetPeopleByName_QNAME, GetPeopleByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPeopleByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.client.finalproject/", name = "getPeopleByNameResponse")
    public JAXBElement<GetPeopleByNameResponse> createGetPeopleByNameResponse(GetPeopleByNameResponse value) {
        return new JAXBElement<GetPeopleByNameResponse>(_GetPeopleByNameResponse_QNAME, GetPeopleByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Person }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.client.finalproject/", name = "person")
    public JAXBElement<Person> createPerson(Person value) {
        return new JAXBElement<Person>(_Person_QNAME, Person.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPeopleByBirthdateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.client.finalproject/", name = "getPeopleByBirthdateResponse")
    public JAXBElement<GetPeopleByBirthdateResponse> createGetPeopleByBirthdateResponse(GetPeopleByBirthdateResponse value) {
        return new JAXBElement<GetPeopleByBirthdateResponse>(_GetPeopleByBirthdateResponse_QNAME, GetPeopleByBirthdateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Update }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.client.finalproject/", name = "update")
    public JAXBElement<Update> createUpdate(Update value) {
        return new JAXBElement<Update>(_Update_QNAME, Update.class, null, value);
    }

}
