package org.openmrs.module.patientseat.api.dao;

import java.util.List;

import org.openmrs.api.db.DAOException;
import org.openmrs.module.patientseat.api.Seat;

/*
 * Database methods for the seatService
 */
public interface SeatDao {
	
	public Seat saveSeat(Seat seat) throws DAOException;
	
	public Seat getSeat(Seat seat) throws DAOException;
	
	public void deleteSeat(Seat seat) throws DAOException;
	
	public List<Seat> getAllSeats(boolean includeVoided) throws DAOException;
	
	public Seat getSeatByUuid(String uuid);
	
}
