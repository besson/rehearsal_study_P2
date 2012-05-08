package eu.choreos.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.carsolutions.ParkSafe;

@WebService
public class CarParkingWS {

	@WebMethod
	public String getCarParkCode (String customerId, String terminal){		
		return "J123";
	}
	
	@WebMethod
	public String getLatitude (String carParkId){
		
		return "23 32 S";
	}
	
	public String getLongitude (String carParkId){
		
		return "46 37 W";
	}
}
