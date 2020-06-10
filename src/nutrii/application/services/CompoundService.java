package nutrii.application.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
 *
 * @author Ellaira
 */
public class CompoundService {

    //todo change return type to List
    public void getAllRows(Class compound) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Criteria crit = session.createCriteria(compound);
//        for (Object i : session.createCriteria(Nutrients.class).list()) {
//             compoundSet.add(i);
//        }
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Compounds> results = crit.list();
        Set<String> resultSet = new HashSet<>();

        for (Compounds c : results) {
            resultSet.add(c.getKeyname() + ": " + c.getId() + "\n");
        }

        System.out.println("RESULTSET--------------------------\n");
        System.out.println(Arrays.asList(resultSet));
        System.out.println("RESULTSET//END--------------------------\n");

        session.close();

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
        //TODO search database for value, if exist, dont add
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
            //session.flush();

            tx.commit();

        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
