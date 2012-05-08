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
		interceptor = new MessageInterceptor("7003");
		interceptor.interceptTo(carParkingWSWSDL);
		
	}
	
	@Test
	public void shouldReturnAConfirmationMessageForSetPassengerInfoOperation() throws Exception {
		// input: A1, 8 (see the contract of carParkReservation by using the item explorer)
		// output: "OK"
		WSClient client = new WSClient(carParkReservationWSDL);
		Item setPassengerInfoResponse = client.request("setPassengerInfo", "A1", "8");
		String return1 = setPassengerInfoResponse.getContent("return");
		assertEquals("OK", return1);
	}
	
	@Test
	public void shouldReturnTheCorrectMessageToTheCarParkingService() throws Exception {
		WSClient client = new WSClient(carParkReservationWSDL);
		client.request("setPassengerInfo", "A1", "8");
		
		List<Item> messages = interceptor.getMessages();
		Item message = messages.get(0);
		
		assertEquals("A1", message.getContent("arg0"));
		assertEquals("8", message.getContent("arg1"));
		
	}
}
