package nutrii.application;

/**
 *
 * @author Ellaira
 */
public class Drink extends FoodItem {
    
    private float amountInML;

    public Drink(String name, float amount) {
        super(name);
        this.setAmountInML(amount);
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
