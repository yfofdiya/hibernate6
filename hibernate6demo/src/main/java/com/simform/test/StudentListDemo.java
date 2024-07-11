package com.simform.test;

import com.simform.entity.Student;
import com.simform.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.SelectionQuery;

import java.util.List;

public class StudentListDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        SelectionQuery<Student> query = session.createSelectionQuery("from Student", Student.class);
        List<Student> studentList = query.list();
        studentList.forEach(System.out::println);
        session.close();
    }
}
