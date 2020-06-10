package nutrii.application;

import nutrii.application.model.Nutrii;
import nutrii.application.other.FoodItemDatabase;
import nutrii.application.other.HibernateUtil;
import nutrii.application.model.*;
import nutrii.application.other.CLIView;
import java.util.ArrayList;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import nutrii.application.other.DBInit;
import nutrii.application.services.CompoundService;

/**
 * the entry point of the application
 *
 * @author Blake & Ellaira
 */
public class NutriiApplication {

    private static DBConnect dbconn;
    private static FoodItemDatabase fdb;
    private static final String USER_FILE = "NUTRII_USERS.txt";
    public static CLIView cli;
    public static Nutrii nutrii;
    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;
    private static DBInit db;
    private static ArrayList<User> tempUserList;

    public static void main(String[] args) {
        initialize();

        CompoundService cs = new CompoundService();

        System.out.println("IN MAIN-------------");
        cs.getAllRows(Nutrients.class);
        System.out.println("\n");
        
        cs.getAllRows(Minerals.class);
        System.out.println("\n");
        
        cs.getAllRows(Vitamins.class);
        
        HibernateUtil.shutdown();
        System.exit(0);
    }

    public static void initialize() {
        try {
             System.out.println("--------INITIALISE DATABASE\n");
             db = new DBInit();
            System.out.println("--------END INITIALISATION\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
        //HibernateUtil.shutdown();
    }
}
