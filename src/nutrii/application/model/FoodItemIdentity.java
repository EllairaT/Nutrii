package nutrii.application.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Ellaira
 */
@Entity
public class FoodItemIdentity implements Serializable {

    @Id
    private String id;

    @Column(nullable = false)
    private int foodItemId;

    @Column(nullable = false)
    private int compoundID;

    @Column
    private float value;

    public FoodItemIdentity() {
    }

    public FoodItemIdentity(int fi, int ci) {
        this.foodItemId = fi;
        this.compoundID = ci;
        this.id = fi + "_" + ci;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    public int getCompoundID() {
        return compoundID;
    }

    public void setCompoundID(int compoundID) {
        this.compoundID = compoundID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
