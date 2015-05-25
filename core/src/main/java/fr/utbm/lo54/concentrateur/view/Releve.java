package fr.utbm.lo54.concentrateur.view;

import java.util.Date;

/**
 * @version 01.00.00
 *
 * @author Jeremy - V01.00.00
 * @date 25 mai 2015<br>
 *
 */
public class Releve {

	/*----------------------*/
	private long areaId;
	private String areaName;
	private long sensorId;
	private String sensorName;
	private float tempVal;
	private Date date;
	/*----------------------*/

	public Releve() {
		super();
	}

	public Releve(	final long areaId,
					final String areaName,
					final long sensorId,
					final String sensorName,
					final float tempVal,
					final Date date) {
		super();
		this.areaId = areaId;
		this.areaName = areaName;
		this.sensorId = sensorId;
		this.sensorName = sensorName;
		this.tempVal = tempVal;
		this.date = date;
	}

	/*----------- GETTERS & SETTERS -----------*/

	public long getAreaId() {
		return areaId;
	}

	public void setAreaId(final long areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(final String areaName) {
		this.areaName = areaName;
	}

	public long getSensorId() {
		return sensorId;
	}

	public void setSensorId(final long sensorId) {
		this.sensorId = sensorId;
	}

	public String getSensorName() {
		return sensorName;
	}

	public void setSensorName(final String sensorName) {
		this.sensorName = sensorName;
	}

	public float getTempVal() {
		return tempVal;
	}

	public void setTempVal(final float tempVal) {
		this.tempVal = tempVal;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

	public Releve getReleve() {
		return this;
	}
}
