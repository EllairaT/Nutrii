package nutrii.application;

import nutrii.application.model.Nutrii;
import nutrii.application.other.HibernateUtil;
import nutrii.application.model.*;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import nutrii.application.other.DBInit;
import nutrii.application.services.FoodItemService;
import nutrii.application.services.UserService;

/**
 * the entry point of the application
 *
 * @author Blake & Ellaira
 */
public class NutriiApplication {

    public static Nutrii nutrii;
    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;
    private static DBInit db;

    public static void main(String[] args) {
        initialize();
        nutrii = new Nutrii();
        FoodItemService fs = new FoodItemService();
        
        List<FoodItem> results = fs.searchByName("Apple");
//        User u = us.userLogIn("Ellaira", "password");
//        nutrii.setCurrentUser(u);
//        System.out.println("CALORIES NEEDED: " + u.calculateCalNeeded());
//        
        for(FoodItem i : results){
            System.out.println(i + "\n------------------------");
        }
        //System.out.println("LOGGED IN: (" + u.getId() + ")" + u);
 
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
