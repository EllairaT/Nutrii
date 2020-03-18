package nutrii.application;

import java.time.LocalDate;

/**
 *
 * @author Ellaira
 */
public class Sedentary extends User{
    
    /**
     *
     */
    public Sedentary(String n, char g, LocalDate d, float h, float w){
       super(n,g,d,h,w);
       modifier = 1.2f;
       
    }
}
