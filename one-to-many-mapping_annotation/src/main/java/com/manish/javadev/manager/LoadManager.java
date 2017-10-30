package com.manish.javadev.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.manish.javadev.model.OrderEntity;
import com.manish.javadev.util.HibernateUtil;

public class LoadManager {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		OrderEntity orderEntity = (OrderEntity) session.get(OrderEntity.class,
				new Long(1));
		System.out.println(orderEntity);
		System.out.println("=============");
		System.out.println(orderEntity.getCustomerEntity());
		tx.commit();
		session.close();
		System.out.println("Done");
	}
}
