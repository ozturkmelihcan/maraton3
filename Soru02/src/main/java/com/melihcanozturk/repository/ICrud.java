package com.melihcanozturk.repository;

import java.util.List;

import org.hibernate.Session;

import com.melihcanozturk.util.HibernateUtils;

public interface ICrud <T> {

	
	void save (T t);
	
	void update (T t);
	
	void delete (long id);
	
	T findById(long id);
	
	List<T> listAll();
	
	default Session dataBaseConnectionHibernate() {

		return HibernateUtils.getSessionFactory().openSession();
	}
	
	
}
