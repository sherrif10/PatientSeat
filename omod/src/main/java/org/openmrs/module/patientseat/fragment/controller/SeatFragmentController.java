package org.openmrs.module.patientseat.fragment.controller;

import java.util.List;

import org.openmrs.Visit;
import org.openmrs.module.patientseat.Seat;
import org.openmrs.module.patientseat.api.SeatService;
import org.openmrs.ui.framework.SimpleObject;
import org.openmrs.ui.framework.annotation.FragmentParam;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;

public class SeatFragmentController {
	
	private SeatService seatService;
	
	private void controller(FragmentModel fragmentModel, @FragmentParam(value = "seat") Seat seat) {
		//  this.seatService= seatService;
		
		//Seat seat = new Seat();
		fragmentModel.addAttribute("seat", seat);
		
		if (seat != null) {
			seat = (Seat) seatService.getAllSeats();
		}
		((Seat) seat).getId();
		((Seat) seat).getName();
		((Seat) seat).getDescription();
	}
	
}
