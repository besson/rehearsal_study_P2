/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.InitializerOOCtrlClassGenerator
 * on: Fri May 04 16:47:33 BRT 2012
 */

package eu.choreos.service;


public class OrchestratorFCscaPrimitiveFCcc86e192
extends juliac.generated.scaPrimitive
implements org.objectweb.fractal.juliac.runtime.Factory {

  public org.objectweb.fractal.api.Type getFcInstanceType()  {
    try
    {
      return new org.objectweb.fractal.julia.type.BasicComponentType( new org.objectweb.fractal.api.type.InterfaceType[]{new org.objectweb.fractal.julia.type.BasicInterfaceType("interactiveGuide","eu.choreos.api.InteractiveGuide",false,false,false),new org.objectweb.fractal.julia.type.BasicInterfaceType("flightFinder","eu.choreos.api.FlightFinderPortType",true,true,false),} );
    }
    catch ( org.objectweb.fractal.api.factory.InstantiationException ie )
    {
      throw new org.objectweb.fractal.juliac.runtime.RuntimeException(ie);
    }
  }

  public Object getFcControllerDesc()  {
      return "scaPrimitive";
  }

  public Object getFcContentDesc()  {
      return "eu.choreos.service.Orchestrator";
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
    ic.content = eu.choreos.service.Orchestrator.class;
    org.objectweb.fractal.api.Interface proxy;
    Object intercept;
    org.objectweb.fractal.api.Component proxyForCompCtrl = (org.objectweb.fractal.api.Component) ic.interfaces.get("component");
    ic.type = new org.objectweb.fractal.julia.type.BasicComponentType( new org.objectweb.fractal.api.type.InterfaceType[]{new org.objectweb.fractal.julia.type.BasicInterfaceType("sca-intent-controller","org.ow2.frascati.tinfi.api.control.SCAIntentController",false,false,false),new org.objectweb.fractal.julia.type.BasicInterfaceType("sca-component-controller","org.oasisopen.sca.ComponentContext",false,false,false),new org.objectweb.fractal.julia.type.BasicInterfaceType("binding-controller","org.objectweb.fractal.api.control.BindingController",false,false,false),new org.objectweb.fractal.julia.type.BasicInterfaceType("lifecycle-controller","org.objectweb.fractal.julia.control.lifecycle.LifeCycleCoordinator",false,false,false),new org.objectweb.fractal.julia.type.BasicInterfaceType("/sca-content-controller","org.ow2.frascati.tinfi.control.content.SCAExtendedContentController",false,false,false),new org.objectweb.fractal.julia.type.BasicInterfaceType("sca-property-controller","org.ow2.frascati.tinfi.api.control.SCAPropertyController",false,false,false),new org.objectweb.fractal.julia.type.BasicInterfaceType("component","org.objectweb.fractal.api.Component",false,false,false),new org.objectweb.fractal.julia.type.BasicInterfaceType("super-controller","org.objectweb.fractal.julia.control.content.SuperControllerNotifier",false,false,false),new org.objectweb.fractal.julia.type.BasicInterfaceType("name-controller","org.objectweb.fractal.api.control.NameController",false,false,false),new org.objectweb.fractal.julia.type.BasicInterfaceType("interactiveGuide","eu.choreos.api.InteractiveGuide",false,false,false),new org.objectweb.fractal.julia.type.BasicInterfaceType("flightFinder","eu.choreos.api.FlightFinderPortType",true,true,false),} );
    intercept = new eu.choreos.api.InteractiveGuideInterceptorSCALCb56bb98SCACCIntent();
    ic.controllers.add(intercept);
    ((org.objectweb.fractal.julia.Interceptor)intercept).setFcItfDelegate(content);
    proxy = new eu.choreos.api.InteractiveGuideFcInItf(proxyForCompCtrl,"interactiveGuide",new org.objectweb.fractal.julia.type.BasicInterfaceType("interactiveGuide","eu.choreos.api.InteractiveGuide",false,false,false),false,intercept);
    ic.interfaces.put("interactiveGuide",proxy);
    (( org.ow2.frascati.tinfi.TinfiComponentInterceptor )intercept).setFcItf(proxy);
    intercept = new eu.choreos.api.FlightFinderPortTypeInterceptorSCAIntent();
    ic.controllers.add(intercept);
    proxy = new eu.choreos.api.FlightFinderPortTypeFcOutItf(proxyForCompCtrl,"flightFinder",new org.objectweb.fractal.julia.type.BasicInterfaceType("flightFinder","eu.choreos.api.FlightFinderPortType",true,true,false),false,intercept);
    ic.interfaces.put("flightFinder",proxy);
    (( org.ow2.frascati.tinfi.TinfiComponentInterceptor )intercept).setFcItf(proxy);
    initFcController(ic);
    return proxyForCompCtrl;
  }

  public org.objectweb.fractal.api.Component newFcControllerInstantiation(org.objectweb.fractal.julia.InitializationContext ic) throws org.objectweb.fractal.api.factory.InstantiationException  {
    Object ctrl = null;
    ic.controllers.add(ctrl = new juliac.generated.SCAPrimitiveIntentControllerImpl());
    ic.controllers.add(ctrl = new juliac.generated.SCAComponentControllerImpl());
    ic.controllers.add(ctrl = new juliac.generated.SCABindingControllerImpl());
    ic.controllers.add(ctrl = new juliac.generated.SCALifeCycleControllerImpl());
    ic.controllers.add(ctrl = new eu.choreos.service.OrchestratorFCSCAContentControllerImpl());
    ic.controllers.add(ctrl = new juliac.generated.SCAPrimitivePropertyControllerImpl());
    ic.controllers.add(ctrl = new juliac.generated.ComponentImpl());
    org.objectweb.fractal.api.Component compctrl = (org.objectweb.fractal.api.Component)ctrl;
    ic.controllers.add(ctrl = new juliac.generated.SuperControllerImpl());
    ic.controllers.add(ctrl = new juliac.generated.NameControllerImpl());
    return compctrl;
  }

}
