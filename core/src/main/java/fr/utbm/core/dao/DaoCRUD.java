package fr.utbm.core.dao;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DaoCRUD<E,I extends Serializable> implements IDaoCRUD<E,I> {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void register(E entity) {
		
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			session.merge(entity);
			session.getTransaction().commit();
			//session.close();
			
		} catch (HibernateException he) {
			
			he.printStackTrace();
			if (session.getTransaction() != null) {
				try {
					session.getTransaction().rollback();
				} catch (HibernateException he2) {
					he2.printStackTrace();
				}
			}
			
		} finally {
			
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException he) {
					he.printStackTrace();
				}
			}
			
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(Class<E> className, I id) {
		
		E objReturn = null;
		
		Session session = sessionFactory.openSession();
		
		try {
			
			
			session.beginTransaction();
			objReturn = (E) session.get(className, id);
			session.getTransaction().commit();
			//session.close();
			
		} catch (HibernateException he) {
			
			he.printStackTrace();
			if (session.getTransaction() != null) {
				try {
					session.getTransaction().rollback();
				} catch (HibernateException he2) {
					he2.printStackTrace();
				}
			}
			
		} finally {
			
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException he) {
					he.printStackTrace();
				}
			}
			
		}
		
		return objReturn;
	}

}
