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
		webTripMock = new WSMock("webTripMock", "4321", webTripWSDL, true);
		MockResponse response = new MockResponse().whenReceive("A1").replyWith(getFligthResponse());
		webTripMock.returnFor("getFlight", response);
		webTripMock.start();
	}
	
	@Test
	public void shouldReturnTheFlightInformationForTheGetFlightInfoOperation() throws Exception {
		// input passengerId = A1
		// output a FlightInfo object with the following attributes: id = 0815, company = AA, destination = Paris, time = 130p, terminal = 8 
		
		final Service flightFinderService = choreography.getServicesForRole("flightFinder").get(0);
		final WSClient wsClient = new WSClient(flightFinderService.getUri());
		final Item responseItem = wsClient.request("getFlightInfo", "A1");
		
		final Item returnItem = responseItem.getChild("return");
		
		assertEquals(returnItem.getChild("id").getContent(), "0815");
		assertEquals(returnItem.getChild("company").getContent(), "AA");
		assertEquals(returnItem.getChild("destination").getContent(), "Paris");
		assertEquals(returnItem.getChild("time").getContent(), "130p");
		assertEquals(returnItem.getChild("terminal").getContent(), "8");		
	}
	
	@Test
	public void shouldSendTheCorrectMessageToTheWebTripMock() throws Exception {
//		WSClient wsClient =  new WSClient(webTripMock.getWsdl());
//		Item responseItem = wsClient.request("getFlight", "A1");
//		Item returnItem = responseItem.getChild("return");
		
		WSClient flightFinderClient = new WSClient(flightFinderWSDL);
		flightFinderClient.request("getFlightInfo", "A1");
		
		Item mockedMessage = webTripMock.getInterceptedMessages().get(0);

		assertEquals(mockedMessage.getChild("id").getContent(), "A1");
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
