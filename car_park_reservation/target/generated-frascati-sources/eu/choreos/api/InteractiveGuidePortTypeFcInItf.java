/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ServerInterfaceClassGenerator
 * on: Sat Apr 28 17:47:52 BRT 2012
 */

package eu.choreos.api;


public class InteractiveGuidePortTypeFcInItf
extends org.ow2.frascati.tinfi.TinfiComponentInterface<eu.choreos.api.InteractiveGuidePortType>
implements eu.choreos.api.InteractiveGuidePortType {

  public InteractiveGuidePortTypeFcInItf()  {
  }

  public InteractiveGuidePortTypeFcInItf(org.objectweb.fractal.api.Component component,String s,org.objectweb.fractal.api.Type type,boolean flag,Object obj)  {
    super(component,s,type,flag,obj);
  }

  public java.lang.String calculateLocations(final java.lang.String arg0)  {
    if ( impl == null )
    {
      throw new java.lang.NullPointerException("Trying to invoke a method on a client or server interface whose complementary interface is not bound.");
    }
    java.lang.String ret = impl.calculateLocations(arg0);
    return ret;
  }

  public void setCarParkInfo(final eu.choreos.CarParkEntry arg0)  {
    if ( impl == null )
    {
      throw new java.lang.NullPointerException("Trying to invoke a method on a client or server interface whose complementary interface is not bound.");
    }
    impl.setCarParkInfo(arg0);
  }

  public java.lang.String getFlightAndCarParkLocation(final java.lang.String arg0)  {
    if ( impl == null )
    {
      throw new java.lang.NullPointerException("Trying to invoke a method on a client or server interface whose complementary interface is not bound.");
    }
    java.lang.String ret = impl.getFlightAndCarParkLocation(arg0);
    return ret;
  }

}
