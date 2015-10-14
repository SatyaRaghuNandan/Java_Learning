package com.prakash.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.prakash.hibernate.dto.UserDetails;
import com.prakash.hibernate.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("Prakash Ranjan");
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Honda Amaze");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Honda City");
		
		
		user.getVehicle().add(vehicle1);
		user.getVehicle().add(vehicle2);
		
		vehicle1.setUsers(user);
		vehicle2.setUsers(user);
		
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle1);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
		
		
		
		user = null;
		session = sessionFactory.openSession();
		user = (UserDetails) session.get(UserDetails.class, 1);
		session.close();
	
	}
}
