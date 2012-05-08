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
		webTripMock = new WSMock("getFlight", "4321", webTripWSDL);
		webTripMock.start();
		Item response = getFligthResponse();
		MockResponse resp = new MockResponse().whenReceive("A1").replyWith(response);
		webTripMock.returnFor("getFlight", resp);
	}
	
	@Test
	public void shouldReturnTheFlightInformationForTheGetFlightInfoOperation() throws Exception {
		// input passengerId = A1
		// output a FlightInfo object with the following attributes: id = 0815, company = AA, destination = Paris, time = 130p, terminal = 8 

		String id_0  = "0815";
		String company_0 = "AA";
		String destination_0 = "Paris";
		String time_0 = "130p";
		String terminal_0 = "8";
		
		WSClient client = new WSClient(flightFinderWSDL);
		Item getFlightInfoResponse = client.request("getFlightInfo", "A1");
		
		Item return1 = getFlightInfoResponse.getChild("return");
		String id = return1.getContent("id");
		String time = return1.getContent("time");
		String terminal = return1.getContent("terminal");
		String company = return1.getContent("company");
		String destination = return1.getContent("destination");
		
		assertEquals(id_0, id);
	}
	
	@Test
	public void shouldTheCorrectMessageToTheCarParkingService() throws Exception {
		
		Item response = getFligthResponse();
				
		WSClient client = new WSClient(flightFinderWSDL);
		Item getFlightInfoResponse = client.request("getFlightInfo", "A1");
		
		Item return1 = getFlightInfoResponse.getChild("return");
		String id = return1.getContent("id");
		String time = return1.getContent("time");
		String terminal = return1.getContent("terminal");
		String company = return1.getContent("company");
		String destination = return1.getContent("destination");
		
		assertEquals(response.getChild("flight").getContent("company"), company);
		
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
