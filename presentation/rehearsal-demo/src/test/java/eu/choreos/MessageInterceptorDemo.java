package eu.choreos;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.interceptor.MessageInterceptor;

public class MessageInterceptorDemo {
	
	final String greetingWSDL = "http://localhost:9080/greeting?wsdl";	
	
	
	@Test
	public void serviceAShouldForwardMessageToServiceB() throws Exception {
		// http://localhost:4321/greetingBWS?wsdl and port 6000
		
	}

}
