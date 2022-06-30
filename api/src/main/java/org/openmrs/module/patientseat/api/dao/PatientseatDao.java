/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.patientseat.api.dao;

import java.util.List;

import org.openmrs.Location;
import org.openmrs.Patient;
import org.openmrs.api.db.DAOException;
import org.openmrs.module.patientseat.api.model.Seat;

public interface PatientseatDao {
	
	//get seat for the patients
	/**
	 * Saves a new seat or updates an existing seat. If an existing seat, this method will
	 * automatically apply seat.
	 * 
	 * @param seat to be saved
	 * @throws DAOException <strong>Should</strong> save seat with basic details
	 *             <strong>Should</strong> update seat successfully <strong>Should</strong> not
	 *             overwrite creator if non null <strong>Should</strong> fail if user is not
	 *             supposed to edit seat of type of given seat
	 */
	public Seat saveSeat(Seat seat) throws DAOException;
	
	/**
	 * Get seat by internal identifier
	 */
	public Seat getSeatById(Integer seatId) throws DAOException;
	
	public Seat getSeatByName(String name) throws DAOException;
	
	public List<Seat> getSeatByPatient(Patient patient) throws DAOException;
	
	public List<Seat> getSeat(Patient who, Location loc, boolean includeVoided) throws DAOException;
	
	/**
	 * Voiding a seat essentially removes it from circulation
	 * 
	 * @param seat object to void
	 */
	public Seat voidSeat(Seat seat, String reason) throws DAOException;
	
}
