package com.springHibernate.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springHibernate.model.Person;
import com.springHibernate.service.MyException;
import com.springHibernate.service.PersonService;

public class SpringHibernateMain {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		/*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("DEV");
		context.register(AppConfig.class); 
		context.refresh();*/
		
		Person person = new Person();
        person.setName("Swati 12"); 
        person.setCountry("India");
        
        PersonService personService = context.getBean(PersonService.class);
        try {
			personService.savePerson(person);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
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
