/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ServiceReferenceClassGenerator
 * on: Fri May 04 16:47:51 BRT 2012
 */

package eu.choreos.api;


public class CarParkReservationFcSR
extends org.ow2.frascati.tinfi.oasis.ServiceReferenceImpl<eu.choreos.api.CarParkReservation>
implements eu.choreos.api.CarParkReservation {

  public CarParkReservationFcSR(Class<eu.choreos.api.CarParkReservation> businessInterface,eu.choreos.api.CarParkReservation service)  {
    super(businessInterface,service);
  }

  public eu.choreos.api.CarParkReservation getService()  {
    return this;
  }

  public java.lang.String setPassengerInfo(final java.lang.String arg0,final java.lang.String arg1)  {
    java.lang.String ret = service.setPassengerInfo(arg0,arg1);
    return ret;
  }

}
