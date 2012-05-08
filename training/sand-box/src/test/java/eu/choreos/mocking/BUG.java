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
		
		WSMock mock = new WSMock("GlobalWeatherWS", "6789", WSDL, true);
		mock.start();
		
		Item esperado = buildWeatherResult("Mar 30, 2012", "03:00 PM", "Sao Paulo/Congonhas Airport, Brazil", "77%", "21C");
		Item resposta1 = buildWeatherResult("asdf", "03asdf0 PM", "Sao Paulo/Casdfongonhas Airport, Brazil", "77asdf%", "2asdf1C");
		Item resposta2 = buildWeatherResult("fora", "03asdf0 PM", "Sao Paulo/Casdfongonhas Airport, Brazil", "77asdf%", "2asdf1C");
		MockResponse response = new MockResponse().whenReceive("Brazil", "Sao Paulo").replyWith(esperado);
		MockResponse response2 = new MockResponse().whenReceive("*", "*").replyWith(resposta1);
		MockResponse response3 = new MockResponse().whenReceive("Brazil", "*").replyWith(resposta2);
		mock.returnFor("getWeather", response,response2,response3);
		
		WSClient client = new WSClient("http://localhost:6789/globalWeather?wsdl");
		Item result = client.request("getWeather", "Brazil", "Sao Paulo");
		assertEquals("Mar 30, 2012",result.getChild("return").getContent("date"));
		
		client = new WSClient("http://localhost:6789/globalWeather?wsdl");
		result = client.request("getWeather", "Basdarazil", "Sao Paulo");
		assertEquals("asdf",result.getChild("return").getContent("date"));
		
		//client = new WSClient("http://localhost:6789/globalWeather?wsdl");
		//result = client.request("getWeather", "Brazil", "Santos");
		//assertEquals("Mar 30, 2012",result.getChild("return").getContent("date"));
		
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
