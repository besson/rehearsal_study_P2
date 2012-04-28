package eu.choreos.common;

import eu.choreos.vv.abstractor.Choreography;
import eu.choreos.vv.abstractor.Service;
import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.ItemImpl;
import eu.choreos.vv.servicesimulator.MockResponse;
import eu.choreos.vv.servicesimulator.WSMock;

public class MockDeployer {
	
	private static WSMock webTripMock;
	
	public static void deployWebTripMock(Choreography choreography) throws Exception{
		Service flightFinder = choreography.getServicesForRole("flightFinder").get(0);		
		
		//Retrieve the wsdl uri of the car parking ws
		Service service = flightFinder.getServicesForRole("flightFinder").get(0);
		String webTripWSDL = service.getUri();
		
		// create the Mock here
		webTripMock = new WSMock("mocks/webTrip", "4321", webTripWSDL, true);
		
		MockResponse response = new MockResponse().whenReceive("A1").replyWith(getFligthResponse());
		
		webTripMock.returnFor("getFlight", response);
		webTripMock.start();
	}
	
	public static void undeploy(){
		webTripMock.stop();
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
