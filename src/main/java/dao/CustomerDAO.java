package dao;

import models.Customer;
import models.Tour;
import utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerDAO {
    private static SessionFactory factory;

    public static List<Customer> listCustomer() {
        List<Customer> customers = null;
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            customers = session.createQuery("from Customer").list();
            return customers;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        session.close();
        return null;
    }

    public static void insert(Customer customer){
        if (customer != null) {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.save(customer);
            tx.commit();
            session.close();
        }
    }
    public static void delete(Customer customer){
        if (customer != null) {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(customer);
            tx.commit();
            session.close();
        }
    }
    public static void update(Customer customer){
        if (customer != null) {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(customer);
            tx.commit();
            session.close();
        }
    }

    public static Customer getCustomerById(int id){
        factory = HibernateUtil.getSessionFactory();
        Customer customer = null;
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        customer = session.get(Customer.class, id);
        return customer;
    }

    public static void deleteById(int id){
        Session session = factory.openSession();
        Customer customer = null;
        Transaction tx = session.beginTransaction();
        customer = session.find(Customer.class, id);
        session.delete(customer);
        tx.commit();
        session.close();
    }
}
