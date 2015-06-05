package fr.utbm.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;

@Entity
@Table(name="sensor")
@XmlRootElement
public class Sensor implements java.io.Serializable {

	/*--------------*/
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Sen_Id")
	private int senId;
	@Column(name = "Sen_Label")
	private String senLabel;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "Sta_Id", referencedColumnName = "Sta_Id")
	private Station station;
	@OneToMany(mappedBy = "sensor", targetEntity = Temperature.class, fetch=FetchType.LAZY)
	private List<Temperature> temperatures;

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
	
	@XmlElement
	public void setSenId(final int senId) {
		this.senId = senId;
	}

	public String getSenLabel() {
		return senLabel;
	}

	@XmlElement
	public void setSenLabel(final String senLabel) {
		this.senLabel = senLabel;
	}

	public Station getStation() {
		return station;
	}
	
	@XmlElement
	public void setStation(final Station station) {
		this.station = station;
	}

	public List<Temperature> getTemperatures() {
		return temperatures;
	}

	public void setTemperatures(List<Temperature> temperatures) {
		this.temperatures = temperatures;
	}


}
