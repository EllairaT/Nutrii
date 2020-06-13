package nutrii.application.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import nutrii.application.model.User;
import nutrii.application.model.VeryActive;
import nutrii.application.other.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
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
        boolean isSuccessul = false;

        try {
            tx = session.beginTransaction();

            session.saveOrUpdate(u);
            session.flush();
            tx.commit();

        } catch (Exception e) {
            System.err.println("Error adding user: " + u.getName());
            tx.rollback();
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return isSuccessul;
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
            if (session != null && session.isOpen()) {
                session.close();
            }
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
    
//    public List<User> browseUsers() {
//
//    }
//
//    public boolean deleteUser() {
//
//    }
//    public boolean updateUser(User u) {
//
//    }
//
//    public ArrayList<User> searchByName() {
//
//    }
//
//    public ArrayList<User> searchByLifeStyle() {
//
//    }

}
