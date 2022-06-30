/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.patientseat.api.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Location;
import org.openmrs.Patient;
import org.openmrs.api.APIException;
import org.openmrs.api.UserService;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.patientseat.Item;
import org.openmrs.module.patientseat.api.PatientseatService;
import org.openmrs.module.patientseat.api.dao.PatientseatDao;
import org.openmrs.module.patientseat.api.model.Seat;

/**
 * Implementations of business logic methods for PatientSeat
 */
public class PatientseatServiceImpl extends BaseOpenmrsService implements PatientseatService {
	
	protected static final Log log = LogFactory.getLog(PatientseatServiceImpl.class);
	
	PatientseatDao dao;
	
	UserService userService;
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	public void setDao(PatientseatDao dao) {
		this.dao = dao;
	}
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public Item getItemByUuid(String uuid) throws APIException {
		return ((PatientseatService) dao).getItemByUuid(uuid);
	}
	
	@Override
	public Item saveItem(Item item) throws APIException {
		if (item.getOwner() == null) {
			item.setOwner(userService.getUser(1));
		}
		
		return ((PatientseatService) dao).saveItem(item);
	}
	
	@Override
	public Seat saveSeat(Seat seat) throws APIException {
		return dao.saveSeat(seat);
	}
	
	@Override
	public Seat getSeat(Integer seatId) throws APIException {
		return dao.getSeatById(seatId);
	}
	
	@Override
	public Seat getSeatByName(String name) throws APIException {
		return dao.getSeatByName(name);
	}
	
	@Override
	public List<Seat> getSeatByPatient(Patient patient) {
		return dao.getSeatByPatient(patient);
	}
	
	@Override
	public List<Seat> getSeat(Patient who, Location loc, boolean includeVoided) {
		return dao.getSeat(who, loc, includeVoided);
	}
	
	@Override
	public Seat voidSeat(Seat seat, String reason) {
		return dao.voidSeat(seat, reason);
	}
}
