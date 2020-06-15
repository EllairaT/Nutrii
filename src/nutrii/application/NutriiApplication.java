package nutrii.application;

import nutrii.application.controllers.UserController;
import nutrii.application.gui.NutriiGUI;
import nutrii.application.model.Nutrii;
import nutrii.application.gui.NutriiLoginGUI;
import nutrii.application.other.DBInit;

/**
 * the entry point of the application
 *
 * @author Blake & Ellaira
 */
public class NutriiApplication {

    public static Nutrii nutrii;
    private static DBInit db;
    private static NutriiLoginGUI logIn;
    private static NutriiGUI view;
    private static UserController uController;
    
    public static void main(String[] args) {
        initialize();
        nutrii = new Nutrii();
        view = new NutriiGUI();
        logIn = new NutriiLoginGUI();
        
        uController = new UserController(view, logIn, nutrii);
        
        logIn.setVisible(true);

        //HibernateUtil.shutdown();
       //  System.exit(0);
    }

    public static void initialize() {
        try {
            db = new DBInit();
            System.out.println("initialised");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
