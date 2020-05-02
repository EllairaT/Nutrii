package nutrii.application;

import java.util.Comparator;

/**
 *
 * @author Ellaira
 */
public class FoodItem implements Comparator<FoodItem>, ItemActions { 
    protected String foodName;
    private Nutrients nutrients;
    private Minerals minerals;
    private Vitamins vitamins;
   
    public FoodItem(String name){
        this.setFoodName(name);
        nutrients = new Nutrients();
        minerals = new Minerals();
        vitamins= new Vitamins();
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
    public void setMinerals(Minerals c) {
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
    public void setNutrients(Nutrients c) {
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
    public void setVitamins(Vitamins c) {
        this.vitamins = vitamins;
    }
    
    public void printNutritionInfo(){
        String className = getClass().getSimpleName();
        System.out.println(className + ": " + foodName + "\n");
        
        nutrients.toString();
        System.out.println("");
        minerals.toString();
        System.out.println("");
        vitamins.toString();
    }

   
}
