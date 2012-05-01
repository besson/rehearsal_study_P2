package eu.choreos;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import eu.choreos.vv.abstractor.Choreography;
import eu.choreos.vv.abstractor.Service;

public class AbstractChoreographyDemo {
	
	private static Choreography choreography;
	
	@BeforeClass
	public static void setUp() throws FileNotFoundException{
		choreography = Choreography.build("resource/futureMarket.yml");
	}
	
	@Test
	public void shouldRetrieveAllServicePlayingSupermarketRole() throws Exception {
	}
	
	@Test
	public void shouldRetrieveTheParicipants() throws Exception {
		List<Service> services = choreography.getServicesForRole("supermarket");
		assertEquals("http://localhost:4321/SM1?wsdl", services.get(0).getServicesForRole("supermarket").get(0).getUri());
	}

}
