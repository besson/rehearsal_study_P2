package eu.choreos;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import eu.choreos.vv.abstractor.Choreography;
import eu.choreos.vv.abstractor.Service;
import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.ItemImpl;
import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.servicesimulator.MockResponse;
import eu.choreos.vv.servicesimulator.WSMock;

public class OperationsTest {

	private static Choreography choreography;
	private static Service interactiveGuide;
	private static WSMock ffMock;
	private static WSClient client;
	
	@BeforeClass
	public static void setUp() throws Exception{
		choreography = Choreography.build("./resource/arrivalAtAirport.yml");
		interactiveGuide = choreography.getServicesForRole("interactiveGuide").get(0);
		String flightFinderWSDL = choreography.getRoles().get(0).getContractUri();
		
		ffMock = new WSMock("mocks/flightFinder", "9002", flightFinderWSDL,  true);
		Item flighInfoResponse = getFlightInfoResponse();
		
		MockResponse response = new MockResponse().whenReceive("*").replyWith(flighInfoResponse);
		ffMock.returnFor("getFlightInfo", response);
		ffMock.start();
		
		client = interactiveGuide.getWSClient();
	}
	
	@AfterClass
	public static void tearDown() throws Exception{
		ffMock.stop();
	}
	
	@Test
	public void shouldReturnAConfirmationMessageWhenAskForLocationCalculation() throws Exception {
		Item response = client.request("calculateLocations", "A1");
		
		assertEquals("Calculation in progress", response.getChild("return").getContent());
	}

	@Test
	public void shouldSendIdPassengerToFlightFinderWhenAskForLocationCalculation() throws Exception {
		client.request("calculateLocations", "A1");
		List<Item> messages = ffMock.getInterceptedMessages();
		
		assertEquals("A1", messages.get(0).getChild("arg0").getContent());
	}
	
	
	@Test
	public void shouldRetrieveTheWholeLocationAfterSetCarParkInfo() throws Exception {
		client.request("calculateLocations", "A1");
		client.request("setCarParkInfo", getCarParkInfo());
		Item response = client.request("getFlightAndCarParkLocation", "A1");
		
		String expectedMessage = "You have to go to terminal 8" + ";" + "Turn the first right and Go straight for 2 blocks ; Park your car in vacancy J123"; 
		assertEquals(expectedMessage, response.getChild("return").getContent());
	}
	
	private static Item getFlightInfoResponse(){
		Item getFlightInfoResponse = new ItemImpl("getFlightInfoResponse"); 
		Item flightInformation = getFlightInfoResponse.addChild("return"); 
		
		flightInformation.addChild("id").setContent("A1234"); 
		flightInformation.addChild("time").setContent("130p"); 
		flightInformation.addChild("terminal").setContent("8"); 
		flightInformation.addChild("company").setContent("AA"); 
		flightInformation.addChild("destination").setContent("Sao Paulo"); 
		
		return getFlightInfoResponse;
	}
	
	private static Item getCarParkInfo(){
		Item setCarParkInfo = new ItemImpl("setCarParkInfo"); 
		Item arg0 = setCarParkInfo.addChild("arg0");
		
		arg0.addChild("pId").setContent("A1"); 
		arg0.addChild("cpId").setContent("J123"); 
		arg0.addChild("longitude").setContent("08000"); 
		arg0.addChild("latitude").setContent("09000"); 
		
		return setCarParkInfo;
	}
		
}
