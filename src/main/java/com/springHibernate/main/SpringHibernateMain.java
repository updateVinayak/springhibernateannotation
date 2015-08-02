package com.springHibernate.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springHibernate.config.AppConfig;
import com.springHibernate.model.Person;
import com.springHibernate.service.PersonService;

public class SpringHibernateMain {

	public static void main(String[] args) {
		
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("DEV");
		context.register(AppConfig.class); 
		context.refresh();
		
		Person person = new Person();
        person.setName("Prafull"); 
        person.setCountry("India");
        
        PersonService personService = context.getBean(PersonService.class);
        personService.savePerson(person);
        
        /*
        PersonDAO personDAO = context.getBean(PersonDAOImpl.class);
        personDAO.save(person);
        List<Person> list = personDAO.list();        
        for(Person person1 : list){
        	System.out.println(person1.getName());
        }        
        System.out.println(list.size());
		*/
	}
	
}
