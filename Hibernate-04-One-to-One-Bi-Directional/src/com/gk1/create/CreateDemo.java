package com.gk1.create;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gk.repository.Instructor;
import com.gk.repository.InstructorDetail;


public class CreateDemo {
	
	// Search for "binding parameter" in logs to see where values are.
	public static void main(String[] args) {

		// Step 1: Create a SessionFactory.
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();

		// Step 2: Create Session.
		Session session=factory.getCurrentSession();

		try {
			
			//Step 1: Create the Objects
			
			/*Instructor instructorTemp=new Instructor("GK","Gopi","gk@google.com");
			InstructorDetail instructorDetails=new InstructorDetail("GkChannel", "Reading Books");*/
			
			Instructor instructorTemp=new Instructor("GK5","Gopi4","gk3@google.com");
			InstructorDetail instructorDetails=new InstructorDetail("Gk4Channel", "Movies-4");
			//Step 2: Associate Objects 
			instructorTemp.setInstructorDetail(instructorDetails); // One to One
			// Start Transaction
			session.beginTransaction();
			
			// Step 3: Save the instructor
			// Note: BY saving instructor object, instructor details also will save because of CascadeType.All
			System.out.println("Instructor details to Save in DB: "+instructorTemp);
			session.save(instructorTemp);
			
			// Commit transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
