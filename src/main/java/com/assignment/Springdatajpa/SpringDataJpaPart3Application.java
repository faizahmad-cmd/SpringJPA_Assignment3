package com.assignment.Springdatajpa;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.assignment.Springdatajpa.entity.Address;
import com.assignment.Springdatajpa.entity.Author;



@SpringBootApplication
public class SpringDataJpaPart3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaPart3Application.class, args);

		Configuration config = new Configuration();

		SessionFactory sessionFactory = config.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Address address = new Address("12A", "Delhi", "UP");

		Author author = new Author();
		author.setName("Faiz");
		author.setAddress(address);

		author.getSubjects().add("Physics");
		author.getSubjects().add("Math");
		author.getSubjects().add("Computer Science");

		session.persist(author);

		tx.commit();
		session.close();

			}

}
