package org.openmrs.module.patientseat.web.controller;

import javax.servlet.http.HttpSession;

import org.openmrs.api.context.Context;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public class PatientSeatAdminPageController {
	
	public void controller(PageModel model, HttpSession session,
	        @RequestParam(value = "seatId", required = false) String seatId,
	        @RequestParam(value = "seatName", required = false) String seatName) {

	}
	
	@RequestMapping(value = "/pages/patientseat/administration.page", method = RequestMethod.GET)
	public void administrationPage(ModelMap model) {
		model.addAttribute("user", Context.getAuthenticatedUser());
	}	
}
