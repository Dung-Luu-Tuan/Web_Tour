package dao;

import models.Customer;
import models.Place;
import models.PlaceOrder;
import utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PlaceDAO {
    private static SessionFactory factory;

    public static List<Place> listPlace() {
        List<Place> places = null;
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            places = session.createQuery("from Place").list();
            return places;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        session.close();
        return null;
    }

    public static void insert(Place place){
        if (place != null) {
            factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.save(place);
            tx.commit();
            session.close();
        }
    }

    public static void delete(Place place){
        if (place != null) {
            factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(place);
            tx.commit();
            session.close();
        }
    }

    public static void update(Place place){
        if (place != null) {
            factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(place);
            tx.commit();
            session.close();
        }
    }

    public static Place getPlaceById(int id){
        Place place = null;
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        place = session.get(Place.class, id);
        return place;
    }

    public static void deleteById(int id){
        Session session = factory.openSession();
        Place place = null;
        Transaction tx = session.beginTransaction();
        place = session.find(Place.class, id);
        session.delete(place);
        tx.commit();
        session.close();
    }
}
