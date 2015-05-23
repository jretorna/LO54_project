package fr.utbm.lo54.concentrateur.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import fr.utbm.core.entity.User;
import fr.utbm.core.service.UserService;
import fr.utbm.core.tools.HibernateUtil;
public class UserServiceImpl implements UserService {
	
	public UserServiceImpl() {
		//this.session = HibernateUtil.getSessionfactory().openSession();
	}
	
	@Override
	public void addUser(User user) {
		
		Session session  = HibernateUtil.getSessionFactory().openSession();
		
		try {
			
			session.beginTransaction();
			
			session.merge(user);
			
			//session.createSQLQuery("Insert into user(user_id, username, active) values(1,'neakkk',1)").executeUpdate();
			
			System.out.println("Fin persist");
		
			session.getTransaction().commit();
			
			System.out.println("Fin commit");
			
		} catch (HibernateException he) {
			he.printStackTrace();
			if(session.getTransaction() != null) { 
				try {
					session.getTransaction().rollback(); 
				}catch(HibernateException he2) {he2.printStackTrace(); }
			}
		}
		finally {
			if(session != null) {
				try { 
					session.close();
				} catch (HibernateException he) {
					he.printStackTrace();
				}
			}
		}
		
		
		
		//session.close();
		
	}

	@Override
	public void deleteTemperature(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getUsers() {
		List<User> users = null;
		
		return users;
		/*
		try {
			
			
			session.createQuery("Select user_id, username, actice From User");
			
		
			session.getTransaction().commit();
			
			System.out.println("Fin commit");
			
		} catch (HibernateException he) {
			he.printStackTrace();
			if(session.getTransaction() != null) { 
				try {
					session.getTransaction().rollback(); 
				}catch(HibernateException he2) {he2.printStackTrace(); }
			}
		}
		finally {
			if(session != null) {
				try { 
					session.close();
				} catch (HibernateException he) {
					he.printStackTrace();
				}
			}
		}


		return null;*/
	}

}
