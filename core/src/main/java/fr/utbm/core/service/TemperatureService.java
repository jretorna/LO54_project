package fr.utbm.core.service;

import java.util.List;

import fr.utbm.core.entity.Temperature;

public interface TemperatureService {
	public void addTemperature(Temperature temp);
	public void deleteTemperature(Temperature temp);
	
	public List<Temperature> getTemperatures();
}
