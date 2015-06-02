package fr.utbm.core.service;

import fr.utbm.core.entity.Area;
import fr.utbm.core.entity.Sensor;
import fr.utbm.core.entity.Station;
import fr.utbm.core.entity.Temperature;
import fr.utbm.core.ressource.Releve;

public interface IReleveService {
	public void addArea(Area area);
	
	public void addStation(Station station);
	
	public void addSensor(Sensor sensor);
	
	public void addTemperature(Temperature temp);
	public void deleteTemperature(Temperature temp);
	
	public void registerReleve(Releve releve);
	
	public String saveFile(byte[] fileBytes);
	public Releve jaxbGet(String releveXmlFileFullName);
	public String jaxbSerialiseReleve(Releve releve, String rootPath);
	
}
