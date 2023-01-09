package com.melihcanozturk.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



import com.melihcanozturk.entity.Siparis;
import com.melihcanozturk.entity.SiparisKalemii;
import com.melihcanozturk.entity.Urun;
import com.melihcanozturk.entity.Musteri;



public class HibernateUtils {

	
	private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

	private static SessionFactory sessionFactoryHibernate() {

		try {
			Configuration configuration = new Configuration();

			configuration.addAnnotatedClass(Musteri.class);
			configuration.addAnnotatedClass(Siparis.class);
			configuration.addAnnotatedClass(SiparisKalemii.class);
			configuration.addAnnotatedClass(Urun.class);
			
			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();

			return factory;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}
