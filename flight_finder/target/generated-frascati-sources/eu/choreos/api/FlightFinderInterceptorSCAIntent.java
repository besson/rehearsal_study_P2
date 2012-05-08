/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.InterceptorClassGenerator
 * on: Fri May 04 16:47:44 BRT 2012
 */

package eu.choreos.api;


public class FlightFinderInterceptorSCAIntent
extends org.ow2.frascati.tinfi.TinfiComponentInterceptor<eu.choreos.api.FlightFinder>
implements org.objectweb.fractal.julia.Interceptor,eu.choreos.api.FlightFinder {

  private static java.lang.reflect.Method[] METHODS;
  public FlightFinderInterceptorSCAIntent()  {
  }

  private FlightFinderInterceptorSCAIntent(Object obj)  {
    setFcItfDelegate(obj);
  }

  public void initFcController(org.objectweb.fractal.julia.InitializationContext ic) throws org.objectweb.fractal.api.factory.InstantiationException  {
    super.initFcController(ic);
    initIntentHandlersMap(METHODS);
  }

  public Object clone()  {
    FlightFinderInterceptorSCAIntent clone = new FlightFinderInterceptorSCAIntent(getFcItfDelegate());
    initFcClone(clone);
    clone.initIntentHandlersMap(METHODS);
    return clone;
  }

  public eu.choreos.model.FlightInfo getFlightInfo(final java.lang.String arg0)  {
    java.util.List<org.ow2.frascati.tinfi.api.IntentHandler> handlers = intentHandlersMap.get(METHODS[0]);
    try {
      if( handlers.size() == 0 ) {
        eu.choreos.model.FlightInfo ret = impl.getFlightInfo(arg0);
        return ret;
      }
      else {
        org.objectweb.fractal.api.Component comp = getFcComponent();
        org.objectweb.fractal.api.Interface itf = getFcItf();
        org.ow2.frascati.tinfi.IntentJoinPointImpl<eu.choreos.api.FlightFinder> ijp = new org.ow2.frascati.tinfi.IntentJoinPointImpl();
        ijp.init(handlers,comp,itf,impl,METHODS[0],(Object)arg0);
    eu.choreos.model.FlightInfo ret = (eu.choreos.model.FlightInfo) ijp.proceed();
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
        eu.choreos.api.FlightFinder.class.getMethod("getFlightInfo",java.lang.String.class),
      };
    }
    catch( NoSuchMethodException e ) {
      throw new org.ow2.frascati.tinfi.TinfiRuntimeException(e);
    }
  }

}
