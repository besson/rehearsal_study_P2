package eu.choreos.service;


import org.osoa.sca.annotations.Reference;

import com.safetrip.service.Flight;
import com.safetrip.service.WebTrip;

import eu.choreos.api.CarParkReservationPortType;
import eu.choreos.api.FlightFinder;
import eu.choreos.model.FlightInfo;

public class Orchestrator implements FlightFinder{

	@Reference
	WebTrip webTrip;
	
	@Reference
	CarParkReservationPortType carParkReservation;
	
	@Override
	public FlightInfo getFlightInfo(String id) {
		Flight flight = webTrip.getFlight(id);
		FlightInfo info = new FlightInfo();
		
		info.setCompany(flight.getCompany());
		info.setDestination(flight.getDestination());
		info.setId(flight.getId());
		info.setTerminal(flight.getTerminal());
		info.setTime(flight.getTime());
		
		carParkReservation.setPassengerInfo(id, info.getTerminal());
		
		return info;
		//FlightInfo flight = new FlightInfo();
		//flight.setId("0815");
		//return flight;
	}

}
