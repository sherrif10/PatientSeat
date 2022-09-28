package org.openmrs.module.patientseat.api;

import java.util.List;

import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.patientseat.api.dao.SeatDao;

public interface SeatService extends OpenmrsService {
	
	public void setSeatDao(SeatDao dao);
	
	public Seat saveSeat(Seat seat) throws APIException;
	
	public Seat getSeat(String seat) throws APIException;
	
	public Seat getSeatByUuid(String uuid) throws APIException;
	
	public List<Seat> getAllSeats(boolean includeVoided) throws APIException;
	
	public void deleteSeat(Seat seat) throws APIException;
	
}
