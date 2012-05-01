
package br.batcave;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "HelloWorldWSService", targetNamespace = "http://batcave.br/", wsdlLocation = "http://localhost:8080/helloWorld?wsdl")
public class HelloWorldWSService
    extends Service
{

    private final static URL HELLOWORLDWSSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(br.batcave.HelloWorldWSService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = br.batcave.HelloWorldWSService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8080/helloWorld?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8080/helloWorld?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        HELLOWORLDWSSERVICE_WSDL_LOCATION = url;
    }

    public HelloWorldWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HelloWorldWSService() {
        super(HELLOWORLDWSSERVICE_WSDL_LOCATION, new QName("http://batcave.br/", "HelloWorldWSService"));
    }

    /**
     * 
     * @return
     *     returns HelloWorldWS
     */
    @WebEndpoint(name = "HelloWorldWSPort")
    public HelloWorldWS getHelloWorldWSPort() {
        return super.getPort(new QName("http://batcave.br/", "HelloWorldWSPort"), HelloWorldWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HelloWorldWS
     */
    @WebEndpoint(name = "HelloWorldWSPort")
    public HelloWorldWS getHelloWorldWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://batcave.br/", "HelloWorldWSPort"), HelloWorldWS.class, features);
    }

}
