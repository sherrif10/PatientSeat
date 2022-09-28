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
	
	public Seat getSeat(Seat seat) throws APIException {
		return dao.getSeat(seat);
	}
	
	@Override
	public Seat getSeatByUuid(String uuid) throws APIException {
		return dao.getSeatByUuid(uuid);
	}
	
	public List<Seat> getAllSeats(boolean includeVoided) throws APIException {
		return dao.getAllSeats(includeVoided);
	}
	
	@Override
	public void deleteSeat(Seat seat) throws APIException {
		dao.deleteSeat(seat);
	}
	
	@Override
	public Seat getSeat(String seat) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
