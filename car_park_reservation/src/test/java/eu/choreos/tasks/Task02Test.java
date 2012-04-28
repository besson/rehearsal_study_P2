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


public class Task02Test {

	private static Choreography choreography;
	private static Service carParkReservation;
	private static String carParkReservationWSDL;
	private static MessageInterceptor interceptor;
	
	@BeforeClass
	public static void setUp() throws Exception{
		choreography = Choreography.build("./resource/arrivalAtAirport.yml");
		carParkReservation = choreography.getServicesForRole("carParkReservation").get(0);		
		carParkReservationWSDL = carParkReservation.getUri();
		
		//Retrieve the wsdl uri of the car parking ws
		Service service = carParkReservation.getParticipants().get(0);
		String carParkingWSWSDL = service.getUri();
		
		//create the interceptor here
		//TODO erase
		interceptor = new MessageInterceptor("7003");
		interceptor.interceptTo(carParkingWSWSDL);
		
	}
	
	@Test
	public void shouldReturnAConfirmationMessageForSetPassengerInfoOperation() throws Exception {
		// input: A1, 8 (see the contract of carParkReservation by using the item explorer)
		// output: "OK"
		
		// TODO: erase and put assertTrue(false)
		WSClient client = new WSClient(carParkReservationWSDL);
		
		Item setPassengerInfo = new ItemImpl("setPassengerInfo"); 
		setPassengerInfo.addChild("arg1").setContent("A1"); 
		setPassengerInfo.addChild("arg0").setContent("8");

		Item response = client.request("setPassengerInfo", setPassengerInfo);
		
		assertEquals("OK", response.getContent("return"));
	}
	
	@Test
	public void shouldReturnTheCorrectMessageToTheCarParkingService() throws Exception {
		// TODO erase
		WSClient client = new WSClient(carParkReservationWSDL);
		
		Item setPassengerInfo = new ItemImpl("setPassengerInfo"); 
		setPassengerInfo.addChild("arg1").setContent("A1"); 
		setPassengerInfo.addChild("arg0").setContent("8");
		
		client.request("setPassengerInfo", setPassengerInfo);
		
		List<Item> messages = interceptor.getMessages();
		
		assertEquals("A1", messages.get(0).getChild("arg1").getContent());
		assertEquals("8", messages.get(0).getChild("arg0").getContent());
	}
}
