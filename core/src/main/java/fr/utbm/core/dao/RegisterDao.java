package fr.utbm.core.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import fr.utbm.core.entity.Area;
import fr.utbm.core.entity.Sensor;
import fr.utbm.core.entity.Station;
import fr.utbm.core.entity.Temperature;
import fr.utbm.core.entity.User;
import fr.utbm.core.tools.HibernateUtil;

public class RegisterDao implements DaoInterface {

	@Override
	public void registerStation(final Station station) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerSensor(final Sensor sensor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerTemperature(final Temperature temperature) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerUser(final User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.merge(user);
			// session.createSQLQuery("Insert into user(user_id, username, active) values(1,'neakkk',1)").executeUpdate();
			session.getTransaction().commit();
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

	@Override
	public void registerArea(final Area area) {
		// TODO Auto-generated method stub

	}

}
