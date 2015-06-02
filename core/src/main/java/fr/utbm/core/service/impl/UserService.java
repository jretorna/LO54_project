package fr.utbm.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.utbm.core.dao.IDaoCRUD;
import fr.utbm.core.entity.User;
import fr.utbm.core.service.IUserService;

@Service
public class UserService implements IUserService {

	/*-------------------------*/

	private IDaoCRUD<User,Integer> dao;
	
	/*private SessionFactory sessionFactory;
	-------------------------

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public IUserService() {
		// this.session = HibernateUtil.getSessionfactory().openSession();
	}*/

	/*@Override
	public void addUser(final User user) {
		System.out.println("cccc");
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.merge(user);
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Fin insert user");
		
	}*/
	
	public IDaoCRUD<User,Integer> getDao() {
		return dao;
	}
	
	@Autowired
	public void setDao(IDaoCRUD<User,Integer> dao) {
		this.dao = dao;
	}

	public void addUser(final User user) {
		System.out.println("Insertion User");
		
		dao.register(user);
		
		System.out.println("Fin insert user");
		
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
	/*
	public DaoInterface getDao() {
		return dao;
	}

	public void setDao(final DaoInterface dao) {
		this.dao = dao;
	}*/

}
