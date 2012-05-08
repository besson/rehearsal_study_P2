package eu.choreos.mocking;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import eu.choreos.ServiceDeployer;
import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.ItemImpl;
import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.servicesimulator.MockResponse;
import eu.choreos.vv.servicesimulator.WSMock;

public class GlobalWeatherMockTest {
	
	final String WSDL = "http://localhost:9876/globalWeather?wsdl";
	
	@BeforeClass
	public static void setUp(){
		ServiceDeployer.deploy();
	}
	
	@AfterClass
	public static void tearDown(){
		ServiceDeployer.undeploy();
	}
	
	@Test
	public void shouldReturnTheWeatherOfOtherCountry() throws Exception {
		/** 1. Create a mock for the global weather service and choose your own WeatherResult values (use the buildWeatherResult method)
		 *  2. Using WSClient, invoke the created mock and then validated the response
		 *  
		 *  Configure the mock to use the port 6789)
		 **/
		
		Item response = buildWeatherResult("Mar 30, 2012", "05:00 PM", "Sao Paulo/Congonhas Airport, Brazil", "77%", "21C");
		
		WSMock mock = new WSMock("getWeather", "6789", WSDL);
		mock.start();
		
		MockResponse resp = new MockResponse().whenReceive("Brazil", "Sao Paulo").replyWith(response);
		
		
		mock.returnFor("getWeather", resp);
		
		WSClient client = new WSClient(mock.getWsdl());
		
		Item result = client.request("getWeather", "Brazil", "Sao Paulo");
		
		assertEquals(response.getChild("return").getContent("time"), result.getChild("return").getContent("time"));
	}
	
	private Item buildWeatherResult(String date, String time, String location, String relativeHuminity, String temperature){
		Item getWeatherResponse = new ItemImpl("getWeatherResponse");
		Item result = getWeatherResponse.addChild("return");
		
		result.addChild("date").setContent(date);
		result.addChild("time").setContent(time);
		result.addChild("location").setContent(location);
		result.addChild("relativeHumidity").setContent(relativeHuminity);
		result.addChild("temperature").setContent(temperature);
		
		return getWeatherResponse;
	}

}
