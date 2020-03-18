package nutrii.application;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 *
 * @author Ellaira
 */
public class NutriiApplication {

    /**
     * @param args the command line arguments
     */
    private Nutrii nutrii;
    private FoodItemDatabase fdb;
    
    public static void main(String[] args) {
//        System.out.println("Nutrii");
//        System.out.println("Nutrition tracking app");
//        
//        User u = new Sedentary("Ellaira", 'f', LocalDate.of(2000, Month.MAY, 23), 150f, 47.2f);
//        
//        System.out.println(u);
//        System.out.println();
//        User blake = new ModeratelyActive("Blake", 'm', LocalDate.of(2000, Month.AUGUST, 13), 180f, 53f);
//        System.out.println(blake);
        
        Vitamins vit = new Vitamins();

        vit.returnList().forEach((key, value)-> {System.out.println(key + " : " + value );});
        
        try {
            vit.update("Vitamin asfd", 12.0f);
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }
        
        
        System.out.println("\nMINERALS:\n");
        Compounds min = new Minerals();
        
        try {
            min.update("dsfbdfsjbkdsgjkdgsfjbk", 12.0f);
        } catch (NoSuchElementException ex) {
            System.err.println(ex.getMessage());
        }
        
        min.returnList().forEach((key, value)-> {System.out.println(key + " : " + value);});
    }
    
    public ArrayList<FoodItemDatabase> recordFoodItems(FoodItemDatabase fdb){
        return new ArrayList<FoodItemDatabase>();
    }
    
    public void getReports(){
        
    }
    
    public User createNewUser(){
       //make user, return user
    }
    
    public void updateUserDetails(User u){
        //update user details here
    }
    
}
