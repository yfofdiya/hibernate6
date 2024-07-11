package com.simform.test;

import com.simform.entity.Student;
import com.simform.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentInsertDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Student student = new Student("Test3", 90.5);
        session.persist(student);
        tx.commit();
        session.close();
    }

}
