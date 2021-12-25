package dao;

import models.Place;
import models.Staff;
import models.TypeCost;
import utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TypeCostDAO {
    private static SessionFactory factory;

    public static List<TypeCost> listTypeCost() {
        List<TypeCost> typeCosts = null;
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            typeCosts = session.createQuery("from TypeCost").list();
            return typeCosts;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        session.close();
        return null;
    }

    public static void insert(TypeCost typeCost){
        if (typeCost != null) {
            factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.save(typeCost);
            tx.commit();
            session.close();
        }
    }

    public static void delete(TypeCost typeCost){
        if (typeCost != null) {
            factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(typeCost);
            tx.commit();
            session.close();
        }
    }

    public static void update(TypeCost typeCost){
        if (typeCost != null) {
            factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(typeCost);
            tx.commit();
            session.close();
        }
    }

    public static TypeCost getTypeCostById(int id){
        TypeCost typeCost = null;
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        typeCost = session.get(TypeCost.class, id);
        return typeCost;
    }

    public static void deleteById(int id){
        Session session = factory.openSession();
        TypeCost typeCost = null;
        Transaction tx = session.beginTransaction();
        typeCost = session.find(TypeCost.class, id);
        session.delete(typeCost);
        tx.commit();
        session.close();
    }
}
