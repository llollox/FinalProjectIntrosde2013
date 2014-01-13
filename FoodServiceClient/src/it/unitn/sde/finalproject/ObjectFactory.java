
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

    private final static QName _GetRecipeResponse_QNAME = new QName("http://finalproject.sde.unitn.it/", "getRecipeResponse");
    private final static QName _GetRecipesResponse_QNAME = new QName("http://finalproject.sde.unitn.it/", "getRecipesResponse");
    private final static QName _RecipeFinder_QNAME = new QName("http://finalproject.sde.unitn.it/", "recipeFinder");
    private final static QName _EdamamResponse_QNAME = new QName("http://finalproject.sde.unitn.it/", "edamamResponse");
    private final static QName _GetRecipe_QNAME = new QName("http://finalproject.sde.unitn.it/", "getRecipe");
    private final static QName _QueryParams_QNAME = new QName("http://finalproject.sde.unitn.it/", "queryParams");
    private final static QName _Recipe_QNAME = new QName("http://finalproject.sde.unitn.it/", "recipe");
    private final static QName _CalculateIngredientsValues_QNAME = new QName("http://finalproject.sde.unitn.it/", "calculateIngredientsValues");
    private final static QName _CalculateIngredientsValuesResponse_QNAME = new QName("http://finalproject.sde.unitn.it/", "calculateIngredientsValuesResponse");
    private final static QName _GetRecipes_QNAME = new QName("http://finalproject.sde.unitn.it/", "getRecipes");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.unitn.sde.finalproject
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetRecipe }
     * 
     */
    public GetRecipe createGetRecipe() {
        return new GetRecipe();
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
     * Create an instance of {@link Recipe }
     * 
     */
    public Recipe createRecipe() {
        return new Recipe();
    }

    /**
     * Create an instance of {@link QueryParams }
     * 
     */
    public QueryParams createQueryParams() {
        return new QueryParams();
    }

    /**
     * Create an instance of {@link GetRecipesResponse }
     * 
     */
    public GetRecipesResponse createGetRecipesResponse() {
        return new GetRecipesResponse();
    }

    /**
     * Create an instance of {@link GetRecipeResponse }
     * 
     */
    public GetRecipeResponse createGetRecipeResponse() {
        return new GetRecipeResponse();
    }

    /**
     * Create an instance of {@link RecipeFinder }
     * 
     */
    public RecipeFinder createRecipeFinder() {
        return new RecipeFinder();
    }

    /**
     * Create an instance of {@link GetRecipes }
     * 
     */
    public GetRecipes createGetRecipes() {
        return new GetRecipes();
    }

    /**
     * Create an instance of {@link CalculateIngredientsValuesResponse }
     * 
     */
    public CalculateIngredientsValuesResponse createCalculateIngredientsValuesResponse() {
        return new CalculateIngredientsValuesResponse();
    }

    /**
     * Create an instance of {@link Criteria }
     * 
     */
    public Criteria createCriteria() {
        return new Criteria();
    }

    /**
     * Create an instance of {@link FacetCounts }
     * 
     */
    public FacetCounts createFacetCounts() {
        return new FacetCounts();
    }

    /**
     * Create an instance of {@link KeyValuePair }
     * 
     */
    public KeyValuePair createKeyValuePair() {
        return new KeyValuePair();
    }

    /**
     * Create an instance of {@link Unit }
     * 
     */
    public Unit createUnit() {
        return new Unit();
    }

    /**
     * Create an instance of {@link Matches }
     * 
     */
    public Matches createMatches() {
        return new Matches();
    }

    /**
     * Create an instance of {@link EnercKCAL }
     * 
     */
    public EnercKCAL createEnercKCAL() {
        return new EnercKCAL();
    }

    /**
     * Create an instance of {@link Source }
     * 
     */
    public Source createSource() {
        return new Source();
    }

    /**
     * Create an instance of {@link SmallImageUrls }
     * 
     */
    public SmallImageUrls createSmallImageUrls() {
        return new SmallImageUrls();
    }

    /**
     * Create an instance of {@link TotalNutrients }
     * 
     */
    public TotalNutrients createTotalNutrients() {
        return new TotalNutrients();
    }

    /**
     * Create an instance of {@link Images }
     * 
     */
    public Images createImages() {
        return new Images();
    }

    /**
     * Create an instance of {@link Flavors }
     * 
     */
    public Flavors createFlavors() {
        return new Flavors();
    }

    /**
     * Create an instance of {@link Attributes }
     * 
     */
    public Attributes createAttributes() {
        return new Attributes();
    }

    /**
     * Create an instance of {@link ImageUrlsBySize }
     * 
     */
    public ImageUrlsBySize createImageUrlsBySize() {
        return new ImageUrlsBySize();
    }

    /**
     * Create an instance of {@link Attribution }
     * 
     */
    public Attribution createAttribution() {
        return new Attribution();
    }

    /**
     * Create an instance of {@link NutritionEstimates }
     * 
     */
    public NutritionEstimates createNutritionEstimates() {
        return new NutritionEstimates();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecipeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "getRecipeResponse")
    public JAXBElement<GetRecipeResponse> createGetRecipeResponse(GetRecipeResponse value) {
        return new JAXBElement<GetRecipeResponse>(_GetRecipeResponse_QNAME, GetRecipeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecipesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "getRecipesResponse")
    public JAXBElement<GetRecipesResponse> createGetRecipesResponse(GetRecipesResponse value) {
        return new JAXBElement<GetRecipesResponse>(_GetRecipesResponse_QNAME, GetRecipesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecipeFinder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "recipeFinder")
    public JAXBElement<RecipeFinder> createRecipeFinder(RecipeFinder value) {
        return new JAXBElement<RecipeFinder>(_RecipeFinder_QNAME, RecipeFinder.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecipe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "getRecipe")
    public JAXBElement<GetRecipe> createGetRecipe(GetRecipe value) {
        return new JAXBElement<GetRecipe>(_GetRecipe_QNAME, GetRecipe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryParams }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "queryParams")
    public JAXBElement<QueryParams> createQueryParams(QueryParams value) {
        return new JAXBElement<QueryParams>(_QueryParams_QNAME, QueryParams.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Recipe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "recipe")
    public JAXBElement<Recipe> createRecipe(Recipe value) {
        return new JAXBElement<Recipe>(_Recipe_QNAME, Recipe.class, null, value);
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

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecipes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "getRecipes")
    public JAXBElement<GetRecipes> createGetRecipes(GetRecipes value) {
        return new JAXBElement<GetRecipes>(_GetRecipes_QNAME, GetRecipes.class, null, value);
    }

}
