/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.InitializerOOCtrlClassGenerator
 * on: Fri May 04 16:47:51 BRT 2012
 */

package juliac.generated;


public class scaCompositeFCa7d9448e
extends juliac.generated.scaComposite
implements org.objectweb.fractal.juliac.runtime.Factory {

  public org.objectweb.fractal.api.Type getFcInstanceType()  {
    try
    {
      return new org.objectweb.fractal.julia.type.BasicComponentType( new org.objectweb.fractal.api.type.InterfaceType[]{new org.objectweb.fractal.julia.type.BasicInterfaceType("interactiveGuideRole","eu.choreos.api.CarParkReservation",false,false,false),} );
    }
    catch ( org.objectweb.fractal.api.factory.InstantiationException ie )
    {
      throw new org.objectweb.fractal.juliac.runtime.RuntimeException(ie);
    }
  }

  public Object getFcControllerDesc()  {
      return "scaComposite";
  }

  public Object getFcContentDesc()  {
      return null;
  }

  public Object newFcContent() throws org.objectweb.fractal.api.factory.InstantiationException  {
    return null;
  }

  public org.objectweb.fractal.api.Component newFcInstance() throws org.objectweb.fractal.api.factory.InstantiationException  {
    Object content = newFcContent();
    return newFcInstance(content);
  }

  public org.objectweb.fractal.api.Component newFcInstance(Object content) throws org.objectweb.fractal.api.factory.InstantiationException  {
    org.objectweb.fractal.julia.InitializationContext ic = newFcInitializationContext(content);
    ic.content = null;
    org.objectweb.fractal.api.Interface proxy;
    Object intercept;
    org.objectweb.fractal.api.Component proxyForCompCtrl = (org.objectweb.fractal.api.Component) ic.interfaces.get("component");
    ic.type = new org.objectweb.fractal.julia.type.BasicComponentType( new org.objectweb.fractal.api.type.InterfaceType[]{new org.objectweb.fractal.julia.type.BasicInterfaceType("sca-intent-controller","org.ow2.frascati.tinfi.api.control.SCABasicIntentController",false,false,false),new org.objectweb.fractal.julia.type.BasicInterfaceType("sca-component-controller","org.oasisopen.sca.ComponentContext",false,false,false),new org.objectweb.fractal.julia.type.BasicInterfaceType("sca-property-controller","org.ow2.frascati.tinfi.api.control.SCAPropertyController",false,false,false),new org.objectweb.fractal.julia.type.BasicInterfaceType("component","org.objectweb.fractal.api.Component",false,false,false),new org.objectweb.fractal.julia.type.BasicInterfaceType("binding-controller","org.objectweb.fractal.api.control.BindingController",false,false,false),new org.objectweb.fractal.julia.type.BasicInterfaceType("content-controller","org.objectweb.fractal.api.control.ContentController",false,false,false),new org.objectweb.fractal.julia.type.BasicInterfaceType("super-controller","org.objectweb.fractal.julia.control.content.SuperControllerNotifier",false,false,false),new org.objectweb.fractal.julia.type.BasicInterfaceType("lifecycle-controller","org.objectweb.fractal.julia.control.lifecycle.LifeCycleCoordinator",false,false,false),new org.objectweb.fractal.julia.type.BasicInterfaceType("name-controller","org.objectweb.fractal.api.control.NameController",false,false,false),new org.objectweb.fractal.julia.type.BasicInterfaceType("interactiveGuideRole","eu.choreos.api.CarParkReservation",false,false,false),} );
    intercept = new eu.choreos.api.CarParkReservationInterceptorSCAIntent();
    ic.controllers.add(intercept);
    ((org.objectweb.fractal.julia.Interceptor)intercept).setFcItfDelegate(content);
    proxy = new eu.choreos.api.CarParkReservationFcInItf(proxyForCompCtrl,"interactiveGuideRole",new org.objectweb.fractal.julia.type.BasicInterfaceType("interactiveGuideRole","eu.choreos.api.CarParkReservation",false,false,false),false,intercept);
    ic.interfaces.put("interactiveGuideRole",proxy);
    (( org.ow2.frascati.tinfi.TinfiComponentInterceptor )intercept).setFcItf(proxy);
    proxy = new eu.choreos.api.CarParkReservationFcOutItf(proxyForCompCtrl,"interactiveGuideRole",new org.objectweb.fractal.julia.type.BasicInterfaceType("interactiveGuideRole","eu.choreos.api.CarParkReservation",true,false,false),true,intercept);
    ic.internalInterfaces.put("interactiveGuideRole",proxy);
    initFcController(ic);
    return proxyForCompCtrl;
  }

  public org.objectweb.fractal.api.Component newFcControllerInstantiation(org.objectweb.fractal.julia.InitializationContext ic) throws org.objectweb.fractal.api.factory.InstantiationException  {
    Object ctrl = null;
    ic.controllers.add(ctrl = new juliac.generated.SCACompositeIntentControllerImpl());
    ic.controllers.add(ctrl = new juliac.generated.SCAComponentControllerImpl());
    ic.controllers.add(ctrl = new juliac.generated.SCACompositePropertyControllerImpl());
    ic.controllers.add(ctrl = new juliac.generated.ComponentImpl());
    org.objectweb.fractal.api.Component compctrl = (org.objectweb.fractal.api.Component)ctrl;
    ic.controllers.add(ctrl = new juliac.generated.CompositeBindingControllerImpl());
    ic.controllers.add(ctrl = new juliac.generated.ContentControllerImpl());
    ic.controllers.add(ctrl = new juliac.generated.SuperControllerImpl());
    ic.controllers.add(ctrl = new juliac.generated.CompositeLifeCycleControllerImpl());
    ic.controllers.add(ctrl = new juliac.generated.NameControllerImpl());
    return compctrl;
  }

}
