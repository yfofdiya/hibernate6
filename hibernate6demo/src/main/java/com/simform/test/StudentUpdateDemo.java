package com.simform.test;

import com.simform.entity.Student;
import com.simform.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

public class StudentUpdateDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        // Method 1
        Student student = session.get(Student.class, 1);
        student.setName("Test 1 Updated");
        student.setMarks(85.0);
        session.merge(student);

        // Method 2
        MutationQuery query = session.createMutationQuery(
                "update Student set name = :name, marks = :marks where id = :id");
        query.setParameter("name", "Test 2 Updated");
        query.setParameter("marks", 100.0);
        query.setParameter("id", 2);
        query.executeUpdate();

        tx.commit();
        session.close();
    }
}
