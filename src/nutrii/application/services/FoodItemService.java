package nutrii.application.services;

import java.util.ArrayList;
import java.util.List;
import nutrii.application.model.Compounds;
import nutrii.application.model.FoodItem;
import nutrii.application.model.FoodItemIdentity;
import nutrii.application.other.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * This class contains the methods that 
 * relate to adding/removing/searching for FoodItms. 
 * 
 * @author Ellaira
 */
public class FoodItemService {

    /**
     * 
     * @param f FoodItem object (either Food or Drink)
     * @param cmp
     * @return 
     */
    public boolean addFoodItem(FoodItem f, ArrayList<Compounds> cmp) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        boolean isSuccessful = false;
        CompoundService cs = new CompoundService();

        try {
            tx = session.beginTransaction();
            session.save(f);
            
            List<Compounds> c = cs.getAllRows(Compounds.class);

            //if an empty arraylist is given, take records from compounds
            //and use the default values       
            FoodItemIdentity fid = null;
            if (cmp.isEmpty()) {
                for (Compounds i : c) {
                    fid = new FoodItemIdentity(f.getId(), i.getId(), 0);
                    session.save(fid);
                }
            } else {
                for (Compounds i : cmp) {
                    fid = new FoodItemIdentity(f.getId(), i.getId(), i.getValue());
                    session.save(fid);
                }
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
            tx.commit();
            isSuccessful = true;
            System.out.println("successfully deleted " + f.getFoodName());
        } catch (HibernateException e) {
            System.err.println("Error deleting food: " + f.getFoodName());
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

    public FoodItem loadItem(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Criteria crit = session.createCriteria(FoodItem.class);
        crit.add(Restrictions.eq("id", id));
        
        FoodItem result = (FoodItem) crit.uniqueResult();
        session.close();
        return result;
    }

    public boolean doesFoodItemExist(String f) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        FoodItem result = null;
        boolean foodExists = false;
        try {
            Criteria crit = session.createCriteria(FoodItem.class);
            crit.add(Restrictions.eq("foodName", f));

            result = (FoodItem) crit.uniqueResult();
            if (result != null) {
                foodExists = true;
            }
        } catch (Exception e) {
            throw e;
        }
        session.close();
        return foodExists;
    }
}
