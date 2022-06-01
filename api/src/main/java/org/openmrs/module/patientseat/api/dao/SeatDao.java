package org.openmrs.module.patientseat.api.dao;

import java.util.List;

import org.openmrs.api.db.DAOException;
import org.openmrs.module.patientseat.Seat;

public interface SeatDao {
	
	public Seat saveSeat(Seat seat) throws DAOException;
	
	public List<Seat> getAllSeats() throws DAOException;
	
	public Seat getSeatByName(Seat seat) throws DAOException;
	
	public Seat getSeatById(Integer seat_id) throws DAOException;
	
	public void deleteSeat(Seat seat) throws DAOException;
	
}
