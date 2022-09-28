package org.openmrs.module.patientseat.api;

import java.util.List;

import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.patientseat.api.dao.SeatDao;
import org.springframework.transaction.annotation.Transactional;

public interface SeatService extends OpenmrsService {
	
	public void setSeatDao(SeatDao dao);
	
	public Seat saveSeat(Seat seat) throws APIException;
	
	@Transactional(readOnly = true)
	@Authorized(value = { "Seat", "Test Seat" }, requireAll = false)
	public Seat getSeat(Integer seatId) throws APIException;
	
	@Transactional(readOnly = true)
	@Authorized(value = { "Seat", "Test Seats" }, requireAll = false)
	public Seat getSeatByUuid(String uuid) throws APIException;
	
	@Transactional(readOnly = true)
	@Authorized(value = { "Seat", "Test Seat" }, requireAll = false)
	public List<Seat> getAllSeats() throws APIException;
	
	/**
	 * Removes a specific seat from the database
	 * 
	 * @param seatId the seatId of the seat to remove
	 */
	public void deleteSeat(Integer id) throws APIException;
	
	@Transactional(readOnly = true)
	@Authorized(value = { "Seat", "Test Seatss" }, requireAll = false)
	public Seat getSeatByName(String name);
	
}
