package eu.choreos.interceptor;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import eu.choreos.ServiceDeployer;
import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.interceptor.MessageInterceptor;

public class GetWeatherInterceptionTest {
	
final String WSDL = "http://localhost:9876/globalWeather?wsdl";
	
	@BeforeClass
	public static void setUp(){
		ServiceDeployer.deploy();
	}
	
	@AfterClass
	public static void tearDown(){
		ServiceDeployer.undeploy();
	}
	
	@Test
	public void shouldValidateMessageContentSentToWS() throws Exception {
		/** 1. Intercept the message sent to globalWeather service 
		 *  2. Validate the content of these messages 
		 *  
		 *  Configure the interceptor to use the port 6789
		 **/
		MessageInterceptor interceptor = new MessageInterceptor("6789");
		interceptor.interceptTo(WSDL);
		WSClient client = new WSClient(interceptor.getProxyWsdl());
		client.request("getWeather", "brables", "Sao Paulo");
		client.request("getWeather", "Brazil", "Sao Paulo");
		List<Item> messages = interceptor.getMessages();
		Item message = messages.get(1);
		assertEquals("Brazil", message.getContent("countryName"));
		assertEquals("Sao Paulo", message.getContent("cityName"));
	}

}
