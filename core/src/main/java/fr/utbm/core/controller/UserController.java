package fr.utbm.core.controller;

import fr.utbm.core.entity.User;
import fr.utbm.core.service.UserService;

public class UserController implements UserControllerInterface {

	/*----------------------*/
	private UserService users;
	/*----------------------*/

	public UserService getUsers() {
		return users;
	}

	public void setUsers(final UserService users) {
		this.users = users;
	}

	@Override
	public void setParameterDirectly() {
		User user = new User();
		user.setUserName("JR");
		user.setActive(true);
		users.addUser(user);
	}

}
