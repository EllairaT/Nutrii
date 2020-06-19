package nutrii.application.model;

import javax.persistence.*;
import nutrii.application.ItemActions;


/**
 * This class generates a single FoodItem table, with the classtype (Food/Drink)
 * being a column within a table. This is so we can make full use of polymorphic query performance
 * So we would only need to query on one entity, rather than two different entities. 
 * 
 * This class is the superclass for both types of items: food and drink
 * @author Blake & Ellaira
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "className", discriminatorType = DiscriminatorType.STRING)
public class FoodItem implements Comparable<FoodItem>, ItemActions{ 
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Column(name="name")
    protected String foodName;
    
    @Transient
    private Nutrients nutrients;
   
    @Transient
    private Minerals minerals;

    @Transient
    private Vitamins vitamins;
    
//    @EmbeddedId
//    private FoodItemIdentity foodItemIdentity;
    
    @Column(name="class_name")
    protected String className;
    
    @Column(name="is_eaten")
    protected boolean isEaten;
   
    public FoodItem(String name){
        className = getClass().getSimpleName();
        this.setFoodName(name);
        
        isEaten = true;
    }
    
    public FoodItem(){}
    
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public boolean isIsEaten() {
        return isEaten;
    }

    public void setIsEaten(boolean isEaten) {
        this.isEaten = isEaten;
    }

    @Override
    public boolean isConsumed(boolean b){ 
      isEaten = b; //fooditem is assumed to be consumed by default
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return this.foodName;
    }
    
    public void printNutritionInfo(){
        System.out.println(className + ": " + foodName + "\n");

    }

    public boolean equals(String f){
        String st = f;
        return foodName.equals(st);
    }
}
