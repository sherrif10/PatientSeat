package org.openmrs.module.patientseat.api.dao.hibernate;

import org.openmrs.api.db.DAOException;
import org.openmrs.module.patientseat.Seat;
import org.openmrs.module.patientseat.api.dao.SeatDao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class HibernateSeatDao implements SeatDao {
	
	/**
	 * Hibernate session factory
	 */
	
	private SessionFactory sessionFactory;
	
	/**
	 * set session factory
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Seat> getAllSeats() throws DAOException {
		Criteria creteria = sessionFactory.getCurrentSession().createCriteria(Seat.class);
		return creteria.list();
	}
	
	public Seat saveSeat(Seat seat) throws DAOException {
		return (Seat) sessionFactory.getCurrentSession().merge(seat);
	}
	
	public void deleteSeat(Seat seat) throws DAOException {
		sessionFactory.getCurrentSession().delete(seat);
	}
	
	public Seat getSeatById(Integer seat_id) throws DAOException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Seat.class);
		criteria.add(Restrictions.eq("seat_id", seat_id));
		return (Seat) criteria.uniqueResult();
	}
	
	@Override
	public Seat getSeatByName(Seat seat) throws DAOException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Seat.class);
		criteria.add(Restrictions.eq("seat", seat));
		return (Seat) criteria.uniqueResult();
	}
	
}
