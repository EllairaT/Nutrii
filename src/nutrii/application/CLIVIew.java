/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutrii.application;
import java.util.Scanner;
/**
 *
 * @author Blake
 */
public class CLIVIew {
    Scanner scan = new Scanner(System.in);
            
    public CLIView(String[] user[]) {    
        User user;
        Meal meal;
        FoodItemDatabase FID = new FoodItemDatabase();
        
        CLIStartPoint();
    }
 
    //Start Menu
    public void CLIStartPoint() {
        System.out.println("Menu: /n"
            + "===================/n"
            + "1. Select User /n"
            + "2. Create User /n"
            + "3. Exit /n"
            + "===================");
            
        int response = scan.nextInt();
        
        if (response == 1) {
            SelectUser();
        }
        else if (response == 2) {
            CreateUser();
        }
        if (response == 3) {
            //Exit
            System.out.println("/n/nExiting Program./n");
        }
    }

    //Select User Menu
    private String SelectUser() {
        System.out.println("Users: /n");
        
        for (int i = 0; i < numOfUsers; i++) {
            System.out.println(user[i]);
        }
        
        System.out.println("/nType in name of user to select (capitals matter):");
        String selectedUser = scan.nextLine();
        
         for (int i = 0; i < numOfUsers; i++) {
            if (selectedUser.equals(user[i])) {
                //return user[i];
            }
        }
        
    }

    //Create User Process
    private void CreateUser() {
        System.out.println("Create New User: /n "
            + "===================/n");
        System.out.println("/n What is your name?: /n");
        String name = scan.nextLine();
        System.out.println("/n What is your height (cm)?: /n");
        int height = scan.nextInt();
        System.out.println("/n What is your weight (kg)?: /n");
        int weight = scan.nextInt();
        
        System.out.println("/n DD/MM/YYYY");
        System.out.println("/n What Year were you born? /n");
        int year = scan.nextInt();
        System.out.println("/n What Month were you born? /n");        
        int month = scan.nextInt();
        System.out.println("/n What day of the month were you born? /n");     
        int day = scan.nextInt();
       
        System.out.println("/n How often do you excercise a week? /n");     
        int ExcerciseFreq = scan.nextInt();
        
    }
    
    //Options Menu
    private void UserSelectedMenu() {
          System.out.println("User Menu: /n"
           + "===================/n"
           + "1. Add to Consumed List /n"   
           + "2. Add Food Item /n"
           + "3. View Food List /n"
           + "4. View Food Nutrition Info /n"
           + "===================/n");
          
           int response = scan.nextInt();
           
           //Add Consumed List menu
           if (response == 1) {
               System.out.println("Type: /n" 
               + "1. Add Food /n"
               + "2. Add Drink /n"
               + "3. Add Meal /n"
               + "===================/n");
               
               int type = scan.nextInt();
               
                if (type == 1) {
                    
                }
                else if (type == 2) {
                   
                }
                else if (type == 3) {
                   
                }
           }
           //Add Food Item menu
           else if (response == 2) {
               System.out.println("Create new: /n" 
               + "1. Food /n"
               + "2. Drink /n"
               + "3. Meal /n"
               + "===================/n");
               
               //This is not going to work for CLI 
               System.out.println("Because this would be unpractical, while using a CLI, this will not be usable.");
           }
           
           //View Food List Menu
           else if (response == 3) {
               System.out.println("All items in: /n" 
               + "1. View Food List /n"
               + "2. View Drink List /n"
               + "3. View Meal List /n"
               + "===================/n");
                
               int type = scan.nextInt();
               
                if (type == 1) {
                    
                }
                else if (type == 2) {
                   
                }
                else if (type == 3) {
                   
                }
           }

           //View Food Nutrtion Info Menu
           else if (response == 4) {
               System.out.println("View Nutrtion info of an item: /n" 
               + "1. View Food List /n"
               + "2. View Drink List /n"
               + "3. View Meal List /n"
                    
               + "===================/n");
                
               int type = scan.nextInt();
               
               /*================================
               *  View Nutrtion info for FOOD item
               */
                if (type == 1) {
                    System.out.println("Food list:  /n");
                    
                    for (int i = 0; I < numFoodItems; i++) {
                        System.out.println("- " + FoodItem[i]);
                    }
                    
                    System.out.println("/n" + "Type the name of the food item you want to view (Capitals matter): ");
                    String ChosenItem = scan.nextLine();
                    
                    for (int i = 0; I < numFoodItems; i++) {
                        if (ChosenItem.equals(FoodItem[i])) {
                            System.out.println(FoodItem[i]);
                        }
                    }
                }
               /*================================
               * View Nutrtion info for DRINK item
               */
                else if (type == 2) {
                   System.out.println("Drink list:  /n");
                    
                    for (int i = 0; I < numWaterItems; i++) {
                        System.out.println("- " + DrinkItem[i]);
                    }
                    
                    System.out.println("/n" + "Type the name of the Drink item you want to view (Capitals matter): ");
                    String ChosenItem = scan.nextLine();
                    
                    for (int i = 0; I < numDrinkItems; i++) {
                        if (ChosenItem.equals(DrinkItem[i])) {
                            System.out.println(DrinkItem[i]);
                        }
                    }
                }
               /*================================
               * View Nutrtion info for MEAL item
               */
                else if (type == 3) {
                   System.out.println("Meal list:  /n");
                    
                    for (int i = 0; I < numMealtems; i++) {
                        System.out.println("- " + MealItem[i]);
                    }
                    
                    System.out.println("/n" + "Type the name of the Meal item you want to view (Capitals matter): ");
                    String ChosenItem = scan.nextLine();
                    
                    for (int i = 0; I < numMealItems; i++) {
                        if (ChosenItem.equals(Mealtem[i])) {
                            System.out.println(MealItem[i]);
                        }
                    }
                }
           }
    }
}
