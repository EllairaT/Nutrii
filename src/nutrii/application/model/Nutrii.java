package nutrii.application.model;

import nutrii.application.other.FoodItemDatabase;
import nutrii.application.model.User;
import nutrii.application.model.Meal;
import nutrii.application.model.ModeratelyActive;
import nutrii.application.model.ExtraActive;
import nutrii.application.model.VeryActive;
import nutrii.application.model.Sedentary;
import nutrii.application.model.*;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import nutrii.application.NutritionTracker;
import nutrii.application.services.UserService;

/**
 * This is the main 'connection point' for the CLI, and the Report classes
 * @author Blake & Ellaira
 */
public class Nutrii {

    private Scanner scan = new Scanner(System.in);
    private LocalDate today;
    private static FoodItemDatabase fdb;
    private ArrayList<Meal> meals;
    private User currentUser;
    private NutritionTracker nt;
    private UserService us;
    
    public Nutrii() {
        us = new UserService();
        today = LocalDate.now();
        meals = new ArrayList<>();
    }

    public FoodItemDatabase getFoodItemDatabase() {
        return fdb;
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

    public List<User> getUserList() {
        List<User> allUsers = us.browseAll(User.class);
        return allUsers;
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
