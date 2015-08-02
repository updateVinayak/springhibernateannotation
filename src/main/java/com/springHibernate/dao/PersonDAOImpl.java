package com.springHibernate.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.springHibernate.model.Person;


@Repository
@Profile("QA")
public class PersonDAOImpl implements PersonDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Person p) {
		
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
        session.close();
		
	}

	public List<Person> list() {
		
		Session session = this.sessionFactory.openSession();
        List<Person> personList = session.createQuery("from Person").list();
        session.close();
        return personList;
		
		
	}

}
