package nutrii.application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A meal is an object containing an arraylist of food items
 * and information such as when and what time the meal was eaten
 * @author Blake & Ellaira
 */
public class Meal {

    private String name;
    private LocalDate date;
    private LocalDateTime time;
    private ArrayList<FoodItem> thisMeal;
    private Minerals mineralsCount;
    private Vitamins vitaminsCount;
    private Nutrients nutrientsCount;
    private FoodItemDatabase fdb;

    public Meal(ArrayList<FoodItem> arr, String n) {
        mineralsCount = new Minerals();
        vitaminsCount = new Vitamins();
        nutrientsCount = new Nutrients();
        thisMeal = arr;
        name = n;
        date = LocalDate.now();
        time = LocalDateTime.now();
        addAll();
    }

    public Meal(String s) {
        thisMeal = new ArrayList<FoodItem>();
        fdb = new FoodItemDatabase("Foods.csv", "Drinks.csv");
        mineralsCount = new Minerals();
        vitaminsCount = new Vitamins();
        nutrientsCount = new Nutrients();
        
        String[] m = s.split(",");
        date = LocalDate.parse(m[0]);
        time = LocalDateTime.parse(m[1]);
        name = m[2]; 

        //first 3 elements will always be the date, time and name
        // so we start at index 3 to read the food items
        for (int i = 3; i < m.length; i++) {
            for(int j = 0; j < fdb.getDB().size(); j++){
                if(fdb.getDB().get(j).equals(m[i])){
                    thisMeal.add(fdb.getDB().get(j)); 
                    break;
                }
            }
        }
        
        addAll(); 
    }

    public ArrayList<FoodItem> getMeal() {
        return thisMeal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * adds all the nutritional information of each food item
     */
    public void addAll() {
        for (FoodItem f : thisMeal) {
            Minerals m = f.getMinerals();
            Vitamins v = f.getVitamins();
            Nutrients n = f.getNutrients();

            //adds all the nutrients together
            m.returnList().forEach(
                    (key, val) -> mineralsCount.returnList().merge(key, val, (v1, v2) -> v1 + v2));
            v.returnList().forEach(
                    (key, val) -> vitaminsCount.returnList().merge(key, val, (v1, v2) -> v1 + v2));
            n.returnList().forEach(
                    (key, val) -> nutrientsCount.returnList().merge(key, val, (v1, v2) -> v1 + v2));
        }
    }

    /** 
     * this method is called when the meal is ready to be written to file
     * @return String containing details about the meal
     */
    public String writeMeal() {
        String toPrint = date + "," + time + "," + name;

        for (FoodItem m : thisMeal) {
            toPrint += "," + m.getFoodName();
        }
        return toPrint;
    }

    public Vitamins getVitamins(){
        return vitaminsCount;
    }
    
    public Minerals getMinerals(){
        return mineralsCount;
    }
    
    public Nutrients getNutrients(){
        return nutrientsCount;
    }

    @Override
    public String toString() {
        String formattedTime = time.getHour() + ":" + time.getMinute();
        System.out.println("You had " + name + " on: " + date.toString() + " at: " + formattedTime);
        printMeal();
        return "This meal is a total of: " + nutrientsCount.returnList().get("Calories") + " calories.";
    }

    /**
     * this method is called in the CLI for the user to read about the meal
     */
    public void printMeal() {
        System.out.println("This is what you had for " + name);
        thisMeal.forEach((f) -> {
            System.out.println(f);
        });
        System.out.println("");
    }

    @Override
    public boolean equals(Object o) {
        String st = (String) o;
        st.strip();
        return name.equals(st);
    }
}
