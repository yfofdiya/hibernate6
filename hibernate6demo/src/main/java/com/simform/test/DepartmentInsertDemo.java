package com.simform.test;

import com.simform.entity.Department;
import com.simform.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DepartmentInsertDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Department department = new Department("Test Department 3");
        session.persist(department);
        tx.commit();
        session.close();
    }
}
