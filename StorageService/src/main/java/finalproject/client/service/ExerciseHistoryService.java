package finalproject.client.service;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

import finalproject.client.interfaces.ExerciseHistoryWebInterface;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.4-b01 Generated
 * source version: 2.2
 * 
 */
@WebServiceClient(name = "ExerciseHistoryService", targetNamespace = "http://finalproject.sde.unitn.it/", wsdlLocation = "http://localhost:5910/lifestyle/storageservice/exercisehistory?wsdl")
public class ExerciseHistoryService extends Service {

	private final static URL EXERCISEHISTORYSERVICE_WSDL_LOCATION;
	private final static WebServiceException EXERCISEHISTORYSERVICE_EXCEPTION;
	private final static QName EXERCISEHISTORYSERVICE_QNAME = new QName(
			"http://finalproject.sde.unitn.it/", "ExerciseHistoryService");

	static {
		URL url = null;
		WebServiceException e = null;
		try {
			url = new URL(
					"http://localhost:5910/lifestyle/storageservice/exercisehistory?wsdl");
		} catch (MalformedURLException ex) {
			e = new WebServiceException(ex);
		}
		EXERCISEHISTORYSERVICE_WSDL_LOCATION = url;
		EXERCISEHISTORYSERVICE_EXCEPTION = e;
	}

	public ExerciseHistoryService() {
		super(__getWsdlLocation(), EXERCISEHISTORYSERVICE_QNAME);
	}

	public ExerciseHistoryService(WebServiceFeature... features) {
		super(__getWsdlLocation(), EXERCISEHISTORYSERVICE_QNAME, features);
	}

	public ExerciseHistoryService(URL wsdlLocation) {
		super(wsdlLocation, EXERCISEHISTORYSERVICE_QNAME);
	}

	public ExerciseHistoryService(URL wsdlLocation,
			WebServiceFeature... features) {
		super(wsdlLocation, EXERCISEHISTORYSERVICE_QNAME, features);
	}

	public ExerciseHistoryService(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	public ExerciseHistoryService(URL wsdlLocation, QName serviceName,
			WebServiceFeature... features) {
		super(wsdlLocation, serviceName, features);
	}

	/**
	 * 
	 * @return returns CRUDExerciseHistory
	 */
	@WebEndpoint(name = "CRUD")
	public ExerciseHistoryWebInterface getCRUD() {
		return super.getPort(new QName("http://finalproject.sde.unitn.it/",
				"CRUD"), ExerciseHistoryWebInterface.class);
	}

	/**
	 * 
	 * @param features
	 *            A list of {@link javax.xml.ws.WebServiceFeature} to configure
	 *            on the proxy. Supported features not in the
	 *            <code>features</code> parameter will have their default
	 *            values.
	 * @return returns CRUDExerciseHistory
	 */
	@WebEndpoint(name = "CRUD")
	public ExerciseHistoryWebInterface getCRUD(WebServiceFeature... features) {
		return super.getPort(new QName("http://finalproject.sde.unitn.it/",
				"CRUD"), ExerciseHistoryWebInterface.class, features);
	}

	private static URL __getWsdlLocation() {
		if (EXERCISEHISTORYSERVICE_EXCEPTION != null) {
			throw EXERCISEHISTORYSERVICE_EXCEPTION;
		}
		return EXERCISEHISTORYSERVICE_WSDL_LOCATION;
	}

}
