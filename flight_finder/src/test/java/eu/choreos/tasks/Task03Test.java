package eu.choreos.tasks;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import eu.choreos.vv.abstractor.Choreography;
import eu.choreos.vv.abstractor.Service;
import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.ItemImpl;
import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.interceptor.MessageInterceptor;
import eu.choreos.vv.servicesimulator.MockResponse;
import eu.choreos.vv.servicesimulator.WSMock;

public class Task03Test {
	
	private static Choreography choreography;
	private static Service flightFinder;

	@BeforeClass
	public static void setUp() throws Exception {
		choreography = Choreography.build("./resource/arrivalAtAirport.yml");
		flightFinder = choreography.getServicesForRole("flightFinder").get(0);
		
		deployWebTripMock();
		deployInteractiveGuideProxy();
	}
	
	@Test
	public void shouldForwardPassengerIdAndTerminalToTheCarParkReservation() throws Exception {
		// input: passengerId = A1

		Service carParkReservation = choreography.getServicesForRole("carParkReservation").get(0);
		String carParkReservationWSDL = carParkReservation.getUri();

		final MessageInterceptor carParkReservationInterceptor = new MessageInterceptor("6003");
		carParkReservationInterceptor.interceptTo(carParkReservationWSDL);
		
		final WSClient flightFinderClient = new WSClient(flightFinder.getUri());
		
		flightFinderClient.request("getFlightInfo", "A1");
		final List<Item> messages = carParkReservationInterceptor.getMessages();
		final Item responseItem = messages.get(0);
		
		assertEquals("A1", responseItem.getChild("arg0").getContent());
		assertEquals("8", responseItem.getChild("arg1").getContent());
	}
	
	private static void deployWebTripMock()throws Exception{
		Service service = flightFinder.getServicesForRole("flightFinder").get(0);
		String webTripWSDL = service.getUri();
				
		WSMock webTripMock = new WSMock("mocks/webTrip", "4321", webTripWSDL, true);
		MockResponse response = new MockResponse().whenReceive("A1").replyWith(getFligthResponse());
				
		webTripMock.returnFor("getFlight", response);
		webTripMock.start();
	}
	
	private static void deployInteractiveGuideProxy() throws Exception {
		Service interactiveGuide = choreography.getServicesForRole("interactiveGuide").get(0); 
		MessageInterceptor interceptor = new MessageInterceptor("6001");
		interceptor.interceptTo(interactiveGuide.getUri());
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



