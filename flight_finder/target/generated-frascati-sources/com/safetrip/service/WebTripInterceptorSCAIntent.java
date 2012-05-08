/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.InterceptorClassGenerator
 * on: Thu May 03 16:31:55 BRT 2012
 */

package com.safetrip.service;


public class WebTripInterceptorSCAIntent
extends org.ow2.frascati.tinfi.TinfiComponentInterceptor<com.safetrip.service.WebTrip>
implements org.objectweb.fractal.julia.Interceptor,com.safetrip.service.WebTrip {

  private static java.lang.reflect.Method[] METHODS;
  public WebTripInterceptorSCAIntent()  {
  }

  private WebTripInterceptorSCAIntent(Object obj)  {
    setFcItfDelegate(obj);
  }

  public void initFcController(org.objectweb.fractal.julia.InitializationContext ic) throws org.objectweb.fractal.api.factory.InstantiationException  {
    super.initFcController(ic);
    initIntentHandlersMap(METHODS);
  }

  public Object clone()  {
    WebTripInterceptorSCAIntent clone = new WebTripInterceptorSCAIntent(getFcItfDelegate());
    initFcClone(clone);
    clone.initIntentHandlersMap(METHODS);
    return clone;
  }

  public com.safetrip.service.Flight getFlight(final java.lang.String arg0)  {
    java.util.List<org.ow2.frascati.tinfi.api.IntentHandler> handlers = intentHandlersMap.get(METHODS[0]);
    try {
      if( handlers.size() == 0 ) {
        com.safetrip.service.Flight ret = impl.getFlight(arg0);
        return ret;
      }
      else {
        org.objectweb.fractal.api.Component comp = getFcComponent();
        org.objectweb.fractal.api.Interface itf = getFcItf();
        org.ow2.frascati.tinfi.IntentJoinPointImpl<com.safetrip.service.WebTrip> ijp = new org.ow2.frascati.tinfi.IntentJoinPointImpl();
        ijp.init(handlers,comp,itf,impl,METHODS[0],(Object)arg0);
    com.safetrip.service.Flight ret = (com.safetrip.service.Flight) ijp.proceed();
    return ret;
      }
    }
    catch( Throwable t ) {
      if( t instanceof RuntimeException ) {
        throw (RuntimeException) t;
      }
      throw new org.ow2.frascati.tinfi.TinfiRuntimeException(t);
    }
  }

  public java.lang.String addFlight(final com.safetrip.service.Flight arg0)  {
    java.util.List<org.ow2.frascati.tinfi.api.IntentHandler> handlers = intentHandlersMap.get(METHODS[1]);
    try {
      if( handlers.size() == 0 ) {
        java.lang.String ret = impl.addFlight(arg0);
        return ret;
      }
      else {
        org.objectweb.fractal.api.Component comp = getFcComponent();
        org.objectweb.fractal.api.Interface itf = getFcItf();
        org.ow2.frascati.tinfi.IntentJoinPointImpl<com.safetrip.service.WebTrip> ijp = new org.ow2.frascati.tinfi.IntentJoinPointImpl();
        ijp.init(handlers,comp,itf,impl,METHODS[1],(Object)arg0);
    java.lang.String ret = (java.lang.String) ijp.proceed();
    return ret;
      }
    }
    catch( Throwable t ) {
      if( t instanceof RuntimeException ) {
        throw (RuntimeException) t;
      }
      throw new org.ow2.frascati.tinfi.TinfiRuntimeException(t);
    }
  }

  static  {
    try {
      METHODS = new java.lang.reflect.Method[]{
        com.safetrip.service.WebTrip.class.getMethod("getFlight",java.lang.String.class),
        com.safetrip.service.WebTrip.class.getMethod("addFlight",com.safetrip.service.Flight.class),
      };
    }
    catch( NoSuchMethodException e ) {
      throw new org.ow2.frascati.tinfi.TinfiRuntimeException(e);
    }
  }

}
