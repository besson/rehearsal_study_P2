package eu.choreos.tasks;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import eu.choreos.vv.abstractor.Choreography;
import eu.choreos.vv.abstractor.Service;
import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.ItemImpl;
import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.servicesimulator.MockResponse;
import eu.choreos.vv.servicesimulator.WSMock;


public class Task02Test {

	private static Choreography choreography;
	private static Service flightFinder;
	private static String flightFinderWSDL;
	private static WSMock webTripMock;
	
	@BeforeClass
	public static void setUp() throws Exception{
		choreography = Choreography.build("./resource/arrivalAtAirport.yml");
		flightFinder = choreography.getServicesForRole("flightFinder").get(0);		
		
		flightFinderWSDL = flightFinder.getUri();
		
		//Retrieve the wsdl uri of the car parking ws
		Service service = flightFinder.getServicesForRole("flightFinder").get(0);
		String webTripWSDL = service.getUri();
		
		// create the Mock here
		webTripMock = new WSMock("mocks/webTrip", "4321", webTripWSDL, true);
		webTripMock.start();
		Item esperado = getFligthResponse();
		MockResponse response = new MockResponse().whenReceive("A1").replyWith(esperado);
		webTripMock.returnFor("getFlight", response);
	}
	
	@Test
	public void shouldReturnTheFlightInformationForTheGetFlightInfoOperation() throws Exception {
		// input passengerId = A1
		// output a FlightInfo object with the following attributes: id = 0815, company = AA, destination = Paris, time = 130p, terminal = 8 
		WSClient client = new WSClient(flightFinderWSDL);
		Item response = client.request("getFlightInfo", "A1");
		Item value = response.getChild("return");
		assertEquals("0815", value.getContent("id"));
		assertEquals("AA", value.getContent("company"));
		assertEquals("Paris", value.getContent("destination"));
		assertEquals("130p", value.getContent("time"));
		assertEquals("8", value.getContent("terminal"));
	}
	
	@Test
	public void shouldTheCorrectMessageToTheWebTripMock() throws Exception {
		WSClient client = new WSClient(flightFinderWSDL);
		client.request("getFlightInfo", "A1");
		Item message = webTripMock.getInterceptedMessages().get(0);
		assertEquals("A1","A1");
	}
	
	private static Item getFligthResponse() {
		Item getFlightInfoResponse = new ItemImpl("getFlightResponse"); 
		Item flightInformation = getFlightInfoResponse.addChild("flight"); 
	
		flightInformation.addChild("id").setContent("0815"); 
		flightInformation.addChild("time").setContent("130p"); 
		flightInformation.addChild("terminal").setContent("8"); 
		flightInformation.addChild("company").setContent("AA"); 
		flightInformation.addChild("destination").setContent("Paris"); 
		 
		return getFlightInfoResponse;
	}
}
