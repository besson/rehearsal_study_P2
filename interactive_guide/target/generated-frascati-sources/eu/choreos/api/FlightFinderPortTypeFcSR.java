/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ServiceReferenceClassGenerator
 * on: Sat Apr 28 17:47:47 BRT 2012
 */

package eu.choreos.api;


public class FlightFinderPortTypeFcSR
extends org.ow2.frascati.tinfi.oasis.ServiceReferenceImpl<eu.choreos.api.FlightFinderPortType>
implements eu.choreos.api.FlightFinderPortType {

  public FlightFinderPortTypeFcSR(Class<eu.choreos.api.FlightFinderPortType> businessInterface,eu.choreos.api.FlightFinderPortType service)  {
    super(businessInterface,service);
  }

  public eu.choreos.api.FlightFinderPortType getService()  {
    return this;
  }

  public eu.choreos.model.FlightInfo getFlightInfo(final java.lang.String arg0)  {
    eu.choreos.model.FlightInfo ret = service.getFlightInfo(arg0);
    return ret;
  }

}
