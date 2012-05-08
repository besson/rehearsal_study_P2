package eu.choreos.wsclient;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import eu.choreos.ServiceDeployer;
import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.WSClient;

public class GlobalWeatherTest {
	
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
	public void shouldReturnTheWeatherForSaoPaulo() throws Exception {
		
		/**
		 *  input: Brazil, Sao Paulo
		 * 
		 *  output:
		 *  location: Sao Paulo/Congonhas Airport, Brazil
		 *  date: Mar 30, 2012
		 *  time: 03:00 PM
		 *  temperature: 21C
		 *  relative humidity: 77%;
		 *  
		 */
		
		final WSClient wsClient = new WSClient(WSDL);
		final Item response = wsClient.request("getWeather", "Brazil", "Sao Paulo");	
		final Item returnItem = response.getChild("return");
				
		final String location = returnItem.getContent("location");
		final String date = returnItem.getContent("date");		
		final String time= returnItem.getContent("time");
		final String temperature = returnItem.getContent("temperature");
		final String relativeHumidity = returnItem.getContent("relativeHumidity");
				
		assertEquals(location, "Sao Paulo/Congonhas Airport, Brazil");
		assertEquals(date, "Mar 30, 2012");
		assertEquals(time, "03:00 PM");
		assertEquals(temperature, "21C");
		assertEquals(relativeHumidity, "77%");
	}
	
	@Test 
	public void temperatureForSampaShouldBe21C() throws Exception
	{
		WSClient wsClient = new WSClient(WSDL);
		
		Item response = wsClient.request("getWeather", "Brazil", "Sao Paulo");
		Item returnItem = response.getChild("return");
		String temperature = returnItem.getContent("temperature");
		
		assertEquals(temperature, "21C");
	}

}
