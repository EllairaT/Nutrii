package nutrii.application;

import java.time.LocalDate;

/**
 *
 * @author Ellaira
 */
public abstract class User {
    
    protected String name;
    protected char gender;
    protected float modifier;
    protected LocalDate DOB;
    protected int thing;
    protected float height;
    protected float weight;
    protected float BMR;
    protected LocalDate startDate; //the day the user creates their account.
    
    public User(){
        System.out.println("user");
       
       
    }
    
    public int getAge(){
        return 0;
    }
    /*
        class calculateBMR() :
        - uses the Revised Harris-Benedict Equation.
        
    */
    public float calculateBMR(){
        
        float totalBMR = 0.0f;
        
        switch(gender){
            case 'm':
                totalBMR = (13.397f * weight) +(4.799f * height ) - (5.677f * getAge()) + 88.362f;
                break;
            case 'f':
                totalBMR = (9.247f * weight) +(3.098f * height ) - (4.330f * getAge()) + 447.593f;
                break;
            default: 
                break;
        }
        return totalBMR;
    }
    
    
}
