/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ClientInterfaceClassGenerator
 * on: Thu May 03 16:31:55 BRT 2012
 */

package com.safetrip.service;


public class WebTripFcOutItf
extends com.safetrip.service.WebTripFcInItf
implements com.safetrip.service.WebTrip,org.ow2.frascati.tinfi.TinfiComponentOutInterface<com.safetrip.service.WebTrip> {

  public WebTripFcOutItf()  {
  }

  public WebTripFcOutItf(org.objectweb.fractal.api.Component component,String s,org.objectweb.fractal.api.Type type,boolean flag,Object obj)  {
    super(component,s,type,flag,obj);
  }

  public org.oasisopen.sca.ServiceReference<com.safetrip.service.WebTrip> getServiceReference()  {
    return new com.safetrip.service.WebTripFcSR(com.safetrip.service.WebTrip.class,this);
  }

}
