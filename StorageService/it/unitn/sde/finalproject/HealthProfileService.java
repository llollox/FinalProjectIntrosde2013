
package it.unitn.sde.finalproject;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "HealthProfileService", targetNamespace = "http://finalproject.sde.unitn.it/", wsdlLocation = "http://localhost:5910/lifestyle/storageservice/healthprofile?wsdl")
public class HealthProfileService
    extends Service
{

    private final static URL HEALTHPROFILESERVICE_WSDL_LOCATION;
    private final static WebServiceException HEALTHPROFILESERVICE_EXCEPTION;
    private final static QName HEALTHPROFILESERVICE_QNAME = new QName("http://finalproject.sde.unitn.it/", "HealthProfileService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:5910/lifestyle/storageservice/healthprofile?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HEALTHPROFILESERVICE_WSDL_LOCATION = url;
        HEALTHPROFILESERVICE_EXCEPTION = e;
    }

    public HealthProfileService() {
        super(__getWsdlLocation(), HEALTHPROFILESERVICE_QNAME);
    }

    public HealthProfileService(WebServiceFeature... features) {
        super(__getWsdlLocation(), HEALTHPROFILESERVICE_QNAME, features);
    }

    public HealthProfileService(URL wsdlLocation) {
        super(wsdlLocation, HEALTHPROFILESERVICE_QNAME);
    }

    public HealthProfileService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HEALTHPROFILESERVICE_QNAME, features);
    }

    public HealthProfileService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HealthProfileService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CRUDHealthProfile
     */
    @WebEndpoint(name = "CRUD")
    public CRUDHealthProfile getCRUD() {
        return super.getPort(new QName("http://finalproject.sde.unitn.it/", "CRUD"), CRUDHealthProfile.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CRUDHealthProfile
     */
    @WebEndpoint(name = "CRUD")
    public CRUDHealthProfile getCRUD(WebServiceFeature... features) {
        return super.getPort(new QName("http://finalproject.sde.unitn.it/", "CRUD"), CRUDHealthProfile.class, features);
    }

    private static URL __getWsdlLocation() {
        if (HEALTHPROFILESERVICE_EXCEPTION!= null) {
            throw HEALTHPROFILESERVICE_EXCEPTION;
        }
        return HEALTHPROFILESERVICE_WSDL_LOCATION;
    }

}