/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ServiceReferenceClassGenerator
 * on: Sat Apr 28 17:26:00 BRT 2012
 */

package eu.choreos.api;


public class InteractiveGuidePortTypeFcSR
extends org.ow2.frascati.tinfi.oasis.ServiceReferenceImpl<eu.choreos.api.InteractiveGuidePortType>
implements eu.choreos.api.InteractiveGuidePortType {

  public InteractiveGuidePortTypeFcSR(Class<eu.choreos.api.InteractiveGuidePortType> businessInterface,eu.choreos.api.InteractiveGuidePortType service)  {
    super(businessInterface,service);
  }

  public eu.choreos.api.InteractiveGuidePortType getService()  {
    return this;
  }

  public java.lang.String calculateLocations(final java.lang.String arg0)  {
    java.lang.String ret = service.calculateLocations(arg0);
    return ret;
  }

  public java.lang.String getFlightAndCarParkLocation(final java.lang.String arg0)  {
    java.lang.String ret = service.getFlightAndCarParkLocation(arg0);
    return ret;
  }

  public void setCarParkInfo(final eu.choreos.CarParkEntry arg0)  {
    service.setCarParkInfo(arg0);
  }

}
