package nutrii.application;

/**
 *
 * @author Ellaira
 */
public class Drink extends FoodItem {
    
    private float amountInML;

    public Drink(String name) {
        super(name);
    }

    /**
     * @return the amountInML
     */
    public float getAmountInML() {
        return amountInML;
    }

    /**
     * @param amountInML the amountInML to set
     */
    public void setAmountInML(float amountInML) {
        this.amountInML = amountInML;
    }    
}
