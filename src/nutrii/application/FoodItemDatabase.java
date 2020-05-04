package nutrii.application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

        }
    }

    public ArrayList<FoodItem> getDB() {
        return DB;
    }

    public ArrayList<FoodItem> getDrinkDB() {
        ArrayList<FoodItem> drink = new ArrayList<>();
        for (FoodItem d : getDB()) {
            if (d instanceof Drink) {
                drink.add(d);
            }
        }
        return drink;
    }

    public ArrayList<FoodItem> getFoodDB() {
        ArrayList<FoodItem> foodOnly = new ArrayList<>();
        for (FoodItem f : getDB()) {
            if (f instanceof Food) {
                foodOnly.add(f);
            }
        }
        return foodOnly;
    }

    public FoodItem getItem(String i) {
        FoodItem item = null;
        for (FoodItem f : DB) {
            if (f.getFoodName().contains(i)) {
                item = f;
            }
        }
        return item;
    }

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

    public void setFoodItemDetails(String[][] m, File f) {

        boolean isItFood = f.getName().equals("Foods.csv");
        int items = isItFood ? foodItems.length : drinkItems.length;

        for (int col = 0; col < items; col++) {
            if (col == 0) {
                continue;
            }

            FoodItem foodItem = isItFood ? new Food(m[0][col]) : new Drink(m[0][col]);

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

                String compound = foodMatrix1[0];

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
