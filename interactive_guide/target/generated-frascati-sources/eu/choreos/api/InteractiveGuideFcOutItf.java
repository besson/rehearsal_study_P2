/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ClientInterfaceClassGenerator
 * on: Sat Apr 28 17:47:47 BRT 2012
 */

package eu.choreos.api;


public class InteractiveGuideFcOutItf
extends eu.choreos.api.InteractiveGuideFcInItf
implements eu.choreos.api.InteractiveGuide,org.ow2.frascati.tinfi.TinfiComponentOutInterface<eu.choreos.api.InteractiveGuide> {

  public InteractiveGuideFcOutItf()  {
  }

  public InteractiveGuideFcOutItf(org.objectweb.fractal.api.Component component,String s,org.objectweb.fractal.api.Type type,boolean flag,Object obj)  {
    super(component,s,type,flag,obj);
  }

  public org.oasisopen.sca.ServiceReference<eu.choreos.api.InteractiveGuide> getServiceReference()  {
    return new eu.choreos.api.InteractiveGuideFcSR(eu.choreos.api.InteractiveGuide.class,this);
  }

}
