package nutrii.application.model;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.persistence.*;
import nutrii.application.ItemActions;
import org.hibernate.HibernateException;
import org.hibernate.type.*;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;
import org.hibernate.usertype.UserType;


/**
 * This class is the superclass for both types of items: food and drink
 * @author Blake & Ellaira
 */
@Entity
@Table(name="Food_Item")
public class FoodItem implements Comparable<FoodItem>, ItemActions{ 
    
    @Id
    private int id;
    
    @Column(name="name")
    protected String foodName;
   
    @Embedded private Nutrients nutrients;
    
    @Embedded private Minerals minerals;

    @Embedded private Vitamins vitamins;
    
    @Column(name="class_name")
    protected String className;
    
    @Column(name="is_eaten")
    protected boolean isEaten;
   
    public FoodItem(String name){
        className = getClass().getSimpleName();
        this.setFoodName(name);
        nutrients = new Nutrients();
        minerals = new Minerals();
        vitamins = new Vitamins();
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
    
    //this is not being used for the CLI
    //for the next phase of the program, this will be used to remove items from the meal list 
    //in case the user makes a mistake in entering a food item.
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

    public boolean equals(String f){
        String st = f;
        return foodName.equals(st);
    }
}
