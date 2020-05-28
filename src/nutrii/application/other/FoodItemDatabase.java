package nutrii.application.other;

import nutrii.application.model.Drink;
import nutrii.application.model.Food;
import nutrii.application.model.FoodItem;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is responsible for reading files that contain the information
 * about different foods.
 *
 * @author Blake & Ellaira
 */
public final class FoodItemDatabase {
    private static ArrayList<FoodItem> DB;
    private static String[][] foodMatrix;
    private static String[][] drinkMatrix;
    private static File food;
    private static File drinks;
    private static String[] foodItems;
    private static String[] drinkItems;
    private static File[] files;

    public FoodItemDatabase(String foodFile, String drinkFile) {
        DB = new ArrayList<>();
        food = new File(foodFile);
        drinks = new File(drinkFile);

        files = new File[2];
        files[0] = food;
        files[1] = drinks;

        try {
            foodItems = setFoodItemsList(food);
            drinkItems = setFoodItemsList(drinks);

            foodMatrix = createMatrix(food);
            drinkMatrix = createMatrix(drinks);

            setFoodItemDetails(foodMatrix, food);
            setFoodItemDetails(drinkMatrix, drinks);

        } catch (IOException ex) {
            System.err.println("Something went wrong.");
        }
    }

    public ArrayList<FoodItem> getDB() {
        return DB;
    }

    //get arraylist of only drinks
    public ArrayList<Drink> getDrinkDB() {
        ArrayList<Drink> drink = new ArrayList<>();
        for (FoodItem d : getDB()) {
            if (d instanceof Drink) {
                drink.add((Drink) d);
            }
        }
        return drink;
    }
    //get arraylist of only food
    public ArrayList<Food> getFoodDB() {
        ArrayList<Food> foodOnly = new ArrayList<>();
        for (FoodItem f : getDB()) {
            if (f instanceof Food) {
                foodOnly.add((Food) f);
            }
        }
        return foodOnly;
    }

    /**
     * searches through the arraylist to find the food that matches the user's input
     * @param i String for the food name
     * @return the food item that matches the food name
     */
    public FoodItem getItem(String i) {
        FoodItem item = null;
        for (FoodItem f : DB) {
            if (f.getFoodName().contains(i)) {
                item = f;
            }
        }
        return item;
    }
    
/**
 * creates a string array containing all the food names
 * @param f the food/drink file passed into the method
 * @return string array of food names
 * @throws IOException 
 */
    public String[] setFoodItemsList(File f) throws IOException {
        String[] itemList = null;

        try ( FileReader fr = new FileReader(f)) {
            BufferedReader br = new BufferedReader(fr);

            //Find items in database (just first row or names of items)
            String line = br.readLine();

            itemList = line.split(",");

        } catch (FileNotFoundException e) {

        }
        return itemList;
    }

    public String[] getFoodItemsList() {
        return foodItems;
    }

    public String[] getDrinkItemsList() {
        return drinkItems;
    }

    public String[] getAllItemsList() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, foodItems);
        Collections.addAll(list, drinkItems);

        return list.toArray(new String[0]);
    }

    /**
     * creates a matrix that details all of the food nutrition information
     * @param f the file passed to the method
     * @return a matrix of food items and their information
     * @throws IOException 
     */
    public static String[][] createMatrix(File f) throws IOException {
        FileReader fr = new FileReader(f);

        List<String[]> rows = new ArrayList<>();

        BufferedReader br = new BufferedReader(fr);
        String line;

        while ((line = br.readLine()) != null) {
            String[] lineToList = line.split(",");
            rows.add(lineToList);
        }

        br.close();

        String[][] matrix = new String[rows.size()][];

        for (int i = 0; i < rows.size(); i++) {
            String[] row = rows.get(i);
            matrix[i] = row;

        }
        return matrix;
    }

    /**
     * this method turns each food item string in the matrix into an actual FoodItem object
     * @param m the matrix passed into the method
     * @param f the food/drink file, determines if a food or drink item is being read
     */
    public void setFoodItemDetails(String[][] m, File f) {
        boolean isItFood = f.getName().equals("Foods.csv");
        int items = isItFood ? foodItems.length : drinkItems.length;

        //skip the first column, as it only contains the compound names
        for (int col = 0; col < items; col++) {
            if (col == 0) {
                continue;
            }

            //create fooditem/drinkitem
            FoodItem foodItem = isItFood ? new Food(m[0][col]) : new Drink(m[0][col]);

            //skip first row, as it only contains the food names
            for (String[] foodMatrix1 : m) {
                if (foodMatrix1 == m[0]) {
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
                //read the compound name in the first column (that was skipped earlier)
                String compound = foodMatrix1[0];
                
                //then assign the proper value to that compound
                if (compound.contains("*n")) {
                    compound = compound.replace("*n", "");
                    foodItem.getNutrients().update(compound, value);

                } else if (compound.contains("*m")) {
                    compound = compound.replace("*m", "");
                    foodItem.getMinerals().update(compound, value);

                } else {
                    foodItem.getVitamins().update(compound, value);
                }
            }
            DB.add(foodItem);
        }
    }

}
