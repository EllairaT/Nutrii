package nutrii.application;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Ellaira
 */
public class NutriiApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Nutrii");
        System.out.println("Nutrition tracking app");
        
        User u = new Sedentary("Ellaira", 'f', LocalDate.of(2000, Month.MAY, 23), 150f, 47.2f);
        
        u.toString();
        
       // System.out.println(u);
        
    }
    
}
