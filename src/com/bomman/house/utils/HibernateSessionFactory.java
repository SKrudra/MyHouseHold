package com.bomman.house.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	public static Session getSession(){
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		return factory.openSession();
		
	}
}
