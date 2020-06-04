package nutrii.application.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import nutrii.application.model.Compounds;
import nutrii.application.model.Minerals;
import nutrii.application.model.Nutrients;
import nutrii.application.model.Vitamins;
import nutrii.application.other.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ellaira
 */
public class CompoundService {

    public void getAllRows(Class compound) {
        Session session = HibernateUtil.getSessionFactory().openSession();
       
        Criteria crit = session.createCriteria(compound);
//        for (Object i : session.createCriteria(Nutrients.class).list()) {
//             compoundSet.add(i);
//        }
        List<Compounds> results = crit.list();
        Set<String> resultSet = new HashSet<>();

        for(Compounds c : results){
            resultSet.add(c.getKeyname());
        }
        
        System.out.println("RESULTSET--------------------------");
        System.out.println(Arrays.asList(resultSet));
        System.out.println("RESULTSET//END--------------------------");
    }

    public void getbyid(int cid) {
        Session session = HibernateUtil.getSessionFactory().openSession();
       try {
            
            session.beginTransaction();
             
            Criteria criteria = session.createCriteria(Nutrients.class);
            criteria.add(Restrictions.eq("id", cid));
             
            Compounds c = (Nutrients) criteria.uniqueResult();
             
            if (c!=null) {
                System.out.println("Nutrient found:");
                System.out.println(c.getKeyname());
            }
             
            session.getTransaction().commit();
        }
        catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void addCompound(Compounds c, String k, float v) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            if (c instanceof Vitamins) {
                c = new Vitamins();
            } else if (c instanceof Minerals) {
                c = new Minerals();
            } else {
                c = new Nutrients();
            }

            c.setKeyname(k);
            c.setValue(v);
            System.out.println("SAVING: " + session.save(c).toString());
           
            session.save(c);
            session.flush();
            tx.commit();
            
           

        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
