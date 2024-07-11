package com.simform.test;

import com.simform.entity.Address;
import com.simform.entity.Customer;
import com.simform.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OneToOneInsertDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Address address = new Address("Dummy Address");

        Customer customer = new Customer("Test Customer");
        customer.setAddress(address);

        session.persist(address);
        session.persist(customer);

        tx.commit();
        session.close();
    }
}
