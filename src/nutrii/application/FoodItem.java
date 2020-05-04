package nutrii.application;

/**
 *
 * @author Ellaira
 */
public class FoodItem implements Comparable<FoodItem>, ItemActions { 
    protected String foodName;
    private Nutrients nutrients;
    private Minerals minerals;
    private Vitamins vitamins;
    protected String className;
    protected boolean isEaten;
   
    public FoodItem(String name){
        className = getClass().getSimpleName();
        this.setFoodName(name);
        nutrients = new Nutrients();
        minerals = new Minerals();
        vitamins = new Vitamins();
        isEaten = true;
    }
    
    @Override
    public boolean isConsumed(boolean b){ 
      isEaten = b;
      return b;  
    }

    @Override
    public int compareTo(FoodItem f1){
        //compare by calorie amount
        return(int) (nutrients.returnList().get("Calories") - f1.getNutrients().returnList().get("Calories")) ;
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
    
    @Override
    public String toString(){
        return className + ": " + foodName + " (" + nutrients.returnList().get("Calories") + " cal)";
    }
    
    public void printNutritionInfo(){

        System.out.println(className + ": " + foodName + "\n");
     
        nutrients.toString();
        System.out.println("");
        minerals.toString();
        System.out.println("");
        vitamins.toString();
    }
}
