
/*
 * 
 */

package eu.choreos.api;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.4.0
 * 2012-03-28T12:05:02.487-03:00
 * Generated source version: 2.4.0
 * 
 */


@WebServiceClient(name = "CarParkReservation", 
                  wsdlLocation = "http://localhost:8003/services/carParkReservation?wsdl",
                  targetNamespace = "http://api.choreos.eu/") 
public class CarParkReservation extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://api.choreos.eu/", "CarParkReservation");
    public final static QName CarParkReservationPort = new QName("http://api.choreos.eu/", "CarParkReservationPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8003/services/carParkReservation?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CarParkReservation.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8003/services/carParkReservation?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CarParkReservation(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CarParkReservation(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CarParkReservation() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     * 
     * @return
     *     returns CarParkReservationPortType
     */
    @WebEndpoint(name = "CarParkReservationPort")
    public CarParkReservationPortType getCarParkReservationPort() {
        return super.getPort(CarParkReservationPort, CarParkReservationPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CarParkReservationPortType
     */
    @WebEndpoint(name = "CarParkReservationPort")
    public CarParkReservationPortType getCarParkReservationPort(WebServiceFeature... features) {
        return super.getPort(CarParkReservationPort, CarParkReservationPortType.class, features);
    }

}