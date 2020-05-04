package nutrii.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.sort;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * this class handles all the application functions 
 * i.e. adding users, editing users, getting reports and recording of 
 * food items.
 * @author Ellaira
 */
public class NutriiApplication {

    /**
     * @param args the command line arguments
     */
    //private Nutrii nutrii;
    private static FoodItemDatabase fdb;
    private static final String USER_FILE = "NUTRII_USERS.txt";
    
    public static void main(String[] args) { 
       fdb = new FoodItemDatabase("Foods.csv", "Drinks.csv");
      
        System.out.println("");
        
        for(FoodItem f : fdb.getDB()){
            System.out.println(f);
        }
        //BEFORE ADDING ANY FOODITEM OBJECT IN A MEAL OBJECT, 
        //ASK IF THE USER WANTS TO REMOVE A FOOD ITEM FROM THE CURRENT ARRAYLIST
        //IF YES, ASSIGN A BOOLEAN FALSE TO THE .isConsumed() METHOD
        //ALL FOODITEMS WILL HAVE A TRUE VALUE BY DEFAULT.
        //THIS IS DONE SO WE CAN GIVE THE USER THE OPTION TO "BRING BACK" FOOD TO THE MEAL
        //(in case they feel guilty about lying about their fattiness lmao)
    }
         
    
    public ArrayList<FoodItemDatabase> recordFoodItems(FoodItemDatabase fdb){
        return new ArrayList<FoodItemDatabase>();
    }
    
    public void getReports(){
        
    }
    
    //user stuff
    public User createNewUser(){
       //make user, return user
       //make sure user doesnt try to create a duplicate user
       return null; //placeholder 
    }
    
    public static void saveUser(User user) throws IOException{
        //im not gonna write code to remove dupes. ill just stop that when user tries to make a dupe user lmao 
        try (FileWriter fw = new FileWriter(USER_FILE, true)) {
            fw.write(user.toWrite()+"\n");
        }
    }
     
    public void updateUserDetails(User u){
        //update user details here
    }
    
    /**
     * reads the text file of users information
     * also instantiates the correct type of user object (sedentary, veryactive, etc)
     * based on the information given from the text file
     * 
     * @return arraylist of User objects
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException 
     */
    public static ArrayList<User> readUserFile() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException{
        ArrayList<User> userList = new ArrayList<>();
        try{
            String line;
            
            BufferedReader reader = new BufferedReader(new FileReader(USER_FILE));
            
            while((line = reader.readLine()) != null){
                String[] s = line.split(","); 
                //find the classname, which is the last item in each line
                Class<?> className = Class.forName(s[s.length-1]);
                Constructor con = className.getConstructor(String.class);
                
                Object userObj = con.newInstance(line);
                 
                System.out.println("\n heya this is what i read : " + userObj.toString());
                if(userObj instanceof VeryActive){ //check to make sure its an actual object now aye
                    System.out.println("ayyy");
                }

            }  
        } catch (IOException e){
            System.err.println("File could not be read.");
        }
        return userList;
    }
    
}
