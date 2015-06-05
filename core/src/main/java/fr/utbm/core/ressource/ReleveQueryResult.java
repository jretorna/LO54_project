package fr.utbm.core.ressource;

public class ReleveQueryResult {
	
	private String areaName;
	private int areaId;
	
	private int staId;
	private String staLabel;
	
	private String sensorName;
	private int sensorId;
	
	private Float tempVal;
	
	public String getAreaName() {
		return areaName;
	}
	
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	
	public int getStaId() {
		return staId;
	}
	
	public void setStaId(int staId) {
		this.staId = staId;
	}

	public String getStaLabel() {
		return staLabel;
	}

	public void setStaLabel(String staLabel) {
		this.staLabel = staLabel;
	}

	public String getSensorName() {
		return sensorName;
	}

	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	public int getSensorId() {
		return sensorId;
	}

	public void setSensorId(int sensorId) {
		this.sensorId = sensorId;
	}

	public Float getTempVal() {
		return tempVal;
	}
	
	public void setTempVal(Float tempVal) {
		this.tempVal = tempVal;
	}

	@Override
	public String toString() {
		return "Releve [areaName=" + areaName + ", areaId=" + areaId
				+ ", sensorName=" + sensorName + ", sensorId=" + sensorId
				+ ", tempVal=" + tempVal + "]";
	}
}
