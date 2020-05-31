package nutrii.application.model;
import javax.persistence.*;
/**
 *
 * @author Blake & Ellaira
 */
@Entity
@Table(name = "Minerals")
public class Minerals extends Compounds {

    public Minerals() {
        compounds = new String[]{

            "Calcium",
            "Phosphorus",
            "Potassium",
            "Sodium",
            "Magnesium",
            "Sulfur",
            "Iron",
            "Chromium",
            "Cobolt",
            "Copper",
            "Zinc",
            "Manganese",
            "Molybdenum",
            "Iodine",
            "Selenium",
            "Fluoride",};

        addComponents(compounds);
    }

    //print useful information about minerals
    @Override
    public void printInformation() {
        
    }
}
