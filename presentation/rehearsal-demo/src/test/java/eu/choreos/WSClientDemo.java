package eu.choreos;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.ItemImpl;
import eu.choreos.vv.clientgenerator.WSClient;

public class WSClientDemo {
	
	@BeforeClass
	public static void setUp() {
		ServiceDeployer.deployServiceA();
	}
	
	@AfterClass
	public static void tearDown(){
		ServiceDeployer.undeployServiceA();
	}
	
	@Test
	public void shouldReturnTheMessageHiJohn() throws Exception {

	}
	
	@Test
	public void shouldReturnWho() throws Exception {
	
	}
	
	

}
