package nutrii.application.other;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import nutrii.application.model.Drink;
import nutrii.application.model.Food;
import nutrii.application.model.FoodItem;
import nutrii.application.model.Meal;
import nutrii.application.model.Nutrii;
import nutrii.application.model.User;

/**
 * This class contains the methods that the user will be interacting with
 * @author Blake & Ellaira
 */
public class CLIView {

    private Nutrii nutrii;
    private Scanner scan = new Scanner(System.in);
    private FoodItemDatabase theDB;
    private ArrayList<User> userList;
    private ArrayList<Food> foodList;
    private ArrayList<Drink> drinkList;
    private ArrayList<FoodItem> meal;
    private User currentUser;

    public CLIView(Nutrii n) {
        nutrii = n;
       // userList = nutrii.getUserList();
        theDB = nutrii.getFoodItemDatabase();
        foodList = theDB.getFoodDB();
        drinkList = theDB.getDrinkDB();
    }
 
    //starting point
    public void CLIStartPoint() {

        System.out.println("Welcome to Nutrii: a nutrition app that helps manage your nutrition.");
        while (true) {
            System.out.print("Menu: \n"
                    + "===================\n"
                    + "1. Select User \n"
                    + "2. Create User \n"
                    + "3. Exit \n"
                    + "===================\n");

            try {
                int response = scan.nextInt();
                scan.nextLine();
                if (response == 1) {
                    if (userList.isEmpty()) {
                        System.out.println("There are no users to choose from. Please create a new User profile.");
                    } else {
                        currentUser = SelectUser();
                        nutrii.setCurrentUser(currentUser); //sets the current user 
                        UserSelectedMenu();
                    }
                } else if (response == 2) {
//                    nutrii.createNewUser();
                } else if (response == 3) {
                    //Exit
                    System.out.print("\nExiting Program... Thank you for using Nutrii, and stay healthy.\n");
                    System.exit(0);
                } else {
                    System.err.print("You need to choose from the options!\n");

                }
                System.out.flush();
            } catch (InputMismatchException e) {
                System.err.println("Choose a number from the options!");
                scan.nextLine();
            }
        }
    }

    //Select User Menu
    private User SelectUser() {
        System.out.println("Users:");

        for (User u : userList) {
            System.out.println(u.getName() + ": " + u.getClass().getSimpleName() + " User");
        }

        System.out.println("\nType in name of user to select (User names are case-sensitive):");

        while (true) {
            boolean isUserSelected = false;
            String selectedUser = scan.nextLine();
            Iterator<User> i = userList.iterator();

            while (i.hasNext()) {
                User u = i.next();
                if (u.equals(selectedUser)) {
                    currentUser = u;
                    isUserSelected = true;
                    break;
                }
            }
            if (!isUserSelected) {
                System.err.println("Could not find user, try again.");
                continue;
            }
            break;
        }

        System.out.println("Current User is: " + currentUser.getName() + "\n");

        return currentUser;
    }

    //adding to the user's meal list for the day
    public void addMeal() {
        meal = new ArrayList<>();
        int exit = 0;
        System.out.println("What would you like to name this meal?");
        String mealName = scan.nextLine();

        while (exit == 0) {
            System.out.println("Add to " + mealName + ":\n"
                    + "1. Add Food \n"
                    + "2. Add Drink \n"
                    + "3. Go Back to menu\n"
                    + "===================\n");
            try {
                int type = scan.nextInt();
                switch (type) {
                    case 1:
                        foodList.forEach((f) -> {
                            System.out.println((foodList.indexOf(f) + 1) + ": " + f);
                        });
                        addFoodItem(type);
                        break;
                    case 2:
                        drinkList.forEach((d) -> {
                            System.out.println((drinkList.indexOf(d) + 1) + ": " + d);
                        });
                        addFoodItem(type);
                        break;
                    case 3:
                        exit = 1;
                        break;
                    default:
                        System.err.println("Choose from the options.");
                        continue;
                }
                continue;
            } catch (InputMismatchException e) {
                System.err.println("Choose from the options.");
                scan.nextLine();
            }
        }

        if (!meal.isEmpty()) {
            Meal newMeal = new Meal(meal, mealName);
            nutrii.addToMealList(newMeal);
            nutrii.writeToReport(newMeal);
        }
    }

