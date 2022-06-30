package org.openmrs.module.patientseat.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.openmrs.BaseOpenmrsData;
import org.openmrs.Location;
import org.openmrs.Patient;

@Entity
@Table(name = "seat")
@BatchSize(size = 25)
public class Seat extends BaseOpenmrsData implements Serializable {
	
	public static final long serialVersionUID = 2L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seat_id")
	private Integer seatId;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;
	
	/** default constructor */
	public Seat() {
	}
	
	/**
	 * @param seatId <strong>Should</strong> set seat id
	 */
	public Seat(Integer seatId) {
		this.seatId = seatId;
	}
	
	// Property accessors
	/**
	 * @return Returns the seatId.
	 */
	public Integer getSeatId() {
		return seatId;
	}
	
	/**
	 * @param seatId The seatId to set.
	 */
	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}
	
	/**
	 * @return Returns the seatId.
	 */
	public String getSeatName() {
		return getSeatName();
	}
	
	/**
	 * @param seatId The seatName to set.
	 */
	public void setSeatName(String name) {
		this.name = name;
	}
	
	/**
	 * @return Returns the location.
	 */
	public Location getLocation() {
		return location;
	}
	
	/**
	 * @param location The location to set.
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
	
	/**
	 * @return Returns the patient.
	 */
	public Patient getPatient() {
		return patient;
	}
	
	/**
	 * @param patient The patient to set.
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	@Override
	public Integer getId() {
		return getId();
	}
	
	@Override
	public void setId(Integer seatId) {
		this.seatId = seatId;
	}
	
	/**
	 * @see java.lang.Object#toString() <strong>Should</strong> not fail with empty object
	 */
	public String toString() {
		String ret = "";
		ret += seatId == null ? "(no ID) " : seatId.toString() + " ";
		ret += this.getSeatName() == null ? "(string) " : this.getSeatName() + " ";
		ret += this.getLocation() == null ? "(no Location) " : this.getLocation().getName() + " ";
		ret += this.getPatient() == null ? "(no Patient) " : this.getPatient().getPatientId().toString() + " ";
		return "Seat: [" + ret + "]";
	}
	
}
