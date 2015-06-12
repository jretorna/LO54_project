package fr.utbm.core.service;

import java.util.List;

import fr.utbm.core.entity.Area;
import fr.utbm.core.entity.Sensor;
import fr.utbm.core.entity.Station;
import fr.utbm.core.entity.Temperature;
import fr.utbm.core.ressource.Releve;
import fr.utbm.core.ressource.ReleveParameter;
import fr.utbm.core.ressource.ReleveQueryResult;
import fr.utbm.core.service.impl.IJaxb;

public interface IReleveService {
	public void addArea(Area area);
	
	public void addStation(Station station);
	
	public void addSensor(Sensor sensor);
	
	public void addTemperature(Temperature temp);
	public void deleteTemperature(Temperature temp);
	
	public void registerReleve(Releve releve);
	public List<ReleveQueryResult> listReleve();
	public List<ReleveQueryResult> listReleveByFilter(Float flt_min, 
			Float flt_max,
			String date_deb,
			String date_fin,
			String station,
			String area,
			String capteur);
	
	public String saveFile(byte[] fileBytes);
	public Releve jaxbGet(String releveXmlFileFullName);
	public String jaxbSerialiseReleve(Releve releve, String rootPath);
	
	public IJaxb<ReleveParameter> getJaxbParamService();
	public String jaxbSerialiseParam(ReleveParameter releveParam);
	
}
