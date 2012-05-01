package eu.choreos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.servicesimulator.MockResponse;
import eu.choreos.vv.servicesimulator.WSMock;

public class WSMockDemo {
	
	final String greetingWSDL = "http://localhost:9080/greeting?wsdl";	
	
	@Test
	public void shouldChangeTheNameIfItIsJohn() throws Exception {
	
		WSMock mock = new WSMock("greetingAWSMock", "5000", "http://localhost:1234/greetingAWS?wsdl", true);
		// Mock is also used as interceptor
		
	}
}
