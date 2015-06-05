package fr.utbm.core.ressource;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import fr.utbm.core.entity.Area;
import fr.utbm.core.entity.Sensor;
import fr.utbm.core.entity.Station;
import fr.utbm.core.entity.Temperature;


@XmlRootElement
public class Releve {
	
	private Area area;
	private Station station;
	private Sensor sensor;
	private Temperature temperature;
	
	
	public Area getArea() {
		return area;
	}
	
	@XmlElement
	public void setArea(Area area) {
		this.area = area;
	}
	
	public Station getStation() {
		return station;
	}
	
	@XmlElement
	public void setStation(Station station) {
		this.station = station;
	}
	
	public Sensor getSensor() {
		return sensor;
	}
	
	@XmlElement
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
	
	
	public Temperature getTemperature() {
		return temperature;
	}
	
	@XmlElement
	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}
	
	/*String areaName;
	int areaId;
	
	private int staId;
	private String staLabel;
	
	String sensorName;
	int sensorId;
	
	Float tempVal;
	
	public String getAreaName() {
		return areaName;
	}
	
	@XmlAttribute
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public int getAreaId() {
		return areaId;
	}
	
	@XmlAttribute
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	
	public int getStaId() {
		return staId;
	}
	
	@XmlElement
	public void setStaId(int staId) {
		this.staId = staId;
	}

	public String getStaLabel() {
		return staLabel;
	}

	@XmlElement
	public void setStaLabel(String staLabel) {
		this.staLabel = staLabel;
	}

	public String getSensorName() {
		return sensorName;
	}

	@XmlElement
	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	public int getSensorId() {
		return sensorId;
	}

	@XmlElement
	public void setSensorId(int sensorId) {
		this.sensorId = sensorId;
	}

	public Float getTempVal() {
		return tempVal;
	}

	@XmlElement
	public void setTempVal(Float tempVal) {
		this.tempVal = tempVal;
	}

	@Override
	public String toString() {
		return "Releve [areaName=" + areaName + ", areaId=" + areaId
				+ ", sensorName=" + sensorName + ", sensorId=" + sensorId
				+ ", tempVal=" + tempVal + "]";
	}
	
	*/
	
	
}
