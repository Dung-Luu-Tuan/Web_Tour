package dao;

import models.DetailTourGroup;
import models.Tour;
import models.TouristGroup;
import utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TouristGroupDetailDAO {
    private static SessionFactory factory;

    public static void update(DetailTourGroup detailTourGroup) {
        if (detailTourGroup != null) {
            factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(detailTourGroup);
            tx.commit();
            session.close();
        }
    }

    public static void insert(DetailTourGroup detailTourGroup){
        if (detailTourGroup != null) {
            factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.save(detailTourGroup);
            tx.commit();
            session.close();
        }
    }

    public static void delete(DetailTourGroup detailTourGroup){
        if (detailTourGroup != null) {
            factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(detailTourGroup);
            tx.commit();
            session.close();
        }
    }

    public static void deleteById(int id){
            factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            TouristGroup touristGroup = null;
            touristGroup = session.find(TouristGroup.class, id);
            session.delete(touristGroup);
            tx.commit();
            session.close();
    }

    public static DetailTourGroup getById(int id){
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        DetailTourGroup detailTourGroup = null;
        detailTourGroup = session.get(DetailTourGroup.class, id);
        tx.commit();
        session.close();
        return detailTourGroup;
    }
}
