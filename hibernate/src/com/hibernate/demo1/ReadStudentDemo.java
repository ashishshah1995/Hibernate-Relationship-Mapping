package com.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save Java object
			
			// create a student object
			System.out.println("Creating a new Student object...");
			Student tempStudent = new Student("Ashish","Shah","ashish@yahoo.com");
			
			// start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			//NEW code to retrieve object from database
			
			//find out student id:primary key
			System.out.println("Saved student . Generated id: "+tempStudent.getId());
			
			// now get a new session and start transaction
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on id: primary key
			System.out.println("\nGetting student with id: "+ tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete "+myStudent);
			
			//comit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			factory.close();
		}
	}

}
