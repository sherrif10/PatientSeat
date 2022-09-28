package org.openmrs.module.patientseat.api.impl;

import java.util.List;

import org.openmrs.api.APIException;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.patientseat.api.Seat;
import org.openmrs.module.patientseat.api.SeatService;
import org.openmrs.module.patientseat.api.dao.SeatDao;

public class SeatServiceImpl extends BaseOpenmrsService implements SeatService {
	
	public SeatServiceImpl() {
	}
	
	protected SeatDao dao;
	
	@Override
	public void setSeatDao(SeatDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Seat saveSeat(Seat seat) throws APIException {
		return dao.saveSeat(seat);
	}
	
	@Override
	public Seat getSeatByUuid(String uuid) throws APIException {
		return dao.getSeatByUuid(uuid);
	}
	
	@Override
	public Seat getSeat(Integer seatId) throws APIException {
		return dao.getSeat(seatId);
	}
	
	@Override
	public List<Seat> getAllSeats() throws APIException {
		return dao.getAllSeats();
	}
	
	@Override
	public void deleteSeat(Integer id) throws APIException {
		dao.deleteSeat(id);
	}
	
	@Override
	public Seat getSeatByName(String name) {
		return dao.getSeatByName(name);
	}
	
}
