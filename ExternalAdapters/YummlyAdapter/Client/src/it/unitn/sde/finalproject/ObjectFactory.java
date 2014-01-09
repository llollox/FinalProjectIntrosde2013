
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
    private final static QName _GetRecipe_QNAME = new QName("http://finalproject.sde.unitn.it/", "getRecipe");
    private final static QName _GetSpecificRecipeResponse_QNAME = new QName("http://finalproject.sde.unitn.it/", "getSpecificRecipeResponse");
    private final static QName _ReceiptFinder_QNAME = new QName("http://finalproject.sde.unitn.it/", "receiptFinder");
    private final static QName _GetSpecificRecipe_QNAME = new QName("http://finalproject.sde.unitn.it/", "getSpecificRecipe");
    private final static QName _Receipt_QNAME = new QName("http://finalproject.sde.unitn.it/", "receipt");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.unitn.sde.finalproject
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReceiptFinder }
     * 
     */
    public ReceiptFinder createReceiptFinder() {
        return new ReceiptFinder();
    }

    /**
     * Create an instance of {@link GetSpecificRecipeResponse }
     * 
     */
    public GetSpecificRecipeResponse createGetSpecificRecipeResponse() {
        return new GetSpecificRecipeResponse();
    }

    /**
     * Create an instance of {@link GetRecipe }
     * 
     */
    public GetRecipe createGetRecipe() {
        return new GetRecipe();
    }

    /**
     * Create an instance of {@link GetRecipeResponse }
     * 
     */
    public GetRecipeResponse createGetRecipeResponse() {
        return new GetRecipeResponse();
    }

    /**
     * Create an instance of {@link Receipt }
     * 
     */
    public Receipt createReceipt() {
        return new Receipt();
    }

    /**
     * Create an instance of {@link GetSpecificRecipe }
     * 
     */
    public GetSpecificRecipe createGetSpecificRecipe() {
        return new GetSpecificRecipe();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecipe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "getRecipe")
    public JAXBElement<GetRecipe> createGetRecipe(GetRecipe value) {
        return new JAXBElement<GetRecipe>(_GetRecipe_QNAME, GetRecipe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSpecificRecipeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "getSpecificRecipeResponse")
    public JAXBElement<GetSpecificRecipeResponse> createGetSpecificRecipeResponse(GetSpecificRecipeResponse value) {
        return new JAXBElement<GetSpecificRecipeResponse>(_GetSpecificRecipeResponse_QNAME, GetSpecificRecipeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReceiptFinder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "receiptFinder")
    public JAXBElement<ReceiptFinder> createReceiptFinder(ReceiptFinder value) {
        return new JAXBElement<ReceiptFinder>(_ReceiptFinder_QNAME, ReceiptFinder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSpecificRecipe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "getSpecificRecipe")
    public JAXBElement<GetSpecificRecipe> createGetSpecificRecipe(GetSpecificRecipe value) {
        return new JAXBElement<GetSpecificRecipe>(_GetSpecificRecipe_QNAME, GetSpecificRecipe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Receipt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finalproject.sde.unitn.it/", name = "receipt")
    public JAXBElement<Receipt> createReceipt(Receipt value) {
        return new JAXBElement<Receipt>(_Receipt_QNAME, Receipt.class, null, value);
    }

}
