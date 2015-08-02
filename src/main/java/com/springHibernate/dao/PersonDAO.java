package com.springHibernate.dao;

import java.util.List;

import com.springHibernate.model.Person;

public interface PersonDAO {

	public void save(Person p);
    
    public List<Person> list();
	
}
