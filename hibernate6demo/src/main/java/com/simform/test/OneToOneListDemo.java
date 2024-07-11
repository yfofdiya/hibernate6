package com.simform.test;

import com.simform.entity.Customer;
import com.simform.util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class OneToOneListDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> root = criteriaQuery.from(Customer.class);

        criteriaQuery.select(root);
        Query<Customer> query = session.createQuery(criteriaQuery);
        List<Customer> customerList = query.getResultList();
        customerList.forEach(System.out::println);

        session.close();
    }
}
