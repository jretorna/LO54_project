package fr.utbm.core.dao;

import fr.utbm.core.entity.Area;
import fr.utbm.core.entity.Sensor;
import fr.utbm.core.entity.Station;
import fr.utbm.core.entity.Temperature;
import fr.utbm.core.entity.User;

public interface DaoInterface {
	public void registerStation(Station station);
	public void registerUser(User user);
	public void registerSensor(Sensor sensor);
	public void registerTemperature(Temperature temperature);
	public void registerArea(Area area);
}
