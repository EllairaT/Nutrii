package nutrii.application;

import java.time.LocalDate;

/**
 *
 * @author Ellaira
 */
public class ModeratelyActive extends User {
    
    public ModeratelyActive(String n, char g, LocalDate d, float h, float w) {
        super(n, g, d, h, w);
        modifier = 1.55f;
    }

    public ModeratelyActive(String s) {
        super(s);
        modifier = 1.55f;
    }

}
