package eu.choreos.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.carsolutions.ParkSafe;

@WebService
public class CarParkingWS {
	
	@WebMethod
	public String getCarParkCode (String customerId, String terminal){
		ParkSafe park = new ParkSafe();
		return park.getCarParkPlace(customerId, terminal);
	}
	
	@WebMethod
	public String getLatitude (String carParkId){
		ParkSafe park = new ParkSafe();
		return park.getLatitude(carParkId);
	}
	
	@WebMethod
	public String getLongitude (String carParkId){
		ParkSafe park = new ParkSafe();
		return park.getLongitude(carParkId);
	}
}
