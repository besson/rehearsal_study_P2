/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ClientInterfaceClassGenerator
 * on: Fri May 04 15:42:21 BRT 2012
 */

package eu.choreos.api;


public class CarParkReservationPortTypeFcOutItf
extends eu.choreos.api.CarParkReservationPortTypeFcInItf
implements eu.choreos.api.CarParkReservationPortType,org.ow2.frascati.tinfi.TinfiComponentOutInterface<eu.choreos.api.CarParkReservationPortType> {

  public CarParkReservationPortTypeFcOutItf()  {
  }

  public CarParkReservationPortTypeFcOutItf(org.objectweb.fractal.api.Component component,String s,org.objectweb.fractal.api.Type type,boolean flag,Object obj)  {
    super(component,s,type,flag,obj);
  }

  public org.oasisopen.sca.ServiceReference<eu.choreos.api.CarParkReservationPortType> getServiceReference()  {
    return new eu.choreos.api.CarParkReservationPortTypeFcSR(eu.choreos.api.CarParkReservationPortType.class,this);
  }

}
