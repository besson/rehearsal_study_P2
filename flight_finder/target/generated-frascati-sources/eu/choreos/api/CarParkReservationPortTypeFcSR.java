/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ServiceReferenceClassGenerator
 * on: Sat Apr 28 17:23:48 BRT 2012
 */

package eu.choreos.api;


public class CarParkReservationPortTypeFcSR
extends org.ow2.frascati.tinfi.oasis.ServiceReferenceImpl<eu.choreos.api.CarParkReservationPortType>
implements eu.choreos.api.CarParkReservationPortType {

  public CarParkReservationPortTypeFcSR(Class<eu.choreos.api.CarParkReservationPortType> businessInterface,eu.choreos.api.CarParkReservationPortType service)  {
    super(businessInterface,service);
  }

  public eu.choreos.api.CarParkReservationPortType getService()  {
    return this;
  }

  public java.lang.String setPassengerInfo(final java.lang.String arg0,final java.lang.String arg1)  {
    java.lang.String ret = service.setPassengerInfo(arg0,arg1);
    return ret;
  }

}
