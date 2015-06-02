package fr.utbm.core.service;

import java.util.List;

import fr.utbm.core.entity.User;

public interface IUserService {
	public void addUser(User user);
	public void deleteTemperature(User user);
	
	public List<User> getUsers();
}
