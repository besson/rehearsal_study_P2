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
		
		fail();
	}
	
	@Test
	public void shouldReturnTheLatitude() throws Exception {
		// input: J123
		// output: 23 32 S
		
		fail();
	}
	
	@Test
	public void shouldReturnTheLongitude() throws Exception {
		// input: J123
		// output: 46 37 W
		
		fail();
	}

}
