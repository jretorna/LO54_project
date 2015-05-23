package fr.utbm.core.service;

import java.util.List;

import fr.utbm.core.entity.Station;

public interface StationService {
	public void addStation(Station station);
	public void deleteSensor(Station station);
	
	public List<Station> getStations();
}
