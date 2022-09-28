package org.openmrs.module.patientseat.web.controller;

import java.util.Date;
//import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//import java.util.List;

//import org.hibernate.loader.custom.Return;
import org.openmrs.api.context.Context;
import org.openmrs.module.patientseat.api.Seat;
import org.openmrs.module.patientseat.api.SeatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.validation.BindingResult;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
//import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("module/patientseat/seat.form")
public class SeatController {
	
	public List<Seat> populateSeat() {
		return (List<Seat>) Context.getService(SeatService.class).getAllSeats();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showSeats() {
		ModelMap model = new ModelMap();
		List<Seat> seats = Context.getService(SeatService.class).getAllSeats();
		if (seats != null)
			model.addAttribute("seat", seats);
		return new ModelAndView("/module/patientseat/seat", model);
	}
	
	/** Logger for this class and subclasses */
	protected final Log log = LogFactory.getLog(getClass());
	
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
