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
 * 2012-03-28T12:03:17.518-03:00
 * Generated source version: 2.4.0
 * 
 */
 
@WebService(targetNamespace = "http://api.choreos.eu/", name = "FlightFinderPortType")
@XmlSeeAlso({ObjectFactory.class, eu.choreos.model.ObjectFactory.class})
public interface FlightFinderPortType {

    @WebResult(name = "return", targetNamespace = "http://api.choreos.eu/")
    @RequestWrapper(localName = "getFlightInfo", targetNamespace = "http://api.choreos.eu/", className = "eu.choreos.api.GetFlightInfo")
    @WebMethod
    @ResponseWrapper(localName = "getFlightInfoResponse", targetNamespace = "http://api.choreos.eu/", className = "eu.choreos.api.GetFlightInfoResponse")
    public eu.choreos.model.FlightInfo getFlightInfo(
        @WebParam(name = "arg0", targetNamespace = "http://api.choreos.eu/")
        java.lang.String arg0
    );
}
