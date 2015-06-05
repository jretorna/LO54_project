package fr.utbm.core;

import fr.utbm.core.entity.Area;
import fr.utbm.core.entity.Sensor;
import fr.utbm.core.entity.Station;
import fr.utbm.core.entity.Temperature;
import fr.utbm.core.ressource.Releve;
import fr.utbm.core.service.impl.ReleveService;

public class ClientTest {

	public static void main(final String[] args) {

		/*IUserService userService = new IUserService();

		User user = new User();

		// user.setUserId(1l);
		user.setUserName("Neaka");
		user.setActive(true);

		System.out.println("deb add");

		userService.addUser(user);

		System.out.println("Add cools");*/
		
		ReleveService releveService = new ReleveService();
		
		Releve releve = new Releve();
		
		Area area = new Area();
		area.setAreId(1);
		area.setAreLabel("area 1");
		
		Station station = new Station();
		
		station.setStaId(2);
		station.setStaLabel("Station oui");
		
		Sensor sensor = new Sensor();
		
		sensor.setSenId(2);
		sensor.setSenLabel("Malavo sen");
		
		Temperature temp = new Temperature();
		temp.setTmpValue(12f);
		
		releve.setArea(area);
		releve.setStation(station);
		releve.setSensor(sensor);
		releve.setTemperature(temp);
		
		
		System.out.println(releveService.jaxbSerialiseReleve(releve, "/Users/mac/Desktop"));

	}

}
