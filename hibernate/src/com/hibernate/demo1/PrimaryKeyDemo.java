package com.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save Java object
			
			// create 3 student objects
			System.out.println("Creating 3 new Student object...");
			Student tempStudent1 = new Student("Sandy","Berne","sandi@yahoo.com");
			Student tempStudent2 = new Student("Pika","Rook","rp@gmail.com");
			Student tempStudent3 = new Student("Fred","Balls","fred@yahoo.com");
			
			// start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);


			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			factory.close();
		}
	}

}
