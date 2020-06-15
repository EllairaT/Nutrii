package nutrii.application.services;

import java.time.LocalDate;
import java.util.List;
import nutrii.application.model.Compounds;
import nutrii.application.model.FoodItem;
import nutrii.application.model.FoodItemIdentity;
import nutrii.application.model.User;
import nutrii.application.other.HibernateUtil;
import org.apache.derby.vti.Restriction;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ellaira
 */
public class FoodItemService {

    //need to grab all the compounds to be able to 
    public boolean addFoodItem(FoodItem f) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        boolean isSuccessful = false;
        CompoundService cs = new CompoundService();

        try {
            tx = session.beginTransaction();
            session.save(f);
            //automatically add records for all of the compounds
            //for future updating.
            List<Compounds> c = cs.getAllRows(Compounds.class);

            for (Compounds cmp : c) {
                FoodItemIdentity fid = new FoodItemIdentity(f.getId(), cmp.getId());
                session.save(fid);
            }

            session.flush();
            tx.commit();
            isSuccessful = true;

        } catch (HibernateException e) {
            System.err.println("Error adding food: " + f.getFoodName());
            tx.rollback();
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return isSuccessful;
    }

    public boolean delFoodItem(FoodItem f) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        boolean isSuccessful = false;

        try {
            tx = session.beginTransaction();

            session.delete(f);

            session.flush();
            tx.commit();
            isSuccessful = true;
        } catch (HibernateException e) {
            System.err.println("Error adding food: " + f.getFoodName());
            tx.rollback();
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return isSuccessful;
    }

    public boolean updateItem(FoodItem fi) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        boolean isSuccessful = false;
        try {
            tx = session.beginTransaction();

            session.merge(fi);
            session.flush();
            tx.commit();
            isSuccessful = true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return isSuccessful;
    }

    public boolean updateItemValue(FoodItemIdentity fi, float val) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        boolean isSuccessful = false;
        try {
            tx = session.beginTransaction();

            fi.setValue(val);
            session.merge(fi);
            session.flush();
            tx.commit();
            isSuccessful = true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return isSuccessful;
    }
    
    public List<FoodItem> browseAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Criteria crit = session.createCriteria(FoodItem.class);
        List<FoodItem> results = crit.list();
        session.close();
        return results;
    }

    public List<FoodItem> searchByName(String fname) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Criteria crit = session.createCriteria(FoodItem.class);
            crit.add(Restrictions.ilike("foodName", "%" + fname + "%"));
        List<FoodItem> results = crit.list();
        session.close();
        return results;
    }

    public List<FoodItem> searchByType(Class type) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Criteria crit = session.createCriteria(type);
        List<FoodItem> results = crit.list();
        session.close();
        return results;
    }
}
