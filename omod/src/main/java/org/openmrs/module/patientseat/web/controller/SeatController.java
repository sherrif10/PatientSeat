package org.openmrs.module.patientseat.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//import java.util.List;

//import org.hibernate.loader.custom.Return;
import org.openmrs.api.context.Context;
import org.openmrs.module.patientseat.api.Seat;
import org.openmrs.module.patientseat.api.SeatService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
//import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("module/patientseat/seat.form")
public class SeatController {
	
	/** Logger for this class and subclasses */
	protected final Log log = LogFactory.getLog(getClass());
	
	/**
	 * Initially called after the formBackingObject method to get the landing form name
	 * 
	 * @return String form view name
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return "module/patientseat/seat.form";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("seat") Seat seat, BindingResult bindingResult, HttpServletRequest request,
	        SessionStatus status) {
		if (bindingResult.hasErrors()) {
			return "module/patientseat/seat.form";
			
		} else {
			SeatService service = Context.getService(SeatService.class);
			String name = "sharif";
			seat.setName(name);
			String description = "TESTING";
			seat.setDescription(description);
			seat.setDateCreated(new Date());
			service.saveSeat(seat);
			return "redirect:/module/patientseat/seat.form";
		}
	}
	
}
