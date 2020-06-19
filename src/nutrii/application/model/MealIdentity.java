package nutrii.application.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * An object of this class contains: 
 * Meal Id - the id of the meal it belongs to
 * Group Id - combination of the user id, meal id, and a hashCode of the date 
 * FoodItemId - id of the foodItem
 * 
 * Basically, this class generates a table where we can find all food items
 * associated with a specific meal, hence the use of the foodItemId and the MealId
 * @author Ellaira
 */
@Entity
public class MealIdentity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String groupId;

    private int foodItemId;

    private int mealId;

    private int userId;
    
    public MealIdentity() {
    }

    public MealIdentity(Meal m, int fid) {
        this.groupId = m.getUserId() + "." + m.getMealId() + "." + m.getDate().hashCode();
        this.foodItemId = fid;
        this.mealId = m.getMealId();
        this.userId = m.getUserId();
    }

    public int getUserId (){
        return userId;
    }
    
    public String getgroupId() {
        return groupId;
    }

    public void setgroupId(String id) {
        this.groupId = id;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public int getFoodItemId() {
        return foodItemId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }
}
