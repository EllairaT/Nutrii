package nutrii.application.model;

import java.time.LocalDate;

/**
 *
 * @author Blake & Ellaira
 */
public class Sedentary extends User{
    public Sedentary(String n, char g, LocalDate d, float h, float w){
       super(n,g,d,h,w);
       modifier = 1.2f;
    }
    public Sedentary(String s){
        super(s);
        modifier = 1.2f;
    }
}
