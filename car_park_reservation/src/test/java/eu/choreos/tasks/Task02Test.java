package eu.choreos.tasks;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.jws.WebMethod;

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
	
		final String wsdlURI = choreography.getServicesForRole("carParkReservation").get(0).getUri();
		final WSClient wsClient = new WSClient(wsdlURI);
		
		final Item responseItem = wsClient.request("setPassengerInfo", "A1", "8");
		
		assertEquals(responseItem.getChild("return").getContent(), "OK");
	}
	
	@Test
	public void shouldReturnTheCorrectMessageToTheCarParkingService() throws Exception {
		WSClient wsClient = new WSClient(interceptor.getProxyWsdl());
		wsClient.request("getCarParkCode", "A1", "8");
		wsClient.request("getLatitude", "A1");
		wsClient.request("getLongitude", "A1");
				
		final List<Item> messages = interceptor.getMessages();
		
		Item message0 = messages.get(0);
		assertEquals(message0.getChild("arg0").getContent(), "A1");
		assertEquals(message0.getChild("arg1").getContent(), "8");
		
		Item message1 = messages.get(1);
		assertEquals(message1.getChild("arg0").getContent(), "A1");
		
		Item message2 = messages.get(2);
		assertEquals(message2.getChild("arg0").getContent(), "A1");		
	}
}
