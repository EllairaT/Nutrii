package nutrii.application;

import nutrii.application.controllers.FoodItemController;
import nutrii.application.controllers.MealController;
import nutrii.application.controllers.UserController;
import nutrii.application.gui.NutriiGUI;
import nutrii.application.model.Nutrii;
import nutrii.application.gui.NutriiLoginGUI;
import nutrii.application.other.DBInit;
import nutrii.application.splash.Splash;

/**
 * the entry point of the application
 *
 * @author Blake & Ellaira
 */
public class NutriiApplication {

    public static Nutrii nutrii;
    private static NutriiLoginGUI logIn;
    private static NutriiGUI view;
    
    public static void main(String[] args) {
        initialize();
        nutrii = new Nutrii();
        view = new NutriiGUI();
        logIn = new NutriiLoginGUI();
        
        UserController uController = new UserController(view, logIn, nutrii);
        FoodItemController fController = new FoodItemController(nutrii, view);
        MealController mController = new MealController(nutrii, view);
        
        Splash splashImg = new Splash();
        
        logIn.setVisible(true);

    }

    public static void initialize() {
        try {
            DBInit db = new DBInit();
            System.out.println("initialised");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
