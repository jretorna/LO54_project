package fr.utbm.lo54.concentrateur.services.impl;

import java.util.List;

import fr.utbm.core.dao.DaoInterface;
import fr.utbm.core.entity.User;
import fr.utbm.core.service.UserService;
public class UserServiceImpl implements UserService {

	/*-------------------------*/
	private DaoInterface dao;
	/*-------------------------*/

	public UserServiceImpl() {
		// this.session = HibernateUtil.getSessionfactory().openSession();
	}

	@Override
	public void addUser(final User user) {
		dao.registerUser(user);
	}

	@Override
	public void deleteTemperature(final User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getUsers() {
		List<User> users = null;

		return users;
		/*
		 * try {
		 * 
		 * 
		 * session.createQuery("Select user_id, username, actice From User");
		 * 
		 * 
		 * session.getTransaction().commit();
		 * 
		 * System.out.println("Fin commit");
		 * 
		 * } catch (HibernateException he) { he.printStackTrace();
		 * if(session.getTransaction() != null) { try {
		 * session.getTransaction().rollback(); }catch(HibernateException he2)
		 * {he2.printStackTrace(); } } } finally { if(session != null) { try {
		 * session.close(); } catch (HibernateException he) {
		 * he.printStackTrace(); } } }
		 * 
		 * 
		 * return null;
		 */
	}

	public DaoInterface getDao() {
		return dao;
	}

	public void setDao(final DaoInterface dao) {
		this.dao = dao;
	}

}
