package nutrii.application.services;

import java.time.LocalDate;
import java.util.List;
import nutrii.application.model.User;
import nutrii.application.other.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * NOTE: When possible I use Criteria over HQL because it looks less messy, is
 * safe from sql injection, and is more flexible.
 *
 *
 * @author Ellaira
 */
public class UserService {

    public User userLogIn(String uname, String pass) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        User currentUser = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Criteria crit = session.createCriteria(User.class);
            crit.add(Restrictions.eq("name", uname));
            crit.add(Restrictions.eq("password", pass));

            User u = (User) crit.uniqueResult();

            if (u != null) {
                System.out.println("Successfully logged in.");
                currentUser = u;
            } else {
                System.err.println("Incorrect user details.");
            }

            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println("Error logging in.");
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return currentUser;
    }

    public boolean addUser(User u) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        boolean isSuccessful = false;

        try {
            tx = session.beginTransaction();

            u.setStartDate(LocalDate.now());
            u.setCalorieReq(u.calculateCalNeeded());
            session.save(u);
            session.flush();
            tx.commit();
            isSuccessful = true;
        } catch (Exception e) {
            System.err.println("Error adding user: " + u.getName());
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
        return isSuccessful;
    }

    public User loadUser(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        User user = null;
        try {
            tx = session.beginTransaction();
            user = (User) session.load(User.class, id);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println("Error loading User");
            throw e;
        } finally {
            session.close();
        }
        return user;
    }

    public List<User> browseAll(Class user) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Criteria crit = session.createCriteria(user);
        List<User> results = crit.list();
        session.close();
        return results;
    }

    public boolean deleteUser(User u) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        boolean isSuccessful = false;
        try {
            tx = session.beginTransaction();
            session.delete(u);
            session.flush();
            tx.commit();
            isSuccessful = true;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
        return isSuccessful;
    }

    public boolean updateUser(User u) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        boolean isSuccessful = false;
        try {
            tx = session.beginTransaction();
            session.merge(u);
            session.flush();
            tx.commit();
            isSuccessful = true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return isSuccessful;
    }

    public List<User> searchByName(String uname) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<User> results = null;
        try {
            Criteria crit = session.createCriteria(User.class);
            crit.add(Restrictions.eq("name", uname));

            results = crit.list();
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
        return results;
    }

    public List<User> searchByLifeStyle(String lifestyle) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<User> results = null;
        try {
            Criteria crit = session.createCriteria(User.class);
            crit.add(Restrictions.eq("Lifestyle", lifestyle));

            results = crit.list();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
        return results;
    }

}
