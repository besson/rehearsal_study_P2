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
//id = 0815, company = AA, destination = Paris, time = 130p, terminal = 8		
			
		Flight fl= webTrip.getFlight(id);		
		carParkReservation.setPassengerInfo(id,fl.getTerminal());
		
		FlightInfo fi=new FlightInfo();
		fi.setId(fl.getId());
		fi.setTerminal(fl.getTerminal());
		fi.setDestination(fl.getDestination());
		fi.setTime(fl.getTime());
		fi.setCompany(fl.getCompany());

				
		 //http://localhost:4321/mocks/webTrip?wsdl
		
		return fi;
	}

}
