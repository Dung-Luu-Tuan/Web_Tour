package dao;

import models.Customer;
import models.CustomerTour;
import models.TouristGroup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class CustomerTourDAO {
    private static SessionFactory factory;

    public static void insertCustomerTour(CustomerTour customerTour) {
        if (customerTour != null) {
            factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.save(customerTour);
            tx.commit();
            session.disconnect();
        }
    }

    public static void deleteCustomerTour(CustomerTour customerTour){
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(customerTour);
        tx.commit();
        session.close();
    }
}
