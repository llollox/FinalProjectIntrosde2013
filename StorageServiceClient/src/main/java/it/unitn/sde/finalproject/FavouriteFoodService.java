
package it.unitn.sde.finalproject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "FavouriteFoodService", targetNamespace = "http://finalproject.sde.unitn.it/", wsdlLocation = "http://localhost:5910/lifestyle/storageservice/favouritefood?wsdl")
public class FavouriteFoodService
    extends Service
{

    private final static URL FAVOURITEFOODSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(it.unitn.sde.finalproject.FavouriteFoodService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = it.unitn.sde.finalproject.FavouriteFoodService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:5910/lifestyle/storageservice/favouritefood?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:5910/lifestyle/storageservice/favouritefood?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        FAVOURITEFOODSERVICE_WSDL_LOCATION = url;
    }

    public FavouriteFoodService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FavouriteFoodService() {
        super(FAVOURITEFOODSERVICE_WSDL_LOCATION, new QName("http://finalproject.sde.unitn.it/", "FavouriteFoodService"));
    }

    /**
     * 
     * @return
     *     returns CRUDFavouriteFood
     */
    @WebEndpoint(name = "CRUD")
    public CRUDFavouriteFood getCRUD() {
        return super.getPort(new QName("http://finalproject.sde.unitn.it/", "CRUD"), CRUDFavouriteFood.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CRUDFavouriteFood
     */
    @WebEndpoint(name = "CRUD")
    public CRUDFavouriteFood getCRUD(WebServiceFeature... features) {
        return super.getPort(new QName("http://finalproject.sde.unitn.it/", "CRUD"), CRUDFavouriteFood.class, features);
    }

}
