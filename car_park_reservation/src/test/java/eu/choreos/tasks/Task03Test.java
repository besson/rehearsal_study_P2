package eu.choreos.tasks;

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
		// input: A1, 8 (see the contract of carParkReservation by using the item explorer)

		//create the interceptor here
		//TODO erase and put assertTrue(false);
		MessageInterceptor interceptor = new MessageInterceptor("6001");
		interceptor.interceptTo(interactiveGuideWSDL);
		
		WSClient client = new WSClient(carParkReservationWSDL);
		
		Item setPassengerInfo = new ItemImpl("setPassengerInfo"); 
		setPassengerInfo.addChild("arg1").setContent("8"); 
		setPassengerInfo.addChild("arg0").setContent("A1");
		
		client.request("setPassengerInfo", setPassengerInfo);
		
		List<Item> messages = interceptor.getMessages();
		
		assertEquals("A1", messages.get(0).getChild("arg0").getChild("pId").getContent());
		assertEquals("J123", messages.get(0).getChild("arg0").getChild("cpId").getContent());
		
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

