/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.InterceptorClassGenerator
 * on: Thu May 03 16:31:55 BRT 2012
 */

package eu.choreos.api;


public class CarParkReservationPortTypeInterceptorSCAIntent
extends org.ow2.frascati.tinfi.TinfiComponentInterceptor<eu.choreos.api.CarParkReservationPortType>
implements eu.choreos.api.CarParkReservationPortType,org.objectweb.fractal.julia.Interceptor {

  private static java.lang.reflect.Method[] METHODS;
  public CarParkReservationPortTypeInterceptorSCAIntent()  {
  }

  private CarParkReservationPortTypeInterceptorSCAIntent(Object obj)  {
    setFcItfDelegate(obj);
  }

  public void initFcController(org.objectweb.fractal.julia.InitializationContext ic) throws org.objectweb.fractal.api.factory.InstantiationException  {
    super.initFcController(ic);
    initIntentHandlersMap(METHODS);
  }

  public Object clone()  {
    CarParkReservationPortTypeInterceptorSCAIntent clone = new CarParkReservationPortTypeInterceptorSCAIntent(getFcItfDelegate());
    initFcClone(clone);
    clone.initIntentHandlersMap(METHODS);
    return clone;
  }

  public java.lang.String setPassengerInfo(final java.lang.String arg0,final java.lang.String arg1)  {
    java.util.List<org.ow2.frascati.tinfi.api.IntentHandler> handlers = intentHandlersMap.get(METHODS[0]);
    try {
      if( handlers.size() == 0 ) {
        java.lang.String ret = impl.setPassengerInfo(arg0,arg1);
        return ret;
      }
      else {
        org.objectweb.fractal.api.Component comp = getFcComponent();
        org.objectweb.fractal.api.Interface itf = getFcItf();
        org.ow2.frascati.tinfi.IntentJoinPointImpl<eu.choreos.api.CarParkReservationPortType> ijp = new org.ow2.frascati.tinfi.IntentJoinPointImpl();
        ijp.init(handlers,comp,itf,impl,METHODS[0],(Object)arg0,(Object)arg1);
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
        eu.choreos.api.CarParkReservationPortType.class.getMethod("setPassengerInfo",java.lang.String.class,java.lang.String.class),
      };
    }
    catch( NoSuchMethodException e ) {
      throw new org.ow2.frascati.tinfi.TinfiRuntimeException(e);
    }
  }

}
