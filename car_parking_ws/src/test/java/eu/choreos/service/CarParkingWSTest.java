package eu.choreos.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.choreos.common.ServiceDeployer;
import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.WSClient;

public class CarParkingWSTest {
	
	final private String WSDL_URI = "http://localhost:1234/carParkingWS?wsdl";
	
	WSClient wsClient = null;
	
	@Before
	public void setUp() throws Exception {
		ServiceDeployer.deploy();
		wsClient = new WSClient(WSDL_URI);
	}
	
	@After
	public void tearDown() throws Exception {
		ServiceDeployer.undeploy();
	}
	
	@Test
	public void shouldReturnTheCarParkCode() throws Exception {
		// input: A1, 8
		// output: J123
		final Item responseItem = wsClient.request("getCarParkCode", "A1", "8");
		
		assertEquals(responseItem.getChild("return").getContent(), "J123");
	}
	
	@Test
	public void shouldReturnTheLatitude() throws Exception {
		// input: J123
		// output: 23 32 S
		final Item responseItem = wsClient.request("getLatitude", "J123");
		
		assertEquals(responseItem.getChild("return").getContent(), "23 32 S");
	}
	
	@Test
	public void shouldReturnTheLongitude() throws Exception {
		// input: J123
		// output: 46 37 W
		final Item responItem = wsClient.request("getLongitude", "J123");
		
		assertEquals(responItem.getChild("return").getContent(), "46 37 W");
	}

}
