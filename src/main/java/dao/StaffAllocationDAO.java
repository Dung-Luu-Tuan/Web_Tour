package dao;

import models.Staff;
import models.StaffAllocation;
import models.Tour;
import utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class StaffAllocationDAO {
    private static SessionFactory factory;

    public static List<StaffAllocation> listStaffAllocation() {
        List<StaffAllocation> staffAllocations = null;
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            staffAllocations = session.createQuery("from Allocation").list();
            return staffAllocations;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        session.close();
        return null;
    }

    public static void update(StaffAllocation staffAllocation) {
        factory = HibernateUtil.getSessionFactory();
        if (staffAllocation != null) {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(staffAllocation);
            tx.commit();
            session.close();
        }
    }

    public static void insert(StaffAllocation staffAllocation) {
        if (staffAllocation != null) {
            factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.save(staffAllocation);
            tx.commit();
            session.close();
        }
    }

    public static void delete(StaffAllocation staffAllocation) {
        if (staffAllocation != null) {
            factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(staffAllocation);
            tx.commit();
            session.close();
        }
    }

//    public static StaffAllocation getById(int id, int id2) {
//            StaffAllocation staffAllocation;
//            factory = HibernateUtil.getSessionFactory();
//            Session session = factory.openSession();
//            Transaction tx = session.beginTransaction();
//            staffAllocation = session.get(StaffAllocation.class, id, id2);
//            tx.commit();
//            session.close();
//            return staffAllocation;
//        }
//    }
}
