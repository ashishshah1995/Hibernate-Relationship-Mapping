package com.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;

public class GetCoursesForAshishDemo {


		public static void main(String[] args) {

			// create session factory
			SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
			
			// create session
			Session session = factory.getCurrentSession();
			
			
			try {			
				
				// start a transaction
				session.beginTransaction();
				
				// get the student Ashish from database
				int theId = 5;
				Student tempStudent = session.get(Student.class,theId);
				System.out.println("\n Loaded Student "+tempStudent);
				System.out.println("Courses: "+tempStudent.getCourses());
				
			

				// commit transaction
				session.getTransaction().commit();
				
				System.out.println("Done!");
			}
			finally {
				
				// add clean up code
				session.close();
				
				factory.close();
			}
		}
	}


	





