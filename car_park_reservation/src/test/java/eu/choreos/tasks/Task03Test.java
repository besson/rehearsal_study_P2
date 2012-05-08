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
import eu.choreos.vv.interceptor.MessageInterceptor;
import eu.choreos.vv.servicesimulator.MockResponse;
import eu.choreos.vv.servicesimulator.WSMock;

public class Task03Test {
	
	private static Choreography choreography;
	private static String carParkReservationWSDL;
	private static String interactiveGuideWSDL;
	
	@BeforeClass
	public static void setUp() throws Exception{
		choreography = Choreography.build("./resource/arrivalAtAirport.yml");
		Service carParkReservation = choreography.getServicesForRole("carParkReservation").get(0);		
		carParkReservationWSDL = carParkReservation.getUri();
		
		Service interactiveGuide = choreography.getServicesForRole("interactiveGuide").get(0);
		interactiveGuideWSDL = interactiveGuide.getUri();
		
		deployWebTripMock();
	}
	
	@Test
	public void shouldSendCarParkInfoToInteractiveGuideCorrectly() throws Exception {
		/**
		 * input: A1, 8 
		 * 
		 * see the contract of interactive guide (using the item explorer) to find out
		 * the interface of setCarParkInfo message. This is the message that will be
		 * intercepted.
		 */
		
		//create the interceptor here
		final MessageInterceptor mInterceptor = new MessageInterceptor("6001");
		mInterceptor.interceptTo(interactiveGuideWSDL);
		
		final WSClient carParkReservationClient = new WSClient(carParkReservationWSDL);
		carParkReservationClient.request("setPassengerInfo", "A1", "8");
		
		final List<Item> messages = mInterceptor.getMessages();
		final Item responseItem = messages.get(0);
		final Item argItem = responseItem.getChild("arg0");
		
		assertEquals("A1", argItem.getChild("pId").getContent());
		assertEquals("J123", argItem.getChild("cpId").getContent());
		assertEquals("46 37 W", argItem.getChild("longitude").getContent());
		assertEquals("23 32 S", argItem.getChild("latitude").getContent());
	}
	
	private static void deployWebTripMock()throws Exception{
		Service flightFinder = choreography.getServicesForRole("flightFinder").get(0);

		Service service = flightFinder.getServicesForRole("flightFinder").get(0);
		String webTripWSDL = service.getUri();

		WSMock webTripMock = new WSMock("mocks/webTrip", "4321", webTripWSDL, true);
		MockResponse response = new MockResponse().whenReceive("A1").replyWith(getFligthResponse());

		webTripMock.returnFor("getFlight", response);
		webTripMock.start();
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

