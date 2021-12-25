package dao;

import models.Customer;
import models.Tour;
import utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class TourDAO {
    private static SessionFactory factory;

    public static List<Tour> listTour() {
        List<Tour> tours;
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            tours = session.createQuery("from Tour").list();
            return tours;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        session.close();
        return null;
    }

    public static Tour getDetail(int matour) {
        try {
            factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();
            Tour tour;
            tour = session.get(Tour.class, matour);
            session.close();
            return tour;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void update(Tour tour){
        if (tour != null) {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(tour);
            tx.commit();
            session.close();
        }
    }

    public static void insert(Tour tour){
        if (tour != null) {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.save(tour);
            tx.commit();
            session.close();
        }
    }

    public static void delete(Tour tour){
        if (tour != null) {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(tour);
            tx.commit();
            session.close();
        }
    }

    public static void deleteById(int id){
            Session session = factory.openSession();
            Tour tour = null;
            Transaction tx = session.beginTransaction();
            tour = session.find(Tour.class, id);
            session.delete(tour);
            tx.commit();
            session.close();
    }

    public static Tour getTourById(int id){
        Tour tour = null;
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        tour = session.get(Tour.class, id);
        return tour;
    }
}
