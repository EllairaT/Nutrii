package nutrii.application;

import nutrii.application.other.FoodItemDatabase;
import nutrii.application.model.User;
import nutrii.application.model.Meal;
import nutrii.application.model.ModeratelyActive;
import nutrii.application.model.ExtraActive;
import nutrii.application.model.VeryActive;
import nutrii.application.model.Sedentary;
import nutrii.application.model.LightlyActive;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * This is the main 'connection point' for the CLI, and the Report classes
 * @author Blake & Ellaira
 */
public class Nutrii {

    private Scanner scan = new Scanner(System.in);
    private LocalDate today;
    private static FoodItemDatabase fdb;
    private static String USER_FILE;
    private ArrayList<User> allUsers;
    private ArrayList<Meal> meals;
    private User currentUser;
    private NutritionTracker nt;

    public Nutrii(ArrayList<User> u, FoodItemDatabase db, String userFile) {
        allUsers = u;
        fdb = db;
        USER_FILE = userFile;
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

    public ArrayList<User> getUserList() {
        return allUsers;
    }

    public void createNewUser() {
        User newUser;

        try {
            String name = "";
            System.out.println("Create New User: \n "
                    + "===================\n");

            boolean doesUserExist = true;

            while (doesUserExist) {
                System.out.println("\n What is your name?: \n");
                name = scan.nextLine();
                Iterator<User> i = getUserList().iterator();

                while (i.hasNext()) {
                    User u = i.next();
                    if (u.equals(name)) {
                        System.out.println("There is already a user with that name!");
                        doesUserExist = true;
                        break;
                    } else {
                        doesUserExist = false;
                    }
                }
                continue;
            }

            char gender = 0;

            while (true) {
                System.out.println("Are you a male(m) or female(f)?");
                gender = scan.nextLine().charAt(0);
                if (gender == 'f' || gender == 'm') {
                    break;
                } else {
                    System.out.println("You need to provide your sex");
                    continue;
                }
            }

            System.out.println("\n What is your height (cm)?: \n");
            float height = scan.nextFloat();

            System.out.println("\n What is your weight (kg)?: \n");
            float weight = scan.nextFloat();

            System.out.println("\n DD/MM/YYYY");
            System.out.println("\n What Year were you born? \n");
            int year = scan.nextInt();
            scan.nextLine();
            System.out.println("\n What Month were you born? \n");
            scan.hasNextLine();
            int month = scan.nextInt();
            scan.nextLine();
            System.out.println("\n What day of the month were you born? \n");
            int day = scan.nextInt();
            scan.nextLine();

            LocalDate bDay = LocalDate.of(year, month, day);

            System.out.println("\n How often do you excercise a week? \n");
            System.out.println("1.) Very little. I sit around a lot. \n"
                    + "2.) Some light sports, 1-3 days a week.\n"
                    + "3.) Quite a bit, 6-7 days a week.\n"
                    + "4.) A lot! Hard exercise every day!\n"
                    + "5.) I exercise twice a day and/or train for marathons/triathlons, etc.");

            int excerciseFreq = scan.nextInt();
            if (excerciseFreq < 1 || excerciseFreq > 5) {
                throw new IllegalArgumentException("Select a number from the options!");

            } else {
                switch (excerciseFreq) {
                    case 1:
                        newUser = new Sedentary(name, gender, bDay, height, weight);
                        break;
                    case 2:
                        newUser = new LightlyActive(name, gender, bDay, height, weight);
                        break;
                    case 3:
                        newUser = new ModeratelyActive(name, gender, bDay, height, weight);
                        break;
                    case 4:
                        newUser = new VeryActive(name, gender, bDay, height, weight);
                        break;
                    case 5:
                        newUser = new ExtraActive(name, gender, bDay, height, weight);
                        break;
                    default:
                        throw new AssertionError("This shouldn't have been reached, something went wrong.");
                }
            }
            allUsers.add(newUser);
            saveUser(newUser);
        } catch (DateTimeException e) {
            System.err.println("Enter a valid date: " + e);
        } catch (IOException ex) {
            System.err.println("Could not find " + USER_FILE + ", please make sure file exists.");
        } catch (InputMismatchException e) {
            System.err.println("Enter a valid value: " + e);
        }
    }

    /**
     * reads the text file of users information also instantiates the correct
     * type of user object (sedentary, very active, etc) based on the
     * information given from the text file
     *
     * @return arraylist of User objects
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public static void saveUser(User user) throws IOException {
        //im not gonna write code to remove dupes. ill just stop that when user tries to make a dupe user lmao 
        try ( FileWriter fw = new FileWriter(USER_FILE, true)) {
            fw.write(user.toWrite() + "\n");
        }
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
