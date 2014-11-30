/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.core.service;

import fr.utbm.core.entity.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author 
 */
@Service
public class UserService {
	public void registerUser(User u) {
		System.out.println(u);

	}

}
