package com.manish.javadev.manager;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.manish.javadev.model.CustomerEntity;
import com.manish.javadev.model.OrderEntity;
import com.manish.javadev.util.HibernateUtil;

public class InsertManager {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// Create OrderEntity
		OrderEntity orderEntity1 = new OrderEntity("IPhone 6", new Date());
		OrderEntity orderEntity2 = new OrderEntity("IPhone 7", new Date());

		// Create CustomerEntity
		CustomerEntity customerEntity = new CustomerEntity("Manish",
				"Srivastava", 30);

		orderEntity1.setCustomerEntity(customerEntity);
		orderEntity2.setCustomerEntity(customerEntity);

		customerEntity.getOrderEntiy().add(orderEntity1);
		customerEntity.getOrderEntiy().add(orderEntity2);

		session.save(customerEntity);

		tx.commit();
		session.close();
		System.out.println("Done");
	}
}
