package nutrii.application;

import java.util.ArrayList;

/**
 *
 * @author Ellaira
 */
public class Meal {
    
    private ArrayList<FoodItem> thisMeal;
    private Minerals mineralsCount;
    private Vitamins vitaminsCount;
    private Nutrients nutrientsCount;
    
    public Meal(ArrayList<FoodItem> arr){
        mineralsCount = new Minerals();
        vitaminsCount = new Vitamins();
        nutrientsCount = new Nutrients();
        thisMeal = arr;
        addAll();
    }
    
    public ArrayList<FoodItem> getMeal(){
        return thisMeal;
    }
    
    public void addAll(){
        for(FoodItem f: thisMeal){
            Minerals m = f.getMinerals();
            Vitamins v = f.getVitamins();
            Nutrients n = f.getNutrients();

            m.returnList().forEach(
                    (key, val) -> mineralsCount.returnList().merge(key, val, (v1, v2) -> v1 + v2));
            v.returnList().forEach(
                    (key, val)-> vitaminsCount.returnList().merge(key, val, (v1, v2) -> v1 + v2));
            n.returnList().forEach(
                    (key, val)-> nutrientsCount.returnList().merge(key, val, (v1, v2) -> v1 + v2));
        }
    }
        
    public void printVitamins(){
        vitaminsCount.toString();
    }
    
    public void printNutrients(){
        nutrientsCount.toString();
    }  
    
     public void printMinerals(){
        mineralsCount.toString();
    }  
     
     public String toString(){
        return "This meal is a total of: " + nutrientsCount.returnList().get("Calories") + " calories.";     
     }
}
