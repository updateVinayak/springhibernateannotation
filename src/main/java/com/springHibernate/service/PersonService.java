package com.springHibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.springHibernate.dao.PersonDAO;
import com.springHibernate.dao.PersonDAOImpl;
import com.springHibernate.model.Person;


@Component
public class PersonService {

	
	private PersonDAO personDAO;
	
	public PersonDAO getPersonDAO() {
		return personDAO;
	}

	@Autowired
	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	public void savePerson(Person p){
		personDAO.save(p);
	}
	
	
}
