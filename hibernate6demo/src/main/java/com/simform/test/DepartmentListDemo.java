package com.simform.test;

import com.simform.entity.Department;
import com.simform.util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class DepartmentListDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Department> criteriaQuery = criteriaBuilder.createQuery(Department.class);
        Root<Department> root = criteriaQuery.from(Department.class);

        criteriaQuery.select(root);
        Query<Department> query = session.createQuery(criteriaQuery);
        List<Department> departmentList = query.getResultList();
        departmentList.forEach(System.out::println);

        /*
            % = Represent zero or one or multiple characters
            _ = Represent one character
         */
//        criteriaQuery.select(root).where(criteriaBuilder.like(root.get("name"), "__s%"));
//        criteriaQuery.select(root).where(criteriaBuilder.like(root.get("name"), "%1"));
//        Query<Department> query = session.createQuery(criteriaQuery);
//        List<Department> departmentList = query.getResultList();
//        departmentList.forEach(System.out::println);

        session.close();
    }
}
