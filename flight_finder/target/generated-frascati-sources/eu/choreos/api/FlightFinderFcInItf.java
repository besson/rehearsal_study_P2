/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ServerInterfaceClassGenerator
 * on: Sat Apr 28 17:23:48 BRT 2012
 */

package eu.choreos.api;


public class FlightFinderFcInItf
extends org.ow2.frascati.tinfi.TinfiComponentInterface<eu.choreos.api.FlightFinder>
implements eu.choreos.api.FlightFinder {

  public FlightFinderFcInItf()  {
  }

  public FlightFinderFcInItf(org.objectweb.fractal.api.Component component,String s,org.objectweb.fractal.api.Type type,boolean flag,Object obj)  {
    super(component,s,type,flag,obj);
  }

  public eu.choreos.model.FlightInfo getFlightInfo(final java.lang.String arg0)  {
    if ( impl == null )
    {
      throw new java.lang.NullPointerException("Trying to invoke a method on a client or server interface whose complementary interface is not bound.");
    }
    eu.choreos.model.FlightInfo ret = impl.getFlightInfo(arg0);
    return ret;
  }

}