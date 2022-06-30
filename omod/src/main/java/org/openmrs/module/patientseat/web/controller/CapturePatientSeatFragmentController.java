package org.openmrs.module.patientseat.web.controller;

import org.openmrs.Location;
import org.openmrs.Patient;
import org.openmrs.api.APIException;
import org.openmrs.api.context.Context;
import org.openmrs.module.patientseat.api.PatientseatService;
import org.openmrs.module.patientseat.api.model.Seat;
import org.openmrs.ui.framework.SimpleObject;
import org.openmrs.ui.framework.UiUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;

public class CapturePatientSeatFragmentController {
	
	private static final String name = null;
	
	private PatientseatService patientseatService;
	
	public CapturePatientSeatFragmentController() {
		patientseatService = Context.getService(PatientseatService.class);
	}
	
	public Seat post(UiUtils uiUtils, @RequestParam("patientId") Patient patient, Location location,
	        @RequestParam(value = "seat", required = false) Integer seatId) {
		//public static final  String NAME = "sharif";
		Seat seat = new Seat();
		//set the attributes needed
		seat.setPatient(patient);
		seat.setLocation(location);
		seat.setId(seatId);
		seat.setSeatName(name);
		//save the object back to the database
		seat = patientseatService.saveSeat(seat);
		return seat;
	}
	
	// private Seat postSeatWithDefaultValues(Patient patient,  Integer seatId, Location location) {
	//     //  public static final  String NAME = "sharif";
	//     Seat seat = new Seat();
	//     //set the attributes needed
	// 	seat.setPatient(patient);
	//     seat.setLocation(location);
	//     seat.setId(seatId);
	//     seat.setSeatName(name);
	//     seat = patientseatService.saveSeat(seat);
	//     return seat;
	// }
	
	public Object postEmptySeat(UiUtils uiUtils, Patient patient) {
		
		SimpleObject simpleObject = new SimpleObject();
		try {
			//Seat seat = postSeatWithDefaultValues(patient, 0,0,uiSessionContext.getSessionLocation());
			simpleObject.put("status", HttpStatus.ACCEPTED);
			
		}
		catch (APIException ex) {
			simpleObject.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
			simpleObject.put("response", "Failed: " + ex.getMessage());
		}
		
		return simpleObject;
	}
	
}
