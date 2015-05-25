package fr.utbm.core;

import fr.utbm.core.entity.User;
import fr.utbm.core.service.UserService;
import fr.utbm.lo54.concentrateur.services.impl.UserServiceImpl;

public class ClientTest {

	public static void main(final String[] args) {

		UserService userService = new UserServiceImpl();

		User user = new User();

		// user.setUserId(1l);
		user.setUserName("Neaka");
		user.setActive(true);

		System.out.println("deb add");

		userService.addUser(user);

		System.out.println("Add cools");

	}

}
