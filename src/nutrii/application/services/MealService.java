package nutrii.application.services;

import nutrii.application.model.FoodItem;
import nutrii.application.model.Meal;
import nutrii.application.other.HibernateUtil;
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
            int i = 0;
            tx = session.beginTransaction();

            session.saveOrUpdate(m);

            if (i % 50 == 0) {
                session.flush();
                tx.commit();
            }
            //session.saveOrUpdate(m);

        } catch (Exception e) {
            System.err.println("Error adding user: " + m.getName());
            tx.rollback();
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
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
            System.err.println("Error loading User");
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return meal;

    }

    public void printAllRows() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.close();
    }
}
