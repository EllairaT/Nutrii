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
    }
    
    public ArrayList<FoodItem> getMeal(){
        return thisMeal;
    }
    
    public void addAll(){
        for(FoodItem f: thisMeal){
            Minerals m = f.getMinerals();
            Vitamins v = f.getVitamins();
            Nutrients n = f.getNutrients();
            m.returnList().forEach((key, value)-> {mineralsCount.update(key, value);});
            v.returnList().forEach((key, value)-> {vitaminsCount.update(key, value);});
            n.returnList().forEach((key, value)-> {nutrientsCount.update(key, value);});
        }
    }
        
    public void printVitamins(){
        vitaminsCount.returnList().forEach((key, value)-> {System.out.println(key + ": " + value);});
    }
    
    public void printNutrents(){
        nutrientsCount.returnList().forEach((key, value)-> {System.out.println(key + ": " + value);});
    }  
    
     public void printMinerals(){
        mineralsCount.returnList().forEach((key, value)-> {System.out.println(key + ": " + value);});
    }  
}
