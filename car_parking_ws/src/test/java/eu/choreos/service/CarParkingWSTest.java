package eu.choreos.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import eu.choreos.common.ServiceDeployer;
import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.WSClient;

public class CarParkingWSTest {
	
	final static private String WSDL_URI = "http://localhost:1234/carParkingWS?wsdl";
	static private WSClient client;
	private Item response;
	
	@Before
	public void setUp() throws Exception {
		ServiceDeployer.deploy();
		client = new WSClient(WSDL_URI);
	}
	
	@After
	public void tearDown() throws Exception {
		ServiceDeployer.undeploy();
	}
	
	@Test
	public void shouldReturnTheCarParkCode() throws Exception {
		// input: A1, 8
		// output: J123
		//WSClient client = new WSClient(WSDL_URI);
		response = client.request("getCarParkCode", "A1", "8");
		assertEquals("J123", response.getContent("return"));
	}
	
	@Test
	public void shouldReturnTheLatitude() throws Exception {
		// input: J123
		// output: 23 32 S
		response = client.request("getLatitude", "J123");
		assertEquals("23 32 S", response.getContent("return"));
	}
	
	@Test
	public void shouldReturnTheLongitude() throws Exception {
		// input: J123
		// output: 46 37 W
		response = client.request("getLongitude", "J123");
		assertEquals("46 37 W", response.getContent("return"));
	}

}
