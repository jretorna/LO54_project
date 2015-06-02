package fr.utbm.core.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="temperature")
public class Temperature implements java.io.Serializable {
	/*--------------*/
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Tmp_Id")
	private int tmpId;
	@Column(name = "Tmp_Value")
	private Float tmpValue;
	@Column(name = "Tmp_Date")
	private Date tmpDate;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "Sen_Id", referencedColumnName = "Sen_Id")
	Sensor sensor;
	/*--------------*/

	/**
	 * Default Constructor
	 */
	public Temperature() {
		// Do nothing
	}

	/**
	 * Constructor
	 */
	public Temperature(	final int tmpId,
						final Float tmpValue,
						final Date tmpDate,
						final Sensor _sensor) {
		super();
		this.tmpId = tmpId;
		this.tmpValue = tmpValue;
		this.tmpDate = tmpDate;
		this.sensor = _sensor;
	}

	/*------- Getters & Setters ------*/

	public int getTmpId() {
		return tmpId;
	}

	public void setTmpId(final int tmpId) {
		this.tmpId = tmpId;
	}

	public Float getTmpValue() {
		return tmpValue;
	}

	public void setTmpValue(final Float tmpValue) {
		this.tmpValue = tmpValue;
	}

	public Date getTmpDate() {
		return tmpDate;
	}

	public void setTmpDate(final Date tmpDate) {
		this.tmpDate = tmpDate;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(final Sensor sensor) {
		this.sensor = sensor;
	}

}
