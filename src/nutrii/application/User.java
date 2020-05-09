package nutrii.application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Ellaira & Blake
 */
public abstract class User {
    
    protected String name;
    private char gender;
    protected float modifier;
    private final LocalDate DOB; 
    private float height;
    private float weight;
    private float BMR;
    private final LocalDate START_DATE; //the day the user creates their account.
    
    public User(String n, char g, LocalDate d, float h, float w){
        this.setName(n);
        this.setGender(g);   
        this.setHeight(h);
        this.setWeight(w);
        this.START_DATE = LocalDate.now();
        this.DOB = d;
        this.setBMR(calculateBMR());
    }
    
    public User(String userString){
        String[] user = userString.split(",");
        this.setName(user[0]);
        this.setGender(user[1].charAt(0));
        this.setHeight(Float.parseFloat(user[3]));
        this.setWeight(Float.parseFloat(user[4]));
        this.START_DATE = LocalDate.parse(user[5]);
        this.DOB = LocalDate.parse(user[2]);
        this.setBMR(calculateBMR());       
    }
    
    /**
     * @return the user's age in years.
     */
    
    public int getAge(){
        Period p; 
        p = Period.between(DOB, LocalDate.now());
        int years = p.getYears();
        
        return years;
    }
    
  /**
   * This class calculates the BMR (Basal Metabolic Rate) of the user, 
   * - i.e. the minimum amount of calories they require per day. 
   * - uses the Revised Harris-Benedict Equation.
   * 
   * @return total BMR of user.
   */
    protected final float calculateBMR(){

        switch(gender){
            case 'm':
                BMR = (13.397f * weight) +(4.799f * height) - (5.677f * getAge()) + 88.362f;
                break;
            case 'f':
                BMR = (9.247f * weight) +(3.098f * height) - (4.330f * getAge()) + 447.593f;
                break;
            default: 
                break;
        }
        return BMR;
    }   
    
    @Override
    public String toString(){
        return name + ", DOB: " + DOB + " ("+  getAge() + ")" + "\nBMR: " + BMR + 
               "\nLifestyle: " + getClass().getSimpleName() +
               "\nTotal Calories needed for lifestyle: " + 
              calculateCalNeeded() + "\nAccount created on: " + START_DATE;
    }
    
    public String toWrite(){
        return name + "," + gender + "," + DOB + "," + height + "," + weight + "," + START_DATE + "," + getClass().getCanonicalName();
    }
    
    /**
     * calculates the total calories needed by the user
     * @return the calories recommended for the user
     */
    public float calculateCalNeeded(){
       return BMR * modifier;           
    }

    /**
     * @return the height
     */
    public float getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public final void setHeight(float height) {
        this.height = height;
    }

    /**
     * @return the weight
     */
    public float getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public final void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * @param BMR the BMR to set
     */
    public final void setBMR(float BMR) {
        this.BMR = BMR;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public final void setName(String name) {
        this.name = name;
    }

    /**
     * @return the startDate
     */
    public LocalDate getStartDate() {
        return START_DATE;
    }

    /**
     * @param gender the gender to set
     */
    public final void setGender(char gender) {
        this.gender = gender;
    }
    
    /**
     *@return the gender
     */
    public char getGender() {
        return gender;
    }

    /**
     * @return the DOB
     */
    public LocalDate getDOB() {
        return DOB;
    }
    
    @Override
    public boolean equals(Object o){
        String st = (String) o;
        return name.equals(st);
    }
    
}
