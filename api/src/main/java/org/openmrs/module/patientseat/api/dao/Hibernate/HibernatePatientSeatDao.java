package org.openmrs.module.patientseat.api.dao.Hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.openmrs.Location;
import org.openmrs.Patient;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.patientseat.api.dao.PatientseatDao;
import org.openmrs.module.patientseat.api.model.Seat;

@SuppressWarnings("unused")
public class HibernatePatientSeatDao implements PatientseatDao {
	
	public DbSessionFactory getDbSessionFactory() {
		return dbSessionFactory;
	}
	
	public void setDbSessionFactory(DbSessionFactory dbSessionFactory) {
		this.dbSessionFactory = dbSessionFactory;
	}
	
	private DbSessionFactory dbSessionFactory;
	
	@Override
	public Seat saveSeat(Seat seat) throws DAOException {
		dbSessionFactory.getCurrentSession().saveOrUpdate(seat);
		return seat;
	}
	
	@Override
	public Seat getSeatById(Integer seatId) throws DAOException {
		return (Seat) dbSessionFactory.getCurrentSession().get(Seat.class, seatId);
	}
	
	@Override
	public Seat getSeatByName(String name) throws DAOException {
		return (Seat) dbSessionFactory.getCurrentSession().get(Seat.class, name);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Seat> getSeatByPatient(Patient patient) throws DAOException {
		//use creteria
		Criteria criteria = dbSessionFactory.getCurrentSession().createCriteria(Seat.class);
		criteria.add(Restrictions.eq("patient", patient));
		return criteria.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Seat> getSeat(Patient who, Location loc, boolean includeVoided) throws DAOException {
		Criteria criteria = dbSessionFactory.getCurrentSession().createCriteria(Seat.class);
		criteria.add(Restrictions.eq("voided", includeVoided));
		
		if (who != null) {
			criteria.add(Restrictions.eq("patient", who));
		}
		if (loc != null) {
			criteria.add(Restrictions.eq("location", loc));
		}
		return criteria.list();
	}
	
	@Override
	public Seat voidSeat(Seat seat, String reason) throws DAOException {
		Seat seatFound = (Seat) dbSessionFactory.getCurrentSession().get(Seat.class, seat);
		seatFound.setVoided(true);
		dbSessionFactory.getCurrentSession().saveOrUpdate(getSeat(null, null, false));
		return seat;
	}
	
}
