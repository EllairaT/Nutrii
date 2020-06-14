package nutrii.application.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Blake & Ellaira
 */
@Entity
@DiscriminatorValue(value = "Food")
public class Food extends FoodItem{
    public Food(){}
    public Food(String name) {
        super(name);
    }
}
