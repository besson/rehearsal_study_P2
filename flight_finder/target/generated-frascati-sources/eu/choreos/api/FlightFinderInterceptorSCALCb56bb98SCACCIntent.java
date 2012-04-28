/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.InterceptorClassGenerator
 * on: Sat Apr 28 17:47:41 BRT 2012
 */

package eu.choreos.api;


public class FlightFinderInterceptorSCALCb56bb98SCACCIntent
extends org.ow2.frascati.tinfi.TinfiComponentInterceptor<eu.choreos.api.FlightFinder>
implements org.objectweb.fractal.julia.Interceptor,eu.choreos.api.FlightFinder {

  private juliac.generated.SCALifeCycleControllerImpl _lc;
  private static java.lang.reflect.Method[] METHODS;
  public FlightFinderInterceptorSCALCb56bb98SCACCIntent()  {
  }

  private FlightFinderInterceptorSCALCb56bb98SCACCIntent(Object obj)  {
    setFcItfDelegate(obj);
  }

  public void initFcController(org.objectweb.fractal.julia.InitializationContext ic) throws org.objectweb.fractal.api.factory.InstantiationException  {
    super.initFcController(ic);
    Object olc = ic.getInterface("lifecycle-controller");
    if ( !( olc instanceof juliac.generated.SCALifeCycleControllerImpl ) )
    {
      while ( olc instanceof org.objectweb.fractal.julia.Interceptor )
      {
        olc = ((org.objectweb.fractal.julia.Interceptor)olc).getFcItfDelegate();
      }

    }
    _lc = (juliac.generated.SCALifeCycleControllerImpl) olc;
    initIntentHandlersMap(METHODS);
  }

  public Object clone()  {
    FlightFinderInterceptorSCALCb56bb98SCACCIntent clone = new FlightFinderInterceptorSCALCb56bb98SCACCIntent(getFcItfDelegate());
    initFcClone(clone);
    clone._lc = _lc;
    clone.initIntentHandlersMap(METHODS);
    return clone;
  }

  public eu.choreos.model.FlightInfo getFlightInfo(final java.lang.String arg0)  {
    synchronized(_lc)
    {
      if ( _lc.fcState != 2 )
      {
        _lc.incrementFcInvocationCounter();
      }
      else
      {
        _lc.fcInvocationCounter++;
      }

    }

      try {
    eu.choreos.api.FlightFinder impl = pushFcAndGet("flightFinder",eu.choreos.api.FlightFinder.class,this);
    try {
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
    finally {
      releaseFcAndPop(impl,false);
    }
      }
      finally {
    synchronized(_lc)
    {
      if ( _lc.fcState != 2 )
      {
        _lc.decrementFcInvocationCounter();
      }
      else
      {
        _lc.fcInvocationCounter--;
      }

    }

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
