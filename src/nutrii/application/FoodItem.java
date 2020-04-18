package nutrii.application;

import java.util.Comparator;

/**
 *
 * @author Ellaira
 */
public class FoodItem implements Comparator<FoodItem>, ItemActions { 
    protected String foodName;
    protected Nutrients nutrients;
    protected Minerals minerals;
    protected Vitamins vitamins;
   
    public FoodItem(String name){
        this.setFoodName(name);
    }
    
    @Override
    public boolean isConsumed(){ 
      return false;  
    }
    
    @Override
    public boolean isDiscarded(){
        return false;
    }
    
    @Override
    public int compare(FoodItem f1, FoodItem f2){
        return 0;
    }

    /**
     * @return the foodName
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     * @param foodName the foodName to set
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * @return the minerals
     */
    public Minerals getMinerals() {
        return minerals;
    }

    /**
     * @param minerals the minerals to set
     */
    public void setMinerals(Minerals minerals) {
        this.minerals = minerals;
    }

    /**
     * @return the nutrients
     */
    public Nutrients getNutrients() {
        return nutrients;
    }

    /**
     * @param nutrients the nutrients to set
     */
    public void setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
    }

    /**
     * @return the vitamins
     */
    public Vitamins getVitamins() {
        return vitamins;
    }

    /**
     * @param vitamins the vitamins to set
     */
    public void setVitamins(Vitamins vitamins) {
        this.vitamins = vitamins;
    }
    
    public void printNutritionInfo(){
        String className = getClass().getSimpleName();
        System.out.println(className + ": " + foodName + "\n");
        
        System.out.println(nutrients.toString());
        System.out.println(vitamins.toString());
        System.out.println(minerals.toString());
        
    }
   
}
