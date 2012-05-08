package eu.choreos.wsclient;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import eu.choreos.ServiceDeployer;
import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.ItemImpl;
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
		
		//fail();
	}
	
	@Test
	public void shouldReturnTheTimeForSaoPaulo() throws Exception {
		WSClient client = new WSClient(WSDL);

		//Item response = new ItemImpl("getWeatherResponse");
		//Item return1 = response.getChild("return");
		
		Item response = client.request("getWeather","Brazil", "Sao Paulo");
		Item return1 = response.getChild("return");
		
		String time = return1.getContent("time");
		assertEquals("03:00 PM", time);
	}
	
	@Test
	public void shouldReturnTheRelativeHumidityForSaoPaulo() throws Exception {
		WSClient client = new WSClient(WSDL);

		Item response = client.request("getWeather","Brazil", "Sao Paulo");
		Item return1 = response.getChild("return");
		
		String time = return1.getContent("relativeHumidity");
		assertEquals("77%", time);
	}	
	
	@Test
	public void shouldReturnTheTemperatureForSaoPaulo() throws Exception {
		WSClient client = new WSClient(WSDL);
		
		Item response = client.request("getWeather","Brazil", "Sao Paulo");
		Item return1 = response.getChild("return");
		
		String temperature = return1.getContent("temperature");
		assertEquals("21C", temperature);
	}

}
