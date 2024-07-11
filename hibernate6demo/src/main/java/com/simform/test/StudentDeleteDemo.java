package com.simform.test;

import com.simform.entity.Student;
import com.simform.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.SelectionQuery;

import java.util.List;

public class StudentDeleteDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        // Method 1
        Student student = new Student();
        student.setId(1);
        session.remove(student);

        // Method 2
        Student student1 = session.get(Student.class, 2);
        session.remove(student1);

        // Method 3 - Delete multiple records
        SelectionQuery<Student> query = session.createSelectionQuery("from Student where marks >= :marks", Student.class);
        query.setParameter("marks", 90.0);
        List<Student> studentList = query.list();
        studentList.forEach(session::remove);
        tx.commit();
        session.close();
    }
}
