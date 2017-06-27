package edu.learn.rest.RestfulWebservices.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {
	static SessionFactory sessionFactory = null;

	@SuppressWarnings("deprecation")
	public static SessionFactory createSessionFactory() throws Exception {
		
		if(sessionFactory == null)
			sessionFactory = new Configuration().configure().buildSessionFactory();
		
		return sessionFactory;
	}
}
