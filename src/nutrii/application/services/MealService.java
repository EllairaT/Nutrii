package nutrii.application.services;

import java.util.List;
import nutrii.application.model.Compounds;
import nutrii.application.model.FoodItem;
import nutrii.application.model.FoodItemIdentity;
import nutrii.application.model.Meal;
import nutrii.application.model.MealIdentity;
import nutrii.application.other.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ellaira
 */
public class MealService {

    public boolean addMeal(Meal m) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        boolean isSuccessul = false;
        try {
            tx = session.beginTransaction();

            session.save(m);
            
            for (FoodItem f : m.getThisMeal()){
                MealIdentity mid = new MealIdentity(m, f.getId());
                session.save(mid);
            }
            session.flush();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw ex;
            
        } finally {
            session.close();
        }
        return isSuccessul;
    }

    public Meal getMeal(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Meal meal = null;
        try {
            tx = session.beginTransaction();
            meal = (Meal) session.load(Meal.class, id);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println("Error loading meal");
            throw e;
        } finally {
             session.close();
        }
        return meal;

    }

    public List<Meal> printAllRows() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Criteria crit = session.createCriteria(Meal.class);
        List<Meal> results = crit.list();

        session.close();
        return results;
    }
}
