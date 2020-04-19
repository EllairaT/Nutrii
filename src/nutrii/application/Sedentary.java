package nutrii.application;

import java.time.LocalDate;

/**
 *
 * @author Ellaira
 */
public class Sedentary extends User{
    //float modifier;
    public Sedentary(String n, char g, LocalDate d, float h, float w){
       super(n,g,d,h,w);
       modifier = 1.2f;
    }
    public Sedentary(String s){
        super(s);
        modifier = 1.2f;
    }
}
