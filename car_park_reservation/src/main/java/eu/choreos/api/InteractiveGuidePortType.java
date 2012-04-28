package eu.choreos.api;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.4.0
 * 2012-03-28T01:19:46.929-03:00
 * Generated source version: 2.4.0
 * 
 */
 
@WebService(targetNamespace = "http://api.choreos.eu/", name = "InteractiveGuidePortType")
@XmlSeeAlso({eu.choreos.ObjectFactory.class, ObjectFactory.class})
public interface InteractiveGuidePortType {

    @RequestWrapper(localName = "setCarParkInfo", targetNamespace = "http://api.choreos.eu/", className = "eu.choreos.api.SetCarParkInfo")
    @WebMethod
    @ResponseWrapper(localName = "setCarParkInfoResponse", targetNamespace = "http://api.choreos.eu/", className = "eu.choreos.api.SetCarParkInfoResponse")
    public void setCarParkInfo(
        @WebParam(name = "arg0", targetNamespace = "http://api.choreos.eu/")
        eu.choreos.CarParkEntry arg0
    );

    @WebResult(name = "return", targetNamespace = "http://api.choreos.eu/")
    @RequestWrapper(localName = "getFlightAndCarParkLocation", targetNamespace = "http://api.choreos.eu/", className = "eu.choreos.api.GetFlightAndCarParkLocation")
    @WebMethod
    @ResponseWrapper(localName = "getFlightAndCarParkLocationResponse", targetNamespace = "http://api.choreos.eu/", className = "eu.choreos.api.GetFlightAndCarParkLocationResponse")
    public java.lang.String getFlightAndCarParkLocation(
        @WebParam(name = "arg0", targetNamespace = "http://api.choreos.eu/")
        java.lang.String arg0
    );

    @WebResult(name = "return", targetNamespace = "http://api.choreos.eu/")
    @RequestWrapper(localName = "calculateLocations", targetNamespace = "http://api.choreos.eu/", className = "eu.choreos.api.CalculateLocations")
    @WebMethod
    @ResponseWrapper(localName = "calculateLocationsResponse", targetNamespace = "http://api.choreos.eu/", className = "eu.choreos.api.CalculateLocationsResponse")
    public java.lang.String calculateLocations(
        @WebParam(name = "arg0", targetNamespace = "http://api.choreos.eu/")
        java.lang.String arg0
    );
}