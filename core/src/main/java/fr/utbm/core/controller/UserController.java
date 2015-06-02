package fr.utbm.core.controller;

import fr.utbm.core.entity.User;
import fr.utbm.core.service.IUserService;

public class UserController implements UserControllerInterface {

	/*----------------------*/
	private IUserService users;
	/*----------------------*/

	public IUserService getUsers() {
		return users;
	}

	public void setUsers(final IUserService users) {
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
