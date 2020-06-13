package nutrii.application.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Blake & Ellaira
 */
@Entity
@DiscriminatorValue(value="Sedentary")
public class Sedentary extends User {

    public Sedentary() {
    }

    public Sedentary(String n, String p, char g, LocalDate d, float h, float w) {
        super(n, p, g, d, h, w);
        modifier = 1.2f;
    }

//    public Sedentary(String s) {
//        super(s);
//        modifier = 1.2f;
//    }

}
