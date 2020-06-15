package nutrii.application.services;

import java.util.List;
import nutrii.application.model.FoodItem;
import nutrii.application.model.Meal;
import nutrii.application.model.MealIdentity;
import nutrii.application.other.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ellaira
 */
public class MealService {
    //todo search by date
    public boolean addMeal(Meal m) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        boolean isSuccessul = false;
        try {
            tx = session.beginTransaction();

            session.save(m);

            for (FoodItem f : m.getThisMeal()) {
                MealIdentity mid = new MealIdentity(m, f.getId());
                session.save(mid);
            }
            session.flush();
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            throw ex;
        }
        session.close();
        return isSuccessul;
    }

    public Meal loadMeal(int id) {
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
        }
        session.close();
        return meal;
    }

    public List<Meal> printAllRows() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Criteria crit = session.createCriteria(Meal.class);
        List<Meal> results = crit.list();

        session.close();
        return results;
    }

    public boolean deleteMeal(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        boolean isSuccessful = false;
        try {
            tx = session.beginTransaction();
            
            Meal meal = (Meal) session.load(Meal.class, id);
            session.delete(meal);
            
            Criteria mealIdentityCriteria = session.createCriteria(MealIdentity.class);
            mealIdentityCriteria.add(Restrictions.eq("mealId", id));
            
            List<MealIdentity> results = mealIdentityCriteria.list();
            for(MealIdentity mid : results){
                session.delete(mid);
            }
            
            tx.commit();
            
            isSuccessful = true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        session.close();
        return isSuccessful;
    }
}
