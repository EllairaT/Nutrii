package nutrii.application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.undo.CompoundEdit;

/**
 * This class is responsible for reading files that contain the information
 * about different foods.
 *
 * @author Blake
 */
public final class FoodItemDatabase {

    private static ArrayList<FoodItem> DB;
    private static String[][] foodMatrix;
    private static File file;
    private static String[] items;

    public FoodItemDatabase(String fileOfFoodStuff) {
        file = new File(fileOfFoodStuff);
        DB = new ArrayList<>();

        try {
            items = setFoodItemsList();
            createMatrix();
            setFoodItemDetails();

        } catch (IOException ex) {

        }
    }

    public static ArrayList<FoodItem> getDB() {
        return DB;
    }
    
    public FoodItem getItem(String i){
        FoodItem item = null;
        for(FoodItem f : DB){
            if(f.getFoodName().contains(i))
                item = f;
        }
        return item;
    }
    

    public String[] setFoodItemsList() throws IOException {
        String[] itemList = null;

        try ( FileReader fr = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fr);

            //Find items in database (just first row or names of items)
            String line = br.readLine();
            itemList = line.split(",");
        } catch (FileNotFoundException e) {
        }
        return itemList;
    }

    public String[] getFoodItemsList() {
        return items;
    }

    public static void createMatrix() throws IOException {
        FileReader fr = new FileReader(file);

        List<String[]> rows = new ArrayList<>();

        BufferedReader br = new BufferedReader(fr);
        String line;

        while ((line = br.readLine()) != null) {
            String[] lineToList = line.split(",");
            rows.add(lineToList);
        }
        br.close();

        foodMatrix = new String[rows.size()][];

        for (int i = 0; i < rows.size(); i++) {
            String[] row = rows.get(i);
            foodMatrix[i] = row;
        }
    }
//

    public void setFoodItemDetails() {

        for (int col = 0; col < items.length; col++) {
            if (col == 0) {
                continue;
            }
            
            FoodItem food = new Food(foodMatrix[0][col]);

            for (String[] foodMatrix1 : foodMatrix) {  
                if (foodMatrix1 == foodMatrix[0]) {
                    continue;
                }
                
                float value = 0.0f;
                String val = foodMatrix1[col];
                val = val.replaceAll("[^0-9.]+", "");

                if (val.length() == 0) {
                    val = "0";
                } else {
                    value = Float.parseFloat(val);
                }
                
                String compound = foodMatrix1[0];
             
                if(compound.contains("*n")){
                    compound = compound.replace("*n", "");           
                    food.getNutrients().update(compound, value);
                    
                } else if(compound.contains("*m")){
                    compound = compound.replace("*m", "");
                    food.getMinerals().update(compound, value);
                    
                } else {
                    food.getVitamins().update(compound, value);
                }
            }
            DB.add(food);
        }
    }

    /*
               for (int row = 1; row <= foodMatrix.length; row++) {
               
                for (int col = 1; col <= foodMatrix.length; col++) {
                    float value = 0.0f;
                    Compounds c = null;
                    
                    String val = foodMatrix[row][col];
                    val = val.replaceAll("[^0-9]", "");
                    
                    if(val.length() == 0){  
                      val = "0";
                    }
                    else{
                        value = Float.parseFloat(val);
                    }
                    
                    String compoundName = foodMatrix[row][0];
                        
                    if ((compoundName.contains("*n"))) {
                        compoundName = compoundName.replace("*n", "");
                        c = new Nutrients();
                        f.setNutrients(c);         
                    } else if ((compoundName.contains("*m"))) {
                        compoundName = compoundName.replace("*m", "");
                        c = new Minerals();
                        f.setMinerals(c);
                    } else if ((compoundName.contains("Vitamin"))) {
                        c = new Vitamins();
                        f.setVitamins(c);
                    }
                    if(c != null){
                        c.update(compoundName, value);
                        System.out.println(f.getFoodName() + " " + compoundName + " " + value);
                    } 
                }
            }
     */
    /**
     *
     * @param f
     * @return
     * @throws IOException if file cannot be found.
     *
     */
    public boolean addFoodItem(FoodItem f) throws IOException {

        boolean isSuccessful = true;

        if (f instanceof Food) {
            //add code to add fooditem to food file
            //to check if item has been added, simply search the file after adding
            //or there might be a method out there
            File file = new File("FoodItems.txt");

        } else if (f instanceof Drink) {
            //...to drink file
            File file = new File("DrinkItems.txt");

        } else if (f instanceof Supplement) {
            //...to supplement file
            File file = new File("SupplementItems.txt");

        } else {
            isSuccessful = false;
        }
        return isSuccessful;
    }

}
