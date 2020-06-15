package nutrii.application.model;

import nutrii.application.other.FoodItemDatabase;
import nutrii.application.model.User;
import nutrii.application.model.Meal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import nutrii.application.NutritionTracker;
import nutrii.application.services.FoodItemService;
import nutrii.application.services.MealService;
import nutrii.application.services.UserService;

/**
 * This is the main 'connection point' for the CLI, and the Report classes
 * @author Blake & Ellaira
 */
public class Nutrii {

    private LocalDate today;
    private ArrayList<Meal> meals;
    private User currentUser;
    private NutritionTracker nt;
    private UserService us;
    private FoodItemService fs;
    private MealService ms;
    
    public Nutrii() {
        us = new UserService();
        fs = new FoodItemService();
        ms = new MealService();
        today = LocalDate.now();
        meals = new ArrayList<>();
    }

    public LocalDate returnDate() {
        return today;
    }

    public void setCurrentUser(User u) {
        currentUser = u;
        nt = new NutritionTracker(u, this);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void addToMealList(Meal m) {
        meals.add(m);
    }

    public ArrayList<Meal> getMeals() {
        if (meals.isEmpty()) {
            meals = nt.getTodayMeals();
        }
        return meals;
    }

    public void readUserReport() {
        nt.readReport();
    }

    public LocalDate getToday() {
        return today;
    }

    public void writeToReport(Meal m) {
        nt.writeReport(m);
    }

    public void printUserInfo() {
        System.out.println(currentUser);
    }

    public void updateUserDetails(User u) {
        //update user details here
    }
}
