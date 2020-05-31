package nutrii.application.model;

import javax.persistence.*;

/**
 *
 * @author Blake & Ellaira
 */
@Entity
@Table(name = "Nutrients")
public class Nutrients extends Compounds {

    public Nutrients() {
        compounds = new String[]{
            "Calories",
            "Total Fat",
            "Saturated Fat",
            "Trans Fat",
            "Polyunsaturated Fat",
            "Monounsaturated Fat",
            "Cholesterol",
            "Total Carbohydrate",
            "Dietary Fiber",
            "Sugars",
            "Added Sugars",
            "Protein",};

        addComponents(compounds);

    }

    //print useful information about nutrients
    @Override
    public void printInformation() {
        System.out.println("");
    }

}
