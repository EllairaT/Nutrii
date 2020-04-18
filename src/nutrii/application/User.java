package nutrii.application;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Ellaira
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
    
    /**
     * @return the user's age in years.
     */
    
    public int getAge(){
        Period p = Period.between(DOB, LocalDate.now()); 
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
        return name + "," + gender + "," + DOB + "," + height + "," + weight + "," + START_DATE + "," + getClass().getSimpleName();
    }
    
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
}
