package org.openmrs.module.patientseat.api.impl;

import java.util.List;

import org.openmrs.api.APIException;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.patientseat.Seat;
import org.openmrs.module.patientseat.api.SeatService;
import org.openmrs.module.patientseat.api.dao.SeatDao;

public class SeatServiceImpl extends BaseOpenmrsService implements SeatService {
	
	public SeatServiceImpl() {
		
	}
	
	protected SeatDao dao;
	
	public void SeatDao(SeatDao dao) throws APIException {
		this.dao = dao;
	}
	
	public Seat saveSeat(Seat seat) throws APIException {
		return dao.saveSeat(seat);
	}
	
	public List<Seat> getAllSeats() throws APIException {
		return dao.getAllSeats();
	}
	
	public Seat getSeatByName(Seat name) throws APIException {
		return dao.getSeatByName(name);
	}
	
	public Seat getSeatById(Integer seat_id) throws APIException {
		return dao.getSeatById(seat_id);
	}
	
	public void deleteSeat(Seat seat) throws APIException {
		dao.deleteSeat(seat);
	}
	
	@Override
	public Seat SaveLab(Seat seat) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Seat getSeatByName(String name) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}
}
