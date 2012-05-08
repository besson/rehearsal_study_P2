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
		
		final WSMock mock = new WSMock("WeatherMock", "6789", WSDL, true);
		mock.start();
		
		final Item resultDefault = buildWeatherResult("Mar 30, 2012", "03:30 PM", "Joao Pessoa, Brazil", "95%", "32C");
		final MockResponse responseDefault = new MockResponse().whenReceive("*").replyWith(resultDefault);
		
		final Item resultDresdenGer = buildWeatherResult("Mai 01, 2012", "04:30 PM", "Dresden, Germany", "30%", "25C");
		final MockResponse responseDresden = new MockResponse().whenReceive("Dresden", "Germany").replyWith(resultDresdenGer);
		
		//final Item resultGer = buildWeatherResult("Mai 01, 2012", "04:30 PM", "Berlin, Germany", "30%", "25C");
		//final MockResponse responseGer = new MockResponse().whenReceive("XXX", "Germany").replyWith(resultGer);
		
		mock.returnFor("getWeather", responseDresden, responseDefault);
		
		final WSClient client = new WSClient(mock.getWsdl());
		
		final Item resultDefaultItem = client.request("getWeather", "foo", "bar");
		assertEquals(resultDefaultItem.getChild("return").getChild("location").getContent(), "Joao Pessoa, Brazil");
		
		final Item resultDresdenGerItem = client.request("getWeather", "Dresden", "Germany");
		assertEquals(resultDresdenGerItem.getChild("return").getChild("location").getContent(), "Dresden, Germany");
		assertEquals(resultDresdenGerItem.getChild("return").getChild("temperature").getContent(), "25C");

		//final Item resultGerItem = client.request("getWeather", "XXX", "Germany");
		//assertEquals(resultGerItem.getChild("return").getChild("location").getContent(), "Berlin, Germany");
		//assertEquals(resultGerItem.getChild("return").getChild("temperature").getContent(), "25C");
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
