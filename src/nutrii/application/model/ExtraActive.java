package nutrii.application.model;

import java.time.LocalDate;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Blake & Ellaira
 */
@Entity
@DiscriminatorValue("5")
public class ExtraActive extends User {

    public ExtraActive() {
    }

    public ExtraActive(String n, String p, char g, LocalDate d, float h, float w) {
        super(n, p, g, d, h, w);
        modifier = 1.9f;
    }
//
//    public ExtraActive(String s) {
//        super(s);
//        modifier = 1.9f;
//    }

}
