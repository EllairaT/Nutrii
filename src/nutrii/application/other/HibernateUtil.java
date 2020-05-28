package nutrii.application.other;

import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Ellaira
 */
public class HibernateUtil {

    private static SessionFactory factory;

    public static SessionFactory getSessionFactory() {
        if (factory == null) {
            try {
                Configuration config = new Configuration().configure();
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(config.getProperties()).build();

                factory = config.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return factory;
    }

    public static Session getSession() {
        return factory.openSession();
    }

    public static void closeSession(Session session) {
        if (session != null) {
            if (session.isOpen()) {
                session.close();
            }
        }
    }
    
    public static void shutdown(){
        factory.close();
    }
}
