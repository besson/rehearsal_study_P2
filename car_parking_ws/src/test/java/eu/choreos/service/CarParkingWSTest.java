package eu.choreos.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.choreos.common.ServiceDeployer;
import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.ItemImpl;
import eu.choreos.vv.clientgenerator.WSClient;

public class CarParkingWSTest {
	
	final private String WSDL_URI = "http://localhost:1234/carParkingWS?wsdl";
	
	@Before
	public void setUp() throws Exception {
		ServiceDeployer.deploy();
	}
	
	@After
	public void tearDown() throws Exception {
		ServiceDeployer.undeploy();
	}
	
	@Test
	public void shouldReturnTheCarParkCode() throws Exception {
		// input: A1, 8
		// output: J123
		WSClient client = new WSClient(WSDL_URI);
		Item response = client.request("getCarParkCode", "A1", "8");
		String return1 = response.getContent("return");
		assertEquals("J123", return1);
	}
	
	@Test
	public void shouldReturnTheLatitude() throws Exception {
		// input: J123
		// output: 23 32 S
		WSClient client = new WSClient(WSDL_URI);
		Item response = client.request("getLatitude", "J123");
		String return1 = response.getContent("return");
		assertEquals("23 32 S", return1);
	}
	
	@Test
	public void shouldReturnTheLongitude() throws Exception {
		// input: J123
		// output: 46 37 W
		WSClient client = new WSClient(WSDL_URI);
		Item response = client.request("getLongitude", "J123");
		String return1 = response.getContent("return");
		assertEquals("46 37 W", return1);
	}

}
