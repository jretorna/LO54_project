package fr.utbm.core.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sensor")
public class Sensor implements java.io.Serializable {

	/*--------------*/
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "Sen_Id")
	private int senId;
	@Column(name = "Sen_Label")
	private String senLabel;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "Sta_Id", referencedColumnName = "Sta_Id")
	private Station station;
	/*@OneToMany(mappedBy = "sensor", targetEntity = Temperature.class, fetch=FetchType.LAZY)
	private List<Temperature> temperatures;*/

	/*--------------*/
	/**
	 * Default Constructor
	 */
	public Sensor() {
		// Do nothing
	}

	/**
	 * Constructor
	 */

	public Sensor(final int senId, final String senLabel, final Station _station) {
		super();
		this.senId = senId;
		this.senLabel = senLabel;
		this.station = _station;
	}

	/*------- Getters & Setters ------*/

	public int getSenId() {
		return senId;
	}

	public void setSenId(final int senId) {
		this.senId = senId;
	}

	public String getSenLabel() {
		return senLabel;
	}

	public void setSenLabel(final String senLabel) {
		this.senLabel = senLabel;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(final Station station) {
		this.station = station;
	}

	/*
	public Collection<Temperature> getTemperatures() {
		return temperatures;
	}

	public void setTemperatures(final List<Temperature> temperatures) {
		this.temperatures = temperatures;
	}*/

}
