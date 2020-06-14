package nutrii.application.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Ellaira
 */
@Entity
public class MealIdentity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    
    private String groupId;

    private int foodItemId;

    public MealIdentity() {
    }

    public MealIdentity(Meal m, int fid) {
        this.groupId = m.getUserId() + "." + m.getMealId() + "." + m.getDate().hashCode();
        this.foodItemId = fid;
    }

    public String getgroupId() {
        return groupId;
    }

    public void setgroupId(String id) {
        this.groupId = id;
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
