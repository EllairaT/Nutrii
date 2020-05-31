package nutrii.application.other;

import org.hibernate.HibernateException;
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

    private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    private static Configuration config;
    private static ServiceRegistry serviceRegistry;
    private static SessionFactory factory;

    static {
        config = new Configuration().configure();
        serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties()).build();

     

        try {
            factory = config.buildSessionFactory(serviceRegistry);
            
        } catch (Exception e) {
            System.err.println("!!!!!!!!!!!!ERROR");
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }

    public static Session getSession() {
        Session session = (Session) threadLocal.get();

        if (session == null || !session.isOpen()) {
            if (factory == null) {
                rebuildSessionFactory();
            }
            session = (factory != null) ? factory.openSession()
                    : null;
            threadLocal.set(session);
        }

        return session;
    }

    public static void rebuildSessionFactory() {
        try {
            config.configure(CONFIG_FILE_LOCATION);
            factory = config.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            System.err
                    .println("%%%% Error Creating SessionFactory %%%%");
            e.printStackTrace();
        }
    }

    public static void closeSession(Session session) {
        if (session != null) {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
