/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ClientInterfaceClassGenerator
 * on: Sat Apr 28 17:47:41 BRT 2012
 */

package eu.choreos.api;


public class FlightFinderFcOutItf
extends eu.choreos.api.FlightFinderFcInItf
implements eu.choreos.api.FlightFinder,org.ow2.frascati.tinfi.TinfiComponentOutInterface<eu.choreos.api.FlightFinder> {

  public FlightFinderFcOutItf()  {
  }

  public FlightFinderFcOutItf(org.objectweb.fractal.api.Component component,String s,org.objectweb.fractal.api.Type type,boolean flag,Object obj)  {
    super(component,s,type,flag,obj);
  }

  public org.oasisopen.sca.ServiceReference<eu.choreos.api.FlightFinder> getServiceReference()  {
    return new eu.choreos.api.FlightFinderFcSR(eu.choreos.api.FlightFinder.class,this);
  }

}
