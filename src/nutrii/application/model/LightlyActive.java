package nutrii.application.model;

import java.time.LocalDate;

/**
 *
 * @author Blake & Ellaira
 */

public class LightlyActive extends User {
    public LightlyActive(String n, char g, LocalDate d, float h, float w) {
        super(n, g, d, h, w);
        modifier = 1.375f;
    }

    public LightlyActive(String s) {
        super(s);
        modifier = 1.375f;
    }

}
