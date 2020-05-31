package nutrii.application.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Blake & Ellaira
 */
@Entity
@Table(name="VeryActive")
@PrimaryKeyJoinColumn(name="id")
public class VeryActive extends User {

    public VeryActive(String n, char g, LocalDate d, float h, float w) {
        super(n, g, d, h, w);
         modifier = 1.725f;
    }

    public VeryActive(String s) {
        super(s);
        modifier = 1.725f;
    }
    
    //Hibernate instantiates objects
    //so a constructor with no arguments is needed
    public VeryActive(){}
}
