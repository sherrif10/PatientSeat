package org.openmrs.module.patientseat.api;

import java.util.List;

import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.patientseat.Seat;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SeatService extends OpenmrsService {
	
	/**
	 * Seat objects fetch and insertion in DB
	 */
	
	public Seat saveSeat(Seat seat) throws APIException;
	
	public List<Seat> getAllSeats() throws APIException;
	
	public Seat getSeatByName(String name) throws APIException;
	
	public void deleteSeat(Seat seat) throws APIException;
	
	public Seat getSeatById(Integer seat_id) throws APIException;
	
}
