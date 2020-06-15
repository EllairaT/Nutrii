package nutrii.application.services;

import java.util.List;
import nutrii.application.model.Compounds;
import nutrii.application.model.Minerals;
import nutrii.application.model.Nutrients;
import nutrii.application.model.Vitamins;
import nutrii.application.other.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * due to the nature of the app, compounds (vitamins, minerals, nutrients) a
 * User should NOT be able to delete a compound from the database, so a delete
 * method is not necessary.
 *
 * Sessions MUST be opened when a method is invoked and closed AFTER. they're
 * not thread safe DO NOT FORGET TO CLOSE THE SESSION!
 *
 * @author Ellaira
 */
public class CompoundService {

    public List<Compounds> getAllRows(Class compound) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Criteria crit = session.createCriteria(compound);

        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Compounds> results = crit.list();

        session.close();
        return results;
    }

    public void getbyid(int cid) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Nutrients.class);
            criteria.add(Restrictions.eq("id", cid));

            Compounds c = (Nutrients) criteria.uniqueResult();

            if (c != null) {
                System.out.println("Nutrient found:");
                System.out.println(c.getKeyname());
            }

            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void addCompound(Compounds c, String k, float v) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();
            if (c instanceof Vitamins) {
                c = (Vitamins) c;
            } else if (c instanceof Minerals) {
                c = (Minerals) c;
            } else {
                c = (Nutrients) c;
            }
            c.setKeyname(k);
            c.setValue(v);

            session.saveOrUpdate(c);
            tx.commit();

        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        session.close();
    }
}
