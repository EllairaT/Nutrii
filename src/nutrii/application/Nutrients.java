package nutrii.application;

/**
 *
 * @author Ellaira
 */
public class Nutrients extends Compounds {
    
    public Nutrients() {
        compounds = new String[]{
            "Calories",
            "Sugar",
            "Fat",
            "Trans Fat",
            "Saturated Fat",
            "Protein",
        };

        addComponents(compounds);

    }

    //print useful information about nutrients
    @Override
    public void printInformation() {
        System.out.println("");
    }

}
