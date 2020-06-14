package nutrii.application.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Blake & Ellaira
 */
@Entity
@DiscriminatorValue(value = "Drink")
public class Drink extends FoodItem {
    public Drink(){}
    public Drink(String name) {
        super(name);
    }

}
