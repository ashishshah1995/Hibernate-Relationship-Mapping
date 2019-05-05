package com.hibernate.demo1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").list();
			
			//display the students
			displayStudents(theStudents);
			
			// query students: lastName="shah"
			theStudents = session.createQuery("from Student s where s.lastName='Shah'").list();

			//display the students
			System.out.println("\n\nStudents who have last name of Shah");
			displayStudents(theStudents);
			
			//query students: lastName ='Shah' OR firstName="Sandy"
			theStudents= session.createQuery("from Student s where"
					+" s.lastName='Shah' OR s.firstName='Sandy'").list();
			
			//display the students
			System.out.println("\n\n Students having last name of Shah or first name of Sandy");
			displayStudents(theStudents);
			
			// query the students  where email LIKE '%yahoo.com'
			theStudents = session.createQuery("from Student s where"
					+" s.email LIKE '%yahoo.com'").list();
			
			//diaplay the students
			System.out.println("\n\n Sudents whose email ends with yahoo.com");
			displayStudents(theStudents);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
