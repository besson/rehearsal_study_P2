/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ServerInterfaceClassGenerator
 * on: Fri May 04 15:38:06 BRT 2012
 */

package com.safetrip.service;


public class WebTripFcInItf
extends org.ow2.frascati.tinfi.TinfiComponentInterface<com.safetrip.service.WebTrip>
implements com.safetrip.service.WebTrip {

  public WebTripFcInItf()  {
  }

  public WebTripFcInItf(org.objectweb.fractal.api.Component component,String s,org.objectweb.fractal.api.Type type,boolean flag,Object obj)  {
    super(component,s,type,flag,obj);
  }

  public com.safetrip.service.Flight getFlight(final java.lang.String arg0)  {
    if ( impl == null )
    {
      throw new java.lang.NullPointerException("Trying to invoke a method on a client or server interface whose complementary interface is not bound.");
    }
    com.safetrip.service.Flight ret = impl.getFlight(arg0);
    return ret;
  }

  public java.lang.String addFlight(final com.safetrip.service.Flight arg0)  {
    if ( impl == null )
    {
      throw new java.lang.NullPointerException("Trying to invoke a method on a client or server interface whose complementary interface is not bound.");
    }
    java.lang.String ret = impl.addFlight(arg0);
    return ret;
  }

}
