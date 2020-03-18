package nutrii.application;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 *
 * @author Ellaira
 */
public abstract class User {
    
    protected String name;
    protected char gender;
    protected float modifier;
    protected LocalDate DOB; // immutable, no setter 
    protected float height;
    protected float weight;
    protected float BMR;
    protected LocalDate startDate; //the day the user creates their account.
    
    public User(String n, char g, LocalDate d, float h, float w){
        startDate = LocalDate.now();
        setName(n);
        gender = g;
        DOB = d;
        height = h;
        weight = w;       
    }
    
    public int getAge(){
        Period age = Period.between(DOB, startDate);
        int years = age.getYears();
        
        return years;
    }
    
    public char getGender(){
        return gender;
    }
    
    public LocalDate getDOB(){
        return DOB;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String n){
        name = n;
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
    
    @Override
    public String toString(){
        return name + ", " + getAge() + ": BMR: " + calculateBMR() + "\nTotal Calories needed for lifestyle: " + calculateCalNeeded();
    }
    
    public float calculateCalNeeded(){
       System.out.println("modifier: " + modifier);
       return calculateBMR() * modifier;           
    }
}
