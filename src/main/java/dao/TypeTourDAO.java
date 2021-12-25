package dao;

import models.Place;
import models.TypeTour;
import utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TypeTourDAO {
    private static SessionFactory factory;

    public static List<TypeTour> listType() {
        List<TypeTour> typeTours = null;
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            typeTours = session.createQuery("from TypeTour").list();
            return typeTours;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        session.close();
        return null;
    }

    public static void insert(TypeTour typeTour){
        if (typeTour != null) {
            factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.save(typeTour);
            tx.commit();
            session.close();
        }
    }

    public static void delete(TypeTour typeTour){
        if (typeTour != null) {
            factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(typeTour);
            tx.commit();
            session.close();
        }
    }

    public static void update(TypeTour typeTour){
        if (typeTour != null) {
            factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(typeTour);
            tx.commit();
            session.close();
        }
    }

    public static TypeTour getById(int id){
            TypeTour typeTour;
            factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            typeTour = session.get(TypeTour.class, id);
            tx.commit();
            session.close();
            return typeTour;
        }
}
