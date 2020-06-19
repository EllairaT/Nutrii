package nutrii.application.model;

import java.time.LocalDate;
import java.util.ArrayList;
import nutrii.application.services.FoodItemService;
import nutrii.application.services.MealService;
import nutrii.application.services.UserService;

/**
 * This is the main 'connection point' for the CLI, and the Report classes
 * 
 * **UPDATE: this class is still a connection point as this object is used throughout
 * all the Controllers. But this class no longer uses the services, that job is now
 * given to the Controllers. 
 * 
 * @author Blake & Ellaira
 */
public class Nutrii {

    private LocalDate today;
    private ArrayList<Meal> meals;
    private User currentUser;
    
    public Nutrii() {
        today = LocalDate.now();
        meals = new ArrayList<>();
    }

    public LocalDate returnDate() {
        return today;
    }

    public void setCurrentUser(User u) {
        currentUser = u;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void addToMealList(Meal m) {
        meals.add(m);
    }

    public LocalDate getToday() {
        return today;
    }

    public void printUserInfo() {
        System.out.println(currentUser);
    }
}
