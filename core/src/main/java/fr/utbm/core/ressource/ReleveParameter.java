package fr.utbm.core.ressource;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReleveParameter {
	
	private int tempMin;
	private int tempMax;
	
	public int getTempMin() {
		return tempMin;
	}
	
	@XmlElement
	public void setTempMin(int tempMin) {
		this.tempMin = tempMin;
	}
	public int getTempMax() {
		return tempMax;
	}
	
	@XmlElement
	public void setTempMax(int tempMax) {
		this.tempMax = tempMax;
	}
	
	
}
