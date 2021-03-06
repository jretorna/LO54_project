package fr.utbm.core.entity;

import java.util.Date;
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
@Table(name="station")
@XmlRootElement
public class Station implements java.io.Serializable {

	/*--------------*/
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Sta_Id")
	private int staId;
	@Column(name = "Sta_Label")
	private String staLabel;
	@Column(name = "Sta_LastCom")
	private Date staLastCom;
	@Column(name = "Sta_Valid")
	private boolean stavalide;
	@OneToMany(mappedBy = "station", targetEntity = Sensor.class, fetch=FetchType.LAZY)
	private List<Sensor> sensors;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "Are_Id", referencedColumnName = "Are_Id")
	private Area area;
	/*--------------*/

	/**
	 * Default Constructor
	 */
	public Station() {
		// Do nothing
	}

	/**
	 * Constructor
	 * 
	 * @param staId
	 * @param staLabel
	 * @param staLastCom
	 * @param stavalide
	 */

	public Station(	final int staId,
					final String staLabel,
					final Date staLastCom,
					final boolean stavalide,
					final Area _area) {
		super();
		this.staId = staId;
		this.staLabel = staLabel;
		this.staLastCom = staLastCom;
		this.stavalide = stavalide;
		this.area = _area;
	}

	/*------- Getters & Setters ------*/

	public int getStaId() {
		return staId;
	}
	
	@XmlElement
	public void setStaId(final int staId) {
		this.staId = staId;
	}

	public String getStaLabel() {
		return staLabel;
	}

	@XmlElement
	public void setStaLabel(final String staLabel) {
		this.staLabel = staLabel;
	}

	public Date getStaLastCom() {
		return staLastCom;
	}

	@XmlElement
	public void setStaLastCom(final Date staLastCom) {
		this.staLastCom = staLastCom;
	}

	public boolean getStavalide() {
		return stavalide;
	}

	@XmlElement
	public void setStavalide(final boolean stavalide) {
		this.stavalide = stavalide;
	}
	/*
	public Collection<Sensor> getSensors() {
		return sensors;
	}

	public void setSensors(final List<Sensor> sensors) {
		this.sensors = sensors;
	}*/

	public Area getArea() {
		return area;
	}
	
	@XmlElement
	public void setArea(final Area area) {
		this.area = area;
	}
}
