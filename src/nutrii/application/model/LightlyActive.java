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
@DiscriminatorValue(value="LightlyActive")
public class LightlyActive extends User {
    
    public LightlyActive() {
    }
    
    public LightlyActive(String n, String p, char g, LocalDate d, float h, float w) {
        super(n, p, g, d, h, w);
        modifier = 1.375f;
    }

//    public LightlyActive(String s) {
//        super(s);
//        modifier = 1.375f;
//    }

}
