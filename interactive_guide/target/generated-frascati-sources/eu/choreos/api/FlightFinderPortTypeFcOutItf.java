/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ClientInterfaceClassGenerator
 * on: Sat Apr 28 16:08:02 BRT 2012
 */

package eu.choreos.api;


public class FlightFinderPortTypeFcOutItf
extends eu.choreos.api.FlightFinderPortTypeFcInItf
implements eu.choreos.api.FlightFinderPortType,org.ow2.frascati.tinfi.TinfiComponentOutInterface<eu.choreos.api.FlightFinderPortType> {

  public FlightFinderPortTypeFcOutItf()  {
  }

  public FlightFinderPortTypeFcOutItf(org.objectweb.fractal.api.Component component,String s,org.objectweb.fractal.api.Type type,boolean flag,Object obj)  {
    super(component,s,type,flag,obj);
  }

  public org.oasisopen.sca.ServiceReference<eu.choreos.api.FlightFinderPortType> getServiceReference()  {
    return new eu.choreos.api.FlightFinderPortTypeFcSR(eu.choreos.api.FlightFinderPortType.class,this);
  }

}