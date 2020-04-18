package nutrii.application;

/**
 *
 * @author Ellaira
 */
public class Food extends FoodItem{

    private float serving;
    
    public Food(String name, float s) {
        super(name);
        this.setServing(s);
    }

    /**
     * @return the serving
     */
    public float getServing() {
        return serving;
    }

    /**
     * @param serving the serving to set
     */
    public void setServing(float serving) {
        this.serving = serving;
    }

    
}
