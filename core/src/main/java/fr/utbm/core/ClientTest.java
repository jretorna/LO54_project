package fr.utbm.core;

import fr.utbm.core.entity.User;
import fr.utbm.core.ressource.Releve;
import fr.utbm.core.service.IUserService;
import fr.utbm.core.service.impl.ReleveService;
import fr.utbm.core.service.impl.UserService;

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
		releve.setAreaId(1);
		releve.setAreaName("area 1");
		releve.setSensorId(3);
		releve.setSensorName("sensor1");
		releve.setTempVal(21f);
		
		System.out.println(releveService.jaxbSerialiseReleve(releve, "/Users/mac/Desktop"));

	}

}
