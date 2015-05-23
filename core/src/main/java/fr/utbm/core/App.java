package fr.utbm.core;

import org.hibernate.Session;

import fr.utbm.core.entity.User;
import fr.utbm.core.tools.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		User user = new User();
		user.setUserName("toto");
		try {
			session.persist(user);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			if (e instanceof java.sql.SQLException) {
				java.sql.SQLException ne = ((java.sql.SQLException) e).getNextException();
				ne.printStackTrace();
			} else {
				throw e;
			}
		}
	}
}
