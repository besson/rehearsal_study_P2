/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ServerInterfaceClassGenerator
 * on: Fri May 04 16:47:50 BRT 2012
 */

package eu.choreos.api;


public class CarParkReservationFcInItf
extends org.ow2.frascati.tinfi.TinfiComponentInterface<eu.choreos.api.CarParkReservation>
implements eu.choreos.api.CarParkReservation {

  public CarParkReservationFcInItf()  {
  }

  public CarParkReservationFcInItf(org.objectweb.fractal.api.Component component,String s,org.objectweb.fractal.api.Type type,boolean flag,Object obj)  {
    super(component,s,type,flag,obj);
  }

  public java.lang.String setPassengerInfo(final java.lang.String arg0,final java.lang.String arg1)  {
    if ( impl == null )
    {
      throw new java.lang.NullPointerException("Trying to invoke a method on a client or server interface whose complementary interface is not bound.");
    }
    java.lang.String ret = impl.setPassengerInfo(arg0,arg1);
    return ret;
  }

}
