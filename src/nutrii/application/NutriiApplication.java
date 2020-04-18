package nutrii.application;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
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
    private Nutrii nutrii;
    private FoodItemDatabase fdb;
    
    public static void main(String[] args) { 
       
       User un = new Sedentary("Ellaira", 'f', LocalDate.of(2000, Month.MAY, 23),150f, 47.2f);
       User aw = new VeryActive("Blake", 'm', LocalDate.of(2000, Month.AUGUST, 13),180f, 52f);
       System.out.println(un.toString());

        try {
            saveUser(un);
            saveUser(aw);
        } catch (IOException ex) {
            System.err.println("something went wrong rip: " + ex);
        }
        
        //this shit works ok 
//        System.out.println("\nMINERALS:\n");
//        Compounds min = new Nutrients();
// 
//        try {
//            min.update("Protein", 12.0f);
//        } catch (NoSuchElementException ex) {
//            System.err.println(ex.getMessage());
//        }
   //   min.returnList().forEach((key, value)-> {System.out.println(key + ": " + value);});
    }
    
    public ArrayList<FoodItemDatabase> recordFoodItems(FoodItemDatabase fdb){
        return new ArrayList<FoodItemDatabase>();
    }
    
    public void getReports(){
        
    }
    
    public User createNewUser(){
       //make user, return user
       //make sure user doesnt try to create a duplicate user
       return null; //placeholder 
    }
    
    public static void saveUser(User user) throws IOException{
        //im not gonna write code to remove dupes. ill just stop that when user tries to make a dupe user lmao
        
        try (FileWriter fw = new FileWriter("NUTRII_USERS.txt", true)) {
            fw.write(user.toWrite()+"\n");
        }
    }
     
    public void updateUserDetails(User u){
        //update user details here
    }
    
}
