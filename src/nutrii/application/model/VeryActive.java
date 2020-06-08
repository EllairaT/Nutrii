package nutrii.application.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.hibernate.annotations.DiscriminatorOptions;
/**
 *
 * @author Blake & Ellaira
 */
@Entity
@DiscriminatorValue("4")
public class VeryActive extends User {
    
    public VeryActive() {
        super();
    }

    public VeryActive(String n, String p, char g, LocalDate d, float h, float w) {
        super(n, p, g, d, h, w);
         modifier = 1.725f;
    }
//
//    public VeryActive(String s) {
//        super(s);
//        modifier = 1.725f;
//    }
}
