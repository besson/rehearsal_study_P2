/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ClientInterfaceClassGenerator
 * on: Sat Apr 28 17:47:52 BRT 2012
 */

package eu.choreos.api;


public class CarParkReservationFcOutItf
extends eu.choreos.api.CarParkReservationFcInItf
implements eu.choreos.api.CarParkReservation,org.ow2.frascati.tinfi.TinfiComponentOutInterface<eu.choreos.api.CarParkReservation> {

  public CarParkReservationFcOutItf()  {
  }

  public CarParkReservationFcOutItf(org.objectweb.fractal.api.Component component,String s,org.objectweb.fractal.api.Type type,boolean flag,Object obj)  {
    super(component,s,type,flag,obj);
  }

  public org.oasisopen.sca.ServiceReference<eu.choreos.api.CarParkReservation> getServiceReference()  {
    return new eu.choreos.api.CarParkReservationFcSR(eu.choreos.api.CarParkReservation.class,this);
  }

}
