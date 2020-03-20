package nutrii.application;

import java.io.IOException;

/**
 * This class is responsible for reading files 
 * that contain the information about different foods.
 * 
 * @author Ellaira
 */
public class FoodItemDatabase {
    //no need for arraylist to store all fooditems, too much data
    //instead, keep reading information in the file
    //and add information to the relevant file if needed
    //threads can be used for this?
    public FoodItemDatabase(){
        
    }
    
    /**
     * 
     * @param f
     * @return
     * @throws IOException if file cannot be found.
     */
    public boolean addFoodItem(FoodItem f) throws IOException{
        
        boolean isSuccessful = true;
        
        if (f instanceof Food){
            //add code to add fooditem to food file
            //to check if item has been added, simply search the file after adding
            //or there might be a method out there
            
        }
        else if(f instanceof Drink){
            //...to drink file
        }
        else if(f instanceof Supplement){
            //...to supplement file
            
        }
        else{
            isSuccessful = false;
        }
        return isSuccessful;
    }
    
    
        
}
