package nutrii.application.model;

import java.time.LocalDate;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Blake & Ellaira
 */
@Entity
@DiscriminatorValue("3")
public class ModeratelyActive extends User {

    public ModeratelyActive() {
    }
    
    public ModeratelyActive(String n, String p, char g, LocalDate d, float h, float w) {
        super(n, p, g, d, h, w);
        modifier = 1.55f;
    }

//    public ModeratelyActive(String s) {
//        super(s);
//        modifier = 1.55f;
//    }

}
