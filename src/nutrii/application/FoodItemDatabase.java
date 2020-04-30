package nutrii.application;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is responsible for reading files 
 * that contain the information about different foods.
 * 
 * @author Blake
 */
public class FoodItemDatabase {
    //no need for arraylist to store all fooditems, too much data
    //instead, keep reading information in the file
    //and add information to the relevant file if needed
    //threads can be used for this?
    private ArrayList<FoodItem> DB;
        
    public FoodItemDatabase(String fileOfFoodStuff){
        DB = new ArrayList<>();
    }
    
   public String[] getFoodItemsList() throws IOException {
        File file = new File("FoodItems.txt");
        String[] ItemsList = null;
       
        try (FileReader fr = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fr);

            //Find items in database (just first row or names of items)
            String line = br.readLine();
            ItemsList = line.split(",");
        }
        catch (FileNotFoundException e) {
        }
        return ItemsList;
    }
   
    public ArrayList<FoodItem> getFoodItemDetails(String FoodItem) throws IOException {
        File file = new File("FoodItems.txt");
        ArrayList<String> itemsList = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String[] LinesList;
            LinesList = null;
            int numOfLine = 0; 
            
            for(String line; (line = br.readLine()) != null;) {
                LinesList[numOfLine] = line;
                ++numOfLine;
            }
           
            br.close();
            
            String[][] AllItems = null;
            
            for (int row = 0; row < numOfLine; row++) {
               
                String[] SeperatedItemsList;
                SeperatedItemsList = LinesList[row].split(",");
                
                
                for (int column = 0; column < SeperatedItemsList.length; column++) { //This line has num 42 which represents the amount of columns in the file
                    
                    AllItems[row][column] = SeperatedItemsList[column];
                    itemsList.add(AllItems[row][column]);
                }
            }
        }
        
         return itemsList;
     }
   
    /**
     * 
     * @param f
     * @return
     * @throws IOException if file cannot be found.
     * 
     */
     
    public boolean addFoodItem(FoodItem f) throws IOException{
        
        boolean isSuccessful = true;
        
        if (f instanceof Food){
            //add code to add fooditem to food file
            //to check if item has been added, simply search the file after adding
            //or there might be a method out there
            File file = new File("FoodItems.txt");
            
            
        }
        else if(f instanceof Drink){
            //...to drink file
            File file = new File("DrinkItems.txt");
            
        }
        else if(f instanceof Supplement){
            //...to supplement file
            File file = new File("SupplementItems.txt");
            
        }
        else{
            isSuccessful = false;
        }
        return isSuccessful;
    }
      
}
