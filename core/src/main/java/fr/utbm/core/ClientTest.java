package fr.utbm.core;

import fr.utbm.core.ressource.ReleveParameter;
import fr.utbm.core.service.impl.Jaxb;

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
		
		/*ReleveService releveService = new ReleveService();
		
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
		
		
		System.out.println(releveService.jaxbSerialiseReleve(releve, "/Users/mac/Desktop"));*/
		
		Jaxb<ReleveParameter> jaxbparam = new Jaxb<ReleveParameter>();
		ReleveParameter param = new ReleveParameter();
		
		param.setTempMin(-100);
		param.setTempMax(70);
		
		System.out.println(jaxbparam.jaxbSerialiseObject(param, ReleveParameter.class, "/Users/mac/Desktop", "param"));
		
		
		

	}

}
