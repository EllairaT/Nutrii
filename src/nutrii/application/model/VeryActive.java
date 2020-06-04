package nutrii.application.model;

import java.time.LocalDate;


/**
 *
 * @author Blake & Ellaira
 */
public class VeryActive extends User {

    public VeryActive(String n, char g, LocalDate d, float h, float w) {
        super(n, g, d, h, w);
         modifier = 1.725f;
    }

    public VeryActive(String s) {
        super(s);
        modifier = 1.725f;
    }
}
