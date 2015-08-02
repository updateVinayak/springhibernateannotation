package com.springHibernate.config;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

import com.springHibernate.dao.PersonDAOImpl;
import com.springHibernate.dao.PersonDAOImpl2;
import com.springHibernate.service.PersonService;

@Configuration
@ComponentScan(value="com.springHibernate")
public class AppConfig {
	
	@Bean
	public BasicDataSource dataSource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		ds.setUsername("system");
		ds.setPassword("India3380");
		ds.setInitialSize(5);
		ds.setMaxActive(10);
		return ds;
	}
	
	@Bean
	public AnnotationSessionFactoryBean sessionFactory(){
		AnnotationSessionFactoryBean sessionFactory = new AnnotationSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[]{"com.springHibernate.model"});
		
		Properties pro = new Properties();		
		pro.setProperty("dialect", "org.hibernate.dialect.Oracle10gDialect");
		pro.setProperty("show_sql", "true");
		
		sessionFactory.setHibernateProperties(pro);
		
		return sessionFactory;
	}
	
	
		
}
