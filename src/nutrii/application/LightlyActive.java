package nutrii.application;

import java.time.LocalDate;

/**
 *
 * @author Ellaira
 */
public class LightlyActive extends User{
    
    public LightlyActive(String n, char g, LocalDate d, float h, float w){
       super(n,g,d,h,w);
       modifier = 1.375f;
    }
    
}
