package nutrii.application;

/**
 *
 * @author Ellaira
 */
public class Supplement extends FoodItem {

    private float dosage; 
    
    public Supplement(String name, float dose) {
        super(name);
        this.setDosage(dose);
    }

    /**
     * @return the dosage
     */
    public float getDosage() {
        return dosage;
    }

    /**
     * @param dosage the dosage to set
     */
    public void setDosage(float dosage) {
        this.dosage = dosage;
    }


    
}