    public void addFoodItem(int type) {
        int exit = 0;
        while (exit == 0) {
            try {
                System.out.println("Add the item you would like to add to the meal or enter '0' to go back: ");
                int userIn = scan.nextInt();

                if (userIn != 0) {
                    if (type == 1) {
                        meal.add(foodList.get(userIn - 1));
                        System.out.println("Added: " + foodList.get(userIn - 1));
                    } else if (type == 2) {
                        meal.add(drinkList.get(userIn - 1));
                        System.out.println("Added: " + drinkList.get(userIn - 1));
                    }
                } else {
                    exit = 1;
                }
            } catch (InputMismatchException e) {
                System.err.println("Enter a valid number!");
            } catch (IndexOutOfBoundsException ie) {
                System.err.println("Enter a number from the options!!");
            }
            scan.nextLine();
        }
    }

    //User Options Menu
    private void UserSelectedMenu() {
       
        int exit = 0;

        while (exit == 0) {
            System.out.println("\nWhat would you like to do, " + currentUser.getName() + "? \n"
                    + "===================\n"
                    + "1. Add a meal\n"
                    + "2. Add Food Item : COMING IN FUTURE UPDATE!! \n"
                    + "3. View Today's Meals \n"
                    + "4. View Food Nutrition Info \n"
                    + "5. View User Profile \n"
                    + "6. View Nutrition Report\n"
                    + "7. Log Out\n"
                    + "===================\n");

            int response = scan.nextInt();
            scan.nextLine();
            //Add meal menu
            if (response == 1) {
                addMeal();
            } //Add Food Item menu
            else if (response == 2) {
                //This is not going to work for CLI 
                System.out.println("Because this would be unpractical while using a CLI, this will not be usable.");
                System.out.println("This feature will be available in Nutrii v.2 (GUI version)");
            } //View Food List Menu
            else if (response == 3) {
                if (!nutrii.getMeals().isEmpty()) {
                    for (Meal m : nutrii.getMeals()) {
                        m.printMeal();
                    }
                } else {
                    System.out.println("You haven't had any meals today :(");
                }
                continue;
            } //View Food Nutrtion Info Menu
            else if (response == 4) {
                printNutritionInformation();
            } else if (response == 5) {
                nutrii.printUserInfo();
            } else if (response == 6) {
                nutrii.readUserReport();
            } else if (response == 7) {
                currentUser = null;
                exit = 1;
            }
        }
    }

    //prints nutrition information for each of the food items stored in the file
    public void printNutritionInformation() {
        int exit = 0;
        while (exit == 0) {
            System.out.println("===================\n" 
                    +"View Nutrition info of an item: \n"
                    + "1. View Food List \n"
                    + "2. View Drink List \n"
                    + "3. Return To Menu \n"
                    + "===================\n");
            int type = 0;
            String chosenItem = "";
            try {
                type = scan.nextInt();
                scan.nextLine();

                if (type == 1) {
                    System.out.println("Food list:");
                    for (Food f : foodList) {
                        System.out.println(f);
                    }

                    System.out.println("\n" + "Type the name of the food item you want to view (Type in the complete name): ");
                    chosenItem = scan.nextLine();

                    for (Food f : foodList) {
                        if (f.equals(chosenItem)) {
                            f.printNutritionInfo();
                            break;
                        }
                    }

                } else if (type == 2) {
                    System.out.println("Drink list:");
                    for (Drink d : drinkList) {
                        System.out.println(d);
                    }

                    System.out.println("\n" + "Type the name of the drink item you want to view (Type in the complete name): ");
                    chosenItem = scan.nextLine();

                    for (Drink d : drinkList) {
                        if (d.equals(chosenItem)) {
                            d.printNutritionInfo();
                            break;
                        }
                    }
                } else if (type == 3) {
                    exit = 1;
                } else {
                    System.err.println("Choose from the options!");
                }
            } catch (InputMismatchException e) {
                System.err.println("Choose from the options please.");
                scan.nextLine();
            }
        }
    }
}
