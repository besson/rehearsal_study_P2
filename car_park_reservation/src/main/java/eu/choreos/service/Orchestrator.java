package eu.choreos.service;

import org.osoa.sca.annotations.Reference;

import eu.choreos.CarParkEntry;
import eu.choreos.ObjectFactory;
import eu.choreos.api.CarParkReservation;
import eu.choreos.api.InteractiveGuidePortType;

public class Orchestrator implements CarParkReservation{
	
	@Reference
	private CarParkingWS carParking;
	
	@Reference
	private InteractiveGuidePortType interactiveGuide;

	@Override
	public String setPassengerInfo(String id, String terminal) {
		String carParkCode = carParking.getCarParkCode(id, terminal);
		String latitude = carParking.getLatitude(id);
		String longitude = carParking.getLongitude(id);
		
		CarParkEntry entry = buildCarParkEntry(id, carParkCode, latitude, longitude);
		
		interactiveGuide.setCarParkInfo(entry);
		return "OK";
	}

	private CarParkEntry buildCarParkEntry(String passengerId, String carParkId,
			String latitude, String longitude) {
	
		ObjectFactory factory = new ObjectFactory();
		CarParkEntry entry = factory.createCarParkEntry();

		entry.setCpId(factory.createCarParkEntryCpId(carParkId));
		entry.setPId(factory.createCarParkEntryPId(passengerId));
		entry.setLatitude(factory.createCarParkEntryLatitude(latitude));
		entry.setLongitude(factory.createCarParkEntryLongitude(longitude));
		return entry;
	}
}
