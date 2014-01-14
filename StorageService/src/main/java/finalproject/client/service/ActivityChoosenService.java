package finalproject.client.service;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

import finalproject.client.interfaces.ActivityChoosenWebInterface;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.4-b01 Generated
 * source version: 2.2
 * 
 */
@WebServiceClient(name = "ActivityChoosenService", targetNamespace = "http://finalproject.sde.unitn.it/", wsdlLocation = "http://localhost:5910/lifestyle/storageservice/activitychoosen?wsdl")
public class ActivityChoosenService extends Service {

	private final static URL ACTIVITYCHOOSENSERVICE_WSDL_LOCATION;
	private final static WebServiceException ACTIVITYCHOOSENSERVICE_EXCEPTION;
	private final static QName ACTIVITYCHOOSENSERVICE_QNAME = new QName(
			"http://finalproject.sde.unitn.it/", "ActivityChoosenService");

	static {
		URL url = null;
		WebServiceException e = null;
		try {
			url = new URL(
					"http://localhost:5910/lifestyle/storageservice/activitychoosen?wsdl");
		} catch (MalformedURLException ex) {
			e = new WebServiceException(ex);
		}
		ACTIVITYCHOOSENSERVICE_WSDL_LOCATION = url;
		ACTIVITYCHOOSENSERVICE_EXCEPTION = e;
	}

	public ActivityChoosenService() {
		super(__getWsdlLocation(), ACTIVITYCHOOSENSERVICE_QNAME);
	}

	public ActivityChoosenService(WebServiceFeature... features) {
		super(__getWsdlLocation(), ACTIVITYCHOOSENSERVICE_QNAME, features);
	}

	public ActivityChoosenService(URL wsdlLocation) {
		super(wsdlLocation, ACTIVITYCHOOSENSERVICE_QNAME);
	}

	public ActivityChoosenService(URL wsdlLocation,
			WebServiceFeature... features) {
		super(wsdlLocation, ACTIVITYCHOOSENSERVICE_QNAME, features);
	}

	public ActivityChoosenService(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	public ActivityChoosenService(URL wsdlLocation, QName serviceName,
			WebServiceFeature... features) {
		super(wsdlLocation, serviceName, features);
	}

	/**
	 * 
	 * @return returns CRUDActivityChoosen
	 */
	@WebEndpoint(name = "CRUD")
	public ActivityChoosenWebInterface getCRUD() {
		return super.getPort(new QName("http://finalproject.sde.unitn.it/",
				"CRUD"), ActivityChoosenWebInterface.class);
	}

	/**
	 * 
	 * @param features
	 *            A list of {@link javax.xml.ws.WebServiceFeature} to configure
	 *            on the proxy. Supported features not in the
	 *            <code>features</code> parameter will have their default
	 *            values.
	 * @return returns CRUDActivityChoosen
	 */
	@WebEndpoint(name = "CRUD")
	public ActivityChoosenWebInterface getCRUD(WebServiceFeature... features) {
		return super.getPort(new QName("http://finalproject.sde.unitn.it/",
				"CRUD"), ActivityChoosenWebInterface.class, features);
	}

	private static URL __getWsdlLocation() {
		if (ACTIVITYCHOOSENSERVICE_EXCEPTION != null) {
			throw ACTIVITYCHOOSENSERVICE_EXCEPTION;
		}
		return ACTIVITYCHOOSENSERVICE_WSDL_LOCATION;
	}

}
