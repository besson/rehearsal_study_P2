/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ClientInterfaceClassGenerator
 * on: Sat Apr 28 17:47:52 BRT 2012
 */

package eu.choreos.service;


public class CarParkingWSFcOutItf
extends eu.choreos.service.CarParkingWSFcInItf
implements eu.choreos.service.CarParkingWS,org.ow2.frascati.tinfi.TinfiComponentOutInterface<eu.choreos.service.CarParkingWS> {

  public CarParkingWSFcOutItf()  {
  }

  public CarParkingWSFcOutItf(org.objectweb.fractal.api.Component component,String s,org.objectweb.fractal.api.Type type,boolean flag,Object obj)  {
    super(component,s,type,flag,obj);
  }

  public org.oasisopen.sca.ServiceReference<eu.choreos.service.CarParkingWS> getServiceReference()  {
    return new eu.choreos.service.CarParkingWSFcSR(eu.choreos.service.CarParkingWS.class,this);
  }

}
